package br.com.lctt.lcttfood.api.controller;

import br.com.lctt.lcttfood.domain.model.Produto;
import br.com.lctt.lcttfood.domain.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtosRepository.findAll();
    }
}
