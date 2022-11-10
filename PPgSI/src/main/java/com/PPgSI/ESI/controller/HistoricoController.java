package com.PPgSI.ESI.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PPgSI.ESI.exception.ResourceNotFoundException;
import com.PPgSI.ESI.model.Aluno;
import com.PPgSI.ESI.model.Historico;
import com.PPgSI.ESI.model.HistoricoId;
import com.PPgSI.ESI.repository.RepositorioHistorico;

@RestController
@RequestMapping("/api/Historico")
public class HistoricoController {
	
    private RepositorioHistorico repositorioHistorico;

    @GetMapping("/listar")
    public List<Historico> getAllHistorico() {
        return repositorioHistorico.findAll();
    }
    
    @GetMapping("/")
    public ResponseEntity<Historico> getHistoricoByid(@RequestBody HistoricoId historicoId) throws ResourceNotFoundException {
    	Historico dadosHistorico = repositorioHistorico.findById(historicoId)
                .orElseThrow(() -> new ResourceNotFoundException("Lista de historicos com id '" + historicoId + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosHistorico);
    }
    
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Historico> addHistorico(@RequestBody Historico historico) {
        repositorioHistorico.save(historico);

        return ResponseEntity.ok(historico);
    }
    
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Historico> deleteHistoricoById(@RequestBody Historico historico) {
        repositorioHistorico.delete(historico);

        return ResponseEntity.ok(historico);
    }
}
