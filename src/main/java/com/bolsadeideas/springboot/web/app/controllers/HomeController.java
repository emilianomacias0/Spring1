package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "redirect:/app/index";
	}
	
	@GetMapping("/on")
	public String buscador() {
		return "redirect:https://github.com/emilianomacias0/Spring1";
	}
}
