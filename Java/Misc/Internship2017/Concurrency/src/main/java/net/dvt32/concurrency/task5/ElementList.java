package net.dvt32.concurrency.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * This program implements a list with a fixed size 
 * and its basic operations (add, remove, print elements).
 * 
 * When a user tries to add an element to a full list
 * or remove an element from an empty list, 
 * a custom unchecked exception is thrown.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ElementList {
	private List<Object> elements;
	private int maxListSize;
	
	Thread addThread;
	Thread removeThread;
	
	/**
	 * Constructor, which sets the maximum size of the list.
	 * If the passed argument is not a positive number, an exception is thrown.
	 * 
	 * The constructor also initializes the internal ArrayList.
	 * 
	 * @param maxListSize The list's maximum size (max number of elements in it)
	 */
	public ElementList(int maxListSize) {
		if (maxListSize <= 0) {
			throw new IllegalArgumentException("Max list size must be a positive number!");
		}
		
		this.elements = new ArrayList<Object>();
		this.maxListSize = maxListSize;
	}
	
	/**
	 * Getter for the maxListSize attribute
	 * 
	 * @return The 'maxListSize' attribute's value
	 */
	public synchronized int getMaxListSize() {
		return maxListSize;
	}
	
	/**
	 * This method tries to add a new element 
	 * to the internal ArrayList (element can be any object type).
	 * 
	 * If the list is already full, however, 
	 * a custom unchecked exception (with an error message) is thrown.
	 * 
	 * @param obj The Object that is to be added to the internal ArrayList
	 */
	public synchronized void add(Object obj) {
		if ( elements.size() == getMaxListSize() ) {
			// wait to remove element
		}
		else {
			elements.add(obj);
		}
	}
	
	/**
	 * This method tries to remove the last element in the internal ArrayList.
	 * 
	 * If the list is empty, however,
	 * a custom unchecked exception (with an error message) is thrown.
	 */
	public synchronized void remove() {
		if ( elements.size() == 0 ) {
			// wait to enter element
		}
		else {
			int lastElementIndex = elements.size()-1;
			elements.remove(lastElementIndex);
		}
	}
	
	/**
	 * This method prints all elements in the internal ArrayList.
	 * If the list is empty, there is no output to the console.
	 */
	public synchronized void printAllElements() {
		for (Object element : elements) {
			System.out.print( element + " " );
		}
		System.out.println();
	}
}