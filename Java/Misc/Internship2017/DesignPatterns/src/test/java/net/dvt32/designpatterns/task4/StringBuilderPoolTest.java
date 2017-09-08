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
		assertTrue( pool.getNumberOfAvailableObjects() == 10 );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		StringBuilderPool pool = new StringBuilderPool(-1);
	}

	/*
	 * acquire() tests
	 */
	@Test
	public void poolShouldHaveNoAvailableObjectsLeftAndShouldHaveThreeCurrentlyUsedObjects() {
		StringBuilderPool pool = new StringBuilderPool(3);
		
		StringBuilder a = pool.acquire();
		StringBuilder b = pool.acquire();
		StringBuilder c = pool.acquire();
		
		assertTrue( 
			pool.getNumberOfAvailableObjects() == 0 &&
			pool.getNumberOfCurrentlyUsedObjects() == 3 
		);
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
		StringBuilder a = pool.acquire();
		pool.release(new StringBuilder());
	}
	
}