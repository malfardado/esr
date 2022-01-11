package br.com.lctt.lcttfood.domain.repository;

import java.util.List;

import br.com.lctt.lcttfood.domain.model.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Long id);
}
