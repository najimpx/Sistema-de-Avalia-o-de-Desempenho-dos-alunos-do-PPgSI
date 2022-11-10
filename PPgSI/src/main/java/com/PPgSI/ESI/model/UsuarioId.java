package com.PPgSI.ESI.model;

import java.io.Serializable;

public class UsuarioId implements Serializable{

	private Long id_role;
	
	public UsuarioId(Long id_role) {
		this.id_role = id_role;
	}
	
	public UsuarioId() {
	}
}
