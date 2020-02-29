package net.dvt32;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
	
	@Value("${my.greeting: Default value goes here}")
	private String greetingMessage;

	@Value("Some static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Autowired
	private Environment env;
	
	/*
	@Value("#{ ${dbValues} }")
	private Map<String, String> dbValues;
	*/
	
	@Autowired 
	DbSettings dbSettings;
	
	@GetMapping("/greeting")
	public String greeting() {
		//return greetingMessage + " " + staticMessage + " " + listValues;
		return dbSettings.getConnection() + " " + dbSettings.getHost() + " " + greetingMessage;
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return env.toString();
	}
	
}
