package net.dvt32.rss.session;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.dvt32.rss.entity.Action;
import net.dvt32.rss.entity.Book;
import net.dvt32.rss.entity.Student;

/**
 * The Library Service stateless session bean implementation
 */
@Stateless
public class LibraryServiceImpl implements LibraryService {
		
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createStudent(Student student) {
		em.persist(student);
	}
	
	@Override
	public void createAction(Action action) {
		em.merge(action);
	}
	
	@Override
	public boolean removeStudent(String fNum) {
		Student studentToRemove = em.find(Student.class, fNum);
		if (studentToRemove == null) {
			return false;	
		}
		else {
			em.remove(studentToRemove);
			return true;
		}
	}

	@Override
	public void createBook(Book book) {
		em.persist(book);
	}

	@Override
	public void connectActionToReferences(Action action, Student student, Book book) {
		book = em.merge(book);
		student = em.merge(student);
		action.setBook(book);
		action.setStudent(student);
		em.merge(action);
	}
	
	@Override
	public List getAllActionsByTypeNamed(String type) {
		Query actionQuery = em.createNamedQuery("actionByType");
		actionQuery.setParameter(1, type);
		List actionList = actionQuery.getResultList();
		return actionList;
	}
	
	@Override
	public List getDynamicQueryResult(String ejbql, Map<String, Object> params) {
		Query dynamicQuery = em.createQuery(ejbql);
		Iterator<String> paramsIter = params.keySet().iterator();
		// Set query params
		while (paramsIter.hasNext()){
			String key = paramsIter.next();
			dynamicQuery.setParameter(key, params.get(key));
		}
		return dynamicQuery.getResultList();
	}
	
}