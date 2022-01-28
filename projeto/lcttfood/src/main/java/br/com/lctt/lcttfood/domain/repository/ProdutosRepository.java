package br.com.lctt.lcttfood.domain.repository;

import br.com.lctt.lcttfood.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}
