package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Historico;
import com.PPgSI.ESI.model.HistoricoId;

@Repository
public interface RepositorioHistorico extends JpaRepository<Historico, HistoricoId>{

}
