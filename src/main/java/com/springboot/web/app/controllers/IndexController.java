package com.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")// ruta de primer nivel
public class IndexController {
	
	@Value ("${texto.indexController.index.titulo}")
	private String tituloIndex;
	
	@Value ("${texto.indexController.perfil.titulo}")
	private String tituloPerfil;
	
	@Value ("${texto.indexController.listar.titulo}")
	private String tituloListar;
		
	@GetMapping({"/index","/","/Home",""}) 
	public String index(ModelMap model) {
		
		//pasar texto a la vista
		model.addAttribute("titulo",tituloIndex);
		
		return "index";
	}
	@GetMapping ("/perfil")
	public String perfil(ModelMap model){
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Edgar");
		usuario.setApellido("Munar");
		usuario.setEmail("edgar@hotmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",tituloPerfil);
		
		return "perfil";		
	}	
	@GetMapping ("/listar")
	public String listar (ModelMap model){
		
//		List<Usuario> usuarios = new ArrayList<>(); 
//		usuarios.add(new Usuario("Edgar","Munar","edgar@hotmail.com"));
//		usuarios.add(new Usuario("Paola","Lopez","paola@hotmail.com"));
//		usuarios.add(new Usuario("Martina","Munar","marty@hotmail.com"));
		model.addAttribute("titulo",tituloListar);
//		model.addAttribute("usuarios",usuarios);
		
		return "listar";		
	}
	
	//Este sirve cuando se necesita en varios metodos o vistas
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = new ArrayList<>(); 
		usuarios.add(new Usuario("Edgar","Munar","edgar@hotmail.com"));
		usuarios.add(new Usuario("Paola","Lopez","paola@hotmail.com"));
		usuarios.add(new Usuario("Martina","Munar","marty@hotmail.com"));
		
		return usuarios;
	}
	
}