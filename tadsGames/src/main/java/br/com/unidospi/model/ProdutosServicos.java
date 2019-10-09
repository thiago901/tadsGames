/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author lucas
 */
public abstract class ProdutosServicos {
    private final int codProdServ;
    private final String categoria;
    private String nome;
    private double valorCompra;
    private String descricao;
    private String regiao;

    public ProdutosServicos(int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao) {
        this.codProdServ = codProdServ;
        this.categoria = categoria;
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.descricao = descricao;
        this.regiao = regiao;
    }

    public int getCodProdServ() {
        return codProdServ;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
    public abstract boolean disponivel();
    
    
    
}
