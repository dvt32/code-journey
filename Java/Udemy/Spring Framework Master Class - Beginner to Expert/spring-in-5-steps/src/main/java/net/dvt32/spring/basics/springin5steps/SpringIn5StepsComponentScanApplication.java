package net.dvt32.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import net.dvt32.spring.basics.componentscan.ComponentDAO;

@SpringBootApplication
@ComponentScan("net.dvt32.spring.basics.componentscan")
public class SpringIn5StepsComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

	public static void main(String[] args) {
		try ( AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsComponentScanApplication.class) ) {
			ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
			LOGGER.info("{}", componentDAO);
		}
	}
}