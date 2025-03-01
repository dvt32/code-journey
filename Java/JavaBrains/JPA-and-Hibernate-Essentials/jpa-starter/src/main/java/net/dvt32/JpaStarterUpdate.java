package net.dvt32;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 8);

        employee.addEmailSubscription(emailGroup);
        emailGroup.addMember(employee);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(emailGroup);
        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
