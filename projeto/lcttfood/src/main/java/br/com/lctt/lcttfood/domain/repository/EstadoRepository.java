package br.com.lctt.lcttfood.domain.repository;

import java.util.List;

import br.com.lctt.lcttfood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);
}
