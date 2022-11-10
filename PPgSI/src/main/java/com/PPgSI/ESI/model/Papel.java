package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Papel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_role;
	
	@Column
	private String tipo;
	
    public Long getId_role() {
        return id_role;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
