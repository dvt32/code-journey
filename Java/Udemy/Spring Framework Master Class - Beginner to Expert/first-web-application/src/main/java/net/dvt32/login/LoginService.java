package net.dvt32.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean isValidUser(String user, String password) {
		if (user.equalsIgnoreCase("dvt32") && password.equals("123")) {
			return true;
		}	
		return false;
	}
	
}
