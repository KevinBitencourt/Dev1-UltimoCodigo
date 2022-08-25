package com.ifrs.edu.restinga.ultimoCodigo.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;

public class BuscaProdutoMain {

	public static void main(String[] args) {
			
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaManyToOneApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
			
		//application context gerencia os beans
		CadastroProduto cadastroProduto = applicationContext.getBean(CadastroProduto.class);

		Produto produto = cadastroProduto.buscar(1L);
		System.out.println(produto.getNome());
		
		
	}

}

