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
    private String sobrenome;
    private String departamento;
    private String cargo;
    private boolean statusFuncionario;
    private int idEmpresa;

    public UsuarioFuncionario(int idFuncionario, String nomeFuncionario, 
            String sobrenome, String departamento, String cargo) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenome = sobrenome;
        this.departamento = departamento;
        this.cargo = cargo;
    } 

    public UsuarioFuncionario(int idUsuario, String nomeUsuario, String departamento, String cargo,int idEmpresa) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.departamento = departamento;
        this.cargo = cargo;
        this.idEmpresa=idEmpresa;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }
    
    
}
