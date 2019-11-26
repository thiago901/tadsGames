/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import br.com.unidospi.DAO.CompraDAO;
import java.util.Date;

/**
 *
 * @author henrique.abastos
 */
public class Compra {
    
    private int idCompra;
    private int idEmpresa;
    private int idProduto;
    private int qtdCompra;
    private Date dataCompra;
    private float valorCompra;

    public Compra(int idCompra, int idEmpresa, int idProduto, int qtdCompra, Date dataCompra, float valorCompra) {
        this.idCompra = idCompra;
        this.idEmpresa = idEmpresa;
        this.idProduto = idProduto;
        this.qtdCompra = qtdCompra;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    public Compra(int idEmpresa, int idProduto, int qtdCompra, Date dataCompra, float valorCompra) {
        this.idEmpresa = idEmpresa;
        this.idProduto = idProduto;
        this.qtdCompra = qtdCompra;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    public Compra(int qtdCompra, float valorCompra) {
        this.qtdCompra = qtdCompra;
        this.valorCompra = valorCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdCompra() {
        return qtdCompra;
    }

    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    public boolean salvar(){
        return CompraDAO.salvar(this);
    }
    
    
}
