package net.dvt32.regexandvalidation.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * This program prints all the 
 * fields and their respective modifiers, types, names and values (supports arrays too)
 * and method signatures of a certain class.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ClassDataPrinter {
	/**
	 * Inner class, which provides some data to test ClassDataPrinter with.
	 * Of course, ClassDataPrinter can work with any other class as well.
	 * 
	 * The inner class is static, so that it cannot access any ClassDataPrinter members.
	 * 
	 * @author Dimitar Trifonov (dvt32)
	 */
	static class DataProvider {
		public int publicIntegerVariable = 1;
		protected double protectedDoubleVariable = 2.0d;
		private String privateStringVariable = "3";
		final long longConstant = 4L;
		static byte staticByteVariable = 5;
		volatile int innerIntegerVariable = 6;
		public transient double transientDoubleVariable = 7.0d; 
		public int[] publicIntegerArray = new int[] { 8, 9, 10 };
		protected Double[] protectedDoubleArray = new Double[] { 11.0, 12.0, 13.0 };
		
		public int methodWithOneParam(int intParam) { return 0; };
		protected double methodWithTwoParams(double firstParam, double secondParam) { return 0; }
		private String methodWithNoParams() { return ""; }
		public void methodWithThreeDifferentParams(int firstParam, double secondParam, Object thirdParam) { }
	}
	
	/**
	 * This method prints:
	 * - all of a class' fields with their modifiers, types, names & values 
	 *   (supports primitive/Object arrays too)
	 * - all of a class' method signatures (name of method and parameter type list)
	 * 
	 * @param obj The object whose class is being examined 
	 */
	public void printClassData(Object obj) throws IllegalArgumentException, IllegalAccessException {
		printFieldData(obj);
		System.out.println();
		printMethodSignatureData(obj);
	}
	
	/**
	 * This method prints all of a class' fields with their modifiers, types, names & values.
	 * It supports primitive/Object arrays too.
	 * 
	 * @param obj The object whose class is being examined 
	 */
	public void printFieldData(Object obj) 
		throws IllegalArgumentException, IllegalAccessException 
	{
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			String fieldModifiers = Modifier.toString( field.getModifiers() );
			String fieldType = String.valueOf( field.getType().getSimpleName() );
			String fieldName = field.getName();
			String fieldValue = getFieldValue(field, obj);
			String fieldInfo = fieldModifiers + " " + fieldType + " " + fieldName + " -> " + fieldValue;
			System.out.println( fieldInfo );
		}	
	}
	
	/**
	 * This method extracts a certain class field's value and returns it as a String.
	 * In case the field is an array, the Arrays class toString() method is used internally.
	 * 
	 * @param field The field being examined
	 * @param obj The object whose class is being examined
	 * @return The field's value in the form of a String
	 */
	public String getFieldValue(Field field, Object obj) 
		throws IllegalArgumentException, IllegalAccessException 
	{
		String fieldModifiers = Modifier.toString( field.getModifiers() );
		if (fieldModifiers.contains("private")) {
			field.setAccessible(true); // in order to have access to value of private fields
		}
		String fieldValue = "";
		
		if ( field.getType().isArray() ) {
			Class<?> arrayType = field.getType().getComponentType();
		    Object array = field.get(obj);
		    
		    if (arrayType == Byte.TYPE) {
		    	fieldValue = Arrays.toString( (byte[]) array );
		    }
		    else if (arrayType == Short.TYPE) {
		    	fieldValue = Arrays.toString( (short[]) array );
		    }
		    else if (arrayType == Integer.TYPE) {
		    	fieldValue = Arrays.toString( (int[]) array );
		    }
		    else if (arrayType == Long.TYPE) {
		    	fieldValue = Arrays.toString( (long[]) array );
		    }
		    else if (arrayType == Float.TYPE) {
		    	fieldValue = Arrays.toString( (float[]) array );
		    }
		    else if (arrayType == Double.TYPE) {
		    	fieldValue = Arrays.toString( (double[]) array );
		    }
		    else if (arrayType == Boolean.TYPE) {
		    	fieldValue = Arrays.toString( (boolean[]) array );
		    }
		    else if (arrayType == Character.TYPE) {
		    	fieldValue = Arrays.toString( (char[]) array );
		    }
		    else {
		    	fieldValue = Arrays.toString( (Object[]) array );
		    }
		}
		else {
			fieldValue = String.valueOf( field.get(obj) );
		}
		
		return fieldValue;
	}
	
	/**
	 * This method prints all of a class' method signatures (name of method and parameter type list).
	 * It doesn't print the methods' return type, modifiers or parameter names - only its signature.
	 *  
	 * @param obj The object whose class is being examined 
	 */
	public void printMethodSignatureData(Object obj) {
		Method[] methods = obj.getClass().getDeclaredMethods();
		
		for (Method method : methods) {
			String methodName = method.getName();
			Parameter[] methodParameters = method.getParameters();
			StringJoiner methodParameterTypes = new StringJoiner(", ");
			
			for (Parameter methodParameter : methodParameters) {
				String methodParameterType = String.valueOf( methodParameter.getType().getSimpleName() );
				methodParameterTypes.add(methodParameterType);
			}
			
			String methodSignature = methodName + "(" + methodParameterTypes + ")";
			System.out.println( methodSignature );
		}
	}
}