/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.FuncionarioEmpresa;
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
 * @author gabri
 */
@WebServlet(name = "ListarFuncionarioController", urlPatterns = {"/listarFuncionario"})
public class ListarFuncionarioController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
//        ArrayList<Funcionario> listaFuncionarios = FuncionarioDAO.obterFuncionario();
        ArrayList<FuncionarioEmpresa> listaFuncionarios = FuncionarioDAO.obterFuncionarios();
        
        request.setAttribute("funcionariosAttr", listaFuncionarios);
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/Funcionario/ListarFuncionario.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
