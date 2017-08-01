package net.dvt32.generictypesclassesandobjects.task2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	/*
	 * addNode() tests
	 */
	@Test
	public void shouldNotAddDuplicateNodeToTree() {
		BinarySearchTree bst = new BinarySearchTree(19);
		bst.addNode(19);
		bst.printInorder(); // in ascending order
		
		String expectedOutput = "19 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldAddOnlyUniqueNodesToTree() {
		int[] nodeValues = new int[] { 14, 15, 19, 16, 19, 19, 17, 19 };
		
		BinarySearchTree bst = new BinarySearchTree(19, nodeValues);
		bst.printInorder();
		
		String expectedOutput = "14 15 16 17 19 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}

	/*
	 * containsNode() tests
	 */
	@Test
	public void shouldNotFindNodeWithValue16() {
		int[] nodeValues = new int[] { 19, 15, 23, 6, 3, 10, 21, 23, 15 }; 
		BinarySearchTree bst = new BinarySearchTree(14, nodeValues);
		assertTrue( !bst.containsNode(16) );
	}
	
	@Test
	public void shouldFindNodeWithValue21() {
		int[] nodeValues = new int[] { 19, 15, 6, 3, 10, 21, 23, 15 }; 
		BinarySearchTree bst = new BinarySearchTree(14, nodeValues);
		assertTrue( bst.containsNode(21) );
	}
	
	/*
	 * Print/traversal tests
	 */
	@Test
	public void shouldPrintTreeInPreorder() { 
		int[] nodeValues = new int[] { 14, 13, 15, 16, 17, 20, 21 }; 
		BinarySearchTree bst = new BinarySearchTree(19, nodeValues);
		
		bst.printPreorder(); // Root-Left-Right
		
		String expectedOutput = "19 14 13 15 16 17 20 21 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintTreeInInorder() {
		int[] nodeValues = new int[] { 14, 13, 15, 16, 17, 20, 21 }; 
		BinarySearchTree bst = new BinarySearchTree(19, nodeValues);
		
		bst.printInorder(); // Left-Root-Right (ascending order)
		
		String expectedOutput = "13 14 15 16 17 19 20 21 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintTreeInPostorder() {
		int[] nodeValues = new int[] { 14, 13, 15, 16, 17, 20, 21 }; 
		BinarySearchTree bst = new BinarySearchTree(19, nodeValues);
		
		bst.printPostorder(); // Left-Right-Root
		
		String expectedOutput = "13 17 16 15 14 21 20 19 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
}