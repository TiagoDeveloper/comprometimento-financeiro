package com.tiagodeveloper.converters;

import java.math.BigDecimal;

import jakarta.persistence.AttributeConverter;

public class RendaComprometidaConverter implements AttributeConverter<BigDecimal, String>{

	@Override
	public BigDecimal convertToEntityAttribute(String attribute) {
		return new BigDecimal(attribute);
	}

	@Override
	public String convertToDatabaseColumn(BigDecimal dbData) {
		return dbData.toString();
	}

}
