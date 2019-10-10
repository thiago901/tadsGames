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

    public Servicos(int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao, boolean status) {
        super(codProdServ, categoria, nome, valorCompra, descricao, regiao, status);
    }

}
