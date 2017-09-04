package net.dvt32.designpatterns.task5;

/**
 * This class is used to instantiate IntegerProxy objects.
 * 
 * There are two createInstance() methods - one for each IntegerProxy constructor.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class IntegerFactory {
	public static IntegerProxy createInstance(int value) {
		return new IntegerProxy(value);
	}
	
	public static IntegerProxy createInstance(String value) {
		return new IntegerProxy(value);
	}
}