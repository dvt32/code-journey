package net.dvt32.javabrains.service;

import net.dvt32.javabrains.model.Circle;
import net.dvt32.javabrains.model.Triangle;

public class FactoryService {
	
	public Object getBean(String beanType) {
		if (beanType.equals("shapeService")) {
			return new ShapeServiceProxy();
		}
		if (beanType.equals("circle")) {
			return new Circle();
		}
		if (beanType.equals("triangle")) {
			return new Triangle();
		}
		
		return null;
	}
}
