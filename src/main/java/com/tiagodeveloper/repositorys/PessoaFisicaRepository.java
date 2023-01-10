package com.tiagodeveloper.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagodeveloper.domains.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {

}
