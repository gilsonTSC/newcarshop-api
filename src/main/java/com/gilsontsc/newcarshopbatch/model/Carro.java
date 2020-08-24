package com.gilsontsc.newcarshopbatch.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gilsontsc.newcarshopbatch.enums.LojaEnum;

@Entity
public class Carro implements Serializable {

    private static final long serialVersionUID = 2l;

    @Id
    @GeneratedValue
    private Long id;
    private String renavam;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private BigDecimal valorCompra;
    private BigDecimal valorVenda;
    private BigDecimal percentalMaxDesconto;
    @Enumerated(EnumType.STRING)
    private LojaEnum loja;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public Carro() {}

    public Carro(Long id, String renavam, String marca, String modelo, Integer anoFabricacao, Integer anoModelo, BigDecimal valorCompra, BigDecimal valorVenda, BigDecimal percentalMaxDesconto, LojaEnum loja, Date dataCadastro) {
        this.id = id;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.percentalMaxDesconto = percentalMaxDesconto;
        this.loja = loja;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getPercentalMaxDesconto() {
        return percentalMaxDesconto;
    }

    public void setPercentalMaxDesconto(BigDecimal percentalMaxDesconto) {
        this.percentalMaxDesconto = percentalMaxDesconto;
    }

    public LojaEnum getLoja() {
        return loja;
    }

    public void setLoja(LojaEnum loja) {
        this.loja = loja;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
