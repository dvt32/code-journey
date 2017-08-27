package net.dvt32.designpatterns.task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTest {
	
	@Test
	public void firstObjectAndSecondObjectShouldBeTheSameObject() {
		Singleton firstObject = Singleton.getInstance();
		Singleton secondObject = Singleton.getInstance();
		
		assertTrue( firstObject instanceof Singleton );
		assertTrue( secondObject instanceof Singleton );
		assertTrue( firstObject == secondObject );
	}
	
	@Test
	public void shouldReturnHelloWorld() {
		Singleton object = Singleton.getInstance();
		assertEquals( "Hello World", object.returnHelloWorld() );
	}
	
}