package br.com.lctt.lcttfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lctt.lcttfood.domain.exception.EntidadeEmUsoException;
import br.com.lctt.lcttfood.domain.exception.EntidadeNaoEncontratadaException;
import br.com.lctt.lcttfood.domain.model.Estado;
import br.com.lctt.lcttfood.domain.repository.EstadoRepository;
import br.com.lctt.lcttfood.domain.service.CadastroEstadoService;


@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	//@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
		Estado estado = estadoRepository.findById(estadoId).get();
		
		if (estado != null) {
			return ResponseEntity.ok(estado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar (@RequestBody Estado estado) {
		return cadastroEstado.salvar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, 
			@RequestBody Estado estado) {
		Estado estadoAtual = estadoRepository.findById(estadoId).get();
		
		if (estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			
			estadoAtual = cadastroEstado.salvar(estadoAtual);
			return ResponseEntity.ok(estadoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<Estado> remover(@PathVariable Long estadoId) {
		try {
			cadastroEstado.excluir(estadoId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontratadaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
