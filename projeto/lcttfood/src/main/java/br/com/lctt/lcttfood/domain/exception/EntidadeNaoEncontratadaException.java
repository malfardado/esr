package br.com.lctt.lcttfood.domain.exception;

public class EntidadeNaoEncontratadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontratadaException(String mensagem) {
		super(mensagem);
	}

}
