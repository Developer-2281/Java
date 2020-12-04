package com.adamp.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery) {
		if(searchQuery == null) {
			return "Hello Human";
		}
		else {
			return "Hello " + searchQuery;
		}
	}

}

//cant get the optional to work, code duplicated entirely, control+z'ed top to previous build.

//@RestController
//public class MainController {
//	@RequestMapping("/")
//	public String index(@RequestParam(value="name", required=false) String searchQuery,@RequestParam(value="lname", required=false) String lName) {
//		if(searchQuery == null) {
//			String name1 = "Hello Human";
//			return name1;
//		}
//		else {
//			String name1 = "Hello " + searchQuery;
//			if (lName == null) {
//				String name2 = "";
//				return name1 + name2;
//			}
//			else {
//			String name2 = " " + lName;
//			return name1 + name2;
//			}
//		}
//
//	}
//}
