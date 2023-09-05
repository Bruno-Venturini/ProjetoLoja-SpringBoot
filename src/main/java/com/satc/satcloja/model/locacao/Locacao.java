package com.satc.satcloja.model.locacao;

import com.satc.satcloja.enums.TipoOperacao;
import com.satc.satcloja.interfaces.OperacaoFinanceira;
import com.satc.satcloja.model.Cliente;
import com.satc.satcloja.model.abstracts.EntityId;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Locacao extends EntityId implements OperacaoFinanceira {

    @OneToMany(mappedBy = "locacao")
    private List<ItemLocacao> itens = new ArrayList<>();

    @Column(name = "dt_locacao")
    private LocalDate dataLocacao;

    @Column(name = "dt_devolucao")
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private String endereco;
    private String observacao;

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItemLocacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLocacao> itens) {
        this.itens = itens;
    }

    public void addItemLocacao(ItemLocacao item) {
        this.itens.add(item);
    }

    public void delItemLocacao(ItemLocacao item) {
        this.itens.remove(item);
    }

    @Override
    public LocalDate getDataOperacao() {
        return this.getDataLocacao();
    }

    @Override
    public Double getValorTotalOperacao() {
        return this.getItens().stream()
                .mapToDouble(ItemLocacao::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.CREDITO;
    }
}
