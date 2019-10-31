/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.Date;

/**
 *
 * @author gabriel.gisidorio
 */
public class UsuarioFuncionario {
    
    private int idUsuario;
    private String nomeUsuario;
    private String senha;
    private Date dtCadastro;
    private boolean statusUsuario;
    private int idFuncionario;
    private String nomeFuncionario;
    private String departamento;
    private String cargo;
    private boolean statusFuncionario;

    public UsuarioFuncionario(int idUsuario, String nomeUsuario, String senha, Date dtCadastro, boolean statusUsuario, int idFuncionario, String nomeFuncionario, String departamento, String cargo, boolean statusFuncionario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dtCadastro = dtCadastro;
        this.statusUsuario = statusUsuario;
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.departamento = departamento;
        this.cargo = cargo;
        this.statusFuncionario = statusFuncionario;
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

    public boolean getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(boolean statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(boolean statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }
    
    
}
