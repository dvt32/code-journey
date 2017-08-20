package net.dvt32.regexandvalidation.task3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * This program prints all of a certain class'
 * -> private field names & their values (arrays are supported too)
 * -> private method names & their returned values (if the method is void, it is called anyway)
 * 
 * It does not support private methods with parameters.
 *
 * @author Dimitar Trifonov (dvt32)
 */
public class PrivateDataAccessor {
	/**
	 * This method prints all of a class' 
	 * private field names & their values (arrays are supported too).
	 * 
	 * @param obj An instance of the class being examined
	 */
	public void printAllPrivateFieldNamesAndValues(Object obj) 
		throws IllegalArgumentException, IllegalAccessException 
	{
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			String fieldModifiers = Modifier.toString( field.getModifiers() );
			if (fieldModifiers.contains("private")) {
				field.setAccessible(true); // in order to have access to value of private fields
				String fieldName = field.getName();
				String fieldValue = getFieldValue(field, obj);
				String fieldInfo = fieldName + " -> " + fieldValue;
				System.out.println( fieldInfo );
			}
		}	
	}
	
	/**
	 * This method extracts a class' private field's value and returns it as a String.
	 * In case the field is an array, the Arrays class toString() method is used internally.
	 * 
	 * @param field The field being examined
	 * @param obj An instance of the class being examined
	 * @return The field's value in the form of a String
	 */
	public String getFieldValue(Field field, Object obj) 
		throws IllegalArgumentException, IllegalAccessException 
	{
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
	 * This method calls all private methods (without parameters) of a certain class, 
	 * prints their name and their returned value.
	 * 
	 * If the method does not return anything, 
	 * it will still be called and 
	 * any additional output will be shown below its name.
	 * 
	 * @param obj An instance of the class being examined
	 */
	public void printAllPrivateNoParamMethodsNamesAndReturnValues(Object obj) 
		throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Method[] methods = obj.getClass().getDeclaredMethods();
		
		for (Method method : methods) {
			String methodModifiers = Modifier.toString( method.getModifiers() );
			boolean methodHasParameters = ( method.getParameterCount() > 0 );
			if ( methodModifiers.contains("private") && !methodHasParameters ) {
				method.setAccessible(true); // in order to be able to call the private method
				String methodName = method.getName() + "()";
				String methodReturnValue = getMethodReturnValue(method, obj);
				
				boolean isVoidMethod = methodReturnValue.equals("void");
				if (isVoidMethod) {
					System.out.println( methodName + "\n -> " + "No returned value!" );
					method.invoke(obj);
				}
				else {
					System.out.println( methodName + "\n -> " + "Returns: " + methodReturnValue );
				}
			}
		}
	}
	
	/**
	 * This method calls a certain class method and returns its value in String form.
	 * If the returned value is an array, the Arrays toString() method is used internally.
	 * 
	 * @param method The method being examined
	 * @param obj An instance of the class being examined
	 * @return The returned value of the examined method in String form or "void" if method is void
	 */
	public String getMethodReturnValue(Method method, Object obj) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Class<?> methodReturnType = method.getReturnType();
		String output = "";
		
		if ( methodReturnType.isArray() ) {
			Class<?> returnedArrayType = methodReturnType.getComponentType();
		    Object returnedArray = method.invoke(obj);
		    
		    if (returnedArrayType == Byte.TYPE) {
		    	output = Arrays.toString( (byte[]) returnedArray );
		    }
		    else if (returnedArrayType == Short.TYPE) {
		    	output = Arrays.toString( (short[]) returnedArray );
		    }
		    else if (returnedArrayType == Integer.TYPE) {
		    	output = Arrays.toString( (int[]) returnedArray );
		    }
		    else if (returnedArrayType == Long.TYPE) {
		    	output = Arrays.toString( (long[]) returnedArray );
		    }
		    else if (returnedArrayType == Float.TYPE) {
		    	output = Arrays.toString( (float[]) returnedArray );
		    }
		    else if (returnedArrayType == Double.TYPE) {
		    	output = Arrays.toString( (double[]) returnedArray );
		    }
		    else if (returnedArrayType == Boolean.TYPE) {
		    	output = Arrays.toString( (boolean[]) returnedArray );
		    }
		    else if (returnedArrayType == Character.TYPE) {
		    	output = Arrays.toString( (char[]) returnedArray );
		    }
		    else {
		    	output = Arrays.toString( (Object[]) returnedArray );
		    }
		}
		else if (methodReturnType == Void.TYPE){
			output = "void";
		}
		else { // returns a primitive
			output = String.valueOf( method.invoke(obj) );
		}
		
		return output;
	}
}