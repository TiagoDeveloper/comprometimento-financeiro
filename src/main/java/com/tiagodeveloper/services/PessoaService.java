package com.tiagodeveloper.services;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagodeveloper.domains.Pessoa;
import com.tiagodeveloper.domains.Socio;
import com.tiagodeveloper.dtos.EstruturaSocietaria;
import com.tiagodeveloper.exceptions.NotFoundException;
import com.tiagodeveloper.repositorys.PessoaRepository;

@Service
@Transactional(readOnly = true)
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public BigDecimal calcularComprometimentoById(Integer id) {
		
		var pessoa = pessoaRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
		var estruturaSocietaria = buildEstruturaSocietaria(pessoa);
		return comprometimentoFinanceiro(estruturaSocietaria);
	}
	
	public BigDecimal calcularComprometimentoByCpf(String cpf) {
		
		var pessoa = pessoaRepository.findByDocumento(cpf)
				.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
		var estruturaSocietaria = buildEstruturaSocietaria(pessoa);
		return comprometimentoFinanceiro(estruturaSocietaria);
	}
	
	public BigDecimal calcularComprometimentoByCnpj(String cnpj) {
		
		var pessoa = pessoaRepository.findByDocumento(cnpj)
				.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
		var estruturaSocietaria = buildEstruturaSocietaria(pessoa);
		return comprometimentoFinanceiro(estruturaSocietaria);
	}
	
	private EstruturaSocietaria buildEstruturaSocietaria(Pessoa pessoa) {
		var pessoas = pessoa.getSocios().stream()
			.map(Socio::getPessoa)
		.collect(Collectors.toList());
		return EstruturaSocietaria.builder()
				.pessoa(pessoa)
				.socios(pessoas)
			.build();	
	}
	
	public BigDecimal comprometimentoFinanceiro(EstruturaSocietaria estruturaSocietaria) {
		
		Set<Pessoa> pessoas = new HashSet<>();
			pessoas.add(estruturaSocietaria.getPessoa());
			pessoas.addAll(estruturaSocietaria.getSocios());
			
		return pessoas.stream()
					.map(Pessoa::getRendaComprometida)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
