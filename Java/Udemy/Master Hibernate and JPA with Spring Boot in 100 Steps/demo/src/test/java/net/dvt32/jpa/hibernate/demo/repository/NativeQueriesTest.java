package net.dvt32.jpa.hibernate.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.dvt32.jpa.hibernate.demo.DemoApplication;
import net.dvt32.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM course", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT c FROM course -> {}", resultList);
	}

	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM course WHERE id = ?", Course.class);
		query.setParameter(1, 10001L);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT c FROM course WHERE id = ? -> {}", resultList);
	}
	
	@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM course WHERE id = :id", Course.class);
		query.setParameter("id", 10001L);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT c FROM course WHERE id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("UPDATE course SET last_updated_date=sysdate()", Course.class);
		int numberOfRowsUpdated = query.executeUpdate();
		logger.info("numberOfRowsUpdated -> {}", numberOfRowsUpdated);
	}
}
