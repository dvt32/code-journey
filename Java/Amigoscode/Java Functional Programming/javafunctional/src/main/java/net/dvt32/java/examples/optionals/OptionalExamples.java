package net.dvt32.java.examples.optionals;

public class OptionalExamples {
	
	public static void main(String[] args) {
		
		// Example 1
		/*
		Object value = Optional.ofNullable(null)
			.orElseGet(() -> "Default value");
		*/
		
		// Example 2
		/*
		Supplier<IllegalStateException> supplier = () -> new IllegalStateException();
		Object value = Optional.ofNullable("Hello")
			.orElseThrow(supplier);
		*/
		
		// System.out.println(value);
		
		// Example 3
		/*
		Optional.ofNullable("john@example.com")
			.ifPresent(email -> {
				System.out.println("Sending email to " + email);
			});
		*/
		
		// Example 4 (Java 9+)
		/*
		Optional.ofNullable(null)
			.ifPresentOrElse(
				email -> System.out.println("Sending email to " + email),
				() -> {
					System.out.println("Cannot send email!");
				}
			);
		*/
		
	}
	
}