package com.PPgSI.ESI.controller;

import com.PPgSI.ESI.exception.ResourceNotFoundException;
import com.PPgSI.ESI.repository.RepositorioAluno;
import com.PPgSI.ESI.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private RepositorioAluno repositorioAluno;

    /**
     * <p>Retorna uma lista com todas as listas de plantas cadastradas no banco de dados.</p>
     * Path: api/listafavoritos/listar
     *
     * @return JSON com todas as listas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<Aluno> getAllListaFavoritos() {
        return repositorioAluno.findAll();
    }


    /**
     * <p>Cadastra uma nova planta no banco de dados. Seus dados (JSON) sao passados no
     * body da requisicao.</p>
     * Path: api/planta/add
     *
     * @param planta Dados JSON da nova planta que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno) {
        repositorioAluno.save(aluno);

        return ResponseEntity.ok(aluno);
    }


    /**
     * Remove uma lista cadastrada no banco de dados.
     * Path: api/listafavoritos/remover/{id}
     *
     * @param id ID da lista que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deleteListById(@PathVariable Long id) {
    	repositorioAluno.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
