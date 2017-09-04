package net.dvt32.designpatterns.task2;

import java.util.List;

/**
 * This class represents a simple email and its components.
 * 
 * The class' methods consist only of getters and setters for its 6 fields:
 * - from, to, subject, content, cc & attachments.
 * The only exception is the toString() method, 
 * which prints the object's information in String format.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Mail {
	String from;
	String to;
	String subject;
	String content;
	String cc;
	List<String> attachments;
	
	//  Getters
	public String getFrom() { return from; }
	public String getTo() { return to; }
	public String getSubject() { return subject; }
	public String getContent() { return content; }
	public String getCC() { return cc; }
	public List<String> getAttachments() { return attachments; }
	
	// Setters
	public void setFrom(String from) { this.from = from; }
	public void setTo(String to) { this.to = to; }
	public void setSubject(String subject) { this.subject = subject; }
	public void setContent(String content) { this.content = content; }
	public void setCC(String cc) { this.cc = cc; }
	public void setAttachments(List<String> attachments) { this.attachments = attachments; }
	
	@Override
	public String toString() {
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		String objectToString =
			"from: " + from + LINE_SEPARATOR +
			"to: " + to + LINE_SEPARATOR +
			"subject: " + subject + LINE_SEPARATOR +
			"content: " + content + LINE_SEPARATOR +
			"CC: " + cc + LINE_SEPARATOR +
			"attachments: " + attachments + LINE_SEPARATOR;
		return objectToString;
	}
}