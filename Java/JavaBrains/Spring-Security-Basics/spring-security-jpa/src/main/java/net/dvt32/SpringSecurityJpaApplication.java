package net.dvt32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
		
		/*
		 	INSERT INTO user (`id`, `user_name`, `password`, `active`, `roles`)
		 	VALUES (1, 'user', 'pass', true, 'ROLE_USER');
		*/
	}

}
