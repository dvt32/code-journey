package com.ami.managed_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	boolean loggedIn = false;
	String username;
	String password;
	
	// Constructors
	public LoginBean() {}
	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password; 
	}
	
	// Getter methods
	public boolean getLoggedIn() {
		return loggedIn;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	// Setter methods
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Validation method
	public String validateAndLogin() {
		if (!username.isEmpty() && 
			!password.isEmpty() && 
			username.equals("admin") && 
			password.equals("123")) 
		{
			loggedIn = true;
			
			return "login_success";
		}
		else {
			return "login_error";
		}
	}
	
	// Logout method
	public String logout() {
		loggedIn = false;
		
		return "logout_success";
	}
}
