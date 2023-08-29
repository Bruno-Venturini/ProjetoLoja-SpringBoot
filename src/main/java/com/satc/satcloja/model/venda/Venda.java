package com.satc.satcloja.model.venda;

import com.satc.satcloja.enums.FormaPagamento;
import com.satc.satcloja.enums.TipoOperacao;
import com.satc.satcloja.interfaces.OperacaoFinanceira;
import com.satc.satcloja.model.Cliente;
import com.satc.satcloja.model.abstracts.EntityId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda extends EntityId implements OperacaoFinanceira {

    private List<ItemVenda> itens = new ArrayList<>();
    private LocalDate dataVenda;
    private FormaPagamento formaPagamento;
    private Cliente cliente;
    private String observacao;

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void addItemVenda(ItemVenda item) {
        this.itens.add(item);
    }

    public void delItemVenda(ItemVenda item) {
        this.itens.remove(item);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", formaPagamento=" + formaPagamento +
                ", observacao='" + observacao + '\'' +
                ", cliente=" + cliente +
                ", itens=" + itens +
                '}';
    }

    @Override
    public LocalDate getDataOperacao() {
        return this.getDataVenda();
    }

    @Override
    public Double getValorTotalOperacao() {
        return this.getItens().stream()
                .mapToDouble(ItemVenda::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.CREDITO;
    }
}
