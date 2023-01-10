package com.tiagodeveloper.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagodeveloper.services.PessoaService;
import com.tiagodeveloper.validators.CommonValidator;


@RestController
public class EstruturaSocietariaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/calcular/{id}")
	public ResponseEntity<BigDecimal> calcularComprometimentoById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(
			pessoaService.calcularComprometimentoById(id), 
			HttpStatus.OK
		);
	}
	
	@PostMapping("/calcular/{cpf}/cpf")
	public ResponseEntity<BigDecimal> calcularComprometimentoByCpf(@PathVariable("cpf") String cpf){
		CommonValidator.cpfValidator(cpf);
		
		return new ResponseEntity<>(
			pessoaService.calcularComprometimentoByCpf(cpf),
			HttpStatus.OK
		);
	}
	
	@PostMapping("/calcular/{cnpj}/cnpj")
	public ResponseEntity<BigDecimal> calcularComprometimentoByCnpj(@PathVariable("cnpj") String cnpj){
		CommonValidator.cnpjValidator(cnpj);
		return new ResponseEntity<>(
			pessoaService.calcularComprometimentoByCnpj(cnpj),
			HttpStatus.OK
		);
	}
}
