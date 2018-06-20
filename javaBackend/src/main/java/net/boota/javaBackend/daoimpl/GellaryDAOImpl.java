package net.boota.javaBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.boota.javaBackend.dao.GellaryDAO;
import net.boota.javaBackend.dto.Gellary;

@Repository("gellaryDAO")
@Transactional
public class GellaryDAOImpl implements GellaryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Gellary get(int id) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Gellary.class,Integer.valueOf(id));
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Gellary> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Gellary", Gellary.class)
					.getResultList();
	}

	@Override
	public boolean add(Gellary img) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(img);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Gellary img) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(img);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Gellary img) {
		try {
			img.setActive(false);
			
			return this.update(img);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	// bussiness Logic

	@Override
	public List<Gellary> listPublicGellary() {
		String selectPublic = "FROM Gellary WHERE privacy = :privacy";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectPublic, Gellary.class)
				 		.setParameter("privacy", "Public")
				 			.getResultList();
	}

	@Override
	public List<Gellary> listPersonalGellary() {
		String selectPersonal = "FROM Gellary WHERE privacy = :privacy";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectPersonal, Gellary.class)
				 		.setParameter("privacy", "Personal")
				 			.getResultList();
	}
	
	@Override
	public List<Gellary> listPrivateGellary() {
		String selectPrivate = "FROM Gellary WHERE privacy = :privacy";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectPrivate, Gellary.class)
				 		.setParameter("privacy", "Private")
				 			.getResultList();
	}

	@Override
	public List<Gellary> getLatestActiveGellary(int count) {
		return sessionFactory
				 .getCurrentSession()
				 	.createQuery("FROM Gellary WHERE active = :active ORDER BY id", Gellary.class)
				 		.setParameter("active", true)
				 			.setFirstResult(0)
				 			.setMaxResults(count)
				 			.getResultList();
	}
	
}
