package br.com.lctt.lcttfood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.lctt.lcttfood.AlgafoodApiApplication;
import br.com.lctt.lcttfood.domain.model.FormaPagamento;
import br.com.lctt.lcttfood.domain.repository.FormaPagamentoRepository;

public class BuscaFormaPagamentoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento = formaPagamentoRepository.buscar(1L);
		
		
		System.out.println(formaPagamento.getDescricao());
		
		
	}
	

}
