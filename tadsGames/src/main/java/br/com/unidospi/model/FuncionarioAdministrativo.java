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
public class FuncionarioAdministrativo extends Funcionario {

    public FuncionarioAdministrativo(double salario, String departamento, String cargo, int id, int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(salario, departamento, cargo, id, idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

    public FuncionarioAdministrativo(double salario, String departamento, 
            String cargo, int idEmpresa, String nome, 
            String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(salario, departamento, cargo, idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

   

    public void mostrarFaturamento() {
    }
}
