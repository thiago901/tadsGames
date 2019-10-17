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
import java.util.ArrayList;
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
 * @author marco.assilva8 
 * @author lucas.sfaria5
 */
@WebServlet(name = "ProdutoController", urlPatterns = {"/formularioProduto"})

public class ProdutoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int retorno;
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");
        boolean ativo = Boolean.valueOf(request.getParameter("ativo"));
        


        Produto p = new Produto (nome, descricao, tipo, ativo);
        try {
            retorno = ProdutoDAO.salvar(p);
            if (retorno > 0) {
            response.sendRedirect("sucesso.html");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
