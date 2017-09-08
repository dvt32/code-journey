package net.dvt32.designpatterns.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * This program is a simple implementation of the Object pool pattern.
 * 
 * This pool is for StringBuilder objects and has a certain size (specified in 
 * the constructor), which determines how many objects it holds.
 * 
 * The objects themselves are stored in an internal list.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class StringBuilderPool {
	List<StringBuilder> availableObjects;
	List<StringBuilder> currentlyUsedObjects;
	
	/**
	 * This constructor initializes the list of available objects.
	 * 
	 * The pool's size MUST be a positive number, 
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param size The number of objects, which the pool will contain
	 */
	public StringBuilderPool(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The pool's size must be a positive number!");
		}
		
		availableObjects = new ArrayList<StringBuilder>();
		for (int i = 0; i < size; ++i) {
			availableObjects.add( new StringBuilder() );
		}
		
		currentlyUsedObjects = new ArrayList<StringBuilder>();
	}
	
	/**
	 * This method returns an available object from the object pool.
	 * By default, this is the last object in the list of available objects.
	 * 
	 * This object is then removed from the available object list
	 * and added to the list of currently used objects.
	 * Then finally it is returned to the caller.
	 * 
	 * If there are no available objects, an IllegalStateException is thrown.
	 * 
	 * @return An available StringBuilder object.
	 */
	public StringBuilder acquire() {
		if (availableObjects.size() > 0) {
			int lastAvailableObjectIndex = availableObjects.size()-1;
			StringBuilder availableObject = availableObjects.remove(lastAvailableObjectIndex);
			currentlyUsedObjects.add(availableObject);
			return availableObject;
		}
		else {
			throw new IllegalStateException("No free resources available!");
		}
	}
	
	/**
	 * This method adds an object to the internal object list (the pool),
	 * but only if this object was from the original pool.
	 * 
	 * If that's the case, this object is released (removed from
	 * the currently used object list) and re-added to the list of available objects.
	 * 
	 * If that condition is NOT met, an IllegalStateException is thrown.
	 * 
	 * @param releasedObject The object to be released in the pool
	 */
	public void release(StringBuilder releasedObject) {
		if ( currentlyUsedObjects.contains(releasedObject) ) {
			currentlyUsedObjects.remove(releasedObject);
			availableObjects.add(releasedObject);
		}
		else {
			throw new IllegalStateException("The released object is not part of the pool!");
		}
	}
	
	/*
	 * Additional helper methods, which get 
	 * the number of available / currently used 
	 * objects (used for JUnit testing).
	 */
	public int getNumberOfAvailableObjects() {
		int numberOfAvailableObjects = availableObjects.size();
		return numberOfAvailableObjects;
	}
	
	public int getNumberOfCurrentlyUsedObjects() {
		int numberOfCurrentlyUsedObjects = currentlyUsedObjects.size();
		return numberOfCurrentlyUsedObjects;
	}
}