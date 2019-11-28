/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.model.Produto;
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
        String n = req.getParameter("offset");
        int offset = 0;
        if (n == null) {
            req.setAttribute("offset", 0);
        } else {
            int aux =Integer.parseInt(n);
            if(aux>=0){
                offset = aux;
            }else{
                offset=0;
            }
            req.setAttribute("offset", offset);
        }

        ArrayList<Produto> lista = ProdutoController.listarProdutoPaginado(offset);
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/produto/listarProduto.jsp");
        rd.forward(req, resp);
        return "";
    }

}
