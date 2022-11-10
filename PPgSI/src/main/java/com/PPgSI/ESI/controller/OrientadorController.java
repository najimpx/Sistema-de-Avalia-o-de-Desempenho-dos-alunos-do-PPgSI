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
import com.PPgSI.ESI.model.Orientador;
import com.PPgSI.ESI.repository.RepositorioOrientador;

@RestController
@RequestMapping("/api/orientador")
public class OrientadorController {
	  @Autowired
	    private RepositorioOrientador repositorioOrientador;

	    /**
	     * <p>Retorna uma lista com todas as listas de orientadores cadastrados no banco de dados.</p>
	     * Path: api/orientador/listar
	     *
	     * @return JSON com todas as listas cadastradas no banco de dados.
	     */
	    @GetMapping("/listar")
	    public List<Orientador> getAllOrientador() {
	        return repositorioOrientador.findAll();
	    }


	    /**
	     * <p>Cadastra um novo orientador no banco de dados. Seus dados (JSON) sao passados no
	     * body da requisicao.</p>
	     * Path: api/orientador/add
	     *
	     * @param orientador Dados JSON do novo orientador que sera cadastrado.
	     */
	    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Orientador> addOrientador(@RequestBody Orientador orientador) {
	    	repositorioOrientador.save(orientador);

	        return ResponseEntity.ok(orientador);
	    }


	    
	    
	    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Orientador> updateOrientador(@PathVariable long id, @RequestBody Orientador dadosOrientador) throws ResourceNotFoundException {
	    	Orientador orientadorAlterado = repositorioOrientador.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Orientador com id '" + id + "' nao foi encontrado"));

	    	orientadorAlterado.setnUSP(dadosOrientador.getnUSP());
	    	orientadorAlterado.setEmailUSP(dadosOrientador.getEmailUSP());
	    	orientadorAlterado.setNome(dadosOrientador.getNome());
	    	repositorioOrientador.save(orientadorAlterado);

	        return ResponseEntity.ok(orientadorAlterado);
	    }
	    
	    /**
	     * Remove um orientador cadastrado no banco de dados.
	     * Path: api/orientador/remover/{id}
	     *
	     * @param id ID da lista que deve ser removida.
	     */
	    @DeleteMapping("/remover/{id}")
	    public ResponseEntity<Long> deleteOrientadorById(@PathVariable Long id) {
	    	repositorioOrientador.deleteById(id);

	        return ResponseEntity.ok(id);
	    }
}
