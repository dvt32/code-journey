package net.dvt32.java.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamExamples {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("John", Gender.MALE),
			new Person("Maria", Gender.FEMALE),
			new Person("Aisha", Gender.FEMALE),
			new Person("Alex", Gender.MALE),
			new Person("Alice", Gender.FEMALE),
			new Person("Bob", Gender.PREFER_NOT_TO_SAY)
		);
		
		/*
		people.stream()
			.map( person -> person.name )
			.collect( Collectors.toSet() )
			.forEach(System.out::println);
		*/
		
		/*
		people.stream()
			.map( person -> person.gender )
			.collect( Collectors.toSet() )
			.forEach(System.out::println);
		*/
		
		// Print length of each name
		/*
		Function<Person, String> function = person -> person.name;
		ToIntFunction<String> toIntFunction = String::length;
		IntConsumer println = ( x -> System.out.println(x) ); // System.out::println
		people.stream()
			.map( function )
			.mapToInt(toIntFunction)
			.forEach(println);
		*/
		
		Predicate<Person> containsOnlyFemalesPredicate = person -> person.gender.equals(Gender.FEMALE);
		boolean containsOnlyFemales = people.stream()
			.noneMatch(containsOnlyFemalesPredicate);
			//.anyMatch(personPredicate);
			//.allMatch(personPredicate);
		System.out.println(containsOnlyFemales);
	}
	
	static class Person {
		private final String name;
		private final Gender gender;
		
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}
	
	enum Gender {
		MALE, FEMALE, PREFER_NOT_TO_SAY;
	}
	
}