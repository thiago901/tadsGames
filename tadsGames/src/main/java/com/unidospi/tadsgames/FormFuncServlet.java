/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unidospi.tadsgames;

import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "FormFuncServlet", urlPatterns = {"/formulario"})
public class FormFuncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Empresa> empresas = FuncionarioDAO.obterEmpresas();
            String[] listaEmpresas = new String[empresas.size()]; 
            HashMap<String, Integer> mapaEmpresas = new HashMap<>();
            
            for (int i = 0; i < empresas.size(); i++) {
                listaEmpresas[i] = empresas.get(i).getNome();
                mapaEmpresas.put(listaEmpresas[i], empresas.get(i).getCod());
            }
            
            request.setAttribute("empresasAttr", empresas);
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/Funcionario/Funcionario.jsp");
        dispatcher.forward(request, response);
    }
}
