package com.ifrs.edu.restinga.ultimoCodigo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Produto;
import com.ifrs.edu.restinga.ultimoCodigo.domain.repository.ProdutoRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

//GET /cozinhas HTTP/1.1
//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/produtos")

//7 indica que a resposta dos metodos desse controler, ir para o corpo 
//@ResponseBody

public class ProdutoController {
	
	//2 definir variavel de instancia
	//3 injetar
	@Autowired
	private ProdutoRepository produtoRepository;

	
	//6 mapear metodo para responder a requisicao 
	@GetMapping("/produto/lista")
	//1 definir metodo
	public List<Produto> listar(){
		return produtoRepository.listar();	
	}
	
	
	@GetMapping("/produto/busca/{produtoId}")
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {
		//return cozinhaRepository.buscar(cozinhaId);
		Produto produto = produtoRepository.buscar(produtoId);
		
		if (produto != null) {
			return ResponseEntity.ok(produto);
		}
		
		return ResponseEntity.notFound().build();             
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar (@RequestBody Produto produto) {
		return produtoRepository.salvar(produto);
	}
	
	@PutMapping("/produto/atualiza/{produtoId}")
	public ResponseEntity<Produto> atualizar (@PathVariable Long produtoId, 
											@RequestBody Produto produto) {
		
		Produto produtoAtual = produtoRepository.buscar(produtoId);
		
		if (produtoAtual != null) {
			//cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(produto, produtoAtual, "id");
			produtoRepository.salvar(produtoAtual);
			return ResponseEntity.ok(produtoAtual);
		}
		return ResponseEntity.notFound().build();            
	}
	
	@DeleteMapping("/produto/delete/{produtoId}")
	public ResponseEntity<Produto> remover(@PathVariable Long produtoId){
		try {
			Produto produto = produtoRepository.buscar(produtoId);
			
			if (produto != null) {
				produtoRepository.remover(produto);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build(); 
		}catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
		        
	}
	
}
