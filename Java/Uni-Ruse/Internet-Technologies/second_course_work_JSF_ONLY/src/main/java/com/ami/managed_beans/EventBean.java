package com.ami.managed_beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="eventBean")
@SessionScoped
public class EventBean {
	private List<Event> eventList = new ArrayList<Event>();
	private String date;
	private String time;
	private String address;
	private String description;
	
	// Constructors
	public EventBean() {}
	public EventBean(String date, String time, String address, String description) {
		this.date = date;
		this.time = time;
		this.address = address;
		this.description = description;
	}
	
	// Getter methods
	public List<Event> getEventList() {
		return eventList;
	}
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
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
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
	
	// Validation method
	public String validateAndAdd() {
		if (!date.isEmpty() && 
			!time.isEmpty() && 
			!address.isEmpty() && 
			!description.isEmpty()) 
		{
			Event submittedEvent = new Event(date, time, address, description);
			eventList.add(submittedEvent);
			
			return "event_add";
		}
		else {
			return "event_error";
		}
	}
}
