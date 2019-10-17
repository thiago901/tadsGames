/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class ListarProdutos {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fez doget");
        ArrayList<Produto> lista = ProdutoDAO.listar();
        RequestDispatcher rd = request.getRequestDispatcher("/listarProduto.jsp");
        request.setAttribute("lista", lista);
        rd.forward(request, response);

        return "";
    }

}
