package br.com.lctt.lcttfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lctt.lcttfood.domain.exception.EntidadeEmUsoException;
import br.com.lctt.lcttfood.domain.exception.EntidadeNaoEncontratadaException;
import br.com.lctt.lcttfood.domain.model.Estado;
import br.com.lctt.lcttfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar (Estado estado) {
		return estadoRepository.salvar(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.remover(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontratadaException(
					String.format("Não existe um cadastro de estado com código %d", estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removido pois está em uso", estadoId));
		}
	}

}
