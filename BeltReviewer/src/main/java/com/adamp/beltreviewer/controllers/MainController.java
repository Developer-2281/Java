package com.adamp.beltreviewer.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adamp.beltreviewer.models.Event;
import com.adamp.beltreviewer.models.Message;
import com.adamp.beltreviewer.models.User;
import com.adamp.beltreviewer.services.MainService;
import com.adamp.beltreviewer.services.UserService;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("userId") == null) {
			redirectAttributes.addFlashAttribute("flasherror", "Forbidden!!! You must login first!!");
			 //if not logged in user is redirected to login
			// flash messages can only be passed across one redirect.
			return "redirect:/registration";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			List<Event> allEvents = mainService.getAllEvents();
			model.addAttribute("events", allEvents);
			model.addAttribute("userId", userId);
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			// Remember the quoted value inside the ("") is what is passed to the jsp file
			System.out.println();
			return "events2.jsp";
		}
	}
	
	
	@PostMapping("/addEvent")
	public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("userId") == null) {
			redirectAttributes.addFlashAttribute("flasherror", "Forbidden!!! You must login first!!");
			 //if not logged in user is redirected to login
			// flash messages can only be passed across one redirect.
			return "redirect:/registration";
		}
		
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			List<Event> allEvents = mainService.getAllEvents();
			model.addAttribute("events", allEvents);
			model.addAttribute("userId", userId);
			User user = userService.findUserById(userId);
			model.addAttribute("user", user);
			// Remember the quoted value inside the ("") is what is passed to the jsp file
			System.out.println();
			return "events2.jsp";
		}
		
		else {
			mainService.addEvent(event);
			return "redirect:/events";
		}
	}
		
	@GetMapping("/test")
	public String testError(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Forbidden!!! You must login first!!");

		return "redirect:/login";
	}
	
	// Show an Event
	@GetMapping("/events/{event_id}")
	public String showEvent(@PathVariable("event_id")Long id, Model model, @ModelAttribute("message")Message message, HttpSession session, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("userId") == null) {
			redirectAttributes.addFlashAttribute("flasherror", "Forbidden!!! You must login first!!");
			 //if not logged in user is redirected to login
			// flash messages can only be passed across one redirect.
			return "redirect:/registration";
		}
		else {
			Event event = mainService.findEventById(id);
			model.addAttribute("event", event);
			Long user_id = (Long) session.getAttribute("userId");
			model.addAttribute("user",userService.findUserById(user_id));
			List<Message> wallposts = mainService.getAllMessages();
			model.addAttribute("wallposts", wallposts);
		
			return "showEvent.jsp";
		}
		
	}

	// Add a Message to the Message Wall
	
	@PostMapping("/events/{event_id}") //always label the id
	public String addMsg(@Valid @ModelAttribute("message")Message message, BindingResult results, HttpSession session, Model model, @PathVariable("event_id") Long id) {
		if(results.hasErrors()) {
			Event event = mainService.findEventById(id);
			model.addAttribute("event", event);
			return "showEvent.jsp";
		}
		else {
			mainService.addMessage(message);
			return "redirect:/events/{event_id}";
		}
		
	}
	
			
	// render event edit page
	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id")Long id, Model model, @ModelAttribute("event")Event event, HttpSession session, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("userId") == null) {
			redirectAttributes.addFlashAttribute("flasherror", "Forbidden!!! You must login first!!");
			 //if not logged in, user is redirected to login
			// flash messages can only be passed across one redirect.
			return "redirect:/registration";
		}
	
		// -------------------- Brute Force Edit Security --------------------------- //

		System.out.println("the event object is :" + mainService.findEventById(id));
		Event thisEvent = (Event) mainService.findEventById(id);
		User eventHost = thisEvent.getHost();
		System.out.println("the host id is :" + eventHost.getId());
		System.out.println("the user id is :" + session.getAttribute("userId"));
		
		if (eventHost.getId() != session.getAttribute("userId")) {
				redirectAttributes.addFlashAttribute("flasherror", "Forbidden!!! You are not the event creator!!");
				//if user is not event creator, redirected to event page
				// flash messages can only be passed across one redirect.
				return "redirect:/events";
			}

		// -------------------- End Brute Force Edit Security --------------------------- //
		
		else {
			Event eventToEdit = mainService.findEventById(id);
			model.addAttribute("event", eventToEdit); 
			return "editEvent.jsp";
		}
	}
		
	//store the edit
	@RequestMapping(value="/events/{id}/edit", method=RequestMethod.PUT)// Binding results stored inside variable result, order is important, valid M-Attribute, filled, binding, then anything else.
	public String editEvent(@Valid @ModelAttribute("event")Event filledEvent, BindingResult results, HttpSession session, Model model, @PathVariable("id")Long id) {
		if(results.hasErrors()) {
			Event eventToEdit = mainService.findEventById(id);
			model.addAttribute("event", eventToEdit); 
			return "editEvent.jsp";
		}
		mainService.update(filledEvent);//calls on the mainService with the variable created above to execute function createEvent(with the inputed event in the paranthesis)
		return "redirect:/events";// :::::::::::::::You must have a : after redirect :::::::::::::::::				
	}
		
	//delete
	@RequestMapping("events/{id}/delete")
	public String destroy(@PathVariable("id")Long id, HttpSession session, RedirectAttributes redirectAttributes) {

		// -------------------- Brute Force Delete Security --------------------------- //

		System.out.println("the event object is :" + mainService.findEventById(id));
		Event thisEvent = (Event) mainService.findEventById(id);
		User eventHost = thisEvent.getHost();
		System.out.println("the host id is :" + eventHost.getId());
		System.out.println("the user id is :" + session.getAttribute("userId"));
		
		if (eventHost.getId() != session.getAttribute("userId")) {
				redirectAttributes.addFlashAttribute("flasherror", "Forbidden to Delete!!! You are not the event creator!!");
				//if user is not event creator, redirected to event page
				// flash messages can only be passed across one redirect.
				return "redirect:/events";
			}

		// -------------------- End Brute Force Delete Security --------------------------- //
		
		mainService.deleteEvent(id);
		return "redirect:/events";
		
	}
	
	//Join Event Many to Many
	
	@RequestMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {

		//								  Relationship join names
		
		Long num = (Long) session.getAttribute("userId");
		User userToJoin = userService.findUserById(num);
		Event eventToJoin = mainService.findEventById(id);
		
		System.out.println("The User's id is:  " + num);
		System.out.println("The user object is:  " + userToJoin);
		System.out.println("The event id is:  " + id);
		System.out.println("The event object is:  " + eventToJoin);
		
		
		//List<Event> events = userToJoin.getJoinedEvents();
		//events.add(eventToJoin); 	only need to add one.
		
		userToJoin.getJoinedEvents().add(eventToJoin);
		userService.saveUser(userToJoin);
		return "redirect:/events";
		
	}
	

	@RequestMapping("/events/{id}/cancel")
	public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {

		//								  Relationship join names
		
		Long num = (Long) session.getAttribute("userId");
		User userToCancel = userService.findUserById(num);
		Event eventToCancel = mainService.findEventById(id);
		
		System.out.println("The User's id is:  " + num);
		System.out.println("The user object is:  " + userToCancel);
		System.out.println("The event id is:  " + id);
		System.out.println("The event object is:  " + eventToCancel);
		
		
		//List<Event> events = userToJoin.getJoinedEvents();
		//events.add(eventToJoin);   only need to add one.

		userToCancel.getJoinedEvents().remove(eventToCancel);
		userService.saveUser(userToCancel);
		return "redirect:/events";
		
		// cancel logic not yet working
		
	}
}