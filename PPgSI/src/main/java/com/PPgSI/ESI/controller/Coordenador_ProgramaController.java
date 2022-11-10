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
import com.PPgSI.ESI.model.Coordenador_Programa;
import com.PPgSI.ESI.repository.RepositorioCoordenador_Programa;

@RestController
@RequestMapping("/api/coordenador")
public class Coordenador_ProgramaController {

	  @Autowired
	    private RepositorioCoordenador_Programa repositorioCoordenador_Programa;

	    /**
	     * <p>Retorna uma lista com todas as listas de plantas cadastradas no banco de dados.</p>
	     * Path: api/coordenador/listar
	     *
	     * @return JSON com todas as listas cadastradas no banco de dados.
	     */
	    @GetMapping("/listar")
	    public List<Coordenador_Programa> getAllCoordenador_Programa() {
	        return repositorioCoordenador_Programa.findAll();
	    }


	    /**
	     * <p>Cadastra um novo aluno no banco de dados. Seus dados (JSON) sao passados no
	     * body da requisicao.</p>
	     * Path: api/coordenador/add
	     *
	     * @param coordenador Dados JSON da nova planta que sera cadastrada.
	     */
	    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Coordenador_Programa> addCoordenador_Programa(@RequestBody Coordenador_Programa coordenador_Programa) {
	    	repositorioCoordenador_Programa.save(coordenador_Programa);

	        return ResponseEntity.ok(coordenador_Programa);
	    }


	    
	    
	    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Coordenador_Programa> updateCoordenador_Programa(@PathVariable long id, @RequestBody Coordenador_Programa dadosCoordenador_Programa) throws ResourceNotFoundException {
	    	Coordenador_Programa coordenador_ProgramaAlterado = repositorioCoordenador_Programa.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("coordenador com id '" + id + "' nao foi encontrado"));

	    	coordenador_ProgramaAlterado.setnUSP(dadosCoordenador_Programa.getnUSP());
	    	coordenador_ProgramaAlterado.setEmailUSP(dadosCoordenador_Programa.getEmailUSP());
	    	coordenador_ProgramaAlterado.setNome(dadosCoordenador_Programa.getNome());
	    	repositorioCoordenador_Programa.save(dadosCoordenador_Programa);

	        return ResponseEntity.ok(dadosCoordenador_Programa);
	    }
	    
	    /**
	     * Remove um coordenador cadastrado no banco de dados.
	     * Path: api/coordenador/remover/{id}
	     *
	     * @param id ID da lista que deve ser removida.
	     */
	    @DeleteMapping("/remover/{id}")
	    public ResponseEntity<Long> deleteCoordenador_ProgramaById(@PathVariable Long id) {
	    	repositorioCoordenador_Programa.deleteById(id);

	        return ResponseEntity.ok(id);
	    }
}
