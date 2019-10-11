/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.FuncionarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henrique.abastos
 */
@WebServlet(name = "FuncionarioController", urlPatterns = {"/formulario/funcionario"})
public class FuncionarioController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idEmpresa = request.getParameter("idEmpresa");
        String nome = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String dtNascStr = request.getParameter("dtNasc");
        String salarioStr = request.getParameter("salario");
        String cargoStr = request.getParameter("cargo");
        String deptoStr = request.getParameter("depto");
        String ativoStr = request.getParameter("ativo");
        String tpFuncStr = request.getParameter("tpFuncionario");
        
//        switch (tpFuncStr) {
//            case ""
//                    
//                    
//        
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("Funcionario/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
