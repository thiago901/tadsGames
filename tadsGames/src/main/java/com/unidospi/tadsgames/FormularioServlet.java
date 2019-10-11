/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unidospi.tadsgames;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FormularioServlet", urlPatterns = {"/formulario/func"})//COMMIT COMENTÁRIO
public class FormularioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String nome = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String dtNascStr = request.getParameter("dtNasc");
        String salarioStr = request.getParameter("salario");
        String cargoStr = request.getParameter("cargo");
        String deptoStr = request.getParameter("depto");
        String ativoStr = request.getParameter("ativo");
        String tpFuncStr = request.getParameter("tpFuncionario");
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("Funcionario/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
