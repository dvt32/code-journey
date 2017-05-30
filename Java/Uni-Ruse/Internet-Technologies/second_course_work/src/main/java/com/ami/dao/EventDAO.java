package com.ami.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ami.entities.Event;

@Stateless
@LocalBean
public class EventDAO
{
	@PersistenceContext(name="persistenceUnit")
	private EntityManager em;
	
	public Event getEventById(int id)
	{
		Event e = em.find(Event.class, id);
		
		return e;
	}
	
	public void addEvent(String date, String time, String address, String description)
	{
		Event e = new Event(date, time, address, description);
		em.persist(e);
	}
	
	public List getAllEvents()
	{
		Query query  = em.createNativeQuery("SELECT * FROM Event e", Event.class);
		List events = query.getResultList();
		
		return events;
	}	
}
