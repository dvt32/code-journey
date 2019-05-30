package net.dvt32.rss.soap.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import net.dvt32.rss.entity.Action;

@WebService(name="LibraryWS", targetNamespace="http://ru.acad.bg/mag/rss/ws/library")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface LibraryWS {
	
	/**
	 * Retrieves all actions by their type name
	 * @param type The type of the Action
	 * @return A list of actions
	 */
	@WebMethod(operationName="getActionsByType")
	List<Action> getLibraryActionsByType(String type);
	
}
