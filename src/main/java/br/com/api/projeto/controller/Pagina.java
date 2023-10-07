package br.com.api.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Pagina {
	
	@RequestMapping("/")
	public ModelAndView pagina() {
		return new ModelAndView("index");
	}
	
	
	
}
