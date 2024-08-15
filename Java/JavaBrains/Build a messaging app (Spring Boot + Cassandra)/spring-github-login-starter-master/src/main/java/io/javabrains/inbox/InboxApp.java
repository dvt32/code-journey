package io.javabrains.inbox;

import io.javabrains.inbox.email.EmailService;
import io.javabrains.inbox.folders.Folder;
import io.javabrains.inbox.folders.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class InboxApp {

	@Autowired
	FolderRepository folderRepository;
	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

	@PostConstruct
	public void init() {
		folderRepository.save( new Folder("dvt32", "Work", "blue") );
		folderRepository.save( new Folder("dvt32", "Home", "green") );
		folderRepository.save( new Folder("dvt32", "Family", "yellow") );

		for (int i = 0; i < 10; ++i) {
			emailService.sendEmail("dvt32", Arrays.asList("dvt32", "abc"), "Hello " + i, "Body");
		}

		emailService.sendEmail("abc", Arrays.asList("def", "abc"), "Hello ", "Body");

	}

}
