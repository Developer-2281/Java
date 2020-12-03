package com.adamp.helloworld;

import org.springframework.boot.SpringApplication; //The newly imported references may be autohidden, click the icon by line 3
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // This is the first file run by the program
@RestController //After typing this press cntrl + shft + o to auto import above
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	//URLS.PY & VIEWS.PY
	@RequestMapping("/")     //cntrl + shft + o to autoimport
	public String hello() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
		System.out.println("You are on the random route");
		return "Spring Boot is Great! So easy to just respond with strings";
	}
	
}
// After filling out the above information right click on the boot folder for your project and select run as, then spring boot app
// the below phrase will appear in the console code if successful
// Tomcat initialized with port(s): 8080 (http)