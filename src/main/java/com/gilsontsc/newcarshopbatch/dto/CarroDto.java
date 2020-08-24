package com.gilsontsc.newcarshopbatch.dto;

import java.io.Serializable;

public class CarroDto implements Serializable {

    private static final long serialVersionUID = 1l;

    private String renavam;
    private String marca;
    private String modelo;
    private String anoFabricacao;
    private String anoModelo;
    private String valorCompra;
    private String invalid;

    public CarroDto() {}

    public CarroDto(String invalid) {
        this.invalid = invalid;
    }

    public CarroDto(String renavam, String marca, String modelo, String anoFabricacao, String anoModelo, String valorCompra) {
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.valorCompra = valorCompra;
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

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }
}
