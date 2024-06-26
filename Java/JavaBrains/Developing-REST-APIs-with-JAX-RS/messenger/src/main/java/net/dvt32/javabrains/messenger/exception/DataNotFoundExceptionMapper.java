package net.dvt32.javabrains.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import net.dvt32.javabrains.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://dvt32.net");
		
		return 
			Response
			.status(Status.NOT_FOUND)
			.type(MediaType.APPLICATION_JSON)
			.entity(errorMessage)
			.build();
	}

}
