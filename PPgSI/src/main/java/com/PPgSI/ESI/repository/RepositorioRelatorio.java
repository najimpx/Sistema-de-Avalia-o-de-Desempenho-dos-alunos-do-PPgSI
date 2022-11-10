package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Relatorio;
import com.PPgSI.ESI.model.RelatorioId;

@Repository
public interface RepositorioRelatorio extends JpaRepository<Relatorio,RelatorioId>{

}
