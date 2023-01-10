package com.tiagodeveloper.domains;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@DiscriminatorValue("CPF")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;


}
