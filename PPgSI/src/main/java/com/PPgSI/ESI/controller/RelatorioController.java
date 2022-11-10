package com.PPgSI.ESI.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PPgSI.ESI.exception.ResourceNotFoundException;
import com.PPgSI.ESI.model.Relatorio;
import com.PPgSI.ESI.model.RelatorioId;
import com.PPgSI.ESI.repository.RepositorioRelatorio;

@RestController
@RequestMapping("/api/Relatorio")
public class RelatorioController {

	private RepositorioRelatorio repositorioRelatorio;
	

    @GetMapping("/listar")
    public List<Relatorio> getAllRelatorio() {
        return repositorioRelatorio.findAll();
    }
    
    @GetMapping("/")
    public ResponseEntity<Relatorio> getRelatorioByid(@RequestBody RelatorioId relatorioId) throws ResourceNotFoundException {
    	Relatorio dadosRelatorio = repositorioRelatorio.findById(relatorioId)
                .orElseThrow(() -> new ResourceNotFoundException("Lista de historicos com id '" + relatorioId + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosRelatorio);
    }
    
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Relatorio> addRelatorio(@RequestBody Relatorio relatorio) {
        repositorioRelatorio.save(relatorio);

        return ResponseEntity.ok(relatorio);
    }
    
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Relatorio> deleteRelatorioById(@RequestBody Relatorio relatorio) {
        repositorioRelatorio.delete(relatorio);

        return ResponseEntity.ok(relatorio);
    }
}
