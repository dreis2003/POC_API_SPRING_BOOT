package com.poc.pessoaapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poc.pessoaapi.repository.model.Pessoa;
import com.poc.pessoaapi.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping(value="/{id}")
	public Pessoa buscarPessoa(@PathVariable Integer id) {
		Optional<Pessoa> result = service.buscaPorId(id);
		return result.isPresent() ? result.get() : null;
	}
	
	@GetMapping
	public List<Pessoa> listarTodasPessoas() {
		return service.buscarTodos();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Pessoa> add(@RequestBody Pessoa pessoa) {
		
		pessoa = service.salvarPessoa(pessoa);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(pessoa.getId())
				.toUri();
	
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Pessoa pessoa) {
		service.salvarPessoa(pessoa);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void apagar(@PathVariable Integer id) {
		service.removerPessoa(id);
	}

}
