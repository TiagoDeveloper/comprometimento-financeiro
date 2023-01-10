package com.tiagodeveloper.validators;

import com.tiagodeveloper.exceptions.BadRequestException;
import com.tiagodeveloper.utils.CnpjUtil;
import com.tiagodeveloper.utils.CpfUtil;

public class CommonValidator {
	
	public static void cpfValidator(String cpf) {
		if(!isCpfValido(cpf)) {
			throw new BadRequestException("Cpf inválido!!!");
		}
		
	}
	
	public static void cnpjValidator(String cnpj) {
		if(!isCnpjValido(cnpj)) {
			throw new BadRequestException("Cnpj inválido!!!");
		}
	}
	
	private static boolean isCpfValido(String cpf) {
		return CpfUtil.isValid(cpf);
	}

	private static boolean isCnpjValido(String cnpj) {
		return CnpjUtil.isValid(cnpj);
	}

}
