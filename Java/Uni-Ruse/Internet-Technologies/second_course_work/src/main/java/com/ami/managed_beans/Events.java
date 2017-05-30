package com.ami.managed_beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.ejb.EJB;

import com.ami.dao.EventDAO;
import com.ami.entities.Event;

@ManagedBean(name="event")
@SessionScoped
public class Events {
	@EJB 
	EventDAO eventDAO;
	
	private List<Event> allEvents;
	
	private String date;
	private String time;
	private String address;
	private String description;
	
	// Constructors
	public Events() {}
	public Events(String date, String time, String address, String description) {
		this.date = date;
		this.time = time;
		this.address = address;
		this.description = description;
	}
	
	// Getter methods
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getAddress() {
		return address;
	}
	public String getDescription() {
		return description;
	}
	
	// Setter methods
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Additional helper methods
	public String validateAndAdd() {
		if (!date.isEmpty() && 
			!time.isEmpty() && 
			!address.isEmpty() && 
			!description.isEmpty()) 
		{
			eventDAO.addEvent(date, time, address, description);
					
			return "event_add";
		}
		else {
			return "event_error";
		}
	}
	
	public List getAllEvents() {
		allEvents = eventDAO.getAllEvents();
		
		return allEvents;
	}
}
