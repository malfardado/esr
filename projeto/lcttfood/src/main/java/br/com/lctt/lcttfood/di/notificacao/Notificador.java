package br.com.lctt.lcttfood.di.notificacao;

import br.com.lctt.lcttfood.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}