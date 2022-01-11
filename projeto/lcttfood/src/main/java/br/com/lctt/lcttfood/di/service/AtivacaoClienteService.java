package br.com.lctt.lcttfood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.lctt.lcttfood.di.modelo.Cliente;

@Component
public class AtivacaoClienteService  {
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	//@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	//@Autowired
	//private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		// notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

}
