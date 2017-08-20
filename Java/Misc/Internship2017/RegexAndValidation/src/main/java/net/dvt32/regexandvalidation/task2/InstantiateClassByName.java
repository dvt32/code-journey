package net.dvt32.regexandvalidation.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This program instantiates a class by name.
 * It can also get the name of the class' superclass 
 * & the names of the interfaces, which it implements.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class InstantiateClassByName 
{
	/**
	 * This method returns a new object from a specified class 
	 * by passing the class' full name as an argument.
	 * 
	 * The method does NOT support classes that don't have a public parameterless constructor.
	 * 
	 * @param className The full name (package included) of the class we want to instantiate
	 * @return A new object from the class being examined, null if the class does not have a parameterless constructor
	 * @throws ClassNotFoundException when trying to access a nonexistent class
	 * @throws IllegalAccessException when trying to access a private class
	 */
	public Object getNewObjectFromClass(String className) 
		throws ClassNotFoundException, IllegalAccessException, InstantiationException 
	{
		Class<?> inputClass = Class.forName(className);
		
		boolean inputClassHasPublicParameterlessConstructor = (
			Stream.of( inputClass.getConstructors() )
			.anyMatch( (constructor) -> constructor.getParameterCount() == 0 )
		);
		
		if (inputClassHasPublicParameterlessConstructor) {
			Object newObjectFromInputClass = inputClass.newInstance();
			return newObjectFromInputClass;
		}
		else {
			return null;
		}
	}

	/**
	 * This method returns the full name of the superclass, 
	 * which the child class inherits.
	 * 
	 * @param className The full name (package included) of the class we want to examine
	 * @return The full name of the examined class' superclass
	 * @throws ClassNotFoundException when the examined class is nonexistent
	 */
	public String getNameOfSuperclassOfClass(String className) 
		throws ClassNotFoundException 
	{
		Class<?> inputClass = Class.forName(className);
		Class<?> superclassOfInputClass = inputClass.getSuperclass();
		String superclassName = superclassOfInputClass.getName();
		return superclassName;
	}
	
	/**
	 * This method returns a list of the names of the interfaces,
	 * which the examined class implements.
	 * 
	 * @param className The full name (package included) of the class we want to examine
	 * @return A list of the names of the interfaces, which the examined class implements
	 * @throws ClassNotFoundException when the examined class is nonexistent
	 */
	public List<String> getNamesOfInterfacesImplementedByClass(String className) 
		throws ClassNotFoundException 
	{
		Class<?> inputClass = Class.forName(className);
		Class[] interfacesImplementedByInputClass = inputClass.getInterfaces();
		List<String> interfaceNames = new ArrayList<String>();
		
		for (Class interfaceImplementedByInputClass : interfacesImplementedByInputClass) {
			String interfaceName = interfaceImplementedByInputClass.getName();
			interfaceNames.add(interfaceName);
		}
		
		return interfaceNames;
	}
}