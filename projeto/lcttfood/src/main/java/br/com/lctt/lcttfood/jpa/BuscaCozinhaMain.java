package br.com.lctt.lcttfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.lctt.lcttfood.AlgafoodApiApplication;
import br.com.lctt.lcttfood.domain.model.Cozinha;
import br.com.lctt.lcttfood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = cozinhaRepository.findById(1L).get();
		
		
		System.out.println(cozinha.getNome());
		
		
	}
	

}
