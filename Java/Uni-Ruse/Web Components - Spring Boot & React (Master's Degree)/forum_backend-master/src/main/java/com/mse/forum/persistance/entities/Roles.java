package com.mse.forum.persistance.entities;

public enum Roles {

	ADMIN("ADMIN"), MODERATOR("MODERATOR"), USER("USER");

	private final String text;

	Roles(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

	public static String[] allRegisteredUsers() {
		String[] adminModAndUSer = { 
			Roles.ADMIN.toString(), 
			Roles.MODERATOR.toString(), 
			Roles.USER.toString() 
		};
		
		return adminModAndUSer;
	}

}