/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author thiago.srocha4
 */
public class EstadoRegiao {

    int id;
    String uf;
    String regiao;

    public EstadoRegiao(int id, String uf, String regiao) {
        this.id = id;
        this.uf = uf;
        this.regiao = regiao;
    }

    public EstadoRegiao(String uf, String regiao) {
        this.uf = uf;
        this.regiao = regiao;
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

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
