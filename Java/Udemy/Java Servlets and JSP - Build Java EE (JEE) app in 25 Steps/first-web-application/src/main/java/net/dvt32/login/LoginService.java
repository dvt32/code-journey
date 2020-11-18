package net.dvt32.login;

public class LoginService {
	
	public boolean isValidUser(String name, String password) {
		if (name.equals("dvt32") && password.equals("123")) {
			return true;
		}
		
		return false;
	}
	
}
