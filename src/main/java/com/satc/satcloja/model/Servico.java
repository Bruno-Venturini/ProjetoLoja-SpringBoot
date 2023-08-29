package com.satc.satcloja.model;

import com.satc.satcloja.model.abstracts.ItemVendavel;

public class Servico extends ItemVendavel {
    private Double quantidadeHoras;

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
