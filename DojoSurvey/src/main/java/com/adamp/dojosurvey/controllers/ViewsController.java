package com.adamp.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewsController {
	
	@RequestMapping("/")
	public String survey() {
		System.out.println("You have visited the survey page");
		return "index.jsp";
	}
//	
//	@RequestMapping("/result")
//	public String result(Model model) {
//		System.out.println("You are looking at the results page");
//		return "index2.jsp";
//	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String input(Model model, 
		@RequestParam(value="name1") String name, 
		@RequestParam(value="location") String location, 
		@RequestParam(value="language") String language, 
		@RequestParam(value="text") String text) { 
		model.addAttribute("name1", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("text", text);
		System.out.println("You have been redirected after submitting your survey");
		System.out.println("name1" + name);
		return "index2.jsp";
	}

}
