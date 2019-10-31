/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.Date;



/**
 *
 * @author gabri
 */
public class Usuario {
    
    private int idUsuario;
    private String nomeUsuario;
    private String senha;
    private Date dtCadastro;
    private boolean status;    
    private int idFuncionario;

    public Usuario(String nomeUsuario, String senha, Date dtCadastro, boolean status, int idFuncionario) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtCadastro = dtCadastro;
        this.status = status;
        this.idFuncionario = idFuncionario;
    }

    public Usuario(int idUsuario, String nomeUsuario, String senha, Date dtCadastro, boolean status, int idFuncionario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtCadastro = dtCadastro;
        this.status = status;
        this.idFuncionario = idFuncionario;
    }        

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }        
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

        
}
