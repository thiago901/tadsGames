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
public class Estoque {
    private int qtdEstoque;
    private double vlrVendaUnitario;
    private Produto p;

    public Estoque(int qtdEstoque, double vlrVendaUnitario, Produto p) {
        this.qtdEstoque = qtdEstoque;
        this.vlrVendaUnitario = vlrVendaUnitario;
        this.p = p;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getVlrVendaUnitario() {
        return vlrVendaUnitario;
    }

    public void setVlrVendaUnitario(double vlrVendaUnitario) {
        this.vlrVendaUnitario = vlrVendaUnitario;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }
    
}
