package net.boota.javaBackend.dao;

import java.util.List;

import net.boota.javaBackend.dto.Message;

public interface MessageDAO {
	
	
	Message get(int messageId);
	List<Message> list();
	boolean add(Message message);
	boolean update(Message message);
	boolean delete(Message message);
	
	// bussines logic
	
	List<Message> listUnreadMessage();

}
