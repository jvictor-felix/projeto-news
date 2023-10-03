package br.com.api.projeto.DAO;

import java.util.List;

public interface IAvaliacao<A, Id>{
	
	
	A pesquisaId(Id id);
	List<A> listar();
	void insert(A a);
	void delete(A a);
	

}

