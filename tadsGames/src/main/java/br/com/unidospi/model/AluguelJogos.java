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

    public AluguelJogos(String dataDevolucao, boolean ativo, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao) {
        super(ativo, codProdServ, categoria, nome, valorCompra, descricao, regiao);
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public boolean disponivel() {
        throw new UnsupportedOperationException("Not supported yet."); //IMPLEMENTAR faz sentido?
    }
    
    
}
