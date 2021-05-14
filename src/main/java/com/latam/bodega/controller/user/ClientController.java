package com.latam.bodega.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@GetMapping("/client")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("user/client");
		// modelAndView.addObject("bodega", new BodegaDTO());
		// modelAndView.addObject("valores", session.getAttribute("valores"));
		return modelAndView;
	}

}
