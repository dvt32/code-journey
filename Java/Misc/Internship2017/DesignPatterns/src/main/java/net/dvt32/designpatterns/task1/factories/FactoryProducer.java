package net.dvt32.designpatterns.task1.factories;


/**
 * This class is used to generate specific factories,
 * which will afterwards be used to produce objects.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class FactoryProducer {
	/**
	 * This method creates a new factory from a specified type.
	 * In case such a factory does not exist, null is returned.
	 *  
	 * @param factoryType The factory's type
	 * @return A new factory object of the specified type, null if the factory type is invalid
	 */
	public static AbstractFactory getFactory(String factoryType) {
		if (factoryType == null) {
			return null;
		}
		else if (factoryType.equalsIgnoreCase("ANIMAL")) {
			return new AnimalFactory();
		}
		else if (factoryType.equalsIgnoreCase("HUMAN")) {
			return new HumanFactory();
		}
		else {
			return null;
		}
	}
}