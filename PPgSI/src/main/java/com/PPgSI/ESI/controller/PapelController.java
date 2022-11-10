package com.PPgSI.ESI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PPgSI.ESI.model.Papel;
import com.PPgSI.ESI.repository.RepositorioPapel;

@RestController
@RequestMapping("/api/papel")
public class PapelController {
	
    @Autowired
    private RepositorioPapel repositorioPapel;
	
    @GetMapping("/listar")
    public List<Papel> getAllPapel() {
        return repositorioPapel.findAll();
    }
    
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Papel> addAluno(@RequestBody Papel papel) {
        repositorioPapel.save(papel);

        return ResponseEntity.ok(papel);
    }
    
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePapelById(@PathVariable Long id) {
    	repositorioPapel.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
