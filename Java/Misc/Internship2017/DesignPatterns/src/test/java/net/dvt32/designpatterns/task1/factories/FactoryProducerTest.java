package net.dvt32.designpatterns.task1.factories;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryProducerTest {

	@Test
	public void shouldCreateAnimalFactory() {
		AbstractFactory animalFactory = FactoryProducer.getFactory("AnImAl");
		assertTrue( animalFactory instanceof AnimalFactory );
	}
	
	@Test
	public void shouldCreateHumanFactory() {
		AbstractFactory humanFactory = FactoryProducer.getFactory("hUmAn");
		assertTrue( humanFactory instanceof HumanFactory );
	}
	
	@Test
	public void shouldReturnNull() {
		AbstractFactory factory = FactoryProducer.getFactory("");
		assertTrue( factory == null );
		
		AbstractFactory anotherFactory = FactoryProducer.getFactory(null);
		assertTrue( anotherFactory == null );
	}

}