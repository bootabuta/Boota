package net.boota.javaBackend.dao;

import java.util.List;

import net.boota.javaBackend.dto.Gellary;



public interface GellaryDAO {

	
	Gellary get(int Id);
	List<Gellary> list();
	boolean add(Gellary img);
	boolean update(Gellary img);
	boolean delete(Gellary img);
	
	// bussines logic
	
	List<Gellary> listPublicGellary();
	List<Gellary> listPersonalGellary();
	List<Gellary> listPrivateGellary();
	List<Gellary> getLatestActiveGellary(int count);
	
}
