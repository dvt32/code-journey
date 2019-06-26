package net.dvt32.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		/*
		for (int i = 1; i <= 10; ++i) {
			String encodedString = encoder.encode("password@!23@#!");
			System.out.println(encodedString);
		}
		*/
		
		for (int i = 1; i <= 10; ++i) {
			String encodedString = encoder.encode("123");
			System.out.println(encodedString);
		}
	}
	
}