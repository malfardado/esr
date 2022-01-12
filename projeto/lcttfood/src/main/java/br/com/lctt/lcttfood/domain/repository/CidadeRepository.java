package br.com.lctt.lcttfood.domain.repository;

import java.util.List;

import br.com.lctt.lcttfood.domain.model.Cidade;
import br.com.lctt.lcttfood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
