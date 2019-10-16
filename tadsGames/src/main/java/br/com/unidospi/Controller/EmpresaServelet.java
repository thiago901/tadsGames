/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarEmpresa;
import br.com.unidospi.Acoes.FormCadastrarEmpresa;
import br.com.unidospi.Acoes.FormEditarEmpresa;
import br.com.unidospi.Acoes.ListarEmpresas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "EmpresaServelet", urlPatterns = {"/input"})
public class EmpresaServelet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        if(paramAction.equals("ListarEmpresas")){
            ListarEmpresas action = new ListarEmpresas();
            action.executa(req,resp);
            
        }else if(paramAction.equals("FormEditarEmpresa")){
            FormEditarEmpresa action = new FormEditarEmpresa();
            action.executa(req,resp);
            
            
        }else if(paramAction.equals("FormCadastrarEmpresa")){
        FormCadastrarEmpresa action =new FormCadastrarEmpresa();
            action.executa(req,resp);
        }
        else if(paramAction.equals("CadastrarEmpresa")){
            CadastrarEmpresa action = new CadastrarEmpresa();
            action.executa(req,resp);
        }
    }

    

}
