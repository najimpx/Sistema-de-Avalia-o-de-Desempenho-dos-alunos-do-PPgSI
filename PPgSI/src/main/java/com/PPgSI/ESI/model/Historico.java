package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(HistoricoId.class)
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_historico;
	@Column
	private int qAnalises;
	
    @Id
    private Long id_orientador;

    @Id
    private Long id_aluno;
    
    public Historico() {
    }
    
    
    public Long getId_historico() {
        return id_historico;
    }
    public int getqAnalises() {
        return qAnalises;
    }
    public Long getId_aluno() {
        return id_aluno;
    }
    public Long getId_orientador() {
        return id_orientador;
    }
    public void setId_historico(Long id_historico) {
        this.id_historico = id_historico;
    }
    public void setqAnalises(int qAnalises) {
        this.qAnalises = qAnalises;
    }
    public void setId_aluno(Long id_aluno) {
        this.id_aluno =id_aluno;
    }
    public void setId_orientador(Long id_orientador) {
        this.id_orientador = id_orientador;
    }
}
