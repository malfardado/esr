package br.com.lctt.lcttfood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.lctt.lcttfood.AlgafoodApiApplication;
import br.com.lctt.lcttfood.domain.model.Estado;
import br.com.lctt.lcttfood.domain.repository.EstadoRepository;

public class BuscaEstadoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado = estadoRepository.buscar(1L);
		
		
		System.out.println(estado.getNome());
		
		
	}
	

}
