package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
@Entity
@Table(name = "orientador")
public class Orientador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_orientador;
	@Column
    private Long nUSP ;
    @Column
    private String emailUSP;
    @Column
    private String nome;
   
    public Orientador() {
    }
    
    public Long getId() {
        return id_orientador ;
    }
    
    public Long getnUSP() {
        return nUSP ;
    }

    public String getEmailUSP() {
        return emailUSP;
    }

    public String getNome() {
        return nome;
    }
    
    public void setId(Long id_orientador) {
        this.id_orientador = id_orientador ;
    }
    
    public void setnUSP(Long nUSP) {
        this.nUSP = nUSP ;
    }

    public void setEmailUSP(String emailUSP) {
    	this.emailUSP = emailUSP;
    }

    public void setNome(String nome) {
    	this.nome = nome;
    }

}
