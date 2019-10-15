/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import br.com.unidospi.Controller.EmpresaController;
import java.sql.Date;

/**
 *
 * @author Thiago
 */
public class EmpresaLista {
    private final int idEmpresa;
    private final String nome;
    private final String cnpj;
    private final Date dataCriacao;
    private final int idEstado;
    private final String uf;
    private final String regiao;
    private final int idCidade ;
    private final String nomeCidade;
    private final Boolean ativo;
    private final Boolean matriz;

    public EmpresaLista(int idEmpresa, String nome, String cnpj, Date dataCriacao, int idEstado, String uf, String regiao, int idCidade, String nomeCidade, Boolean ativo,Boolean matiz) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.idEstado = idEstado;
        this.uf = uf;
        this.regiao = regiao;
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.ativo = ativo;
        this.matriz = matiz;
    }

    public Boolean getMatriz() {
        return matriz;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public String getUf() {
        return uf;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "ListaEmpresa{" + "idEmpresa=" + idEmpresa + ", nome=" + nome + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao + ", idEstado=" + idEstado + ", uf=" + uf + ", regiao=" + regiao + ", idCidade=" + idCidade + ", nomeCidade=" + nomeCidade + ", ativo=" + ativo + '}';
    }

    
    
    
    
}
