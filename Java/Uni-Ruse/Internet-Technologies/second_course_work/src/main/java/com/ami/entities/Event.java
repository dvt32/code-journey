package com.ami.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private int id;
	
	private String date;
	private String time;
	private String address;
	private String description;
	
	// Constructors
	public Event() {}
	public Event(String date, String time, String address, String description) {
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
}

