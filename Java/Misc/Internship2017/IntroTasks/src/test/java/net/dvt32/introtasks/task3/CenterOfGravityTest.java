package net.dvt32.introtasks.task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CenterOfGravityTest {

	CenterOfGravity cog = new CenterOfGravity();
	
	@Test
	public void centerOfGravityIndexShouldBe3() {
		int expectedOutput = 3;
		int actualOutput = cog.getCenterOfGravityIndex( new int[] { 1, 2, 3, 44, 5 } );
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void centerOfGravityIndexShouldBe2() {
		int expectedOutput = 2;
		int actualOutput = cog.getCenterOfGravityIndex( new int[] { 4, 5, 99, -1, 5, 6 } );
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void centerOfGravityIndexShouldNotBePositive() {
		int output = cog.getCenterOfGravityIndex( new int[] { } );
		assertFalse(output > 0);
	}
	
}
