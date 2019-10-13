/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import br.com.unidospi.Controller.CidadeController;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Cidade {
    int idCidade;
    String nomeCidade;
    int idEstado;

    public Cidade(String nomeCidade, int idEstado) {
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;
    }

    public Cidade(int idCidade, String nomeCidade, int idEstado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public List listarCidade(){
        return CidadeController.listarCidade();
    }
    public List listarCidade(int uf){
        return CidadeController.listarCidade(uf);
    }
    
    
}
