package br.com.lctt.lcttfood.di.notificacao;

import org.springframework.stereotype.Component;

import br.com.lctt.lcttfood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {
	
	@Override
	public void notificar (Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS através do telefone %s:  %s:\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem);
		
	}

}
