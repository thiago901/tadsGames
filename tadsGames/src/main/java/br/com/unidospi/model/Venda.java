/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author thiago.srocha4
 */
public class Venda {
    
    private int idVenda;
    private float vlrVenda;
    private Date dtVenda;
    private String statusVenda;
    private Cliente cliente;
    private Empresa empresa;
    
    private ArrayList<VendaDetalhe> vendaDetalhe;

    public Venda(int idVenda, float vlrVenda, Date dtVenda, String statusVenda, Cliente cliente, Empresa empresa) {
        this.idVenda = idVenda;
        this.vlrVenda = vlrVenda;
        this.dtVenda = dtVenda;
        this.statusVenda = statusVenda;
        this.cliente = cliente;
        this.empresa = empresa;
    }

    public Venda(float vlrVenda, Date dtVenda, String statusVenda, Cliente cliente, Empresa empresa) {
        this.vlrVenda = vlrVenda;
        this.dtVenda = dtVenda;
        this.statusVenda = statusVenda;
        this.cliente = cliente;
        this.empresa = empresa;
        
    }

    public int getIdVenda() {
        return idVenda;
    }

    public float getVlrVenda() {
        return vlrVenda;
    }

    public void setVlrVenda(float vlrVenda) {
        this.vlrVenda = vlrVenda;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    public boolean salvar(){
        return true;
    }
    
    
    
}
