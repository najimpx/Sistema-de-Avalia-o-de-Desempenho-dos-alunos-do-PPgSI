package com.PPgSI.ESI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PPgSI.ESI.model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
