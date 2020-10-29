package com.example.controledegastospessoais.modelo;

public class Gastos {
    private int id;
    private String descricao;
    private String categoria;
    private String data;
    private double valor;

    public Gastos(String descricao, String categoria, String data, double valor) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValorComoString() {
        return String.valueOf(valor);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
