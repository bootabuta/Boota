package net.boota.javaFront.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.boota.javaBackend.dao.CategoryDAO;
import net.boota.javaBackend.dao.GellaryDAO;
import net.boota.javaBackend.dao.InformationDAO;
import net.boota.javaBackend.dao.MessageDAO;
import net.boota.javaBackend.dto.Category;
import net.boota.javaBackend.dto.Message;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private InformationDAO informationDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired 
	private GellaryDAO gellaryDAO;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
		logger.info("Inside the PageControoler Index Method - INFO");
		logger.debug("Inside the PageControoler Index Method - DEBUG");
		
	//	mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value={"/about/show/main/information"})
	public ModelAndView listInformation(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAllInformation", true);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("information_list", informationDAO.listActiveInformationByCategory(1));
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(@RequestParam(name= "operation", required= false) String operation){
		
		ModelAndView mv = new ModelAndView("Page");
		
		if(operation != null) {
			if(operation.equals("message")) {
				mv.addObject("infoMessage","Your Message Sent Successfully. We connect you Soon as possible !");
			}
		}
		
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		Message nMessage = new Message();
		nMessage.setRead(false);
		
		mv.addObject("message", nMessage);
		return mv;
	}
	
	// Handling Message Submission 
	
		@RequestMapping(value = "/contact", method=RequestMethod.POST)
		public String handleMessageSubmission(@Valid @ModelAttribute("message") Message nMessage, BindingResult results, Model model) {
			
			if(results.hasErrors()) {
				model.addAttribute("userClickContact", true);
				model.addAttribute("title", "Contact Us");
				return "Page";
			}
			
			messageDAO.add(nMessage);
			
			return "redirect:/contact?operation=message";
		}
	
	
	
	@RequestMapping(value={"/portfolio/public"})
	public ModelAndView portfolio(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Portfolio");
		mv.addObject("userClickPortfolio", true);
		mv.addObject("imageList", gellaryDAO.listPublicGellary());
		return mv;
	}
	
	@RequestMapping(value={"/portfolio/personal"})
	public ModelAndView portfolioPersonal(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Portfolio");
		mv.addObject("userClickPortfolio", true);
		mv.addObject("imageList", gellaryDAO.listPersonalGellary());
		return mv;
	}
	
	
	
	@RequestMapping(value={"/blogs"})
	public ModelAndView blogs(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Blogs");
		mv.addObject("userClickBlogs", true);
	//	mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value={"/resume"})
	public ModelAndView resume(){
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("title", "Resume");
		mv.addObject("userClickResume", true);
	//	mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value={"/show/category/{id}/information"})
	public ModelAndView showCategoryInformation(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("Page");
		
		// Loading Category Name
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
	
		mv.addObject("category", category );
		mv.addObject("userClickCategoryInformation", true);
		mv.addObject("categories", categoryDAO.list()); 
		mv.addObject("information_list", informationDAO.listActiveInformationByCategory(id));
		return mv;
	}
	
}
