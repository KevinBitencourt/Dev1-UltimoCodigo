package com.ifrs.edu.restinga.ultimoCodigo.domain.infrastructure.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;
import com.ifrs.edu.restinga.ultimoCodigo.domain.repository.ProdutoRepository;

@Component
public class ProdutoRepositoryImp implements ProdutoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> listar() {
		return manager.createQuery("from Produto", Produto.class)
				.getResultList();
	}
	
	@Override
	public Produto buscar(Long id) {
		return manager.find(Produto.class, id);
	}
	
	@Transactional
	@Override
	public Produto salvar(Produto produto) {
		return manager.merge(produto);
	}
	
	@Transactional
	@Override
	public void remover(Produto produto) {
		produto = buscar(produto.getId());
		manager.remove(produto);
	}

}
