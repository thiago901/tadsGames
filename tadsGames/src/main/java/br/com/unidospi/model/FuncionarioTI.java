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
public class FuncionarioTI extends Funcionario {

    public FuncionarioTI(double salario, String departamento, String cargo, String login, String senha, int id, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(salario, departamento, cargo, login, senha, id, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

    public FuncionarioTI(double salario, String departamento, String cargo, String login, String senha, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(salario, departamento, cargo, login, senha, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

    
    
    public void mostrarFaturamento() {}
    public void criarCadastroFuncionario() {}
    public void liberarAcessoFuncionario() {}
}
