package net.dvt32.designpatterns.task1.humans;

/**
 * This class represents a concrete human - a man.
 * A man has a name attribute, which can be set 
 * via its setter method or via one of the constructors.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Man
	implements Human
{
	private String name;
	
	public Man(String name) { this.name = name; }
	public Man() { name = "John Doe"; }
	
	/*
	 * Getters/setters
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	/**
	 * This method overrides the Human sayOwnName() method,
	 * because a man has his own unique way of saying his name.
	 */
	@Override
	public void sayOwnName() {
		System.out.println("My name is " + name + " and I'm a man!");
	}
}