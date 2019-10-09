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
public abstract class Servicos extends ProdutosServicos {
    
    private boolean ativo;

    public Servicos(boolean ativo, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao) {
        super(codProdServ, categoria, nome, valorCompra, descricao, regiao);
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public abstract boolean disponivel ();
    
    
}
