package com.adamp.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adamp.dojoninjas.models.Dojo;
import com.adamp.dojoninjas.models.Ninja;
import com.adamp.dojoninjas.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			mainService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}

	@GetMapping("/ninjas/new")
	public String index2(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> allDojos = mainService.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "index2.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = mainService.getAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "index2.jsp";
		}
		else {
			mainService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = mainService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
}
