package net.boota.javaBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.boota.javaBackend.dao.InformationDAO;
import net.boota.javaBackend.dto.Information;

@Repository("informationDAO")
@Transactional
public class InformationDAOImpl implements InformationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Information get(int informationId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Information.class,Integer.valueOf(informationId));
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Information> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Information", Information.class)
					.getResultList();
	}

	@Override
	public boolean add(Information information) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(information);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Information information) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(information);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Information information) {
		try {
			information.setActive(false);
			
			return this.update(information);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	// bussiness method

	@Override
	public List<Information> listActiveInformation() {
		String selectActiveInformation = "FROM Information WHERE active = :active";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectActiveInformation, Information.class)
				 		.setParameter("active", true)
				 			.getResultList();
	}

	@Override
	public List<Information> listActiveInformationByCategory(int categoryId) {
		String selectActiveInformationByCategory = "FROM Information WHERE active = :active AND categoryId = :categoryId";
		 return sessionFactory
				 .getCurrentSession()
				 	.createQuery(selectActiveInformationByCategory, Information.class)
				 		.setParameter("active", true)
				 		.setParameter("categoryId", categoryId)
				 			.getResultList();
	}

	@Override
	public List<Information> getLatestActiveInformation(int count) {
		return sessionFactory
				 .getCurrentSession()
				 	.createQuery("FROM Information WHERE active = :active ORDER BY id", Information.class)
				 		.setParameter("active", true)
				 			.setFirstResult(0)
				 			.setMaxResults(count)
				 			.getResultList();
	}

}
