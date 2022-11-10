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
     * <p>Retorna uma lista com todas as listas de alunos cadastrados no banco de dados.</p>
     * Path: api/aluno/listar
     *
     * @return JSON com todas as listas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<Aluno> getAllAluno() {
        return repositorioAluno.findAll();
    }


    /**
     * <p>Cadastra um novo aluno no banco de dados. Seus dados (JSON) sao passados no
     * body da requisicao.</p>
     * Path: api/aluno/add
     *
     * @param alunos Dados JSON do novo aluno que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno) {
        repositorioAluno.save(aluno);

        return ResponseEntity.ok(aluno);
    }


    
    
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> updateAluno(@PathVariable long id, @RequestBody Aluno dadosAluno) throws ResourceNotFoundException {
    	Aluno alunoAlterado = repositorioAluno.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));

    	alunoAlterado.setnUSP(dadosAluno.getnUSP());
    	alunoAlterado.setEmailUSP(dadosAluno.getEmailUSP());
    	alunoAlterado.setNome(dadosAluno.getNome());
    	alunoAlterado.setLink_curriculo_lattes(dadosAluno.getLink_curriculo_lattes());
    	alunoAlterado.setTipo_de_curso(dadosAluno.getTipo_de_curso());
    	alunoAlterado.setData_entrada(dadosAluno.getData_entrada());
    	alunoAlterado.setResultado_avaliacao_recente(dadosAluno.getResultado_avaliacao_recente());
        alunoAlterado.setPrazo_maximo_inscricao_programa_qualificacao(dadosAluno.getPrazo_maximo_inscricao_programa_qualificacao());
        alunoAlterado.setPrazo_maximo_dissertacao(dadosAluno.getPrazo_maximo_dissertacao());

        repositorioAluno.save(alunoAlterado);

        return ResponseEntity.ok(alunoAlterado);
    }
    
    /**
     * Remove um aluno cadastrado no banco de dados.
     * Path: api/aluno/remover/{id}
     *
     * @param id ID da lista que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deleteAlunoById(@PathVariable Long id) {
    	repositorioAluno.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
