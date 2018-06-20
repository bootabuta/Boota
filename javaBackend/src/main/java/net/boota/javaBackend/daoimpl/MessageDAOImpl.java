package net.boota.javaBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.boota.javaBackend.dao.MessageDAO;
import net.boota.javaBackend.dto.Information;
import net.boota.javaBackend.dto.Message;

@Repository("messageDAO")
@Transactional
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Message get(int messageId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Message.class,Integer.valueOf(messageId));
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Message> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Message", Message.class)
					.getResultList();
	}

	@Override
	public boolean add(Message message) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(message);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Message message) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(message);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Message message) {
		try {
			message.setRead(false);
			
			return this.update(message);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> listUnreadMessage() {
		String selectUnreadMessage = "FROM Message WHERE read = :read";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectUnreadMessage, Message.class)
				 		.setParameter("read", true)
				 			.getResultList();
	}

}
