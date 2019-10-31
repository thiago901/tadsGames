/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.sql.Date;

/**
 *
 * @author gabri
 */
public class FuncionarioEmpresa {
    private final int id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String cpf;
    private Date dtNasc;
    private boolean status;
    private float salario;
    private String cargo;
    private String departamento;
    private int idEmpresa;
    private String nomeEmpresa;

    public FuncionarioEmpresa(int id, String nome, String sobrenome, String sexo, 
            String cpf, Date dtNasc, boolean status, float salario, String cargo, 
            String departamento, int idEmpresa, String nomeEmpresa) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.status = status;
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getId() {
        return id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
    
}
