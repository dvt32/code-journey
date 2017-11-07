package net.dvt32.unit3;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		Thread t = new Thread( MethodReferenceExample1::printMessage ); // equal to () -> printMessage()
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
