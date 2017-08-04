package net.dvt32.generictypesclassesandobjects.task2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.dvt32.generictypesclassesandobjects.task2.HeterogeneousTree.HeterogeneousTreeNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeterogeneousTreeTest {

private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}
	
	// HeterogeneousTreeNode class tests
	/*
	 * Constructor tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructorShouldThrowIllegalArgumentException() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( null );
	}
	
	@Test
	public void shouldCreateNodeWithIntegerValue() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( 1337 );
		assertTrue( (Integer) node.getValue() == 1337 );
	}
	
	@Test
	public void shouldCreateNodeWithStringValue() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( "1337" );
		assertTrue( ((String) node.getValue()).equals("1337") );
	}
	
	@Test
	public void shouldCreateNodeWithDoubleValue() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( 1337.13d );
		assertTrue( (Double) node.getValue() == 1337.13d );
	}
	
	/*
	 * addChildNode() tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void addChildNodeMethodShouldThrowIllegalArgumentException() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( 13 );
		node.addChildNode( new HeterogeneousTreeNode(null) );
	}
	
	@Test
	public void shouldAddTwoChildNodes() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( 13 );
		node.addChildNode( new HeterogeneousTreeNode("12") );
		node.addChildNode( new HeterogeneousTreeNode(11.0d) );
		
		boolean firstChildIsString = node.getChildAtIndex(0).getValue() instanceof String;
		boolean secondChildIsDouble = node.getChildAtIndex(1).getValue() instanceof Double;
		assertTrue( firstChildIsString && secondChildIsDouble );
		
		String firstChildValue = (String) node.getChildAtIndex(0).getValue();
		double secondChildValue = (Double) node.getChildAtIndex(1).getValue();
		assertTrue( firstChildValue.equals("12") && secondChildValue == 11.0d );
		
		int childNodeCount = node.getNumberOfChildNodes();
		assertTrue( childNodeCount == 2 );
	}
	
	@Test
	public void shouldAddThreeChildNodesWithOneChildEach() {
		HeterogeneousTreeNode node = new HeterogeneousTreeNode( 13 );
		node.addChildNode( new HeterogeneousTreeNode("12") );
		node.addChildNode( new HeterogeneousTreeNode(11.0d) );
		node.addChildNode( new HeterogeneousTreeNode(10l) );
		
		HeterogeneousTreeNode firstChild = node.getChildAtIndex(0);
		HeterogeneousTreeNode secondChild = node.getChildAtIndex(1);
		HeterogeneousTreeNode thirdChild = node.getChildAtIndex(2);
		
		firstChild.addChildNode( new HeterogeneousTreeNode("9") );
		secondChild.addChildNode( new HeterogeneousTreeNode('7') );
		thirdChild.addChildNode( new HeterogeneousTreeNode(6f) );
		
		assertTrue(
			firstChild.getNumberOfChildNodes() == 1 &&
			secondChild.getNumberOfChildNodes() == 1 &&
			thirdChild.getNumberOfChildNodes() == 1
		);
	}
	
	// HeterogeneousTree class tests
	/*
	 * Constructor tests
	 */
	@Test(expected = IllegalArgumentException.class)
	public void treeConstructorShouldThrowIllegalArgumentException() {
		HeterogeneousTree tree = new HeterogeneousTree( null );
	}
	
	@Test
	public void shouldCreateTreeWithIntegerRoot() {
		HeterogeneousTree tree = new HeterogeneousTree( 1337 );
		assertTrue( 
			(Integer) tree.getRootNode().getValue() == 1337 
		);
	}
	
	@Test
	public void shouldCreateTreeWithStringRoot() {
		HeterogeneousTree tree = new HeterogeneousTree( "1337" );
		assertTrue( 
			((String) tree.getRootNode().getValue()).equals("1337") 
		);
	}
	
	@Test
	public void shouldCreateTreeWithDoubleRoot() {
		HeterogeneousTree tree = new HeterogeneousTree( 1337.13d );
		assertTrue( 
			(Double) tree.getRootNode().getValue() == 1337.13d
		);
	}
	
	/*
	 * printDFS() tests
	 */
	@Test
	public void shouldPrintAllTreeNodeValues() {
		Object[] treeNodeValues = new Object[] { 
			"1",
			2,
			3.0d,
			4.0f,
			'5',
			6l
		};
		
		HeterogeneousTree tree = new HeterogeneousTree( treeNodeValues[0] );
		
		tree.getRootNode().addChildNode( new HeterogeneousTreeNode(treeNodeValues[1]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HeterogeneousTreeNode(treeNodeValues[2]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HeterogeneousTreeNode(treeNodeValues[3]) );
		tree.getRootNode().addChildNode( new HeterogeneousTreeNode(treeNodeValues[4]) );
		tree.getRootNode().getChildAtIndex(1).addChildNode( new HeterogeneousTreeNode(treeNodeValues[5]) );
		
		tree.printDFS();
		
		String output = consoleOutput.toString();
		
		for (Object treeNodeValue : treeNodeValues) {
			assertTrue( output.contains(String.valueOf(treeNodeValue)) );
		}
	}
	
	@Test
	public void shouldPrintAllTreeNodeValuesInDFSOrder() {
		Object[] treeNodeValues = new Object[] { 
			"1",
			2,
			3.0d,
			4.0f,
			'5',
			6l
		};
		
		HeterogeneousTree tree = new HeterogeneousTree( treeNodeValues[0] );
		
		tree.getRootNode().addChildNode( new HeterogeneousTreeNode(treeNodeValues[1]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HeterogeneousTreeNode(treeNodeValues[2]) );
		tree.getRootNode().getChildAtIndex(0).addChildNode( new HeterogeneousTreeNode(treeNodeValues[3]) );
		tree.getRootNode().addChildNode( new HeterogeneousTreeNode(treeNodeValues[4]) );
		tree.getRootNode().getChildAtIndex(1).addChildNode( new HeterogeneousTreeNode(treeNodeValues[5]) );
		
		tree.printDFS();
		
		/* Tree structure looks like this: 
		   "1" (root)
			- 2 (child 1)
			  - 3.0d (child 1 of child 1)
			  - 4.0f (child 2 of child 1)
			- '5' (child 2)
			  - 6l (child 1 of child 2)
		*/
		
		String expectedOutput = "3.0 4.0 2 6 5 1 ";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
}