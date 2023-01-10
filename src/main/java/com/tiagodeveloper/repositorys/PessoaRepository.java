package com.tiagodeveloper.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.tiagodeveloper.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	@Override
	@EntityGraph(
		type = EntityGraphType.FETCH,
		attributePaths = {
			"socios",
		}
	)
	public List<Pessoa> findAll();
	
	@EntityGraph(
		type = EntityGraphType.FETCH,
		attributePaths = {
			"socios",
		}
	)
	public Optional<Pessoa> findByDocumento(String documento);

}
