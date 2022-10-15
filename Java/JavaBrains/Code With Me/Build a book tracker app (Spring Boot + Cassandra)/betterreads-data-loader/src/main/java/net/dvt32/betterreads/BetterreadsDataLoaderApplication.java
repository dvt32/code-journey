package net.dvt32.betterreads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import net.dvt32.betterreads.author.Author;
import net.dvt32.betterreads.author.AuthorRepository;
import net.dvt32.betterreads.book.Book;
import net.dvt32.betterreads.book.BookRepository;
import net.dvt32.betterreads.connection.DataStaxAstraProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BetterreadsDataLoaderApplication {
    
    @Autowired
    AuthorRepository authorRepository;
    
    @Autowired
    BookRepository bookRepository;
    
    @Value("${datadump.location.author}")
    private String authorDumpLocation;
    
    @Value("${datadump.location.works}")
    private String worksDumpLocation;

	public static void main(String[] args) {
		SpringApplication.run(BetterreadsDataLoaderApplication.class, args);
	}
	
	private void initAuthors() {
	    Path path = Paths.get(authorDumpLocation);
	    try (Stream<String> lines = Files.lines(path)) {
	        lines.forEach(line -> {
	            // Read and parse the line
	            String jsonString = line.substring( line.indexOf("{") );
	            try {
	                JSONObject jsonObject = new JSONObject(jsonString);
       
    	            // Construct Author object
    	            Author author = new Author();
    	            author.setName( jsonObject.optString("name") );
    	            author.setPersonalName( jsonObject.optString("personal_name") );
    	            author.setId( jsonObject.optString("key").replace("/authors/", "") );
    	            
    	            // Persist using repository
    	            System.out.println("Saving author " + author.getName() + "...");
    	            authorRepository.save(author);
	            }
	            catch (JSONException e) {
                    e.printStackTrace();
                }
	        });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void initWorks() {
	    Path path = Paths.get(worksDumpLocation);
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
	    
        try (Stream<String> lines = Files.lines(path)) {
            lines.limit(50).forEach(line -> {
                // Read and parse the line
                String jsonString = line.substring( line.indexOf("{") );
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
       
                    // Construct Book object
                    Book book = new Book();
                    book.setId( jsonObject.getString("key").replace("/works/", "") );
                    book.setName( jsonObject.optString("title")) ;
                    JSONObject descriptionObj = jsonObject.optJSONObject("description");
                    if (descriptionObj != null) {
                        book.setDescription( descriptionObj.getString("value") );
                    }
                    JSONObject publishedObj = jsonObject.optJSONObject("created");
                    if (publishedObj != null) {
                        String dateStr = publishedObj.getString("value");
                        book.setPublishedDate( LocalDate.parse(dateStr, dateFormat) );
                    }
                    JSONArray coversJSONArr = jsonObject.optJSONArray("covers");
                    if (coversJSONArr != null) {
                        List<String> coverIds = new ArrayList<>();
                        for (int i = 0; i < coversJSONArr.length(); ++i) {
                            coverIds.add( coversJSONArr.getString(i) );
                        }
                        book.setCoverIds(coverIds);
                    }
                    JSONArray authorsJSONArr = jsonObject.optJSONArray("authors");
                    if (authorsJSONArr != null) {
                        List<String> authorIds = new ArrayList<>();
                        for (int i = 0; i < authorsJSONArr.length(); ++i) {
                            String authorId = 
                                authorsJSONArr
                                    .getJSONObject(i)
                                    .getJSONObject("author")
                                    .getString("key")
                                    .replace("/authors", "");
                            authorIds.add(authorId);
                        }
                        book.setAuthorIds(authorIds);
                        List<String> authorNames = 
                            authorIds.stream()
                                .map(id -> authorRepository.findById(id))
                                .map(optionalAuthor -> {
                                    if (!optionalAuthor.isPresent()) return "Unknown Author";
                                    return optionalAuthor.get().getName();
                                })
                                .collect( Collectors.toList() );
                        book.setAuthorNames(authorNames);
                    }
                    
                    // Persist using repository
                    System.out.println("Saving book " + book.getName() + "...");
                    bookRepository.save(book);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@PostConstruct
	public void start() {
	    // initAuthors();
	    initWorks();
	}
	
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
	    Path bundle = astraProperties.getSecureConnectBundle().toPath();
	    return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

}
