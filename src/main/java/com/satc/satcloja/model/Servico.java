package com.satc.satcloja.model;

import com.satc.satcloja.model.abstracts.ItemVendavel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "servico")
public class Servico extends ItemVendavel {

    @Column(name = "qtde_horas")
    private Double quantidadeHoras;

    public Servico() {
    }

    public Servico(String descricao, Double valorUnitario, Double quantidadeHoras) {
        super.setDescricao(descricao);
        super.setValorUnitario(valorUnitario);
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public Boolean getEstocavel() {
        return Boolean.FALSE;
    }

    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}
