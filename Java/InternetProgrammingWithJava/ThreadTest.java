// http://www.nakov.com/books/inetjava/

// page 29

class MyThread extends Thread {
	private String name;
	private long timeInterval;
	
	public MyThread(String name, long timeInterval) {
		this.name = name;
		this.timeInterval = timeInterval;
	}
	
	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				System.out.println(this.name);
				sleep(this.timeInterval);
			}
		} catch (InterruptedException intEx) {
			// Current thread was interrupted by another thread
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		MyThread firstThread = new MyThread("Thread 1", 1000);
		MyThread secondThread = new MyThread("Thread 2", 3000);
		MyThread thirdThread = new MyThread("Thread 3", 1500);
		
		firstThread.start();
		secondThread.start();
		thirdThread.start();
	}

}
