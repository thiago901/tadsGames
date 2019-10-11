/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;

/**
 *
 * @author marco.assilva8
 */
public class ProdutoController {
    
    public static boolean salvar(int codProduto, String nome,double valorCompra, String descricao, String regiao){
        Produto produto = new Produto(codProduto,nome,valorCompra,descricao,regiao,true);
        return ProdutoDAO.salvar(produto);
 
    }
    
    public static boolean editar(int codProduto, String nome,double valorCompra, String descricao, String regiao){
        Produto produto = new Produto(codProduto,nome,valorCompra,descricao,regiao,true);
        return ProdutoDAO.editar(produto);
 
    }
    
    public static boolean alterarStatus(int codProduto, String nome,double valorCompra, String descricao, String regiao){
        Produto produto = new Produto(codProduto,nome,valorCompra,descricao,regiao,true);
        return ProdutoDAO.alterarStatus(produto);
    
    }
    
    public static boolean incluir(int codProduto, String nome,double valorCompra, String descricao, String regiao){
        Produto produto = new Produto(codProduto,nome,valorCompra,descricao,regiao,true);
        return ProdutoDAO.incluir(produto);
 
    }
}
