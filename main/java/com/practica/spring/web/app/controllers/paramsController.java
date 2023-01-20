package com.practica.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class paramsController {
	
	@GetMapping("/")
	public String texto() {
		return "params/index";
	}
	//prueba localhost:9080/params/string?texto=hola k hace
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", defaultValue = "no existen valores") String texto,
			Model model) {
		model.addAttribute("verParam", "El parametro enviado es: " + texto);
		return "params/ver";
	}
	
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero ,Model model) {
		model.addAttribute("verParam", "El saludo enviado es: '" + saludo+"' y el número es '"+
				numero+"'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request,Model model) {
		
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return "Parametro no númerico o no valido: " + e;
		}
		
		model.addAttribute("verParam", "El saludo enviado es: '" + saludo+"' y el número es '"+
				numero+"'");
		return "params/ver";
	}
	
	
}
