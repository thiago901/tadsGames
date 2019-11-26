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
public class Produto {
    private int idProduto;
    private String nome;
    private String tipo;
    private String descricao;
    private boolean ativo; //define status, se é ativo ou não

    public Produto(int idProduto, String nome, String descricao, String tipo, boolean ativo) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Produto(String nome, String descricao, String tipo, boolean ativo) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Produto(int idProduto, String nome) {
        this.idProduto = idProduto;
        this.nome = nome;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }


    public String getDescricao() {
        return descricao;
    }

 
    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

 
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

  
    
    
    
    
    
    
}
