package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Orientador;

@Repository
public interface RepositorioOrientador extends JpaRepository<Orientador, Long>{

}
