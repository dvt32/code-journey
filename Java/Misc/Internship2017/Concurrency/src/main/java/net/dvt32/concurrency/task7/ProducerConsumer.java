package net.dvt32.concurrency.task7;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This program implements a simple solution to the Producer/Consumer problem
 * and it supports multiple producers and consumers.
 * 
 * A shared warehouse is used and that warehouse has a max capacity/size.
 * 
 * In other words, if the warehouse is full, a producer will have to wait
 * for a consumer to buy an item, before he can produce a new one and put it 
 * in the warehouse.
 * 
 * Likewise, the consumer will have to wait for the producer to 
 * produce something, before he can consume it.
 * 
 * The producers will keep producing until a certain item number is reached.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class ProducerConsumer {
	
	final static int MAX_WAREHOUSE_SIZE = 3;
	final static int MAX_PRODUCED_ITEM_NUMBER = 10;
	
	/**
	 * This class represents a producer.
	 * 
	 * Each producer uses the same warehouse (it is shared).
	 * 
	 * He produces items with a certain number. An AtomicInteger is used, so
	 * that every producer will be guaranteed to produce an item with a unique number.
	 * Once the max item number is reached, the producers will stop producing.
	 * 
	 * Each producer also has an ID, so that he can be distinguished from the other producers.
	 * 
	 * @author Dimitar Trifonov (dvt32)
	 */
	public static class Producer 
		implements Runnable 
	{
		private LinkedList<Integer> sharedWarehouse;
		private static AtomicInteger producedItemNumber = new AtomicInteger(1);
		private int id;
	
		/**
		 * This constructor initializes the shared warehouse 
		 * and sets the ID for this producer.
		 * 
		 * The shared warehouse is a LinkedList, so that
		 * after the producers pause the producing,
		 * the consumer(s) can consume the items according to their production time (they first consume 
		 * the first produced item, then the second produced item and so on).
		 * 
		 * @param sharedWarehouse A LinkedList, which will be shared between the producers
		 * @param id The ID number of this producer
		 */
		public Producer(LinkedList<Integer> sharedWarehouse, int id) {
			this.sharedWarehouse = sharedWarehouse;
			this.id = id;
		}

		/**
		 * This method describes what happens when a producer is producing.
		 * 
		 * Producers produce until a certain target item number is reached.
		 * Each item is added to the warehouse.
		 * 
		 * If the warehouse is full, the producer will wait for a consumer to consume an item first.
		 * Otherwise, the producer produces new items until the warehouse becomes full or until the target item
		 * number is reached.
		 * 
		 * Because LinkedList is not synchronized, it needs to be put in a synchronized block.
		 * 
		 * After the producer is done producing, he notifies all other threads of this.
		 */
		public void run() {
				while (true) {
					synchronized (sharedWarehouse) {
						while (sharedWarehouse.size() == MAX_WAREHOUSE_SIZE) {
							try {
								sharedWarehouse.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						int currentItemNumber = producedItemNumber.intValue();
						
						// This will stop the producers from producing when the target number is reached.
						if (currentItemNumber > MAX_PRODUCED_ITEM_NUMBER) {
							break;
						}
						
						sharedWarehouse.add(currentItemNumber);
						System.out.println("Producer " + id + " put " + currentItemNumber);
						producedItemNumber.incrementAndGet();
						sharedWarehouse.notifyAll();	
					}	
			}
		}
	}
	
	/**
	 * This class represents a consumer. 
	 * 
	 * Consumers consume while there is something in the warehouse.
	 * If it's empty, they wait for a producer to produce something, so that they can consume it.
	 * 
	 * They use the same warehouse as the producers, so that they can consume items from it.
	 * 
	 * Each consumer has a name, which distinguishes him from the other consumers.
	 * 
	 * @author Dimitar Trifonov (dvt32)
	 */
	public static class Consumer 
		implements Runnable 
	{
		private LinkedList<Integer> sharedWarehouse;
		private String name;

		/**
		 * This constructor initializes the shared warehouse
		 * and the consumer's name. 
		 * 
		 * The warehouse is a LinkedList, so that
		 * the consumer can consume items in chronological order (first the first one 
		 * produced, then the second one produced and so on).
		 * 
		 * @param sharedWarehouse A LinkedList, which will be shared between the producers & consumers
		 * @param name The name of this consumer
		 */
		public Consumer(LinkedList<Integer> sharedWarehouse, String name) {
			this.sharedWarehouse = sharedWarehouse;
			this.name = name;
		}

		/**
		 * This method describes what's happening when a consumer is consuming.
		 * 
		 * If the warehouse is empty, the consumer waits for the producer to produce something.
		 * Otherwise, he consumes the items in the warehouse in chronological order.
		 * 
		 * Because LinkedList is not synchronized, a synchronized block is used.
		 */
		public void run() {
			while (true) {
				synchronized (sharedWarehouse) {
					while (sharedWarehouse.size() == 0) {
						try {
							sharedWarehouse.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} 
					
					int removedNumber = sharedWarehouse.removeFirst();
					System.out.println("Consumer " + name + " got " + removedNumber);
				}
			}
		}
	}

	/**
	 * This is the program's main method. 
	 * 
	 * Two producers are producing and two consumers are consuming.
	 * 
	 * The producers and consumers both wait for each other when necessary.
	 */
	public static void main(String args[]) throws Exception {
		LinkedList<Integer> sharedWarehouse = new LinkedList<Integer>();
		
		Thread producer1 = new Thread( new Producer(sharedWarehouse, 1) );
		Thread producer2 = new Thread( new Producer(sharedWarehouse, 2) );
		Thread consumer1 = new Thread( new Consumer(sharedWarehouse, "A") );
		Thread consumer2 = new Thread( new Consumer(sharedWarehouse, "B") );
		
		producer1.start();
		producer2.start();
		
		consumer1.start();
		consumer2.start();
	}
}