package net.dvt32.concurrency.task1;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This program starts a thread, which counts 
 * the number of elapsed seconds (since the thread's start)
 * until a certain target number of seconds has been reached
 * OR until the thread has been interrupted by user input.
 * 
 * Finally, it prints the number of elapsed seconds.
 * 
 * Internally, a ScheduledExecutorService is used, 
 * in order to execute the thread's run() method every second.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class StopCounterThread
	implements Runnable
{
	private Thread counterThread;
	private ScheduledExecutorService executor;
	private int elapsedSeconds;
	private int targetSeconds;
	
	/**
	 * This constructor sets the target number of seconds to reach,
	 * before the thread will stop counting and finish its execution.
	 * 
	 * It also initializes the internal thread and executor service,
	 * along with the number of elapsed seconds (initially 0).
	 * 
	 * The target seconds number MUST be positive, 
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param targetSeconds The target seconds number
	 */
	public StopCounterThread(int targetSeconds) {
		if (targetSeconds <= 0) {
			throw new IllegalArgumentException("The target seconds number MUST be positive!");
		}
		this.targetSeconds = targetSeconds;
		counterThread = new Thread(this);
		executor = Executors.newScheduledThreadPool(1);
		elapsedSeconds = 0;
	}
	
	/**
	 * This method starts the thread and calls its run() method every second.
	 * 
	 * Because this class implements the Runnable interface,
	 * an object from it can be passed as an argument 
	 * to the ScheduledExecutorService scheduleAtFixedRate() method.
	 */
	public void start() {
		Runnable threadToBeExecuted = this;
		long initialDelayInSeconds = 0;
		long secondsBetweenRunMethodCall = 1;
		executor.scheduleAtFixedRate(
			threadToBeExecuted, 
			initialDelayInSeconds, 
			secondsBetweenRunMethodCall, 
			TimeUnit.SECONDS
		);
	}
	
	/**
	 * This method interrupts the thread and 
	 * shuts down the executor service (if they weren't already).
	 * 
	 * The method is called either when the thread
	 * completes its task and counts to the specified
	 * target number of seconds OR when the user enters input.
	 */
	public void stop() {
		if ( !counterThread.isInterrupted() && 
			 !executor.isShutdown() ) 
		{
			counterThread.interrupt();
			executor.shutdown();
		}
	}
	
	/**
	 * This method returns the total number of elapsed seconds.
	 * 
	 * @return the number of elapsed seconds
	 */
	public int getElapsedSeconds() {
		return elapsedSeconds;
	}

	/**
	 * This method dictates what happens when the thread is executing.
	 * 
	 * Since this method is called every second, 
	 * the only thing needed is for the elapsed seconds counter
	 * to be incremented.
	 * 
	 * Lastly, if the thread has reached the target number of seconds,
	 * it will be stopped, along with the executor service.
	 */
	public void run() {
		elapsedSeconds++;
		if (elapsedSeconds == targetSeconds) {
			stop();
		}
	}
	
	/**
	 * This is the program's main method,
	 * in which the thread is started and 
	 * then user input is expected.
	 * 
	 * Once the user enters something,
	 * the thread is stopped (in case it wasn't already).
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		StopCounterThread counter = new StopCounterThread( 5 );
		
		counter.start();
		read.nextLine();
		counter.stop();
		read.close();
		
		System.out.println( counter.getElapsedSeconds() );
	}
}