package net.dvt32.java.examples.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImperativeVersusDeclarativeApproachExamples {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("John", Gender.MALE),
			new Person("Maria", Gender.FEMALE),
			new Person("Aisha", Gender.FEMALE),
			new Person("Alex", Gender.MALE),
			new Person("Alice", Gender.FEMALE)
		);
		
		/*
		 * Imperative approach
		 */
		System.out.println("Imperative approach");
		
		List<Person> females = new ArrayList<>();
		
		for (Person person : people) {
			if (person.gender.equals(Gender.FEMALE)) {
				females.add(person);
			}
		}
		
		for (Person female : females) {
			System.out.println(female);
		}
		
		/*
		 * Declarative approach
		 */
		System.out.println("Declarative approach");
		
		Predicate<Person> predicate = ( person -> person.gender.equals(Gender.FEMALE) );
		List<Person> females2 = people.stream()
			.filter(predicate)
			.collect( Collectors.toList() ); 
		females2.forEach( System.out::println );
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
		MALE, FEMALE;
	}
	
}