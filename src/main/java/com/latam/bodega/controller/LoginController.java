package com.latam.bodega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= "/")
public class LoginController {
	
	@GetMapping(value= "/")
	public String home() {
	   return "index";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
		
	}

}
