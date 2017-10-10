package net.dvt32.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dvt32.javabrains.service.FactoryService;
import net.dvt32.javabrains.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();

	}

}
