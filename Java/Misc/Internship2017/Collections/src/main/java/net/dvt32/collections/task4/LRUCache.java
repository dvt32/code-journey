package net.dvt32.collections.task4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * This program implements the LRU algorithm
 * by caching a certain number of map entries from a LinkedHashMap.
 * 
 * A LinkedHashMap is used, because such a map keeps 
 * the original "put" order of the elements.
 * 
 * A LRUCache object has a certain capacity (the max number of map entries it caches).
 * 
 * Here's an example of how the LRU cache works. 
 * 
 * 1. First we have a LRUCache object with a capacity of 2.
 * 2. We add the entries (1, 1) and (2, 2) to the internal map. 
 * 3. Now we retrieve the entry (2, 2) and store its value in a variable.
 * 	  We repeat the same with (1, 1).
 * 4. Finally, we decide to add another element to the internal map (3, 3).
 *    Only one problem - our LRUCache only has a capacity of 2.
 * 5. Since this third element is beyond the LRUCache's capacity,
 *    we check what the Least Recently Used (LRU) element is. 
 *    Turns out it's (2, 2). Why? Here's a list of things we did with both elements (in order)
 *    - 1) We added (1, 1)
 *    - 2) We added (2, 2)
 *    - 3) We retrieved (2, 2)
 *    - 4) We retrieved (1, 1)
 *    The MOST recently used element was (1, 1), since the last thing we did was retrieve its value. 
 *    Therefore, the LEAST recently used element is (2, 2).
 *    Since that's the case, we remove the LRU element and add (3, 3) at the end of the internal map.
 *    Note that BOTH "adding" and "retrieving" are considered "using" the entry.

 * Done! The internal map has 2 elements now - (1, 1) and (3, 3).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class LRUCache {
	private int capacity;
	private Map<Integer, Integer> map;
	
	/**
	 * This constructor initializes the internal map 
	 * and also sets the cache's capacity.
	 * 
	 * The capacity MUST be a positive number (otherwise an IllegalArgumentException is thrown).
	 * 
	 * @param capacity The max number of cached entries from the internal map
	 */
	public LRUCache(int capacity) {
		this.capacity = capacity;
		if (this.capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be a positive number!");
		}
		this.map = new LinkedHashMap<Integer, Integer>();
	}
	
	/**
	 * This method retrieves a value from the internal map by specifying a key.
	 * 
	 * If the value does not exist in the map, a NoSuchElementException is thrown.
	 * Otherwise the element's value is returned.
	 * 
	 * Before returning the value, however,
	 * this map entry is re-put in the internal map (it is removed and re-added at the end of the map).
	 * This is done so that the LRU element is always the first one in the map.
	 * 
	 * @param key The key to be found in the internal map
	 * @return The value corresponding to the specified key in the internal map
	 */
	public int get(int key) {
		Integer value = this.map.get(key);
		if (value == null) {
			throw new NoSuchElementException("No such element in the internal map!");
		}
		else {
			this.put(key, value);
		}
		return value;
	}
	
	/**
	 * This method adds a new entry to the internal map by specifying a key/value pair.
	 * 
	 * In case there is already such a key in the map, it is removed and re-added to the internal map.
	 * This is done so that the LRU element is always the first one in the map.
	 * 
	 * In case the key does not exist, but we've reached the LRU cache's capacity,
	 * we first remove the LRU element (always the first one) and THEN add the new element at the end of the map.
	 * 
	 * In case we're still within the LRUCache's capacity and the key does not exist yet, 
	 * the element is simply added to the internal map (at the end).
	 * 
	 * @param key The entry's key
	 * @param value The value corresponding to the entry's key
	 */
	public void put(int key, int value) {
		if ( this.map.containsKey(key) ) {
			this.map.remove(key);
		}
		else if ( this.map.size() == this.capacity ){
			Iterator<Integer> it = this.map.keySet().iterator();
			it.next(); // move iterator to first element of the map
			it.remove(); // remove the first element from the map
		}
		this.map.put(key, value);
	}
	
	/**
	 * This method overrides the Map toString() method,
	 * in order to print the contents of the internal map more easily.
	 */
	@Override
	public String toString() {
		return this.map.toString();
	}
}