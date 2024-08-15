package com.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "/params/index";
	}

	@GetMapping("/string")
	public String pasoParametrosURL(@RequestParam(name = "text", defaultValue = "No se envio nada") String text,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es :" + text);
		return "/params/ver";
	}
	
	@GetMapping("/mix-params")
	public String pasoParametrosURL(@RequestParam String saludo,@RequestParam Integer numero,Model model) {
		model.addAttribute("resultado", "El Saludo enviado es :" + saludo +" y el numero que se envia es:"+ numero);
		return "/params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String pasoParametrosURL(HttpServletRequest request,Model model) {
		
		String saludo = request.getParameter("saludo");
		Integer numero = null;
				
		try{
			numero = Integer.parseInt(request.getParameter("numero"));
		}
		catch(NumberFormatException e){
			numero = 0;
		}
		model.addAttribute("resultado", "El Saludo enviado es :" + saludo +" y el numero que se envia es:"+ numero);
		return "/params/ver";
	}
}