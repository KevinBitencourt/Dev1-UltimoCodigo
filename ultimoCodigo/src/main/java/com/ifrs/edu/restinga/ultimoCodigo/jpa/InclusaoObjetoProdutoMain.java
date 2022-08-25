package com.ifrs.edu.restinga.ultimoCodigo.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;

public class InclusaoObjetoProdutoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaManyToOneApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CadastroProduto cadastroProduto = applicationContext.getBean(CadastroProduto.class);
		
		Produto produto1 = new Produto();
		produto1.setNome("Chip da Oi");
		
		Produto produto2 = new Produto();
		produto2.setNome("Relógio Paraguaio");
		
		Produto produto3 = new Produto();
		produto3.setNome("Capinha");
		
		cadastroProduto.adicionar(produto1);
		cadastroProduto.adicionar(produto2);
		cadastroProduto.adicionar(produto3);


	} 
}
