package net.boota.javaBackend.dao;

import java.util.List;

import net.boota.javaBackend.dto.Information;

public interface InformationDAO {
	
	Information get(int informationId);
	List<Information> list();
	boolean add(Information information);
	boolean update(Information information);
	boolean delete(Information information);
	
	// bussines logic
	
	List<Information> listActiveInformation();
	List<Information> listActiveInformationByCategory(int categoryId);
	List<Information> getLatestActiveInformation(int count);
	
	

}
