/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ListarProdutoController", urlPatterns = {"/lista"})

public class ListarProdutoController extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("fez doget tambem");
        ArrayList<Produto> lista = ProdutoDAO.listar();
        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listarProduto.jsp");
        rd.forward(request, response);
        

    }
}
