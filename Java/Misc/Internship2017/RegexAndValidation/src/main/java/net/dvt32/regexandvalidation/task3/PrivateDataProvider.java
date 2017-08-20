package net.dvt32.regexandvalidation.task3;

/**
 * This class provides data for testing the PrivateDataAccessor class.
 * 
 * Public/protected methods/fields and private methods with parameters are ignored.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class PrivateDataProvider {
	private int privateIntVariable = 1;
	private int[] privateIntArray = new int[] { 2, 3, 4, 5 };
	private Double privateDoubleObject = 6.0;
	private Double[] privateDoubleObjectArray = new Double[] { 7.0, 8.0 };
	
	private int privateIntegerMethod() { return 9; }
	private void privateVoidMethod() { System.out.println("10"); }
	private int[] privateIntArrayMethod() {	return new int[] { 11, 12, 13, 14, 15 }; }
	private Integer[] privateIntegerArrayMethod() {	return new Integer[] { 16, 17, 18, 19, 20 }; }
	
	// These will be ignored
	public int publicIntVariable = 21;
	protected Integer publicIntegerMethod() { return 22; }
	private double privateDoubleMethodWithParam(int a) { return (double) a; }
}