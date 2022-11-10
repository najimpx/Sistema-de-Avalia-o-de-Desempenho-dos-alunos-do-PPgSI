package com.PPgSI.ESI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(RelatorioId.class)
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_relatorio;
	
    @Id
    private Long id_orientador;

    @Id
    private Long id_aluno;
    
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data;
    
	@Column
	private int semestre;
	
	@Column
	private int ano;
	
	@Column
	private String avaliacao;
	
	@Column
	private String comentario_orientador;
	
    public Relatorio() {
    }
    
    public Long getId_relatorio() {
        return id_relatorio;
    }
    public Long getId_aluno() {
        return id_aluno;
    }
    public Long getId_orientador() {
        return id_orientador;
    }
    public Date getdata() {
        return data;
    }
    public int getsemestre() {
        return semestre;
    }
    public int getano() {
        return ano;
    }
    public String getavaliacao() {
        return avaliacao;
    }
    public String getcomentario_orientador() {
        return comentario_orientador;
    }
    public void setId_relatorio(Long id_relatorio) {
        this.id_relatorio = id_relatorio;
    }
    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }
    public void setId_orientador(Long id_orientador) {
        this.id_orientador = id_orientador;
    }
    public void setdata(Date data) {
        this.data = data;
    }
    public void setsemestre(int semestre) {
        this.semestre = semestre;
    }
    public void setano(int ano) {
        this.ano = ano;
    }
    public void setavaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setcomentario_orientador(String comentario_orientador) {
        this.comentario_orientador = comentario_orientador;
    }
}
