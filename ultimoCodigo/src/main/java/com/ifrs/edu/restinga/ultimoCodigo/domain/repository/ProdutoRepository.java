package com.ifrs.edu.restinga.ultimoCodigo.domain.repository;
import java.util.List;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;
public interface ProdutoRepository {

    List<Produto> listar();
	Produto buscar(Long id);
	Produto salvar(Produto produto);
	void remover(Produto produto);
}
