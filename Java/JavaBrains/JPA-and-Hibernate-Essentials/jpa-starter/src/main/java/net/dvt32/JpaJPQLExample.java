package net.dvt32;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaJPQLExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        int minAge = 25;
//        TypedQuery<Employee> query = entityManager.createQuery(
//            "select e from Employee e where e.age > :minAge",
//            Employee.class
//        );
//        query.setParameter("minAge", minAge);

        TypedQuery<Employee> query = entityManager.createNamedQuery("emp name asc", Employee.class);
        query.setParameter("age", 25);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }

}
