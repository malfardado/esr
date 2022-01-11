package br.com.lctt.lcttfood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lctt.lcttfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	/*
	 * @GetMapping("/cozinhas/por-nome") public List<Cozinha>
	 * cozinhasPorNome(@RequestParam("nome") String nome) { return
	 * cozinhaRepository.consultarPorNome(nome);
	 * 
	 * }
	 */ 

}
