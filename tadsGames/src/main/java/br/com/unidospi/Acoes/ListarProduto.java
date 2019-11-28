/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.model.Produto;
import br.com.unidospi.util.ListaPaginada;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */


public class ListarProduto implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        double qtdRegistoPorPagina = 10;
        double qtdPagina = 1;
        int offset=0;
        ArrayList<Produto> lista;
        
        String numPaginaStr = req.getParameter("pagina");
        String nome = req.getParameter("nome");
        int numPagina=1;
        
        if(!(numPaginaStr==null)){
            numPagina = Integer.parseInt(numPaginaStr);
            double qtdRegitro=1;
            if(nome==null){
                qtdRegitro=ProdutoController.qtdRegitro();
            }else{
                qtdRegitro=ProdutoController.qtdRegitro(nome);
                req.setAttribute("nome", nome);
            }
            ListaPaginada lp = new ListaPaginada(qtdRegitro, qtdRegistoPorPagina, numPagina);
            qtdPagina = lp.getQtdPaginas();
            numPagina= lp.getNumPagina();
            offset = lp.offset();
        }

        req.setAttribute("pagina", String.valueOf(numPagina));
        req.setAttribute("qtdPagina", (int)qtdPagina);
        
        if(nome==null){
            lista = ProdutoController.listarProdutoPaginado(offset);
        }else{
            lista = ProdutoController.listarProdutoPaginado(offset,nome);
        }
        
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/produto/listarProduto.jsp");
        rd.forward(req, resp);
        return "";
    }
    
    public static double devolveDouble(int v1, int v2){
        return v1/v2;
    }

}
