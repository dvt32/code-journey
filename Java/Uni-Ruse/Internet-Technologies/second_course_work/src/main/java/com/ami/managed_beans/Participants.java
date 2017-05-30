package com.ami.managed_beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.ejb.EJB;

import com.ami.dao.ParticipantDAO;
import com.ami.entities.Participant;

@ManagedBean(name="participant")
@SessionScoped
public class Participants {
	@EJB 
	ParticipantDAO participantDAO;
	
	private List<Participant> allParticipants;
	
	private String name;
	private String competitionName;
	private String rankNumber;
	
	// Constructors
	public Participants() {}
	public Participants(String name, String competitionName, String rankNumber) {
		this.name = name;
		this.competitionName = competitionName;
		this.rankNumber = rankNumber;
	}
	
	// Getter methods
	public String getName() {
		return name;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public String getRankNumber() {
		return rankNumber;
	}
	
	// Setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public void setRankNumber(String rankNumber) {
		this.rankNumber = rankNumber;
	}
	
	// Additional helper methods
	public String validateAndAdd() {
		if (!name.isEmpty() && 
			!competitionName.isEmpty() && 
			!rankNumber.isEmpty()) 
		{
			participantDAO.addParticipant(name, competitionName, rankNumber);
			
			return "participant_add";
		}
		else {
			return "participant_error";
		}
	}
	
	public List<Participant> getAllParticipants() {
		allParticipants = participantDAO.getAllParticipants();
		return allParticipants;
	}
}
