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
public abstract class Usuario extends PessoaCadastravel {

    private String login;
    private String senha;

    public Usuario(String login, String senha, int id, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(id, nome, sobrenome, sexo, cpf, dataNasc, ativo);
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(nome, sobrenome, sexo, cpf, dataNasc, ativo);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
