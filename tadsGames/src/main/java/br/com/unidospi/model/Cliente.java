/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.sql.Date;

/**
 *
 * @author henrique.abastos
 */
public class Cliente extends PessoaCadastravel {

    public Cliente(String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

}
