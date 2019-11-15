/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.EstoqueDAO;
import br.com.unidospi.model.Compra;
import br.com.unidospi.model.Estoque;
import br.com.unidospi.model.Venda;
import br.com.unidospi.model.VendaDetalhe;
import java.util.List;

/**
 *
 * @author thiago.srocha4
 */
public class EstoqueController {

    
    public static void estocar(Compra c){
        if(EstoqueDAO.temEstoque(c.getIdProduto(), c.getIdEmpresa())){
            atualizarEstoque(c);
        }else{
            insereEstoque(c);
        }
        
    }
    private static void atualizarEstoque(Compra c) {
        int qtdEstoqueAtual = estoqueAtual(c) ;
        int idProduto = c.getIdProduto();
        int idEmpresa = c.getIdEmpresa();
        int qtdEstoque =c.getQtdCompra()+qtdEstoqueAtual;
        float vlrUnitario = c.getValorCompra();

        Estoque estoca = new Estoque(idProduto, idEmpresa, qtdEstoque,vlrUnitario);
        estoca.alterar();
             
    }
    
    public static void atualizarEstoque(Venda c) {
        List<VendaDetalhe> vd = c.getVendaDetalhe();
        for(VendaDetalhe v : vd){
            
                int qtdEstoqueAtual = estoqueAtual(v.getIdProduto(),c.getIdEmpresa());
            if(qtdEstoqueAtual>=v.getQtdVenda()){
                int idProduto = v.getIdProduto();
                int idEmpresa = c.getIdEmpresa();
                int qtdEstoque =qtdEstoqueAtual - v.getQtdVenda();
                float vlrUnitario = v.getVlrUnitario();

                Estoque estoca = new Estoque(idProduto, idEmpresa, qtdEstoque,vlrUnitario);
                estoca.alterar();
            }else{
                throw new RuntimeException("Não há quantidade suficiente");
            }
            
        }
        
             
    }
    
    private static void insereEstoque(Compra compra) {
        
        int idProduto = compra.getIdProduto();
        int idEmpresa = compra.getIdEmpresa();
        int qtdEstoque =compra.getQtdCompra();
        float vlrUnitario = compra.getValorCompra();
        
        Estoque estoca = new Estoque(idProduto, idEmpresa, qtdEstoque,vlrUnitario);
        estoca.salva();
        
        
    }

   
    
    private boolean temEstoque(int idProduto, int idEmpresa) {
        return EstoqueDAO.temEstoque(idProduto, idEmpresa);
    }
    
    private static int estoqueAtual(Compra c){
        return EstoqueDAO.qtdEstoque(c.getIdProduto(), c.getIdEmpresa());
    }
    private static int estoqueAtual(int idProduto, int idEmpresa){
        return EstoqueDAO.qtdEstoque(idProduto, idEmpresa);
    }
    
     
    
    
    
}
