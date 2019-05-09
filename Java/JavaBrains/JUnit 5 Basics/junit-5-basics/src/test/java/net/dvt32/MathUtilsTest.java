package net.dvt32;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@DisplayName("When running MathUtilsTest")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	/*
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to be run before all...");
	}
	*/
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	}
	
	/*
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up...");
	}
	*/
	
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
		}
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			assertEquals(
				expected, 
				actual, 
				() -> "should return sum " + expected + " but returned sum " + actual
			);
		}
	}
	
	@Test
	@DisplayName("multiply method")
	@Tag("Math")
	void testMultiply() {
		// assertEquals(4, mathUtils.multiply(2, 2), "should return the right product");
		assertAll(
			() -> assertEquals(4, mathUtils.multiply(2, 2)),
			() -> assertEquals(0, mathUtils.multiply(2, 0)),
			() -> assertEquals(-2, mathUtils.multiply(2, -1))
		);
	}
	
	@Test
	@DisplayName("divide method")
	@Tag("Math")
	// @EnabledOnOs(OS.LINUX)
	void testDivide() {
		// boolean isServerUp = false;
		// assumeTrue(isServerUp);
		assertThrows(
			ArithmeticException.class, 
			() -> mathUtils.divide(1, 0), 
			"Divide should throw ArithmeticException"
		);
	}
	
	@RepeatedTest(3)
	@Tag("Circle")
	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
		MathUtils mathUtils = new MathUtils();
		assertEquals(
			314.1592653589793, 
			mathUtils.computeCircleArea(10), 
			"Should return right circle area"
		);
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. Should not run!")
	void testDisabled() {
		fail("This method should be disabled!");
	}

}