package com.adamp.languages.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adamp.languages.models.Language;
import com.adamp.languages.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainServ;
	public MainController(MainService mainServ) {
		this.mainServ =mainServ;
	}
	
	@GetMapping("/")	// This is a test route
	public String index() {
		return "test.jsp";
	}
	//dashboard
	@GetMapping("/languages")//Model model allows use of model.Attribute
	public String dashboard(Model model, @ModelAttribute("language")Language emptyLang) {
		List<Language> allLangs = mainServ.getAllLanguages();
		model.addAttribute("allLangs", allLangs);  // allLangs will be the variable passed the html
		return "newLang.jsp";
	}
	
	//dashboard
	@PostMapping("/submitLang")// Binding results stored inside variable result, order is important, valid M-Attribute, filled, binding, then anything else.
	public String addLang(@Valid @ModelAttribute("language")Language filledLang, BindingResult results, HttpSession session, Model model) {
		if(results.hasErrors()) {
			List<Language> allLangs = mainServ.getAllLanguages();
			model.addAttribute("allLangs", allLangs);  // allLangs will be the variable passed the html
			return "newLang.jsp";
		}
		mainServ.createLanguage(filledLang);//calls on the mainServer with the variable created above to execute function createLanguage(with the inputed language in the paranthesis)
		return "redirect:/languages";// :::::::::::::::You must have a : after redirect :::::::::::::::::				
	}
	//edit render
	@GetMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id")Long id, Model model, @ModelAttribute("language")Language emptyLang) {
		List<Language> allLangs = mainServ.getAllLanguages();
		model.addAttribute("allLangs", allLangs); 
		return "editLang.jsp";
	
	}
	//edit store the edit
	@RequestMapping(value="/languages/edit/{id}", method=RequestMethod.PUT)// Binding results stored inside variable result, order is important, valid M-Attribute, filled, binding, then anything else.
	public String editLang(@Valid @ModelAttribute("language")Language filledLang, BindingResult results, HttpSession session, Model model) {
		if(results.hasErrors()) {
			List<Language> allLangs = mainServ.getAllLanguages();
			model.addAttribute("allLangs", allLangs);  // allLangs will be the variable passed the html
			return "editLang.jsp";
		}
		mainServ.update(filledLang);//calls on the mainServer with the variable created above to execute function createLanguage(with the inputed language in the paranthesis)
		return "redirect:/languages";// :::::::::::::::You must have a : after redirect :::::::::::::::::				
	}
	//delete
	@RequestMapping("languages/delete/{id}")
	public String destroy(@PathVariable("id")Long id) {
		mainServ.deleteLanguage(id);
		return "redirect:/languages";
	}
	//show language
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Language language = mainServ.findLanguageById(id);
		model.addAttribute("language", language);
		return "language.jsp";
	
	}
}
