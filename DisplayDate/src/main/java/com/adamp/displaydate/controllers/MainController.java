package com.adamp.displaydate.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import java.time.LocalDateTime;

@Controller
public class MainController {


	@RequestMapping("/") 
	public String display() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String displayDate(Date date, HttpSession Session){
			SimpleDateFormat date1 = new SimpleDateFormat("EEEE 'the' d 'of' MMMM',' yyyy");
			Date date2 = new Date();
			String stringDate = date1.format(date2);
			Session.setAttribute("date", stringDate);
			
		    System.out.println("The date is: " + date);
		    System.out.println("The date is: " + date1);
		    System.out.println("The date is: " + date2);
		    System.out.println("The date is: " + stringDate);
			return "date.jsp";
		
		
	}

	@RequestMapping("/time")
	public String disTime(Date time, HttpSession Session) {
			SimpleDateFormat time1 = new SimpleDateFormat("hh:mm a");
			Date time2 = new Date();
			String stringTime = time1.format(time2);
			Session.setAttribute("time", stringTime);
			
		    System.out.println("The date is: " + time);
		    System.out.println("The date is: " + time1);
		    System.out.println("The date is: " + time2);
		    System.out.println("The date is: " + stringTime);
			return "time.jsp";
		
	}

}