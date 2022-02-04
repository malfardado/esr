package br.com.lctt.lcttfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public class EntidadeNaoEncontratadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontratadaException(String mensagem) {
		super(mensagem);
	}

}
