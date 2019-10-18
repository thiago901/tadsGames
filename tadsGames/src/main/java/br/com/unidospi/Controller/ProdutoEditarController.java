/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas.sfaria5
 */
@WebServlet(name = "ProdutoEditarController", urlPatterns = {"/editarProduto"})

public class ProdutoEditarController extends HttpServlet{
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        Produto p = ProdutoDAO.listarProduto(id);
        request.setAttribute("p", p);
        RequestDispatcher rd = request.getRequestDispatcher("/alterarProduto.jsp");
        rd.forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean retorno;
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");
        boolean ativo = Boolean.valueOf(request.getParameter("ativo"));

        Produto p = new Produto (Integer.parseInt(request.getParameter("id")), nome, descricao, tipo, ativo);
        retorno = ProdutoDAO.editar(p);
        if (retorno) {
            response.sendRedirect("sucesso.html");
        }


    }
}
