package net.dvt32.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.dvt32.jpa.hibernate.demo.entity.FullTimeEmployee;
import net.dvt32.jpa.hibernate.demo.entity.PartTimeEmployee;
import net.dvt32.jpa.hibernate.demo.repository.CourseRepository;
import net.dvt32.jpa.hibernate.demo.repository.EmployeeRepository;
import net.dvt32.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		// studentRepository.saveStudentWithPassport();
		// repository.playWithEntityManager();
		// courseRepository.addHardcodedReviewsForCourse();	
		// List<Review> reviews = new ArrayList<>();
		// reviews.add( new Review("5", "Great Hands-on Stuff.") );
		// reviews.add( new Review("5", "Hatsoff.") );
		// courseRepository.addReviewsForCourse(10003L, reviews);
		// studentRepository.insertHardcodedStudentAndCourse();
		// studentRepository.insertStudentAndCourse( new Student("Jack"), new Course("Microservices in 100 Steps") );
		
		/*
		employeeRepository.insert(
			new PartTimeEmployee( "Jill", new BigDecimal("50") )
		);
		employeeRepository.insert(
			new FullTimeEmployee( "Jack", new BigDecimal("10000") )
		);
		
		logger.info("Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
		logger.info("Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
		*/
		
	}
}
