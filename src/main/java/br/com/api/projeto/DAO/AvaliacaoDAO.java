package br.com.api.projeto.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.api.projeto.model.Avaliacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AvaliacaoDAO implements IAvaliacao<Avaliacao, Integer>{
		
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Avaliacao pesquisaId(Integer id) {
		return em.find(Avaliacao.class, id);
	}
	
	@Override
	public List<Avaliacao> listar(){
		Query query = em.createQuery("select a from Avaliacao a");
		return (List<Avaliacao>) query.getResultList();
	}
	
	@Override
	public void insert(Avaliacao avaliacao) {
		em.persist(avaliacao);
	}
	
	
	@Override
	public void delete(Avaliacao avaliacao) {
		em.remove(avaliacao);
	}
}
