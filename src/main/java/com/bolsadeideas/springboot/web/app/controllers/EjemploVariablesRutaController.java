package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Hola spring framework");
		return "variables/index";
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto,@PathVariable Integer numero, Model model) {
		model.addAttribute("titulo","Recibir parametros de la ruta @PathVariable");
		model.addAttribute("resultado","Eltexto enviado de la ruta es "+texto+" "
				+ " y el numero enviado en el path es: "+numero );
		return "variables/ver";
	}
	
}
