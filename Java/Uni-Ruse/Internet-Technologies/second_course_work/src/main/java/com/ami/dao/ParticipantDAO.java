package com.ami.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ami.entities.Participant;

@Stateless
@LocalBean
public class ParticipantDAO
{
	@PersistenceContext(name="persistenceUnit")
	private EntityManager em;
	
	public Participant getParticipantById(int id)
	{
		Participant p = em.find(Participant.class, id);
		
		return p;
	}
	
	public void addParticipant(String name, String competitionName, String rankNumber)
	{
		Participant p = new Participant(name, competitionName, rankNumber);
		em.persist(p);
	}
	
	public List getAllParticipants()
	{
		Query query  = em.createNativeQuery("SELECT * FROM Participant p", Participant.class);
		List participants = query.getResultList();
		
		return participants;
	}
}
