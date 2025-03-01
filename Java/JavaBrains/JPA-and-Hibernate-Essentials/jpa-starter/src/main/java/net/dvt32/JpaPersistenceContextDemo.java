package net.dvt32;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaPersistenceContextDemo {

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("new Employee");
        employee1.setSsn("12345");
        employee1.setDob(new Date());
        employee1.setAge(25);
        employee1.setType(EmployeeType.FULL_TIME);

        System.out.println("*************** Created Employee Instance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        System.out.println("*************** Starting transaction");

        entityManager.persist(employee1);

        System.out.println("*************** After Persist method called");

        Employee employeeFound = entityManager.find(Employee.class, 1);
        System.out.println(employee1);
        System.out.println(employeeFound);
        System.out.println(employee1 == employeeFound);

        transaction.commit();

        System.out.println("*************** After transaction closed");

        entityManager.close();
        entityManagerFactory.close();
    }

}