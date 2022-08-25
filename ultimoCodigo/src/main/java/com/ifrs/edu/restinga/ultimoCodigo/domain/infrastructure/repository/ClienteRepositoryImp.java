package com.ifrs.edu.restinga.ultimoCodigo.domain.infrastructure.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Cliente;
import com.ifrs.edu.restinga.ultimoCodigo.domain.repository.ClienteRepository;

@Component
public class ClienteRepositoryImp implements ClienteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}
	
	@Override
	public Cliente buscar(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	@Transactional
	@Override
	public Cliente salvar(Cliente cliente) {
		return manager.merge(cliente);
	}
	
	@Transactional
	@Override
	public void remover(Cliente cliente) {
		cliente = buscar(cliente.getId());
		manager.remove(cliente);
	}

}