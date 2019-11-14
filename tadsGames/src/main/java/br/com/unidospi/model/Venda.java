/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import br.com.unidospi.DAO.VendaDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thiago.srocha4
 */
public class Venda {
    
    private int idVenda;
    private int idCliente;
    private int idEmpresa;
    private float vlrVenda;
    private Date dtVenda;
    private String statusVenda;
    private List<VendaDetalhe> vendaDetalhe =new ArrayList<>();
    private int idFuncionario;
    
    
    
    

    public Venda(int idVenda, int idCliente, int idEmpresa,int idFuncionario, float vlrVenda, Date dtVenda, String statusVenda) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        this.vlrVenda = vlrVenda;
        this.dtVenda = dtVenda;
        this.statusVenda = statusVenda;
        this.idFuncionario=idFuncionario;
    }

    public Venda(int idCliente, int idEmpresa, int idFuncionario,float vlrVenda, Date dtVenda, String statusVenda) {
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
        this.vlrVenda = vlrVenda;
        this.dtVenda = dtVenda;
        this.statusVenda = statusVenda;
        this.idFuncionario = idFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

  

    public int getIdVenda() {
        return idVenda;
    }

    public float getVlrVenda() {
        return vlrVenda;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public List<VendaDetalhe> getVendaDetalhe() {
        return Collections.unmodifiableList(vendaDetalhe);
    }

    public int salvar() {
        return VendaDAO.salvar(this);
    }

    public void adiciona(VendaDetalhe vd) {
        vendaDetalhe.add(vd);
    }

    
    
    
    
}
