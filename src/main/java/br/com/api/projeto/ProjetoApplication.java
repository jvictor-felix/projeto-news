package br.com.api.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.api.projeto.DAO.NoticiasDAO;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	
		NoticiasDAO teste =  new NoticiasDAO();
		
	
	}
	
}
