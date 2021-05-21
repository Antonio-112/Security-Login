package com.latam.bodega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.latam.bodega.model.Users;
import com.latam.bodega.service.RegisterServiceImpl;

@Controller
@RequestMapping(value= "/")
public class LoginController {
	
	@Autowired
	RegisterServiceImpl regService;
	
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
	@PostMapping("/register")
	public ModelAndView register(Users user) {
		System.out.println(regService.registerUser(user));
		return new ModelAndView("register");
		
	}

}
