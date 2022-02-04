package br.com.lctt.lcttfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public class EntidadeNaoEncontratadaException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontratadaException(HttpStatus status, String mensagem) {
		super(status, mensagem);
	}

	public EntidadeNaoEncontratadaException(String mensagem) {
		this(HttpStatus.NOT_FOUND, mensagem);
	}

}
