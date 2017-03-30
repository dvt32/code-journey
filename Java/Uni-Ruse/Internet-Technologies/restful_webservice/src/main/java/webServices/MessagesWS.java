package webServices;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Message;

@Path("messages")
public class MessagesWS {
	static List<Message> messages = null;
	
	public MessagesWS() {
		if (messages == null) {
			messages = new ArrayList<Message>();
			
			messages.add( new Message(1, "Hello!") );
			messages.add( new Message(2, "What a beautiful day!") );
			messages.add( new Message(3, "It's spring!") );
			messages.add( new Message(4, "Thank you!") );
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllMessages() {
		return messages.toString();
	}
	
	private Message getMessageByID(int id) {
		for (int i = 0; i < messages.size(); ++i) {
			Message currentMessage = messages.get(i);
			if (currentMessage.getId() == id) {
				return currentMessage;
			}
		}
		
		return null;
	}
	
	@GET
	@Path("/{messageID}")
	public String getSingleMessage(@PathParam("messageID") int id) {
		Message message = getMessageByID(id);
		
		return message.toString();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createMessage( @FormParam("messageText") String text ) {
		Message lastMessage = messages.get( messages.size()-1 );
		int nextMessageID = lastMessage.getId() + 1;
		Message newMessage = new Message(nextMessageID, text);
		
		messages.add(newMessage);
		
		return newMessage.toString();
	}
	
	@PUT
	@Path("/{messageID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateMessage(
		@PathParam("messageID") int id, 
		@FormParam("messageText") String text) 
	{
		Message message = getMessageByID(id);
		message.setMessage(text);
		
		return message.toString();
	}
	
	@DELETE
	@Path("/{messageID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("messageID") int id) {
		Message message = getMessageByID(id);
		
		messages.remove(message);
		
		return "";
	}
}
