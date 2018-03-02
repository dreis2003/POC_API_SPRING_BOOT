package com.poc.pessoaapi.repository.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pessoaDAO")
public interface PessoaDAO extends JpaRepository<Pessoa, Integer> {
	
	Optional<Pessoa> findByNome(String nome);

}
