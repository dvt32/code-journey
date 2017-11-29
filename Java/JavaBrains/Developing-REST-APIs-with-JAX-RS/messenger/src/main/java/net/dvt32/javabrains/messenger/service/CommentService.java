package net.dvt32.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.dvt32.javabrains.messenger.database.DatabaseClass;
import net.dvt32.javabrains.model.Comment;
import net.dvt32.javabrains.model.ErrorMessage;
import net.dvt32.javabrains.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>( comments.values() );
	}
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://dvt32.net");
		
		Response response = 
			Response.status(Status.NOT_FOUND)
			.type(MediaType.APPLICATION_JSON)
			.entity(errorMessage)
			.build();
		
		Message message = messages.get(messageId);
		if (message == null) {
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if (comment == null) {
			throw new NotFoundException(response);
		}
		
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId( comments.size()+1 );
		comments.put( comment.getId(), comment );
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put( comment.getId(), comment );
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
