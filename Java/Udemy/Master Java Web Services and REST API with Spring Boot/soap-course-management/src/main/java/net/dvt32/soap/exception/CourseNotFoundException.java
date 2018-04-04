package net.dvt32.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(
	faultCode=FaultCode.CUSTOM, 
	customFaultCode="{http://in28minutes.com/courses}001_COURSE_NOT_FOUND"
)
public class CourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258922457344263047L;

	public CourseNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
