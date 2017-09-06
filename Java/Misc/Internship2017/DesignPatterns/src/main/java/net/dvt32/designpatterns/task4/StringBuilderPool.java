package net.dvt32.designpatterns.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * This program is a simple implementation of the Object pool pattern.
 * 
 * This pool is for StringBuilder objects and has a max size attribute,
 * which determines how many objects it can hold at maximum.
 * 
 * The objects themselves are stored in an internal list.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class StringBuilderPool {
	private int maxSize;
	List<StringBuilder> availableObjects;
	
	/**
	 * This constructor initializes the list of available objects.
	 * 
	 * The pool's max size MUST be a positive number, 
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param maxSize The max number of objects the pool can hold
	 */
	public StringBuilderPool(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("The pool's max size must be a positive number!");
		}
		this.maxSize = maxSize;
		
		
		availableObjects = new ArrayList<StringBuilder>();
		for (int i = 0; i < maxSize; ++i) {
			availableObjects.add( new StringBuilder() );
		}
	}
	
	/**
	 * This method returns an available object from the object pool.
	 * By default, this is the last added object to the list.
	 * 
	 * If there are no available objects, an IllegalStateException is thrown.
	 * 
	 * @return An available StringBuilder object.
	 */
	public StringBuilder acquire() {
		if (availableObjects.size() > 0) {
			int lastAvailableObjectIndex = availableObjects.size()-1;
			StringBuilder availableObject = availableObjects.remove(lastAvailableObjectIndex);
			return availableObject;
		}
		else {
			throw new IllegalStateException("No free resources available!");
		}
	}
	
	/**
	 * This method adds an object to the internal object list (the pool),
	 * but only if the list's size is less than the pool's max size.
	 * 
	 * If that condition is not met, an IllegalStateException is thrown.
	 * 
	 * @param releasedObject The object to be released in the pool
	 */
	public void release(StringBuilder releasedObject) {
		if (this.availableObjects.size() < this.maxSize) {
			availableObjects.add(releasedObject);
		}
		else {
			throw new IllegalStateException("The pool cannot hold any more objects!");
		}
	}
	
	/**
	 * This method returns the pool's current size.
	 * 
	 * @return The pool's current size.
	 */
	public int size() {
		int poolSize = availableObjects.size();
		return poolSize;
	}
}