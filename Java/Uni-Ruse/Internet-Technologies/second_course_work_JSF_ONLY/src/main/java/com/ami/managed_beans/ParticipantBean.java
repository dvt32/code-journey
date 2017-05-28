package com.ami.managed_beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="participantBean")
@SessionScoped
public class ParticipantBean {
	private List<Participant> participantList = new ArrayList<Participant>();
	private String name;
	private String competitionName;
	private String rankNumber;
	
	// Constructors
	public ParticipantBean() {}
	public ParticipantBean(String name, String competitionName, String rankNumber) {
		this.name = name;
		this.competitionName = competitionName;
		this.rankNumber = rankNumber;
	}
	
	// Getter methods
	public List<Participant> getParticipantList() {
		return participantList;
	}
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
	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public void setRankNumber(String rankNumber) {
		this.rankNumber = rankNumber;
	}
	
	// Validation method
	public String validateAndAdd() {
		if (!name.isEmpty() && 
			!competitionName.isEmpty() && 
			!rankNumber.isEmpty()) 
		{
			Participant submittedParticipant = new Participant(name, competitionName, rankNumber);
			participantList.add(submittedParticipant);
			
			return "participant_add";
		}
		else {
			return "participant_error";
		}
	}
}
