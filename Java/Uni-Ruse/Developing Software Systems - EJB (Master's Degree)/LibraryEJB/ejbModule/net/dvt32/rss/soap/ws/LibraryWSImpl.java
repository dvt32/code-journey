package net.dvt32.rss.soap.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import net.dvt32.rss.entity.Action;
import net.dvt32.rss.session.LibraryService;

/**
 * The SIB for the Library WS
*/
@Stateless
@WebService(endpointInterface="net.dvt32.rss.soap.ws.LibraryWS")
public class LibraryWSImpl implements LibraryWS {

	/**
	 * The library service session bean injected
	 */
	@EJB
	LibraryService libService;
	
	@Override
	public List<Action> getLibraryActionsByType(String type) {
		List allActions = libService.getAllActionsByTypeNamed(type);
		return allActions;
	}

}