package com.ifrs.edu.restinga.ultimoCodigo.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;

public class ConsultaProdutoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaManyToOneApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//application context gerencia os beans
		CadastroProduto cadastroProduto = applicationContext.getBean(CadastroProduto.class);

		List<Produto> produtos = cadastroProduto.listar();
		
		for (Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
	}
}
