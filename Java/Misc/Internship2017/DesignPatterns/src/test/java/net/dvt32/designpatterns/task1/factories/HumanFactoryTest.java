package net.dvt32.designpatterns.task1.factories;

import static org.junit.Assert.*;
import net.dvt32.designpatterns.task1.humans.Man;
import net.dvt32.designpatterns.task1.humans.Woman;

import org.junit.Test;

public class HumanFactoryTest {

	HumanFactory humanFactory = new HumanFactory();
	private final String HUMANS_PACKAGE_NAME = "net.dvt32.designpatterns.task1.humans";

	/*
	 * getHuman() tests
	 */
	@Test
	public void shouldCreateMan() {
		assertTrue( humanFactory.getHuman("Man") instanceof Man );
	}
	
	@Test
	public void shouldCreateWoman() {
		assertTrue( humanFactory.getHuman("WoMaN") instanceof Woman );
	}
	
	@Test
	public void shouldReturnNull() {
		assertTrue( humanFactory.getHuman("") == null );
		assertTrue( humanFactory.getHuman(null) == null );
	}
	
	/*
	 * createInstance() tests
	 */
	@Test
	public void shouldCreateManWithReflection() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		assertTrue( humanFactory.createInstance(HUMANS_PACKAGE_NAME + "." + "Man") instanceof Man );
	}
	
	@Test
	public void shouldCreateWomanWithReflection() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		assertTrue( humanFactory.createInstance(HUMANS_PACKAGE_NAME + "." + "Woman") instanceof Woman );
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException() 
		throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		humanFactory.createInstance(null);
	}

}
