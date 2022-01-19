package br.com.lctt.lcttfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import br.com.lctt.lcttfood.domain.model.Cozinha;
import br.com.lctt.lcttfood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

}
