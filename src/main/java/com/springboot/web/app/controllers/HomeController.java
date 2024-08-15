package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(){
	
		return "forward:/app/index"; 
		// Se envia al controlador deseado forward No cambia la ruta en el navegador y no reinicia controlador
		// redirect cambia la ruta y reinicia controlador
	}
}