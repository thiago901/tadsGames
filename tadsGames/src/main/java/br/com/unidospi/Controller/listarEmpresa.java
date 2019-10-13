/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.model.ListaEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "listarEmpresa", urlPatterns = {"/listarEmpresa"})
public class listarEmpresa extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<ListaEmpresa> le = EmpresaController.listarEmpresas();
        RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresa.jsp");
        request.setAttribute("lista", le);
        rd.forward(request, response);
        
    }

   
}
