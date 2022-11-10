package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordenador_Programa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_coordenador;
	@Id
	@Column
    private Long nUSP ;
    @Column
    private String emailUSP;
    @Column
    private String nome;
   
    public Coordenador_Programa() {
    }
    
    public Long getId() {
        return id_coordenador ;
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
    
    public void setId(Long id_coordenador) {
        this.id_coordenador = id_coordenador ;
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
