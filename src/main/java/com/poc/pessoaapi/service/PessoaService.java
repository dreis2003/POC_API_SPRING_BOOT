package com.poc.pessoaapi.service;

import java.util.List;
import java.util.Optional;

import com.poc.pessoaapi.repository.model.Pessoa;

public interface PessoaService {
	
	Optional<Pessoa> buscaPorId(Integer id);
	
	Optional<Pessoa> buscaPorNome(String nome);
	
	Pessoa salvarPessoa(Pessoa pessoa);
	
	List<Pessoa> buscarTodos();
	
	void removerPessoa(Integer id);
	

}
