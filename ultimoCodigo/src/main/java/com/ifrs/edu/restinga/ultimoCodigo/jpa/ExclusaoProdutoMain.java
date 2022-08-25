package com.ifrs.edu.restinga.ultimoCodigo.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;
import com.ifrs.edu.restinga.ultimoCodigo.domain.repository.ProdutoRepository;



public class ExclusaoProdutoMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaManyToOneApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ProdutoRepository produtoRepository = applicationContext.getBean(ProdutoRepository.class);
		
		Produto produto = new Produto();
		produto.setId(1L);
		
		produtoRepository.remover(produto);
	}
	
}
	

