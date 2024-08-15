package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")

public class EjemploVariblesRutaController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo", "Enviar parametros de la Ruta y mostrarlos con PAthVariable");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variable (@PathVariable String texto,Model model ) {
		
		model.addAttribute("titulo", "Recibir parametros de la Ruta (@PathVariable)");
		model.addAttribute("resultado", "El valor enviado por PathVariable es =" + texto);
		return "variables/ver"; // esto siempre apunta a la vista
	}	
	
	@GetMapping("/string/{texto}/{numero}")
	public String variable (@PathVariable String texto,@PathVariable Integer numero,Model model ) {
		
		model.addAttribute("titulo", "Recibir parametros de la Ruta (@PathVariable)");
		model.addAttribute("resultado", "El valor enviado por PathVariable es =" + texto + " y el Numero enviado en PathVariable es = "+numero);
		return "variables/ver"; // esto siempre apunta a la vista
	}	

}
