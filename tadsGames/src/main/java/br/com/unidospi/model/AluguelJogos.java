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
public class AluguelJogos extends Servicos {
    private String dataDevolucao;

    public AluguelJogos(String dataDevolucao, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao, boolean status) {
        super(codProdServ, categoria, nome, valorCompra, descricao, regiao, status);
        this.dataDevolucao = dataDevolucao;
    }
    
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    
    
}
