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
public abstract class Funcionario extends Usuario {
    private double salario;
    private String departamento;
    private String cargo;

    public Funcionario(double salario, String departamento, String cargo, 
            String login, String senha, int id, String nome,String sobrenome, String cpf, 
            Date dataNasc, boolean ativo) {
        super(login, senha, id, nome,sobrenome, cpf, dataNasc, ativo);
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public Funcionario(double salario, String departamento, String cargo, 
            String login, String senha, String nome,String sobrenome, String cpf, 
            Date dataNasc, boolean ativo) {
        super(login, senha, nome,sobrenome, cpf, dataNasc, ativo);
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
}
