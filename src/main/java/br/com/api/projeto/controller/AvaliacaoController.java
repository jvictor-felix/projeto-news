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

import br.com.api.projeto.DAO.AvaliacaoDAO;
import br.com.api.projeto.model.Avaliacao;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/apisms")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoDAO dao;
	
	@RequestMapping(value = "/msg/listar", method = RequestMethod.GET)
	public List<Avaliacao> listar(){
		return dao.listar();
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @RequestBody Avaliacao avaliacao) {
		dao.insert(avaliacao);
		return "ok";
		
	}
	
	@RequestMapping(value = "/msg/remover/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable Integer id) {
		Avaliacao avaliacao = dao.pesquisaId(id);
		dao.delete(avaliacao);
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
