/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.Date;

/**
 *
 * @author thiago.srocha4
 */
public class ClienteLista {
    private int idCliente;
    private String nome; 
    private String sobrenome;
    private String CPF;
    private Date dtNasc;
    private String sexo;
    private int idEmpresa;
    private String nomeEmpresa; 
    private boolean ativo;

    public ClienteLista(int idCliente, String nome, String sobrenome, String CPF, Date dtNasc, String sexo, int idempresa, String nomeEmpresa, boolean ativo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.idEmpresa = idempresa;
        this.nomeEmpresa = nomeEmpresa;
        this.ativo = ativo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdempresa() {
        return idEmpresa;
    }

    public void setIdempresa(int idempresa) {
        this.idEmpresa = idempresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
    
}
