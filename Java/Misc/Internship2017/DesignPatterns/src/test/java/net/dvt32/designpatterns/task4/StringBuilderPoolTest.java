package net.dvt32.designpatterns.task4;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderPoolTest {
	
	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreatePoolWithSize10() {
		StringBuilderPool pool = new StringBuilderPool(10);
		assertTrue( pool.size() == 10 );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		StringBuilderPool pool = new StringBuilderPool(-1);
	}

	/*
	 * acquire() tests
	 */
	@Test
	public void poolShouldHaveNoRemainingObjects() {
		StringBuilderPool pool = new StringBuilderPool(3);
		
		StringBuilder a = pool.acquire();
		StringBuilder b = pool.acquire();
		StringBuilder c = pool.acquire();
		
		int expectedResult = 0;
		int actualResult = pool.size();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateException() {
		StringBuilderPool pool = new StringBuilderPool(3);
		StringBuilder a = pool.acquire();
		StringBuilder b = pool.acquire();
		StringBuilder c = pool.acquire();
		StringBuilder d = pool.acquire();
	}
	
	/*
	 * release() tests
	 */
	@Test
	public void shouldReuseStringBuilderWithTextInside() {
		StringBuilderPool pool = new StringBuilderPool(1);
		
		StringBuilder a = pool.acquire();
		a.append("hello");
		
		pool.release(a);
		StringBuilder b = pool.acquire();
		assertTrue( b.toString().equals("hello") && a == b);
	}
	
	@Test(expected = IllegalStateException.class)
	public void releaseMethodShouldThrowIllegalStateException() {
		StringBuilderPool pool = new StringBuilderPool(1);
		pool.release(new StringBuilder());
	}
	
}