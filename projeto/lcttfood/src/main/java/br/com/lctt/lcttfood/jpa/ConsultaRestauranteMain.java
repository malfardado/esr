package br.com.lctt.lcttfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.lctt.lcttfood.AlgafoodApiApplication;
import br.com.lctt.lcttfood.domain.model.Restaurante;
import br.com.lctt.lcttfood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> restaurantes = restauranteRepository.listar();
		
		for (Restaurante restaurante :  restaurantes) {
			System.out.printf("%s - %f - %s\n",  restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}
		
	}
	

}
