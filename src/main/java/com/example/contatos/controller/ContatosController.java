package com.example.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.contatos.model.Contatos;
import com.example.contatos.repository.ContatosRepository;


@Controller
@RestController
@RequestMapping("/")
public class ContatosController {
	
	@Autowired
	private ContatosRepository contatos;
	
	@GetMapping
	 public ModelAndView listar() {
		List<Contatos> lista = contatos.findAll();
	     
	    ModelAndView modelAndView = new ModelAndView("index");
	    
	    
	    modelAndView.addObject("contatos", lista);
	     
	    return modelAndView;
	  }
	@GetMapping("{codigo}")
	public ModelAndView lista(@PathVariable Long codigo) {
		Contatos contato = contatos.findOne(codigo);
		
		ModelAndView modelAndView = new ModelAndView("alterar");
		
		modelAndView.addObject("contatos", contato);
		
		return modelAndView;
	}
	
	@GetMapping("delete/{codigo}")
	public ModelAndView delete(@PathVariable Long codigo){
		contatos.delete(codigo);
		return listar();
	}
	
}
