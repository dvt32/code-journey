package net.dvt32.concurrency.task6;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This program implements a Hashtable with keys that expire if they haven't been used
 * in a specified number of seconds (by "not used" we mean that their value 
 * hasn't changed via put() and they haven't been retrieved via get()).
 * 
 * This is done by storing a Future object for every key, which informs us
 * whether the key was recently accessed or not.
 * 
 * To get a Future object for every key, we use a ScheduledExecutorService object.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class TimeoutHashtable {
	private Map<String, Object> hashTable;
	private Map< String, Future<?> > keyFutures;
	private ScheduledExecutorService executorService;
	private int keyLifeInSeconds;
	
	/**
	 * This constructor initializes the internal hashtables and the executor service.
	 * It also sets the lifespan of every key in the hashtable (in seconds).
	 * 
	 * @param keyLifeInSeconds The key's lifespan in seconds
	 */
	public TimeoutHashtable(int keyLifeInSeconds) {
		hashTable = new Hashtable<String, Object>();
		keyFutures = new Hashtable< String, Future<?> >();
		executorService = Executors.newScheduledThreadPool(1);
		this.keyLifeInSeconds = keyLifeInSeconds;
	}
	
	/**
	 * This method overrides the Map toString() method,
	 * in order to print the contents of the internal hashtable more easily.
	 */
	public String toString() {
		return this.hashTable.toString();
	}
	
	/**
	 * This method removes a certain key from the internal hashtable 
	 * and returns that key's corresponding value.
	 * 
	 * If the key does not exist, null is returned.
	 * 
	 * @param key The key to be removed from the internal hashtable
	 * @return The removed key's corresponding value, null if the key does not exist
	 */
	public Object remove(String key) {
		Object removedKeyValue = hashTable.remove(key);
		return removedKeyValue;
	}
	
	/**
	 * This method adds a key/pair value to the internal hashtable.
	 * 
	 * Every key has its own Future object. 
	 * If the key's current future is not null (i.e. this is not a new key), that means
	 * that the key's life has already begun and the executor service is counting until its expiration.
	 * 
	 * Since we're accessing that key via put(), we're resetting its future 
	 * and the executor service starts counting again from 0.
	 * 
	 * If it IS a new key, then we simply give it a Future object and the executor service starts counting.
	 * 
	 * @param key The key to be added
	 * @param value The value corresponding to that key
	 */
	public void put(final String key, Object value) {
		hashTable.put(key, value);
		
		Future<?> keyCurrentFuture = keyFutures.get(key);
		if ( keyCurrentFuture != null ) {
			keyCurrentFuture.cancel(true);
		}
		Future<?> keyNewFuture = executorService.schedule(
			new Runnable() {
				public void run() {
					hashTable.remove(key);
				}  
			}, 
			keyLifeInSeconds, 
			TimeUnit.SECONDS
		);
		keyFutures.put(key, keyNewFuture);
	}
	
	/**
	 * This method retrieves a value corresponding to a key in the internal hashtable.
	 * 
	 * Every key has its own Future object. 
	 * If the key's current future is not null (i.e. this is not a new key), that means
	 * that the key's life has already begun and the executor service is counting until its expiration.
	 * 
	 * Since we're accessing that key via get(), we're resetting its future 
	 * and the executor service starts counting again from 0.
	 * 
	 * @param key The key whose value is to be returned
	 * @return The value corresponding to the passed key argument, null if the key doesn't exist
	 */
	public Object get(final String key) {
		Object keyValue = hashTable.get(key);
		if (keyValue == null) {
			return null;
		}
		
		Future<?> keyCurrentFuture = keyFutures.get(key);
		if ( keyCurrentFuture != null ) {
			keyCurrentFuture.cancel(true);
		}
		Future<?> keyNewFuture = executorService.schedule(
			new Runnable() {
				public void run() {
					hashTable.remove(key);
				}  
			}, 
			keyLifeInSeconds, 
			TimeUnit.SECONDS
		);
		keyFutures.put(key, keyNewFuture);
		
		return keyValue;
	}
	
	/**
	 * This is the program's main method.
	 * 
	 * 1. It creates a hashtable with a 3 second lifespan for each key.
	 * 2. It adds 2 elements to the hashtable. 
	 *    Since 3 seconds haven't passed, both of them are still in the hashtable.
	 * 3. The program waits 2 seconds.
	 *    Since 3 seconds still haven't passed, both of the elements are still in the hashtable.
	 * 4. The first added element is accessed via get(). This resets that element's lifespan.
	 * 5. The program waits 1 second.
	 *    Now the first element is still in the hashtable, but the second isn't, because 3 seconds have passed
	 *    since it was last accessed via put().
	 * 6. A third element is added.
	 * 7. The program waits 2 seconds.
	 * 	  By now, the first key has expired (3 seconds have passed since it was last accessed)
	 *    and the only left element in the hashtable is the third one.
	 * 8. The executor service shuts down and the JVM is terminated via System.exit()
	 */
	public static void main(String[] args) throws InterruptedException {
		TimeoutHashtable timeoutHashtable = new TimeoutHashtable(3);
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		
		timeoutHashtable.put("1", "a");
		timeoutHashtable.put("2", "b");
		System.out.println("Contents of TimeoutHashtable: " + timeoutHashtable);
		
		waitSeconds(2, executorService);
		System.out.println("Contents of TimeoutHashtable: " + timeoutHashtable);
		
		timeoutHashtable.get("1");
		waitSeconds(1, executorService);
		System.out.println("Contents of TimeoutHashtable: " + timeoutHashtable);
		
		timeoutHashtable.put("3", "c");
		waitSeconds(2, executorService);
		System.out.println("Contents of TimeoutHashtable: " + timeoutHashtable);
		
		executorService.shutdown();
		System.exit(0);
	}
	
	/**
	 * This method makes the program wait for a certain number of seconds.
	 * 
	 * A CountDownLatch is used, in order to stop the program's further execution 
	 * until AFTER the scheduled task has been completed by the ExecutorService.
	 * 
	 * @param seconds The number of seconds for the program to wait.
	 * @param executorService The ExecutorService that prints a message after the specified number of seconds have passed
	 */
	public static void waitSeconds(final int seconds, final ScheduledExecutorService executorService) 
		throws InterruptedException 
	{
		final CountDownLatch latch = new CountDownLatch(1);
		
		executorService.schedule(
			new Runnable() {
				public void run() {
					System.out.println(seconds + " seconds have passed!");
					latch.countDown();
				}  
			}, 
			seconds, 
			TimeUnit.SECONDS
		);
		
		latch.await();
	}
}