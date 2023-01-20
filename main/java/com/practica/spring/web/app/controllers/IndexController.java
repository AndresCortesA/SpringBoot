package com.practica.spring.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexController.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexController.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/","","/home"})
	//metodo por defecto
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
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
		model.addAttribute("tituloPerfil", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
<<<<<<< HEAD
		model.addAttribute("tituloListar", textoListar);
//		model.addAttribute("usuarios", usuarios);
=======
		model.addAttribute("tituloListar", "Listado de usuarios");
>>>>>>> df66d5ccb7ba89c6eeb7efb380a07860dffa0c05
		
		return "listar";
	}
	
	//Este sera un metodo más optimo que nos permita desarrollar los datos de manera más eficiente
	//llamandolos en los otros metodos ya que estara disponible para todas las rutas
	/*
	 * esta sera una alternativa para pasar datos a la vista de forma separada
	 */
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrew", "Cortes", "andres@estecorreo.com"),
				new Usuario("Flopez", "Maria", "Flopez@estecorreo.com"),
				new Usuario("Marian", "Cilantro", "marian@estecorreo.com"));
		return usuarios;
	}
	
}
