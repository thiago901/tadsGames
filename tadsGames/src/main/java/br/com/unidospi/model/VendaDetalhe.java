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
    private int item;
    private int idVenda;
    private int idProduto;
    private String nomeProduto;
    private int qtdVenda;
    private float vlrUnitario;
    private float vlrTotal;
    

    public VendaDetalhe(int idProduto, int qtdVenda, float vlrUnitario, float vlrTotal) {
        
        this.idProduto = idProduto;
        this.qtdVenda = qtdVenda;
        this.vlrUnitario = vlrUnitario;
        this.vlrTotal = vlrTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

   

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public float getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(float vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    
        
}
