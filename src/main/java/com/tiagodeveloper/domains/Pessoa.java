package com.tiagodeveloper.domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tiagodeveloper.converters.RendaComprometidaConverter;
import com.tiagodeveloper.enums.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name="tipo_documento")
@Table(name="pessoa")
@EqualsAndHashCode(of = "id")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String documento;
	
	@Convert(converter = RendaComprometidaConverter.class)
	private BigDecimal rendaComprometida;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_documento", insertable = false, updatable = false)
	private TipoDocumento tipoDocumento;
	
	@ManyToMany
	@JoinTable(
		name = "pessoa_socio",
		joinColumns = { @JoinColumn(name="pessoa_id") },
		inverseJoinColumns = { @JoinColumn(name="socio_id") }
	)
	private List<Socio> socios = new ArrayList<Socio>();
}
