package com.PPgSI.ESI.model;

import java.io.Serializable;

public class RelatorioId implements Serializable{
    private Long id_orientador;

    private Long id_aluno;
    
    public RelatorioId(Long id_aluno, Long id_orientador) {
        this.id_aluno = id_aluno;
        this.id_orientador = id_orientador;
    }
    
    public RelatorioId(){
    }
}
