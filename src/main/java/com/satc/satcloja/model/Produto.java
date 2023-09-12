package com.satc.satcloja.model;

import com.satc.satcloja.enums.Status;
import com.satc.satcloja.exceptions.MargemLucroException;
import com.satc.satcloja.model.abstracts.ItemVendavel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "produto")
public class Produto extends ItemVendavel {

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "preco_compra")
    private Double precoCompra;

    @Column(name = "dt_validade")
    private LocalDate dataValidade;

    @Column(name = "dt_prazo")
    private LocalDate dataPrazo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Produto() {

    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        super.setDescricao(descricao);
    }

    public void setPrecoVenda(Double precoVenda) throws MargemLucroException {
        super.setValorUnitario(precoVenda);
        if (this.calculaMargemDeLucro() < 20.0) {
            throw new MargemLucroException();
        }
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double calculaMargemDeLucro() {
        double lucro = super.getValorUnitario() - precoCompra;
        double margemLucro = (lucro / super.getValorUnitario()) * 100;

        return margemLucro;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                "descricao='" + super.getDescricao() + '\'' +
                '}';
    }
}