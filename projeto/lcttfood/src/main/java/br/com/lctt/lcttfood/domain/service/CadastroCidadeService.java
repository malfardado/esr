package br.com.lctt.lcttfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.lctt.lcttfood.domain.exception.EntidadeEmUsoException;
import br.com.lctt.lcttfood.domain.exception.EntidadeNaoEncontratadaException;
import br.com.lctt.lcttfood.domain.model.Estado;
import br.com.lctt.lcttfood.domain.model.Cidade;
import br.com.lctt.lcttfood.domain.repository.EstadoRepository;
import br.com.lctt.lcttfood.domain.repository.CidadeRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar (Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId).get();
		
		if (estado == null) {
			throw new EntidadeNaoEncontratadaException(
					String.format("Não existe cadastro de estado com o código %d", estadoId));
		}
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			Cidade cidadeApagar = cidadeRepository.findById(cidadeId).get();
			cidadeRepository.delete(cidadeApagar);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontratadaException(
					String.format("Não existe um cadastro de cidade com código %d", cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removido pois está em uso", cidadeId));
		}
	}

}
