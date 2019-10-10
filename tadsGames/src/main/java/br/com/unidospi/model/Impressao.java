/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author lucas
 */
public class Impressao extends Servicos {
    private String tipoDeImpressao;

    public Impressao(String tipoDeImpressao, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao, boolean status) {
        super(codProdServ, categoria, nome, valorCompra, descricao, regiao, status);
        this.tipoDeImpressao = tipoDeImpressao;
    }

    public String getTipoDeImpressao() {
        return tipoDeImpressao;
    }

    public void setTipoDeImpressao(String tipoDeImpressao) {
        this.tipoDeImpressao = tipoDeImpressao;
    }
    
    
    
}
