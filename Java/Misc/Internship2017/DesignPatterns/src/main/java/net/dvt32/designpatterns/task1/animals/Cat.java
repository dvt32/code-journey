package net.dvt32.designpatterns.task1.animals;

/**
 * This class represents a concrete animal - a cat.
 * A cat has an age attribute, which can be set 
 * via its setter method or via one of the constructors.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Cat
	implements Animal
{
	private int age;
	
	public Cat(int age) { this.age = age; }
	public Cat() { age = 0; }
	
	/*
	 * Getters/setters
	 */
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	/**
	 * This method overrides the Animal speak() method,
	 * because a cat has its own unique way of speaking.
	 */
	@Override
	public void speak() {
		System.out.println("Meow!");	
	}
}