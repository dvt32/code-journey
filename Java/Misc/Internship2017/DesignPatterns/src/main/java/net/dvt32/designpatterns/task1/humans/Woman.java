package net.dvt32.designpatterns.task1.humans;

/**
 * This class represents a concrete human - a woman.
 * A woman has a name attribute, which can be set 
 * via its setter method or via one of the constructors.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Woman 
	implements Human 
{
	private String name;
	
	public Woman(String name) { this.name = name; }
	public Woman() { name = "Jane Doe"; }
	
	/*
	 * Getters/setters
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	/**
	 * This method overrides the Human sayOwnName() method,
	 * because a woman has her own unique way of saying her name.
	 */
	@Override
	public void sayOwnName() {
		System.out.println("My name is " + name + " and I'm a woman!");
	}
}