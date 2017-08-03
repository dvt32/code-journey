package net.dvt32.generictypesclassesandobjects.task2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.dvt32.generictypesclassesandobjects.task2.HomogeneousTree.HomogeneousTreeNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomogeneousTreeTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	// HomogeneousTreeNode class tests
	/*
	 * Constructor tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructorShouldThrowIllegalArgumentException() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>( null );
	}
	
	@Test
	public void shouldCreateNodeWithValue1337() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>( 1337 );
		assertTrue( node.getValue() == 1337 );
	}
	
	/*
	 * addChildNode() tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addChildNodeMethodShouldThrowIllegalArgumentException() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>( 13 );
		node.addChildNode( new HomogeneousTreeNode<Integer>(null) );
	}
	
	@Test
	public void shouldAddTwoChildNodes() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>( 13 );
		node.addChildNode( new HomogeneousTreeNode<Integer>(12) );
		node.addChildNode( new HomogeneousTreeNode<Integer>(11) );
		
		int firstChildValue = node.getChildAtIndex(0).getValue();
		int secondChildValue = node.getChildAtIndex(1).getValue();
		assertTrue( firstChildValue == 12 && secondChildValue == 11 );
		
		int childNodeCount = node.getNumberOfChildNodes();
		assertTrue( childNodeCount == 2 );
	}
	
	@Test
	public void shouldAddThreeChildNodesWithOneChildEach() {
		HomogeneousTreeNode<Integer> node = new HomogeneousTreeNode<Integer>( 13 );
		node.addChildNode( new HomogeneousTreeNode<Integer>(12) );
		node.addChildNode( new HomogeneousTreeNode<Integer>(11) );
		node.addChildNode( new HomogeneousTreeNode<Integer>(10) );
		
		HomogeneousTreeNode<Integer> firstChild = node.getChildAtIndex(0);
		HomogeneousTreeNode<Integer> secondChild = node.getChildAtIndex(1);
		HomogeneousTreeNode<Integer> thirdChild = node.getChildAtIndex(2);
		
		firstChild.addChildNode( new HomogeneousTreeNode<Integer>(9) );
		secondChild.addChildNode( new HomogeneousTreeNode<Integer>(8) );
		thirdChild.addChildNode( new HomogeneousTreeNode<Integer>(7) );
		
		assertTrue(
			firstChild.getNumberOfChildNodes() == 1 &&
			secondChild.getNumberOfChildNodes() == 1 &&
			thirdChild.getNumberOfChildNodes() == 1
		);
	}

	// HomogeneousTree class tests
	/*
	 * Constructor tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void treeConstructorShouldThrowIllegalArgumentException() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>( null );
	}
	
	@Test
	public void shouldCreateTreeWithRoot1337() {
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>( 1337 );
		assertTrue( tree.getRootNode().getValue() == 1337 );
	}
	
	/*
	 * printDFS() tests
	 */
	@Test
	public void shouldPrintAllTreeNodeValues() {
		int[] treeNodeValues = new int[] { 1, 2, 3, 4, 5, 6 };
		
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>( treeNodeValues[0] );
		
		tree.getRootNode().addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[1]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[2]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[3]) );
		tree.getRootNode().addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[4]) );
		tree.getRootNode().getChildAtIndex(1).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[5]) );
		
		tree.printDFS();
		
		String output = consoleOutput.toString();
		
		for (int treeNodeValue : treeNodeValues) {
			assertTrue( output.contains(String.valueOf(treeNodeValue)) );
		}
	}
	
	@Test
	public void shouldPrintAllThreeNodeValuesInDFSOrder() {
		int[] treeNodeValues = new int[] { 1, 2, 3, 4, 5, 6 };
		
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>( treeNodeValues[0] );
		
		tree.getRootNode().addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[1]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[2]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[3]) );
		tree.getRootNode().addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[4]) );
		tree.getRootNode().getChildAtIndex(1).addChildNode( new HomogeneousTreeNode<Integer>(treeNodeValues[5]) );
		
		tree.printDFS();
		
		/* Tree structure looks like this: 
		   1 (root)
			- 2 (child 1)
			  - 3 (child 1 of child 1)
			  - 4 (child 2 of child 1)
			- 5 (child 2)
			  - 6 (child 1 of child 2)
		*/
		
		String expectedOutput = "3 4 2 6 5 1 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
}