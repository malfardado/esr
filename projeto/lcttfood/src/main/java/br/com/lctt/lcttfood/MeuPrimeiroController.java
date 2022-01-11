package br.com.lctt.lcttfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lctt.lcttfood.di.modelo.Cliente;
import br.com.lctt.lcttfood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {
	
	@Autowired
	AtivacaoClienteService ativacaoClienteService;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente cli = new Cliente("Lucas", "lucas@eu.com", "37 99917-7080", true);
		ativacaoClienteService.ativar(cli);
		return "Olá Mundo";
	}

}
