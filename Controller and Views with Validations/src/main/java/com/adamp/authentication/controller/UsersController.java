package com.adamp.authentication.controller;

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

import com.adamp.authentication.models.User;
import com.adamp.authentication.services.UserService;
import com.adamp.authentication.validators.UserValidator;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator uValid;
	

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	uValid.validate(user, result);
    	if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
		else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
        	User user = userService.findByEmail(email);
        	session.setAttribute("userId", user.getId());
        	return "redirect:/home";
        }
        else {
        	model.addAttribute("error", "Invalid Credentials. Please try again.");
        	return "loginPage.jsp";
        }
    }

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "homePage.jsp";
    }	
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
}
