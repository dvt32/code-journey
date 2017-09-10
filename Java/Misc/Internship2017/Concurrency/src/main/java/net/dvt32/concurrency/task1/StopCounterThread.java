package net.dvt32.concurrency.task1;

import java.util.Scanner;

/**
 * This program starts a thread, which counts 
 * the number of elapsed seconds (since the thread's start)
 * until a certain target number of seconds has been reached
 * OR until the thread has been interrupted by user input.
 * 
 * Finally, it prints the number of elapsed seconds.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class StopCounterThread
	implements Runnable
{
	private Thread counterThread;
	private int targetSeconds;
	private int elapsedSeconds;
	
	/**
	 * Constructor, which initially sets the number of elapsed seconds to 0.
	 * It also sets the thread's target number of seconds and initializes the thread itself.
	 * 
	 * @param targetSeconds The number of elapsed seconds before the thread dies.
	 */
	public StopCounterThread(int targetSeconds) {
		counterThread = new Thread(this);
		this.targetSeconds = targetSeconds;
		elapsedSeconds = 0;
	}
	
	/*
	 * Getters
	 */
	public Thread getCounterThread() {
		return counterThread;
	}
	
	public int getTargetSeconds() {
		return targetSeconds;
	}
	
	public int getElapsedSeconds() {
		return elapsedSeconds;
	}
	
	/**
	 * This method dictates what happens when the thread is executing.
	 * 
	 * First the start time is calculated. 
	 * 
	 * Then the thread waits around 1 second (around 1000 milliseconds, but 
	 * Thread.sleep() does not guarantee it) and the time difference in seconds is equal 
	 * to the number of elapsed seconds.
	 * 
	 * This is done continually, 
	 * until the target number of seconds has been reached
	 * or until the user interrupts the thread.
	 * 
	 * In case the thread is interrupted by user input,
	 * the thread is re-interrupted (to keep state)
	 * and its execution stops.
	 */
	public void run() {
		long startTimeInMilliseconds = System.currentTimeMillis();
		
		while (elapsedSeconds < targetSeconds) {
			try {
				Thread.sleep(1000);
				long currentTimeInMilliseconds = System.currentTimeMillis();
				long timeDifferenceInMilliseconds = (currentTimeInMilliseconds - startTimeInMilliseconds);
				elapsedSeconds = (int) (timeDifferenceInMilliseconds / 1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
	
	/**
	 * This method reads a line from a Scanner with some input data,
	 * tries to interrupt the thread (if it's alive)
	 * and prints the total number of elapsed seconds.
	 * 
	 * @param read The Scanner object, containing the user input information
	 */
	public void readLineAndPrintElapsedSeconds(Scanner read) {
		read.nextLine();
		read.close();
		
		interruptCounterThreadIfAlive();
		
		System.out.println( elapsedSeconds );
	}
	
	/**
	 * This method interrupts the counter thread,
	 * in case it was still alive when the method was called.
	 */
	public void interruptCounterThreadIfAlive() {
		if (counterThread.isAlive()) {
			counterThread.interrupt();
		}
	}
}