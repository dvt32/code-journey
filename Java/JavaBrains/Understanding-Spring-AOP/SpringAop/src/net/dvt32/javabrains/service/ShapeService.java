package net.dvt32.javabrains.service;

import net.dvt32.javabrains.aspect.Loggable;
import net.dvt32.javabrains.model.Circle;
import net.dvt32.javabrains.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle's getter called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
