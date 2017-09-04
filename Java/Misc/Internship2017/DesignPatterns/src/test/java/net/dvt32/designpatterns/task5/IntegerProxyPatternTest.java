package net.dvt32.designpatterns.task5;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerProxyPatternTest {

	@Test
	public void shouldCreateIntegersWithSameValue() {
		Number a = new Integer(5);
		Number b = IntegerFactory.createInstance(5);
		assertEquals(String.valueOf(a), String.valueOf(b));
	}
	
	@Test
	public void shouldNotBeTheSameObject() {
		Integer a = new Integer(5);
		IntegerProxy b = IntegerFactory.createInstance(5);
		assertNotEquals(a, b);
	}
	
	@Test
	public void shouldCreateIntegersWithSameValueWithoutUsingFactory() {
		Integer a = new Integer(5);
		IntegerProxy b = new IntegerProxy(5);
		assertEquals(String.valueOf(a), String.valueOf(b));
	}
	
	@Test(expected = NumberFormatException.class)
	public void shouldThrowNumberFormatException() {
		IntegerFactory.createInstance(new Integer(null));
	}
	
	@Test
	public void shouldCreateIntegersWithSameValueWithDifferentConstructors() {
		Integer a = new Integer(5);
		IntegerProxy b = IntegerFactory.createInstance("5");
		assertEquals(String.valueOf(a), String.valueOf(b));
	}
	
	@Test
	public void shouldConvertIntegerProxyToDouble() {
		IntegerProxy a = IntegerFactory.createInstance("1");
		assertEquals(1.0, a.doubleValue(), 0.01);
	}
	
}