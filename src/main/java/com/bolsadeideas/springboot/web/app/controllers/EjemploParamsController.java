package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros del request HTTP GET - URL");
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto",required = false,defaultValue = "no info") String texto, Model model) {
		model.addAttribute("titulo", "Recibir atributo get");
		model.addAttribute("resultado", "El texto enviado es "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String texto,@RequestParam Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir atributo get");
		model.addAttribute("resultado", "El saludos es '"+texto+"' y el numero es '"+numero+"'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("texto");
		Integer numero = 0;
		try {
		 numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("titulo", "Recibir atributo get");
		model.addAttribute("resultado", "El saludos es '"+saludo+"' y el numero es '"+numero+"'");
		return "params/ver";
	}
	

}
