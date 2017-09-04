package net.dvt32.designpatterns.task5;

/**
 * This class is a proxy for the Integer class.
 * 
 * This means that when an IntegerProxy object is instantiated,
 * it appears as if the user is working with an IntegerProxy object,
 * but actually he is working with an Integer object.
 * 
 * The class extends Number, just like Integer does.
 * That's why it overrides the doubleValue(), floatValue(), intValue(), longValue() methods.
 * 
 * It also implements two constructors, which the Integer class also has.
 * It does NOT implement static Integer methods.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class IntegerProxy
	extends Number
{
	private Integer realInteger;
	
	public IntegerProxy(int value) {
		realInteger = new Integer(value);
	}
	
	public IntegerProxy(String value) {
		realInteger = new Integer(value);
	}
	
	@Override
	public double doubleValue() {
		return (double) realInteger;
	}

	@Override
	public float floatValue() {
		return (float) realInteger;
	}

	@Override
	public int intValue() {
		return (int) realInteger;
	}

	@Override
	public long longValue() {
		return (long) realInteger;
	}
	
	@Override
	public String toString() {
		return String.valueOf(realInteger);
	}
}