package net.dvt32.javabrains.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import org.koushik.javabrains.messenger.model.Message;

public class GenericDemo {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		List<Message> messages =
			client
			.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
			.path("messages")
			.queryParam("year", 2017)
			.request()
			.get(new GenericType<List<Message>>() { });
		
		System.out.println( messages );
		
	}
}
