package net.boota.javaBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.boota.javaBackend.dao.InformationDAO;
import net.boota.javaBackend.dto.Information;

public class InformationTestCase {

	private static AnnotationConfigApplicationContext context;
	
	public static InformationDAO informationDAO;
	
	private Information information;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.boota.javaBackend");
		context.refresh();
		informationDAO = (InformationDAO)context.getBean("informationDAO");
		
	}
	

	@Test
	public void testCRUDInformation() {
		
		// create operation
		information = new Information();
		
		information.setName("Mount Abu Tour");
		information.setUrl1(null);
		information.setUrl2(null);
		information.setUrl3(null);
		information.setPrivacy("Public");
		
		information.setDescription2(
				
				"So as you embark on your own journey toward self-improvement as a\r\n" + 
				"man, assume that the advice you read in this book works until proven\r\n" + 
				"otherwise. In other words, ya gotta have faith!\r\n" + 
				"This book lays it on the line for you as to what women find attractive in a\r\n" + 
				"man and shows you step-by-step how you can not only act in attractive ways but\r\n" + 
				"also actually become an attractive man. And when you become an attractive\r\n" + 
				"man, you’ll achieve your dreams just by being yourself. "
				);
		
		information.setDescription3("");
		information.setDescription1("");
		information.setCategoryId(4);
		information.setSupplierId(2);
		
		assertEquals("something went wrong when inserting product",
				true,informationDAO.add(information));
		
		/*
		
		// reading and updating the information
		
		information = informationDAO.get(1);
		information.setName("Main Again Change");
		
		assertEquals("something went wrong when inserting product",
				true,informationDAO.update(information));
		
		
		// delete product
		assertEquals("something went wrong when inserting product",
				true,informationDAO.delete(information));
		
		// list
		assertEquals("something went wrong when inserting product",
				3,informationDAO.list().size());
		
		*/
		
		}
	/*
	
	@Test
	public void testListActiveInfomation() {
		
		assertEquals("something went wrong when inserting product",
				2,informationDAO.listActiveInformation().size());
		
	}
	
	
	@Test
	public void testListActiveInformationByCategory() {
		
		assertEquals("something went wrong when inserting product",
				2,informationDAO.listActiveInformationByCategory(2).size());
		
		assertEquals("something went wrong when inserting product",
				0,informationDAO.listActiveInformationByCategory(1).size());
		
	}

	
	
	@Test
	public void testGetLatestActiveInformation() {
		
		assertEquals("something went wrong when inserting product",
				2,informationDAO.getLatestActiveInformation(3).size());
		
	}
	*/
	
}
