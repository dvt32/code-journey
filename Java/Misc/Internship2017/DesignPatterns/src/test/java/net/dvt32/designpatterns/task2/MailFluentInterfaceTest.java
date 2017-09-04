package net.dvt32.designpatterns.task2;

import static org.junit.Assert.*;

import java.util.Arrays;

import net.dvt32.designpatterns.task2.Mail;
import net.dvt32.designpatterns.task2.MailBuilder;

import org.junit.Test;

public class MailFluentInterfaceTest {

	@Test
	public void shouldBuildMailWithOnlyFromFieldFilled() {
		Mail mail = new MailBuilder().from("John Doe").build();
		
		String expectedOutput = 
			"from: John Doe\r\n" + 
			"to: null\r\n" + 
			"subject: null\r\n" + 
			"content: null\r\n" + 
			"CC: null\r\n" + 
			"attachments: null\r\n";
		String actualOutput = mail.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldBuildMailWithAllFieldsFilled() {
		Mail mail = new MailBuilder()
			.from("John Doe")
			.to("Thomas Edison")
			.subject("Apple pie")
			.content("Would you like some apple pie?")
			.cc("I forgot what CC was!")
			.attachments( Arrays.asList("Attachment1.jpg", "Attachment2.rar") )
			.build();
		
		String expectedOutput = 
			"from: John Doe\r\n" + 
			"to: Thomas Edison\r\n" + 
			"subject: Apple pie\r\n" + 
			"content: Would you like some apple pie?\r\n" + 
			"CC: I forgot what CC was!\r\n" + 
			"attachments: [Attachment1.jpg, Attachment2.rar]\r\n";
		String actualOutput = mail.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldThrowIllegalStateException() {
		Mail mail = new MailBuilder().to("Thomas Edison").build();
	}

}