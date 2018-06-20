package net.boota.javaBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.boota.javaBackend.dao.GellaryDAO;
import net.boota.javaBackend.dto.Gellary;

public class GellaryTestCase {

	
	
private static AnnotationConfigApplicationContext context;
	
	public static GellaryDAO gellaryDAO;
	
	private Gellary gellary;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.boota.javaBackend");
		context.refresh();
		gellaryDAO = (GellaryDAO)context.getBean("gellaryDAO");
		
	}
	/*	

	@Test
	public void testCRUDgellary() {
	
		// create operation
		gellary = new Gellary();
		
		gellary.setImgName("Mount Abu Tour");
		gellary.setActive(false);
		gellary.setPrivacy("Public");
		
		gellary.setDescription(
				
				"So as you embark on your own journey toward self-improvement as a\r\n" + 
				"man, assume that the advice you read in this book works until proven\r\n"
				);
		
		assertEquals("something went wrong when inserting product",
				true,gellaryDAO.add(gellary));
		
		
		
		// reading and updating the gellary
		
		gellary = gellaryDAO.get(1);
		gellary.setImgName("Beautiful");
		
		assertEquals("something went wrong when inserting product",
				true,gellaryDAO.update(gellary));
		
		
		// delete product
		assertEquals("something went wrong when inserting product",
				true,gellaryDAO.delete(gellary));
		
		// list
		assertEquals("something went wrong when inserting product",
				1,gellaryDAO.list().size());
		
		
		
		}
	*/
	
	@Test
	public void testListPublicGellary() {
		
		assertEquals("something went wrong when inserting product",
				2,gellaryDAO.listPublicGellary().size());
		
	}
	
	@Test
	public void testListPrivateGellary() {
		
		assertEquals("something went wrong when inserting product",
				1,gellaryDAO.listPrivateGellary().size());
		
	}
	
	@Test
	public void testListPersanalGellary() {
		
		assertEquals("something went wrong when inserting product",
				0,gellaryDAO.listPersonalGellary().size());
		
	}
	
	
	@Test
	public void testGetLatestActivegellary() {
		
		assertEquals("something went wrong when inserting product",
				2,gellaryDAO.getLatestActiveGellary(2).size());
		
	}
	

	
	
	
}
