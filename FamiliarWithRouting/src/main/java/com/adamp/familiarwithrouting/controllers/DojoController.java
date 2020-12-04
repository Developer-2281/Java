package com.adamp.familiarwithrouting.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/{dojo_name}")
	public String dojo(@PathVariable("dojo_name") String name) {
		if(name.equals("dojo")) {
			return "The dojo is awesome!";
		}
		if(name.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
		}
		if(name.equals("san-jose")) {
			return "SJ Dojo is the headquarters";
		}
		else return "Sorry this Dojo doesn't exist yet.";
	}

	
}
