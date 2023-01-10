package com.tiagodeveloper.dtos;

import java.util.ArrayList;
import java.util.List;

import com.tiagodeveloper.domains.Pessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstruturaSocietaria {

	private Integer id;
	
	private Pessoa pessoa;

	@Builder.Default
	private List<Pessoa> socios = new ArrayList<>();

}
