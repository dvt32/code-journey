package net.dvt32.regexandvalidation.task4;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class AnnotationSorterTest {
	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateThreeChildClassInstances() {
		ChildOne child = new ChildOne(1);
		AnnotationSorter anotherChild = new ChildTwo(2);
		ChildThree yetAnotherChild = new ChildThree(3);
		
		assertTrue( child instanceof ChildOne );
		assertTrue( anotherChild instanceof ChildTwo );
		assertTrue( yetAnotherChild instanceof ChildThree );
	}
	
	@Test
	public void childClassObjectShouldNotBeInstanceOfOtherChildClass() {
		AnnotationSorter child = new ChildOne(1);
		
		assertFalse( child instanceof ChildTwo );
		assertFalse( child instanceof ChildThree );
		
		assertTrue( child instanceof ChildOne );
		assertTrue( child instanceof AnnotationSorter );
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void shouldGetValuesOfAllChildClassInstances() {
		ChildOne child = new ChildOne(1);
		AnnotationSorter anotherChild = new ChildTwo(2);
		ChildThree yetAnotherChild = new ChildThree(3);
		
		int childValue = child.getValue();
		int anotherChildValue = anotherChild.getValue();
		int yetAnotherChildValue = yetAnotherChild.getValue();
		
		assertTrue(
			childValue == 1 &&
			anotherChildValue == 2 &&
			yetAnotherChildValue == 3
		);
	}
	
	@Test(expected = NumberFormatException.class)
	public void getterShouldThrowNumberFormatException() {
		ChildOne child = new ChildOne(new Integer(null));
		child.getValue();
	}
	
	@Test
	public void shouldChangeValuesOfChildClassObjects() {
		ChildOne child = new ChildOne(1);
		AnnotationSorter anotherChild = new ChildTwo(2);
		ChildThree yetAnotherChild = new ChildThree(3);
		
		assertTrue(
			child.getValue() == 1 &&
			anotherChild.getValue() == 2 &&
			yetAnotherChild.getValue() == 3
		);
		
		child.setValue(4);
		anotherChild.setValue(5);
		yetAnotherChild.setValue(6);
		
		assertTrue(
			child.getValue() == 4 &&
			anotherChild.getValue() == 5 &&
			yetAnotherChild.getValue() == 6
		);
	}
	
	/*
	 * getSortOrderFromAnnotation() tests
	 */
	@Test
	public void allClassSortAnnotationsShouldHaveSameValue() {
		String expectedOrderValue = AnnotationSorter.getSortOrderFromAnnotation();
		assertEquals(expectedOrderValue, ChildOne.getSortOrderFromAnnotation());
		assertEquals(expectedOrderValue, ChildTwo.getSortOrderFromAnnotation());
		assertEquals(expectedOrderValue, ChildThree.getSortOrderFromAnnotation());
	}
	
	@Test
	public void allClassSortAnotationShouldHaveSameValueEvenWithNonstaticMethodCall() {
		String expectedOrderValue = AnnotationSorter.getSortOrderFromAnnotation();
		assertEquals(expectedOrderValue, new ChildOne(1).getSortOrderFromAnnotation());
		assertEquals(expectedOrderValue, new ChildTwo(2).getSortOrderFromAnnotation());
		assertEquals(expectedOrderValue, new ChildThree(3).getSortOrderFromAnnotation());
	}
	
	/*
	 * compareTo() tests
	 */
	@Test
	public void shouldSortObjectsAccordingToSortAnnotationValue() {
		AnnotationSorter[] arr = new AnnotationSorter[] { 
			new ChildOne(-1), 
			new ChildTwo(3333), 
			new ChildThree(45) 
		};
		
		Arrays.sort(arr);
		
		if ( AnnotationSorter.getSortOrderFromAnnotation().equals("descending") ) {
			assertTrue(
				arr[0].getValue() == 3333 &&
				arr[1].getValue() == 45 &&
				arr[2].getValue() == -1
			);
		}
		else if ( AnnotationSorter.getSortOrderFromAnnotation().equals("ascending") ) {
			assertTrue(
				arr[0].getValue() == -1 &&
				arr[1].getValue() == 45 &&
				arr[2].getValue() == 3333
			);
		}
		else {
			assertTrue(
				arr[0].getValue() == -1 &&
				arr[1].getValue() == 3333 &&
				arr[2].getValue() == 45
			);
		}
	}
	
	@Test(expected = NullPointerException.class) 
	public void sortingShouldThrowNullPointerException() {
		AnnotationSorter[] arr = new AnnotationSorter[] { 
			null, null, null
		};
		
		Arrays.sort(arr);
	}
}