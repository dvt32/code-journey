package net.dvt32.designpatterns.task1.factories;

import net.dvt32.designpatterns.task1.animals.Animal;
import net.dvt32.designpatterns.task1.humans.Human;
import net.dvt32.designpatterns.task1.humans.Man;
import net.dvt32.designpatterns.task1.humans.Woman;

/**
 * This class represents a factory, which produces humans (Human objects).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class HumanFactory
	implements AbstractFactory
{
	/**
	 * This method always returns null, 
	 * because the factory does not produce animals (Animal objects)
	 * at this time.
	 * 
	 * @param animalType The animal's type
	 * @return Always null
	 */
	@Override
	public Animal getAnimal(String animalType) {
		return null;
	}

	/**
	 * This method creates a new Human object, depending on the passed type.
	 * In case the factory cannot produce such a human, null is returned.
	 * 
	 * To create the object, the Factory method pattern is used.
	 * 
	 * @param humanType The human's type
	 * @return A new Human object of the specified type (Man, Woman or null)
	 */
	@Override
	public Human getHuman(String humanType) {
		if (humanType == null) {
			return null;
		}
		else if (humanType.equalsIgnoreCase("MAN")) {
			return new Man();
		}
		else if (humanType.equalsIgnoreCase("WOMAN")) {
			return new Woman();
		}
		else {
			return null;	
		}
	}
	
	/**
	 * This method creates a new Human object, but via reflection (rather than the Factory method pattern)
	 * 
	 * @param className The full name (including package) of the concrete Human to be instantiated
	 * @return A new Human object of the specified type
	 * @throws ClassNotFoundException when there is no class with that name
	 */
	public Human createInstance(String className) 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		Human newHuman = (Human) Class.forName(className).newInstance();	
		return newHuman;
	}
}