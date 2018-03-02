package com.poc.pessoaapi.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.pessoaapi.PocPessoaApiApplicationTests;
import com.poc.pessoaapi.repository.model.Pessoa;

public class PessoaServiceTest extends PocPessoaApiApplicationTests{
	
	@Autowired
	private PessoaService service;
	
	private Pessoa pessoa;

	
	@Before
	public void init() {
		pessoa = new Pessoa();
		pessoa.setNome("Daniel");
		pessoa.setSobrenome("Reis");
	}
	@Test
	public void testSalvarPessoa() {
		Pessoa pessoaSalva = service.salvarPessoa(pessoa);
		assertEquals(pessoa.getNome(), pessoaSalva.getNome());
	}
	
	@After
	public void finish() {
		Optional<Pessoa> buscaPorNome = service.buscaPorNome("Daniel");
		if (buscaPorNome.isPresent() )
			service.removerPessoa(buscaPorNome.get().getId()) ;
	}

}
