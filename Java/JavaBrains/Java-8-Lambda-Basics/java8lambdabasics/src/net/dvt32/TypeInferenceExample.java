package net.dvt32;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLambda myLambda = s -> s.length();
		
		System.out.println( myLambda.getLength("Hello Lambda") );

	}
	
	public static void printLambda(StringLengthLambda l) {
		System.out.println( l.getLength("Hello Lambda") );
	}

	interface StringLengthLambda {
		int getLength(String s);
	}
	
}
