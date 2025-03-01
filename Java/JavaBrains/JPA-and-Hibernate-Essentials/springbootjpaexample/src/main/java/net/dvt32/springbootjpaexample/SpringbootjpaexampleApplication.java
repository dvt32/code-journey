package net.dvt32.springbootjpaexample;

import jakarta.annotation.PostConstruct;
import net.dvt32.springbootjpaexample.models.Employee;
import net.dvt32.springbootjpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootjpaexampleApplication {

//	@PersistenceUnit
//	private EntityManagerFactory emf;

//	@PersistenceContext
//	private EntityManager entityManager;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaexampleApplication.class, args);
	}

	@PostConstruct
	@Transactional(readOnly = true)
	public void start() {
		Employee e = new Employee();
		e.setAge(20);
		e.setName("Foo Bar");
		e.setSsn("1234");
		e.setDob(new Date());
		employeeRepository.save(e);

		Optional<Employee> employee = employeeRepository.findById(1);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			updateEmployee(employee.get());
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateEmployee(Employee employee) {
		employee.setName("Updated name");
		employeeRepository.save(employee);
	}

}
