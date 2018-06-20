package net.boota.javaBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.boota.javaBackend.dao.MessageDAO;
import net.boota.javaBackend.dto.Message;



public class MessageTestCase {

	private static AnnotationConfigApplicationContext context;
	
	public static MessageDAO messageDAO;
	
	private Message message;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.boota.javaBackend");
		context.refresh();
		messageDAO = (MessageDAO)context.getBean("messageDAO");
		
	}
	
	
	

	@Test
	public void testCRUDMessage() {
		
		// create operation
		message = new Message();
		
		message.setSenderName("Crazzy Boota");
		message.setSenderEmail("boota@gmail.com");
		message.setMessageSubject("High School");
		message.setMainMessage("High School 3 is my favoritvasdjn egnnagmn jnfgvok c");
		message.setRead(true);
		
		assertEquals("something went wrong when inserting product",
				true,messageDAO.add(message));
		
		
		
		// reading and updating the message
		
		message = messageDAO.get(2);
		message.setMessageSubject("Manpreet");
		
		assertEquals("something went wrong when inserting product",
				true,messageDAO.update(message));
		
		
		// delete product
		assertEquals("something went wrong when inserting product",
				true,messageDAO.delete(message));
		
		// list
		assertEquals("something went wrong when inserting product",
				3,messageDAO.list().size());
		
		
		
		}
/*
	
	@Test
	public void testListUnreadMessage() {
		
		assertEquals("something went wrong when inserting product",
				1,messageDAO.listUnreadMessage().size());
		
	}
	
		*/
}
