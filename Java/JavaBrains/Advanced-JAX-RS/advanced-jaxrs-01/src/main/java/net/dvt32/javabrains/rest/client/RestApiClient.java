package net.dvt32.javabrains.rest.client;

import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		// Response response = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1").request().get();
		// Message message = response.readEntity( Message.class );
		
		/*
		WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1");
		Builder builder = target.request();
		Response response = builder.get();
		*/
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");

		Message message1 = singleMessageTarget
			.resolveTemplate("messageId", "1")
			.request()
			.get(Message.class);
		
		Message message2 = singleMessageTarget
			.resolveTemplate("messageId", "2")
			.request()
			.get(Message.class);
		
		Message newMessage = new Message(4, "My New message from JAX-RS client", "dvt32");
		Response postResponse = messagesTarget.request().post( Entity.json(newMessage) );
		if (postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		
		System.out.println( createdMessage.getMessage() );

		//System.out.println( message1.getMessage() );
		//System.out.println( message2.getMessage() );

	}

}
