package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String titulo;
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", titulo);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Emiliano");
		usuario.setApellido("Macias");
		usuario.setEmail("emilianomacias0@gmail.com");
		model.addAttribute("titulo", titulo);
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", titulo);
		return "listado";
	}
	//Hace disponible el objeto usuarios en todo el controlador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Emiliano","Macias","emilianomacias0mail.com"),
				new Usuario("Juan","perez","j.perez@gmail.com"),
				new Usuario("Emiliano","Macias","emilianomacias0mail.com"),
				new Usuario("Evelardo","Gutierrez","e.guiti@mail.com"));
		
		return usuarios;
	}
	
}
