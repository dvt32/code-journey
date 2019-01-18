package net.dvt32.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Ranga", "Admin"));
        repository.save(new User("Ravi", "User"));
        repository.save(new User("Satish", "Admin"));
        repository.save(new User("Raghu", "User"));
        
        log.info("-------------------------------");
        
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        
        log.info("Finding all admins");
        log.info("-------------------------------");
        for (User admin : repository.findByRole("Admin")) {
            log.info(admin.toString());
            // Do something...
        }
	}

}
