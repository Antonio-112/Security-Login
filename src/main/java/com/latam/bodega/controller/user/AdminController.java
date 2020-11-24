package com.latam.bodega.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	 @GetMapping("/admin")
	    public ModelAndView home(HttpSession session) {
	        ModelAndView modelAndView = new ModelAndView("admin/admin");
	        return modelAndView;
	}

}
