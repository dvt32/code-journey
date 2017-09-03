package net.dvt32.designpatterns.task1.factories;

import net.dvt32.designpatterns.task1.animals.Animal;
import net.dvt32.designpatterns.task1.animals.Cat;
import net.dvt32.designpatterns.task1.animals.Dog;
import net.dvt32.designpatterns.task1.humans.Human;

/**
 * This class represents a factory, which produces animals (Animal objects).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class AnimalFactory
	implements AbstractFactory
{
	/**
	 * This method creates a new Animal object, depending on the passed type.
	 * In case the factory cannot produce such an animal, null is returned.
	 * 
	 * To create the object, the Factory method pattern is used.
	 * 
	 * @param animalType The animal's type
	 * @return A new Animal object of the specified type (Dog, Cat or null)
	 */
	@Override
	public Animal getAnimal(String animalType) {
		if (animalType == null) {
			return null;
		}
		else if (animalType.equalsIgnoreCase("DOG")) {
			return new Dog();
		}
		else if (animalType.equalsIgnoreCase("CAT")) {
			return new Cat();
		}
		else {
			return null;	
		}
	}

	/**
	 * This method always returns null, 
	 * because the factory does not produce humans (Human objects)
	 * at this time.
	 * 
	 * @param humanType The human's type
	 * @return Always null
	 */
	@Override
	public Human getHuman(String humanType) {
		return null;
	}
	
	/**
	 * This method creates a new Animal object, but via reflection (rather than the Factory method pattern)
	 * 
	 * @param className The full name (including package) of the concrete Animal to be instantiated
	 * @return A new Animal object of the specified type
	 * @throws ClassNotFoundException when there is no class with that name
	 */
	public Animal createInstance(String className) 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		Animal newAnimal = (Animal) Class.forName(className).newInstance();	
		return newAnimal;
	}
}