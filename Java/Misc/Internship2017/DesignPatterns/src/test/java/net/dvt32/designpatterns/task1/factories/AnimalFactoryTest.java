package net.dvt32.designpatterns.task1.factories;

import static org.junit.Assert.*;
import net.dvt32.designpatterns.task1.animals.Cat;
import net.dvt32.designpatterns.task1.animals.Dog;

import org.junit.Test;

public class AnimalFactoryTest {
	
	AnimalFactory animalFactory = new AnimalFactory();
	private final String ANIMALS_PACKAGE_NAME = "net.dvt32.designpatterns.task1.animals";

	/*
	 * getAnimal() tests
	 */
	@Test
	public void shouldCreateDog() {
		assertTrue( animalFactory.getAnimal("DOG") instanceof Dog );
	}
	
	@Test
	public void shouldCreateCat() {
		assertTrue( animalFactory.getAnimal("CaT") instanceof Cat );
	}
	
	@Test
	public void shouldReturnNull() {
		assertTrue( animalFactory.getAnimal("") == null );
		assertTrue( animalFactory.getAnimal(null) == null );
	}
	
	/*
	 * createInstance() tests
	 */
	@Test
	public void shouldCreateDogWithReflection() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		assertTrue( animalFactory.createInstance(ANIMALS_PACKAGE_NAME + "." + "Dog") instanceof Dog );
	}
	
	@Test
	public void shouldCreateCatWithReflection() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		assertTrue( animalFactory.createInstance(ANIMALS_PACKAGE_NAME + "." + "Cat") instanceof Cat );
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		animalFactory.createInstance(null);
	}

}