package com.poc.pessoaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.pessoaapi.repository.model.Pessoa;
import com.poc.pessoaapi.repository.model.PessoaDAO;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaDAO pessoaDAO;

	@Override
	public Optional<Pessoa> buscaPorId(Integer id) {
		return pessoaDAO.findById(id);
	}

	@Override
	public Optional<Pessoa> buscaPorNome(String nome) {
		return pessoaDAO.findByNome(nome);
	}

	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaDAO.saveAndFlush(pessoa);
	}

	@Override
	public void removerPessoa(Integer id) {
		pessoaDAO.deleteById(id);
		
	}

	@Override
	public List<Pessoa> buscarTodos() {
		return pessoaDAO.findAll();
	}

}
