package net.dvt32.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import net.dvt32.models.CatalogItem;
import net.dvt32.models.UserRating;
import net.dvt32.services.MovieInfo;
import net.dvt32.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating ratings = userRatingInfo.getUserRating(userId);
		return ratings.getRatings().stream()
			.map(rating -> movieInfo.getCatalogItem(rating))
			.collect(Collectors.toList());
	}

}

/*
Movie movie = webClientBuilder.build()
	.get()
	.uri("http://localhost:8082/movies/" + rating.getMovieId())
	.retrieve()
	.bodyToMono(Movie.class)
	.block();
*/