package com.tiagodeveloper.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagodeveloper.domains.Pessoa;
import com.tiagodeveloper.domains.Socio;

public interface SocioRepository extends JpaRepository<Socio, Pessoa> {

}
