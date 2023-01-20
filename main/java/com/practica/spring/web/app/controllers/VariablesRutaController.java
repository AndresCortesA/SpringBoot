package com.practica.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("tituloIndexVar", "Enviar parámetros de la ruta(@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("tituloVariable", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto que se envia a la ruta es: " + texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("tituloVariable", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto que se envia a la ruta es: " + texto+
				" el número en el path es: "+numero);
		return "variables/ver";
	}
	

}
