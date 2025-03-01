package net.dvt32;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7);
        System.out.println("Got email group. Now accessing members");
        System.out.println(emailGroup.getMembers());
    }

}
