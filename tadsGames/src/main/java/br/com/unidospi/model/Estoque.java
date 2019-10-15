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
    private int idEstoque;
    private int qtdEstoque;
    private float vlrVendaUnitario;
    private int idP;

    public Estoque(int idEstoque, int qtdEstoque, float vlrVendaUnitario, int idP) {
        this.idEstoque = idEstoque;
        this.qtdEstoque = qtdEstoque;
        this.vlrVendaUnitario = vlrVendaUnitario;
        this.idP = idP;
    }
    
    public Estoque(int qtdEstoque, float vlrVendaUnitario, int idP) {
        this.qtdEstoque = qtdEstoque;
        this.vlrVendaUnitario = vlrVendaUnitario;
        this.idP = idP;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
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

    public void setVlrVendaUnitario(float vlrVendaUnitario) {
        this.vlrVendaUnitario = vlrVendaUnitario;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    

}
