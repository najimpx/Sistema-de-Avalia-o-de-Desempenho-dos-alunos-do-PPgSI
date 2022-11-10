package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Aluno;

@Repository
public interface RepositorioAluno extends JpaRepository<Aluno, Long>{

}
