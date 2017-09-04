package net.dvt32.designpatterns.task2;

import java.util.List;

/**
 * This class builds a Mail object using a "fluent interface" (implemented via method chaining).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class MailBuilder {
	private Mail mail;
	
	/**
	 * This constructor initializes the internal Mail object (the one about to be built)
	 */
	public MailBuilder() {
		mail = new Mail();
	}
	
	/*
	 * The following methods provide the method chaining functionality.
	 * Instead of having to write setFrom(), setTo(), setSubject() etc,
	 * the user can simply use a MailBuilder object 
	 * and then call from(String).to(String).subject(String)
	 * and finally build the Mail object.
	 */
	public MailBuilder from(String from) {
		mail.setFrom(from);
		return this;
	}
	
	public MailBuilder to(String to) {
		mail.setTo(to);
		return this;
	}
	
	public MailBuilder subject(String subject) {
		mail.setSubject(subject);
		return this;
	}
	
	public MailBuilder content(String content) {
		mail.setContent(content);
		return this;
	}
	
	public MailBuilder cc(String cc) {
		mail.setCC(cc);
		return this;
	}
	
	public MailBuilder attachments(List<String> attachments) {
		mail.setAttachments(attachments);
		return this;
	}
	
	/**
	 * This method builds the Mail object with the provided information.
	 * 
	 * The "from" field is the only mandatory one
	 * and without it, a Mail object cannot be constructed
	 * (an IllegalStateException is thrown when attempting to build it).
	 * 
	 * @return The Mail object
	 */
	public Mail build() {
		String from = mail.getFrom();
		if ( from == null || from.isEmpty() ) {
			throw new IllegalStateException("Mail cannot have an empty 'from' field!");
		}
		else {
			return mail;
		}
	}
}