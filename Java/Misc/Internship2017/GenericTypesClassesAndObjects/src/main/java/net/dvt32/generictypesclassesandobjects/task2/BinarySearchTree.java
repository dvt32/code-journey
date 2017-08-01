package net.dvt32.generictypesclassesandobjects.task2;

/**
 * This program is a simple implementation of a Binary Search Tree (BST) with integer elements.
 * 
 * It supports the following operations:
 * - insert an element (only if it's not in the tree already)
 * - traverse and print all values in preorder/inorder/postorder
 * - search for a specific element and determine if it exists in the tree
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class BinarySearchTree {
	private int rootValue;
	private BinarySearchTree leftSubtree;
	private BinarySearchTree rightSubtree;
	
	public BinarySearchTree(int rootValue) {
		this.rootValue = rootValue;
		leftSubtree = null;
		rightSubtree = null;
	}
	/**
	 * This is an additional constructor, which 
	 * allows us to initialize the BST with certain nodes, 
	 * by passing an integer array, which contains the nodes' values.
	 * 
	 * @param rootValue The value of the BST's root node
	 * @param nodeValues An integer array with node values for nodes we want to add to the BST
	 */
	public BinarySearchTree(int rootValue, int[] nodeValues) {
		this.rootValue = rootValue;
		leftSubtree = null;
		rightSubtree = null;
		
		for (int nodeValue : nodeValues) {
			addNode(nodeValue);
		}
	}
	
	/**
	 * This method inserts a new node (element) in the BST, 
	 * as long as that node's value is not already present in the tree.
	 * 
	 * According to the BST definition:
	 * - if nodeValue < rootValue, node will be added to the left subtree
	 * - if nodeValue >= rootValue, node will be added to the right subtree
	 * 
	 * @param nodeValue The node value, which we want to add to the BST.
	 */
	public void addNode(int nodeValue) {
		if (containsNode(nodeValue)) {
			return;
		}
		
		if (nodeValue < rootValue) {
			if (leftSubtree != null) {
				leftSubtree.addNode(nodeValue);
			}
			else {
				leftSubtree = new BinarySearchTree(nodeValue);
			}
		}
		else {
			if (rightSubtree != null) {
				rightSubtree.addNode(nodeValue);
			}
			else {
				rightSubtree = new BinarySearchTree(nodeValue);
			}
		}
	}
	
	/**
	 * This method searches recursively within the BST to see if a node with a specified value exists.
	 * 
	 * @param nodeValueToFind The value of the node we're searching for.
	 * @return "true" if the element was found, "false" otherwise
	 */
	public boolean containsNode(int nodeValueToFind) {
		if (rootValue == nodeValueToFind) {
            return true;
		}
		else if (nodeValueToFind < rootValue && leftSubtree != null) {
			return leftSubtree.containsNode(nodeValueToFind);
	    }
		else if (nodeValueToFind > rootValue && rightSubtree != null){
			return rightSubtree.containsNode(nodeValueToFind);
		}
		
		return false;
	}
	
	/**
	 * This method traverses and prints the tree's elements in "preorder" (Root-Left-Right) recursively.
	 * First the root is printed, then its left subtree and finally its right subtree.
	 */
	public void printPreorder() {
		System.out.print(rootValue + " ");
		if (leftSubtree != null) {
			leftSubtree.printPreorder();
		}
		if (rightSubtree != null) {
			rightSubtree.printPreorder();
		}
	}
	
	/**
	 * This method traverses and prints the tree's elements in "inorder" (Left-Root-Right) recursively.
	 * First the left subtree is printed, then the root and finally the right subtree.
	 * 
	 * This method will print all tree node values in ASCENDING order.
	 */
	public void printInorder() {
		if (leftSubtree != null) {
			leftSubtree.printInorder();
		}
		System.out.print(rootValue + " ");
		if (rightSubtree != null) {
			rightSubtree.printInorder();
		}
	}
	
	/**
	 * This method traverses and prints the tree's elements in "postorder" (Left-Right-Root) recursively.
	 * First the left subtree is printed, then the right subtree and finally the root.
	 */
	public void printPostorder() {
		if (leftSubtree != null) {
			leftSubtree.printPostorder();
		}
		if (rightSubtree != null) {
			rightSubtree.printPostorder();
		}
		System.out.print(rootValue + " ");
	}
}