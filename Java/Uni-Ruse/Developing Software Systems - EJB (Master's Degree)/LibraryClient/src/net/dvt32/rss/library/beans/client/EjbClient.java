package net.dvt32.rss.library.beans.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.dvt32.rss.entity.Action;
import net.dvt32.rss.entity.Book;
import net.dvt32.rss.entity.Student;
import net.dvt32.rss.session.LibraryService;

public class EjbClient {

	private static final String STUDENT_BY_ACTION_PERFORMED = 
		"SELECT st "
		+ "FROM Student st "
		+ "JOIN st.actions as act "
		+ "WHERE act.type = :actType";
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		
		Context context;
		try {
			 context = new InitialContext(properties);
			 LibraryService libServiceRemote = (LibraryService) context.lookup(
				"ejb:/LibraryEJB/LibraryServiceImpl!" + LibraryService.class.getName()
			 );
			 
			 /**
			  * 1. Create student
			  */
			 Student student = new Student("063346", "Dimitar Trifonov", new Date());
			 libServiceRemote.createStudent(student);
			 System.out.println("Successfully created the student.");

			 /**
			  * 2. Create book
			  */
			 Book book = new Book("Ernest Hemingway", new Date(), 321, new Date( ), "Under an apple tree");
			 libServiceRemote.createBook(book);
			 System.out.println("Successfully created the book.");

			 /**
			  * 3. Create action
			  */
			 Action action = new Action(new Date(), "return");
			 libServiceRemote.createAction(action);
			 System.out.println("Successfully created the action.");
			 
			 /**
			  * 4. Remove student
			  */
			 /*
			 System.out.println(libServiceRemote.removeStudent("063346"));
			 */
			 
			 /**
			  * 5. Connect action to references
			  */
			 libServiceRemote.connectActionToReferences(action, student, book);
			 System.out.println("Successfully connected the action.");
			 
			 /**
			  * 6. Construct a dynamic query
			  */
			 Map<String, Object> studentByActionTypeParams = new HashMap<String, Object>();
			 studentByActionTypeParams.put("actType", "return");
			 Iterator studentByActionsIter = libServiceRemote.getDynamicQueryResult(STUDENT_BY_ACTION_PERFORMED, studentByActionTypeParams).iterator();
			 while (studentByActionsIter.hasNext()) {
				 Student s  = (Student) studentByActionsIter.next();
				 System.out.println("Student returned has id: "+ s.getFNumber());
			 }

			 /**
			  *7. Construct a named query
			  */
			 Iterator actionsIter = libServiceRemote.getAllActionsByTypeNamed("return").iterator();
			 System.out.println("Invoking getAllActionsByTypeNamed(return)");
			 while (actionsIter.hasNext()){
				 Action a = (Action) actionsIter.next();
				 System.out.println("Action returned has id: "+ a.getId());
			 }
			 
			 /**
			  * 8. Send message via JMS
			  */
			 QueueConnectionFactory queueConnectionFactory = 
				(QueueConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
		     Queue queue = (Queue) context.lookup("jms/queue/LibraryQueue");
		     QueueConnection queueConnection = 
		    	queueConnectionFactory.createQueueConnection("student", "123456");
			 QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		     QueueSender queueSender = queueSession.createSender(queue);
		     ObjectMessage objMessage = queueSession.createObjectMessage();
		     
		     objMessage.setObject(new Student("133741", "dvt32", new Date()));
		     queueSender.send(objMessage);
		     
		     queueSender.close();
		     queueSession.close();
		     queueConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}