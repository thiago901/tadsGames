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

    public Impressao(boolean ativo, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao) {
        super(ativo, codProdServ, categoria, nome, valorCompra, descricao, regiao);
    }

    @Override
    public boolean disponivel() {
        throw new UnsupportedOperationException("Not supported yet."); ///IMPLEMENTAR
    }
    
}
