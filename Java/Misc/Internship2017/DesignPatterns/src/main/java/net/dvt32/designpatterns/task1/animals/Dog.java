package net.dvt32.designpatterns.task1.animals;

/**
 * This class represents a concrete animal - a dog.
 * A dog has an age attribute, which can be set 
 * via its setter method or via one of the constructors.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Dog 
	implements Animal
{
	private int age;
	
	public Dog(int age) { this.age = age; }
	public Dog() { age = 0; }
	
	/*
	 * Getters/setters
	 */
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	/**
	 * This method overrides the Animal speak() method,
	 * because a dog has its own unique way of speaking.
	 */
	@Override
	public void speak() {
		System.out.println("Woof!");
	}
}