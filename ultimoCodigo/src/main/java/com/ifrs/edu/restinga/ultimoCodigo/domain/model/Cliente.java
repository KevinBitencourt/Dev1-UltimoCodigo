package com.ifrs.edu.restinga.ultimoCodigo.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
		
	@ManyToOne
	//@JoinColumn(name = "produto_codigo")
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@ManyToMany
    @JoinTable(name = "cliente_venda",joinColumns = @JoinColumn(name = "cliente_id"),inverseJoinColumns = @JoinColumn(name = "venda_id"))
    private List<Venda> venda = new ArrayList();
	
	// @ManyToMany
	// @JoinTable(name = "restaurante_forma_pagamento",
	// joinColumns = @JoinColumn(name = "restaurante_id"),
	// inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	// private List<FormaPagamento> formasPagamento = new ArrayList();
}