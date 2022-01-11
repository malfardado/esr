package br.com.lctt.lcttfood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.lctt.lcttfood.di.service.ClienteAtivadoEvent;

@Component
public class EmiessaoNotaFiscalService {
	
	@EventListener
	public void clientAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}

}
