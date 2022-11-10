package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UsuarioId.class)
public class Usuario {

	@Id
    @Column
    private Long nUSP ;
    @Column
    private String emailUSP;
    @Column
    private String nome;
    @Id
    private Long id_role;
    
    public Long getnUSP() {
        return nUSP;
    }
    public Long getId_role() {
        return id_role;
    }
    public String getEmailUSP() {
        return emailUSP;
    }
    public String getNome() {
        return nome;
    }
    public void setnUSP(Long nUSP) {
        this.nUSP = nUSP;
    }
    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }
    public void setEmailUSP(String emailUSP) {
        this.emailUSP = emailUSP;
    }
    public void setNome( String nome) {
        this.nome = nome;
    }
}
