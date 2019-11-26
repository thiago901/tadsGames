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
public class Funcionario extends PessoaCadastravel {
    private double salario;
    private String departamento;
    private String cargo;

    public Funcionario(double salario, String departamento, String cargo, int id, int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(id, idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);        
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }
    public Funcionario(double salario, String departamento, String cargo, int id, int idEmpresa, String nome, String sobrenome, String sexo, Date dataNasc, boolean ativo) {
        super(id, idEmpresa, nome, sobrenome, sexo, dataNasc, ativo);        
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public Funcionario(int id, String nome, String sobrenome) {
        super(id, nome, sobrenome);
    }
    
    public Funcionario(double salario, String departamento, String cargo, 
            int idEmpresa, String nome, 
            String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);
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
