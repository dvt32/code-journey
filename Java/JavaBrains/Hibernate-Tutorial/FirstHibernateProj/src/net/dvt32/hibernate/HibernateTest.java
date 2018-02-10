package net.dvt32.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import net.dvt32.javabrains.dto.Address;
import net.dvt32.javabrains.dto.FourWheeler;
import net.dvt32.javabrains.dto.TwoWheeler;
import net.dvt32.javabrains.dto.UserDetails;
import net.dvt32.javabrains.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query = builder.createQuery(UserDetails.class);
		Root<UserDetails> root = query.from(UserDetails.class);
		query.select(root);
		query.where(
			builder.or(
				builder.between(root.get("userId"), 2, 5),
				builder.between(root.get("userId"), 7, 8)
			)
		);
		
		Query<UserDetails> q = session.createQuery(query);
		List<UserDetails> users = q.getResultList();
		
		for (UserDetails user : users) {
			System.out.println( user.getUserName() );
		}
		*/
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated User");
		
		
		session.getTransaction().commit();
		session.close();
		
		// Session 2
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 1);
	
		session2.getTransaction().commit();
		session2.close();
	}

}
