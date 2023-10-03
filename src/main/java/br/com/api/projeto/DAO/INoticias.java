package br.com.api.projeto.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.api.projeto.model.Noticias;

public interface INoticias<T, ID>{
	
	T pesquisaID(ID id);
	List<T> lista();
	
	void insert(T t);
	void remove(T t);
	void update(T t);
	List<T>pesquisarNoticias(String pesquisa);
	
	
}
