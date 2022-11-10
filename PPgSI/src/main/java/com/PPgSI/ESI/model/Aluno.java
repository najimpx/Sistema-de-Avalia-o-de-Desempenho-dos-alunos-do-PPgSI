package com.PPgSI.ESI.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id_aluno;
    @Column
    private Long nUSP ;
    @Column
    private String emailUSP;
    @Column
    private String nome;
    @Column
    private String link_curriculo_lattes;
    @Column
    private String tipo_de_curso;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date data_entrada;
    @Column
    private String resultado_avaliacao_recente;
    @Column
    private String prazo_maximo_inscricao_programa_qualificacao;
    @Column
    private String prazo_maximo_dissertacao;
    
    public Aluno() {
    }
    
    public Long getId() {
        return id_aluno ;
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
    
    public String getLink_curriculo_lattes() {
        return link_curriculo_lattes;
    }
    public String getTipo_de_curso() {
        return tipo_de_curso;
    }
    public Date getData_entrada() {
        return data_entrada;
    }
    public String getResultado_avaliacao_recente() {
        return resultado_avaliacao_recente;
    }
    public String getPrazo_maximo_inscricao_programa_qualificacao() {
        return prazo_maximo_inscricao_programa_qualificacao;
    }
    public String getPrazo_maximo_dissertacao() {
        return prazo_maximo_dissertacao;
    }
    
    public void setId(Long id_aluno) {
        this.id_aluno = id_aluno ;
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
    
    public void setLink_curriculo_lattes(String link_curriculo_lattes) {
        this.link_curriculo_lattes = link_curriculo_lattes;
    }
    public void setTipo_de_curso(String tipo_de_curso) {
        this.tipo_de_curso = tipo_de_curso;
    }
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }
    public void setResultado_avaliacao_recente(String resultado_avaliacao_recente) {
        this.resultado_avaliacao_recente = resultado_avaliacao_recente;
    }
    public void setPrazo_maximo_inscricao_programa_qualificacao(String prazo_maximo_inscricao_programa_qualificacao) {
        this.prazo_maximo_inscricao_programa_qualificacao = prazo_maximo_inscricao_programa_qualificacao;
    }
    public void setPrazo_maximo_dissertacao(String prazo_maximo_dissertacao) {
        this.prazo_maximo_dissertacao = prazo_maximo_dissertacao;
    }
}
