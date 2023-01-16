package com.practica.spring.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.spring.web.app.models.Usuario;
//rutas de primer nivel
@Controller
//Mapear controlador Con RequestMapping
@RequestMapping("/app")
public class IndexController {
	//rutas de segundo nivel
	
//	@RequestMapping(value="/index",
//			method=RequestMethod.GET)
	
	@GetMapping({"/index","/","","/home"})
	//metodo por defecto
	public String index(Model model) {
		model.addAttribute("titulo", "hola spring Framework");
		return "index";
	}
	
	//metodo handler - un manejador que es capaz de recibir un evento o mensaje, etc.
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("Arias");
		usuario.setEmail("andres@comcat.com");	
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("tituloPerfil", "Pefil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		/*
		 * una forma más optima, Arrays.asList(); esto convierte en una lista
		 * los datos que le demos a partir del constructor separados por una coma
		 */
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrew", "Cortes", "andres@estecorreo.com"),
				new Usuario("Flopez", "Maria", "Flopez@estecorreo.com"),
				new Usuario("Marian", "Cilantro", "marian@estecorreo.com"));
		
		//una forma
//		usuarios.add(new Usuario("Andrew", "Cortes", "andres@estecorreo.com"));
//		usuarios.add(new Usuario("Flopez", "Maria", "Flopez@estecorreo.com"));
//		usuarios.add(new Usuario("Marian", "Cilantro", "marian@estecorreo.com"));
		
		model.addAttribute("tituloListar", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
}