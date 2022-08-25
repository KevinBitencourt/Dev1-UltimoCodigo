package com.ifrs.edu.restinga.ultimoCodigo.jpa;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrs.edu.restinga.ultimoCodigo.domain.model.Cliente;
import com.ifrs.edu.restinga.ultimoCodigo.domain.repository.ClienteRepository;
public class ConsultaClienteMain {
    
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaManyToOneApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ClienteRepository clienteRepository = applicationContext.getBean(ClienteRepository.class);
		
		List<Cliente> todosClientes = clienteRepository.listar();
		
		for (Cliente cliente : todosClientes) {
			System.out.printf("%s - %f - %s\n", cliente.getNome(),
					cliente.getProduto().getNome());
			}
	}
}
