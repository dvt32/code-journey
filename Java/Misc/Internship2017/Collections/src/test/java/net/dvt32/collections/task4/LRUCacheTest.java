package net.dvt32.collections.task4;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void shouldReplace_2_2_with_3_3() {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(2);
		cache.get(1);
		cache.put(3, 3);
		
		String expectedResult = "{1=1, 3=3}";
		String actualResult = cache.toString();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldReplace_1_1_with_3_3() {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		
		String expectedResult = "{2=2, 3=3}";
		String actualResult = cache.toString();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void shouldReturn_1_1_then_2_2_then_4_4() {
		LRUCache cache = new LRUCache(3);

		cache.put(7, 7); // map contents: {7=7}
		cache.put(0, 0); // map contents: {7=7, 0=0}
		cache.put(1, 1); // map contents: {7=7, 0=0, 1=1}
		assertEquals("{7=7, 0=0, 1=1}", cache.toString());
		
		cache.put(2, 2); // beyond capacity, LRU = 7, remove it => map contents: {0=0, 1=1, 2=2}
		assertEquals("{0=0, 1=1, 2=2}", cache.toString());
		
		cache.put(4, 4); // beyond capacity, LRU = 0, remove it => map contents: {1=1, 2=2, 4=4}
		assertEquals("{1=1, 2=2, 4=4}", cache.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		LRUCache cache = new LRUCache(-1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldThrowNoSuchElementException() {
		LRUCache cache = new LRUCache(1);
		cache.put(3, 3);
		cache.get(2);
	}
	
}