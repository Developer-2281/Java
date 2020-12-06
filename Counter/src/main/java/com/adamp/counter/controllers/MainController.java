package com.adamp.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/your_server")
	public String serv(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count ++;
		session.setAttribute("count", count);
		System.out.println("Current site visit count is " + count);
		return "index.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String count(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "index2.jsp";
	}
}
