package br.com.api.projeto.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.api.projeto.model.Noticias;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class NoticiasDAO implements INoticias<Noticias, Integer>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Noticias pesquisaID(Integer id) {
		return entityManager.find(Noticias.class, id);
	}
	
	@Override
	public List<Noticias> lista(){
		Query query = entityManager.createQuery("Select n from Noticias n");
		return (List<Noticias>) query.getResultList();
	}
	
	
	@Override
	public void insert(Noticias noticia) {
		entityManager.persist(noticia);
	}
	@Override
	public void remove(Noticias noticias) {
		entityManager.remove(noticias);
	}
	
	@Override
	public void update(Noticias noticias) {
		entityManager.merge(noticias);
	}
	
	@Override 
	public List<Noticias> pesquisarNoticias(String pesquisa){
		String query = "SELECT n FROM Noticias n WHERE n.titulo LIKE :pesquisa";
        return entityManager.createQuery(query, Noticias.class)
                .setParameter("pesquisa", "%" + pesquisa + "%")
                .getResultList();
	}
	
	
	
	
	
	
}
