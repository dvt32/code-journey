package net.dvt32.generictypesclassesandobjects.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * This program is a simple implementation of a homogeneous tree.
 * 
 * Each node of the tree can have an infinite amount of child nodes.
 * Each of these child nodes can also have an infinite amount of child nodes.
 * 
 * Every node has a "value" attribute.
 * The program can visit each node and print its value.
 * 
 * @author Dimitar Trifonov (dvt32)
 *
 * @param <T> the type of nodes, which will be included in the tree (can be any type of object)
 */
public class HomogeneousTree<T> {
	/**
	 * This inner class represents the internal structure of a single node, 
	 * which will later be added to a homogeneous tree.
	 * 
	 * Each node has a "value" attribute and list of child nodes.
	 * Since a tree data structure does not allow multiple parents of a single child, 
	 * we also keep a boolean variable 'hasParentNode', which prevents that from happening.
	 * 
	 * Null elements are not allowed.
	 * 
	 * @author Dimitar Trifonov (dvt32)
	 *
	 * @param <T> The node's element type (can be any type of object)
	 */
	public static class HomogeneousTreeNode<T> {
		private T value;
		private List< HomogeneousTreeNode<T> > childNodes;
		private boolean hasParentNode;
		
		/**
		 * Default constructor for the HomogeneousTreeNode class, 
		 * which initializes a new node and gives it the passed value.
		 * 
		 * If the passed value is null, the node is disregarded.
		 * 
		 * @param value The node's value.
		 */
		public HomogeneousTreeNode(T value) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.setValue(value);
			this.childNodes = new ArrayList< HomogeneousTreeNode<T> >(); 
			this.hasParentNode = false;
		}
		
		/*
		 * Getter/setter methods
		 */
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public int getNumberOfChildNodes() {
			return childNodes.size();
		}	
		public HomogeneousTreeNode<T> getChildAtIndex(int index) {
			return childNodes.get(index);
		}
		public boolean hasParentNode() {
			return hasParentNode;
		}
		
		/**
		 * This method tries to add a node as a child of the current node (the one calling the method).
		 * However, if this child node already has a parent or is null, it is disregarded.
		 * 
		 * @param childNode The child node to be added.
		 */
		public void addChildNode(HomogeneousTreeNode<T> childNode) {
			if (childNode == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			if ( childNode.hasParentNode() ) {
				throw new IllegalArgumentException("Child already has a parent!");
			}
			childNodes.add(childNode);
			childNode.hasParentNode = true;
		}
	}
	
	private HomogeneousTreeNode<T> rootNode;
	
	/**
	 * Default constructor for the HomogeneousTree class,
	 * which initializes a new homogeneous tree with a passed root node's value.
	 * 
	 * A new node is created with this value and is then added to the tree 
	 * (if the passed value is not null).
	 * 
	 * @param rootNodeValue The tree's root node value.
	 */
	public HomogeneousTree(T rootNodeValue) {
		if (rootNodeValue == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		rootNode = new HomogeneousTreeNode<T>(rootNodeValue);
	}
	
	/**
	 * This method returns the tree's root node (NOT its value).
	 * 
	 * @return The homogeneous tree's root node.
	 */
	public HomogeneousTreeNode<T> getRootNode() {
		return rootNode;
	}
	
	/**
	 * This method prints all of the elements of the homogeneous tree by using Depth-first Search (DFS).
	 * It starts at the root and explores as far as possible along each branch before backtracking.
	 * 
	 * This method has two implementations, in order to make it easier to call.
	 * This way we don't have to call it by passing the root node as an initial argument.
	 * Instead we can simply call the no argument implementation, which will call the 1-argument implementation.
	 */
	public void printDFS() {
		printDFS(rootNode);
	}
	private void printDFS(HomogeneousTreeNode<T> node) {
		if (rootNode == null) {
			return;
		}
		
		for (int i = 0; i < node.getNumberOfChildNodes(); ++i) {
			HomogeneousTreeNode<T> child = node.getChildAtIndex(i);
			printDFS(child);
		}
		
		System.out.print(node.getValue() + " ");
	}
}