package net.dvt32.javabrains.service;

import net.dvt32.javabrains.aspect.LoggingAspect;
import net.dvt32.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
	
}
