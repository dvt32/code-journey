package net.dvt32.rss.jms;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import net.dvt32.rss.entity.Student;
import net.dvt32.rss.session.LibraryService;

/**
 * A class listening for instances of the Library entities, waiting to save them
 */
@MessageDriven(
	activationConfig = {
		@ActivationConfigProperty(
			propertyName = "destinationType",
	        propertyValue = "javax.jms.Queue"
	    ),
	    @ActivationConfigProperty(
	    	propertyName = "destination",
	        propertyValue = "jms/queue/LibraryQueue"
	    ) 
	}
)
public class LibraryListener 
	implements MessageListener 
{
	
	/**
	 * Injected reference to the libraryService session bean
	 * used for saving the received entities
	 */
	@EJB
	LibraryService libraryService;
	
	Logger log = Logger.getLogger(LibraryListener.class.toString());
	
	/**
	 * Waits for an object message containing Entity beans to save
	 * 
	 * @param message The ObjectMessage containing entity bean instance
	 */
	 public void onMessage(final Message message) {
        try {
        	ObjectMessage om = (ObjectMessage) message;
        	log.info(
        		"Received a new ObjectMessage. Object class is: " +
        		((om.getObject() == null) ? " NULL! " : om.getObject().getClass().getSimpleName())
        	);
			if (om.getObject() != null && om.getObject().getClass().equals(Student.class)) {
				libraryService.createStudent((Student) om.getObject());
			}
			// TODO: Add cases for saving a Student and an Action!
			// Try cascade persisting on Action instances!
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}