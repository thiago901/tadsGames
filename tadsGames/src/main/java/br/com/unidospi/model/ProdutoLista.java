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
public class ProdutoLista {
    private int idProduto;
    private String nome;
    private int qtdEstoque;
    private float vlrUnitario;

    public ProdutoLista(int idProduto, String nome, int qtdEstoque, float vlrUnitario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.vlrUnitario = vlrUnitario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public float getVlrUnitario() {
        return vlrUnitario;
    }
    

    
  
    
    
    
    
    
    
}
