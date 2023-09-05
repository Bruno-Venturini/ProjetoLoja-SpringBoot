package com.satc.satcloja.model;


import com.satc.satcloja.model.abstracts.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa {
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "incricao_estadua", nullable = false)
    private String inscricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCnpj();
    }
}
