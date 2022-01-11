package br.com.lctt.lcttfood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.lctt.lcttfood.di.notificacao.NivelUrgencia;
import br.com.lctt.lcttfood.di.notificacao.Notificador;
import br.com.lctt.lcttfood.di.notificacao.TipoDoNotificador;
import br.com.lctt.lcttfood.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clientAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}

}
  