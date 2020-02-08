package net.dvt32.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
	
	// JWT Token:
	// eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkdnQzMiIsImV4cCI6MTU4MDk5NDM0NSwiaWF0IjoxNTgwMzg5NTQ1fQ.OpAnlR0kBuvnIcPdjvKKS1zes97yhQI3jgrskvuivnCADbWQ3H9gV46pGynZnWnohA0eHgvMXN2XL_Ln36iTVw
  
	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

