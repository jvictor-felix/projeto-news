package br.com.api.projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projeto.DAO.NoticiasDAO;
import br.com.api.projeto.model.Noticias;

@RestController
@CrossOrigin("*")
@RequestMapping("/apinews")
public class NoticiasController{
	
	@Autowired
	private NoticiasDAO dao;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public List<Noticias> noticias(){
		return dao.lista();
	}
	
	@RequestMapping(value = "/news/adicionar", method = RequestMethod.POST)
	public String adicionar(@RequestBody Noticias noticias) {
		dao.insert(noticias);
		Noticias n = noticias;
		return "ok";
	}
	
	@RequestMapping(value = "/pesquisaid/{id}", method = RequestMethod.GET)
	public Noticias noticia(@PathVariable Integer id) {
		return dao.pesquisaID(id);
	}
	
	@RequestMapping(value = "/pesquisar/{pesquisa}", method = RequestMethod.GET)
	public List<Noticias> pesquisar(@PathVariable String pesquisa){
		return dao.pesquisarNoticias(pesquisa);
	}
	
	@RequestMapping(value = "/news/atualizar", method = RequestMethod.PUT)
	public String atualizar(@RequestBody Noticias noticias) {
		dao.update(noticias);
		return "Fez update";
	}
	
	@RequestMapping(value = "/news/remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable Integer id) {
		Noticias noticia = dao.pesquisaID(id);
		dao.remove(noticia);
		return "ok";
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
			
		});
		return errors;
	}
	
	
	

}
