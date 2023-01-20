package com.practica.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	//redirect sirve para dar rutas externas al proyecto
	//forward sirver para dar rutas internas del proyecto
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}
	
}
