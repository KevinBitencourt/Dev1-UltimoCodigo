package com.ifrs.edu.restinga.ultimoCodigo.domain.repository;
import java.util.List;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Cliente;

public interface ClienteRepository {
    List<Cliente> listar();
	Cliente buscar(Long id);
	Cliente salvar(Cliente cliente);
	void remover(Cliente cliente);
}
