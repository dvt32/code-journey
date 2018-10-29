package net.dvt32.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import net.dvt32.spring.basics.springin5steps.scope.PersonDAO;

@SpringBootApplication
@ComponentScan
public class SpringIn5StepsScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

	public static void main(String[] args) {
		try ( AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsScopeApplication.class) ) {
			PersonDAO personDao = applicationContext.getBean(PersonDAO.class);
			PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
	
			LOGGER.info("{}", personDao);
			LOGGER.info("{}", personDao.getJdbcConnection());
			LOGGER.info("{}", personDao.getJdbcConnection());
	
			LOGGER.info("{}", personDao2);
			LOGGER.info("{}", personDao.getJdbcConnection());
		}
	}
}