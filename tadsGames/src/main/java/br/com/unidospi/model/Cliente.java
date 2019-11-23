/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.Date;



/**
 *
 * @author henrique.abastos
 */
public class Cliente extends PessoaCadastravel {

    public Cliente(int id, int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(id, idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }
    public Cliente(int id, int idEmpresa, String nome, String sobrenome, String sexo, Date dataNasc, boolean ativo) {
        super(id, idEmpresa, nome, sobrenome, sexo, dataNasc, ativo);
    }
    public Cliente(int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        super(idEmpresa, nome, sobrenome, sexo, cpf, dataNasc, ativo);
    }

    public Cliente(int id, String nome, String sobrenome) {
        super(id, nome, sobrenome);
    }
   
    

    

}
