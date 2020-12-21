package com.adamp.beltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adamp.beltreviewer.models.User;
import com.adamp.beltreviewer.services.UserService;
import com.adamp.beltreviewer.validators.UserValidator;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator uValid;
	

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "logReg/logRegPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "redirect:/registration";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	uValid.validate(user, result);
    	if(result.hasErrors()) {
			return "logReg/logRegPage.jsp";
		}
		else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
        boolean isAuthenticated = userService.authenticateUser(email, password); // the model attribute from the login/registration form user is passed on here with User user, though not needed by the login it must be present because it is on the same jsp file. 
    	if(isAuthenticated) {
        	User user1 = userService.findByEmail(email);
        	session.setAttribute("userId", user1.getId());
        	return "redirect:/home";
        }
        else {
        	model.addAttribute("error", "Invalid Credentials. Please try again.");
        	return "logReg/logRegPage.jsp";
        }
    }

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) { 
			// if not logged in user is redirected to login
			return "redirect:/login";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
	        User user = userService.findUserById(userId);
	        model.addAttribute("user", user);
	        return "redirect:/events";
		}
		
    }	
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
}
