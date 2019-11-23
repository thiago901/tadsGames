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
public abstract class PessoaCadastravel {

    private int id;
    private int idEmpresa;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String cpf;
    private Date dataNasc;
    private boolean ativo;

    public PessoaCadastravel(int id, int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }

    public PessoaCadastravel(int id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    
    public PessoaCadastravel(int id, int idEmpresa, String nome, String sobrenome, String sexo, Date dataNasc, boolean ativo) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }
    
    public PessoaCadastravel(int idEmpresa, String nome, String sobrenome, String sexo, String cpf, Date dataNasc, boolean ativo) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }
    

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

   

    public void bloquearCadastro() {
    }

    public void desbloquearCadastro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }   

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
