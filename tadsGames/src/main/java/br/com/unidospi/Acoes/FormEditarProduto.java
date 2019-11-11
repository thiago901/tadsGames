/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class FormEditarProduto implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
               int id = Integer.parseInt(req.getParameter("idProduto"));
        Produto p = ProdutoDAO.listarProduto(id);
        req.setAttribute("p", p);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/produto/alterarProduto.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
