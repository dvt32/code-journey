package net.dvt32;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.dvt32.models.AuthenticationRequest;
import net.dvt32.models.AuthenticationResponse;
import net.dvt32.services.MyUserDetailsService;
import net.dvt32.util.JwtUtil;

@RestController
public class HomeResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) 
    	throws Exception 
    {
    	try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(),
					authenticationRequest.getPassword()
				)	
			);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
    	
    	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    	final String jwt = jwtUtil.generateToken(userDetails);
    	
    	return ResponseEntity.ok( new AuthenticationResponse(jwt) );
    }
    
}