package net.dvt32.designpatterns.task3;

/**
 * This program provides a simple implementation
 * of the Singleton design pattern.
 * 
 * 'instance' is the only instance of the Singleton class. 
 * The class constructor is private, so that no more Singleton objects can be created.
 * 
 * The getSingleInstance() method returns the only Singleton object - 'instance'.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton() { }
	
	public static Singleton getInstance() { return instance; }
	
	/**
	 * This is just an additional method, 
	 * which is used to test the Singleton instance.
	 */
	public String returnHelloWorld() {
		return "Hello World";
	}
}