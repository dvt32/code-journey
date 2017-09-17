package net.dvt32.concurrency.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * This program implements a list with a fixed size 
 * and its basic operations (add element, remove last element, print elements).
 * 
 * In the main method, two threads are running concurrently 
 * - a thread that ADDS elements and 
 * - a thread that REMOVES elements.
 * 
 * In case the REMOVE thread tries to remove an element from an empty list,
 * it waits for the ADD thread to add an element (1 or more) and then it removes the last element.
 * (it waits for around 1 second, otherwise it won't remove anything).
 * 
 * In case the ADD thread tries to add an element to a full list,
 * it waits for the REMOVE thread to remove an element (1 or more) and then it adds that new element
 * (it waits for around 1 second, otherwise it won't add anything).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ElementList {
	private List<Object> elements;
	private int maxListSize;
	
	// This object is used as an "intrinsic lock", in order to keep program execution synchronized.
	private final Object lock = new Object();
	
	// This constant defines how long to wait on every lock.wait() call
	private final long TIME_TO_WAIT_IN_MILLISECONDS = 1000;
	
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
	 * Getter for the maxListSize attribute.
	 * 
	 * @return The 'maxListSize' attribute's value
	 */
	public int getMaxListSize() {
		synchronized (lock) {
			return maxListSize;
		}
	}
	
	/**
	 * This method prints all elements in the internal ArrayList.
	 * If the list is empty, there is no output to the console.
	 */
	public void printAllElements() {
		for (Object element : elements) {
			System.out.print( element + " " );
		}
		System.out.println();
	}
	
	/**
	 * This method tries to add a new element 
	 * to the internal ArrayList (element can be any object type).
	 * 
	 * If the list is already full, however, 
	 * the method waits (around 1 second) for another thread to remove an element (1 or more)
	 * and if it does - the original element is added. Otherwise, nothing is added to the list.
	 * 
	 * @param obj The Object that is to be added to the internal ArrayList
	 */
	public void add(Object obj) 
		throws InterruptedException 
	{
		synchronized (lock) {
			if ( elements.size() == getMaxListSize() ) {
				System.out.println("Can't add " + obj + " (full list) -> waiting for element(s) to be removed...");
				
				lock.wait(TIME_TO_WAIT_IN_MILLISECONDS);
				
				// If an element was removed by another thread while waiting, add the original element
				if ( elements.size() < getMaxListSize() ) {
					elements.add(obj);
					System.out.println("Added " + obj);
				}
			}
			else {
				elements.add(obj);
				System.out.println("Added " + obj);
				lock.notifyAll();
			}
		}
	}
	
	/**
	 * This method tries to remove the last element in the internal ArrayList.
	 * 
	 * If the list is empty, however,
	 * the method waits (around 1 second) for another thread to add an element (1 or more)
	 * and if it does - the last added element is removed. Otherwise, nothing is removed from the list.
	 */
	public void remove() 
		throws InterruptedException 
	{
		synchronized (lock) {
			if ( elements.size() == 0 ) {
				System.out.println("Can't remove (empty list) -> waiting for element(s) to be added...");
				
				lock.wait(TIME_TO_WAIT_IN_MILLISECONDS);
				
				// // If an element (1 or more) was added by another thread while waiting, remove the last added element
				if ( elements.size() > 0 ) {
					int lastElementIndex = elements.size()-1;
					System.out.println("Removed " + elements.remove(lastElementIndex) );
				}
			}
			else {
				int lastElementIndex = elements.size()-1;
				System.out.println("Removed " + elements.remove(lastElementIndex) );
				lock.notifyAll();
			}
		}
	}
	
	/**
	 * This is the program's main method.
	 * 
	 * It starts the two threads:
	 * - ADD thread, which only adds elements and 
	 * - REMOVE thread, which only removes elements
	 * 
	 * They are running concurrently and once they have finished,
	 * the list of elements is printed.
	 * 
	 * The element list object is marked as "final", in order to be able 
	 * to be used in the Runnable run() method.
	 */
	public static void main(String[] args) 
		throws InterruptedException 
	{
		final ElementList elementList = new ElementList(2);
		
		Thread addThread = new Thread(new Runnable() {
			public void run() {
				try {
					elementList.add(1);
					elementList.add(2);
					elementList.add(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			} 
		});
		
		Thread removeThread = new Thread(new Runnable() {
			public void run() {
				try {
					elementList.remove();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		addThread.start();
		removeThread.start();
		
		// Make sure threads have finished executing
		addThread.join();
		removeThread.join();
		
		elementList.printAllElements();
	}
}