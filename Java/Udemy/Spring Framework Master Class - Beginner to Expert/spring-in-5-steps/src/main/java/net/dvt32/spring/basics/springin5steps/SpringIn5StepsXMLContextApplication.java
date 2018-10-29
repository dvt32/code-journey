package net.dvt32.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dvt32.spring.basics.springin5steps.xml.XmlPersonDAO;

public class SpringIn5StepsXMLContextApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXMLContextApplication.class);

	public static void main(String[] args) {
		try ( ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ) {
			LOGGER.info( "Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames() );
			
			XmlPersonDAO personDao = applicationContext.getBean(XmlPersonDAO.class);
			
			LOGGER.info("{} {}", personDao, personDao.getXmlJdbcConnection());
		}
	}
	
}