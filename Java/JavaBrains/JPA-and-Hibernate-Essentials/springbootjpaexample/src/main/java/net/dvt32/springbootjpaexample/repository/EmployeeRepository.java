package net.dvt32.springbootjpaexample.repository;

import net.dvt32.springbootjpaexample.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
