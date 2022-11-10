package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Papel;

@Repository
public interface RepositorioPapel extends JpaRepository<Papel, Long>{

}
