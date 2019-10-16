/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.EmpresaLista;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class FormEditarEmpresa {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        EmpresaLista e = EmpresaController.listarEmpresas(id);
        req.setAttribute("e", e);
        RequestDispatcher rd = req.getRequestDispatcher("/alterarEmpresa.jsp");
        rd.forward(req, resp);
    }
    
}
