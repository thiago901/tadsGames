/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.List;

/**
 *
 * @author thiago.srocha4
 */
public class EstadoRegiao {

    int id;
    String uf;
    String estado;
    String capital;
    String regiao;
    String pais;

    public EstadoRegiao(int id, String uf, String estado, String capital, String regiao, String pais) {
        this.id = id;
        this.uf = uf;
        this.estado = estado;
        this.capital = capital;
        this.regiao = regiao;
        this.pais = pais;
    }

    public EstadoRegiao(String uf, String estado, String capital, String regiao, String pais) {
        this.uf = uf;
        this.estado = estado;
        this.capital = capital;
        this.regiao = regiao;
        this.pais = pais;
    }

    
    
    public int getId() {
        return id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public List<EstadoRegiao> listarEstadosRegioes(){
        return null;
        
    }

    
}
