package net.boota.javaFront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.boota.javaBackend.dao.InformationDAO;
import net.boota.javaBackend.dto.Information;
 
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private InformationDAO informationDAO;
	
	@RequestMapping("/all/information")
	@ResponseBody
	public List<Information> getAllInformation(){
		
		return informationDAO.listActiveInformation();
	}
	
	
	@RequestMapping("/category/{id}/information")
	@ResponseBody
	public List<Information> getInformationByCategory(@PathVariable int id){
		
		return informationDAO.listActiveInformationByCategory(id);
	}

}
