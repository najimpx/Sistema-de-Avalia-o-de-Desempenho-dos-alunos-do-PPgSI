package com.PPgSI.ESI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PPgSI.ESI.exception.ResourceNotFoundException;
import com.PPgSI.ESI.model.UsuarioId;
import com.PPgSI.ESI.model.Relatorio;
import com.PPgSI.ESI.model.Usuario;
import com.PPgSI.ESI.repository.RepositorioUsuario;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
    @GetMapping("/listar")
    public List<Usuario> getAllUsuario() {
        return repositorioUsuario.findAll();
    }
    @GetMapping("/")
    public ResponseEntity<Usuario> getUsuarioByid(@RequestBody UsuarioId usuarioId) throws ResourceNotFoundException {
    	Usuario dadosUsuario = repositorioUsuario.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Lista de usuarios com id '" + usuarioId + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosUsuario);
    }
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
    	repositorioUsuario.save(usuario);

        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Usuario> deleteUsuarioById(@RequestBody Usuario usuario) {
    	repositorioUsuario.delete(usuario);

        return ResponseEntity.ok(usuario);
    }
}
