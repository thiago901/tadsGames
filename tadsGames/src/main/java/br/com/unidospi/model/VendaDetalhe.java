/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author thiago.srocha4
 */
public class VendaDetalhe {
    private int idVenda;
    private Produto produto;
    private int qtdVenda;
    private float vlrUnitario;

    public VendaDetalhe(int idVenda, Produto produto, int qtdVenda, float vlrUnitario) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.qtdVenda = qtdVenda;
        this.vlrUnitario = vlrUnitario;
    }

    public VendaDetalhe(Produto produto, int qtdVenda, float vlrUnitario) {
        this.produto = produto;
        this.qtdVenda = qtdVenda;
        this.vlrUnitario = vlrUnitario;
    }

    public int getIdVenda() {
        return idVenda;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public float getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(float vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }
    
    
    
    
}
