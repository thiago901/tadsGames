/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import br.com.unidospi.DAO.EstoqueDAO;

/**
 *
 * @author lucas
 */
public class Estoque {
    private int idEstoque;
    private int idProduto;
    private int idEmpresa;
    private int qtdEstoque;
    private float vlrVendaUnitario;

    public Estoque(int idEstoque, int idProduto, int idEmpresa, int qtdEstoque, float vlrVendaUnitario) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.idEmpresa = idEmpresa;
        this.qtdEstoque = qtdEstoque;
        this.vlrVendaUnitario = vlrVendaUnitario;
    }

    public Estoque(int idProduto, int idEmpresa, int qtdEstoque, float vlrVendaUnitario) {
        this.idProduto = idProduto;
        this.idEmpresa = idEmpresa;
        this.qtdEstoque = qtdEstoque;
        this.vlrVendaUnitario = vlrVendaUnitario;
    }

    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public float getVlrVendaUnitario() {
        return vlrVendaUnitario;
    }

    public void setVlrVendaUnitario(float vlrVendaUnitario) {
        this.vlrVendaUnitario = vlrVendaUnitario;
    }

    public boolean alterar() {
        return EstoqueDAO.alterar(this);
    }

    public boolean salva() {
        return EstoqueDAO.salvar(this);
    }
    
    
    
    

}
