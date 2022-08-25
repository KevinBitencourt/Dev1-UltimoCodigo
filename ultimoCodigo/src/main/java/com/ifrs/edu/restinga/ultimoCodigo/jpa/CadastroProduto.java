package com.ifrs.edu.restinga.ultimoCodigo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;

@Component
public class CadastroProduto {
	
	@PersistenceContext
	private EntityManager manager;

	/*public List<Produto> listar() {
		//select nome from produto
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}*/
	
	public List<Produto> listar() {
		return manager.createQuery("from Produto", Produto.class)
				.getResultList();
	}
	
	@Transactional
	public Produto adicionar(Produto produto) {
		//insert into
		//retorna instancia persistida 
		return manager.merge(produto);	
	}
	
	public Produto buscar(Long id) {
		return manager.find(Produto.class, id);
	}
}
