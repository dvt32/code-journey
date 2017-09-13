package net.dvt32.concurrency.task3;

/**
 * This program starts two threads at the same time
 * and both of them count and print numbers 
 * from some start value to an end value.
 * 
 * On each count, the threads wait for a certain period of time.
 * 
 * When one of the counter threads finishes its execution,
 * it automatically interrupts the other thread.
 * 
 * This is possible, because the class has two Thread objects
 * - the thread which does the counting AND a thread, which is part
 * of another class object and is simply being monitored.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class WaitingCounterThread
	implements Runnable
{
	private Thread counterThread;
	private Thread threadToStop;
	private int startValue;
	private int endValue;
	
	private long timeToWaitInMilliseconds;
	
	/**
	 * This constructor initializes the internal counter thread and gives it a name.
	 * 
	 * The start value MUST be greater than the end value,
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param startValue The start number value
	 * @param endValue The end number value
	 * @param threadName The counter thread's name
	 * @param timeToWaitInMilliseconds the duration for which the thread will wait after each count (in milliseconds)
	 */
	public WaitingCounterThread(int startValue, int endValue, String threadName, long timeToWaitInMilliseconds) {
		if (startValue > endValue) {
			throw new IllegalArgumentException("Start value CAN'T be larger than end value!");
		}
		
		counterThread = new Thread(this, threadName);
		this.startValue = startValue;
		this.endValue = endValue;
		
		this.timeToWaitInMilliseconds = timeToWaitInMilliseconds;
	}
	
	/**
	 * This method returns the internal counter thread.
	 * It is used in order for it to be possible for 
	 * the counter thread to be monitored by another class object.
	 * 
	 * @return the counter thread
	 */
	public Thread getCounterThread() {
		return counterThread;
	}
	
	/**
	 * This method sets the thread, which is monitored and
	 * will be potentially interrupted.
	 * 
	 * @param threadToStop The thread, which will potentially be interrupted
	 */
	public void setThreadToStop(Thread threadToStop) {
		this.threadToStop = threadToStop;
	}

	/**
	 * This method shows what's happening when the counter thread is running.
	 * 
	 * If the counter thread is interrupted, that means that the other thread
	 * has already finished its execution and this breaks the loop.
	 * 
	 * If the counter thread is interrupted DURING ITS WAIT PERIOD,
	 * an InterruptedException is thrown.
	 * 
	 * If the loop successfully prints all expected values,
	 * a final check interrupts the other thread, in case it's still running,
	 * and an informative message is printed.
	 */
	public void run() {
		int currentValue = startValue;
		synchronized (this) {
			try {
				while (!counterThread.isInterrupted() && currentValue <= endValue) {
					System.out.println( counterThread.getName() + ": " + currentValue);
					currentValue++;
					wait(timeToWaitInMilliseconds); // method from the Object class
				}
			}
			catch (InterruptedException e) {
				System.out.println( 
					counterThread.getName() + " was interrupted while waiting!"
				);
			}
		}
		
		if (counterThread.isInterrupted()) {
			return;
		}
		else if ( threadToStop.isAlive() ) {
			threadToStop.interrupt();
			System.out.println( counterThread.getName() + " interrupted " + threadToStop.getName() );
		}
	}
	
	/**
	 * This is the program's main method. 
	 * 
	 * It starts two counter threads, which monitor each other
	 * and when one of them finishes, the one that has finished 
	 * interrupts the other one.
	 */
	public static void main(String[] args) {
		WaitingCounterThread a = new WaitingCounterThread(1, 3, "a", 1000);
		WaitingCounterThread b = new WaitingCounterThread(1, 2, "b", 2000);
		
		a.setThreadToStop( b.getCounterThread() );
		b.setThreadToStop( a.getCounterThread() );
		
		a.getCounterThread().start();
		b.getCounterThread().start();
	}
}