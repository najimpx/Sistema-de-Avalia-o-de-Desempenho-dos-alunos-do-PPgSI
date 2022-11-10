package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Coordenador_Programa;

@Repository
public interface RepositorioCoordenador_Programa extends JpaRepository<Coordenador_Programa, Long> {

}
