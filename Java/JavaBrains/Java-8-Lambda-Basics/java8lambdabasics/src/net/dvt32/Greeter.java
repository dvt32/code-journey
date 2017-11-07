package net.dvt32;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		Greeting myLambdaFunction = () -> System.out.println("Hello world!");
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.println("Hello world!");
			}
		};
		
		greeter.greet(myLambdaFunction);
		greeter.greet(innerClassGreeting);
	}

}