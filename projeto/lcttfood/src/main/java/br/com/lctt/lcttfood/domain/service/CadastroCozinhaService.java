package br.com.lctt.lcttfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lctt.lcttfood.domain.exception.EntidadeEmUsoException;
import br.com.lctt.lcttfood.domain.exception.EntidadeNaoEncontratadaException;
import br.com.lctt.lcttfood.domain.model.Cozinha;
import br.com.lctt.lcttfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	public static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com código %d";
	public static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser removido pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar (Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontratadaException(
					String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_COZINHA_EM_USO, cozinhaId));
		}
	}

	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontratadaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}

}
