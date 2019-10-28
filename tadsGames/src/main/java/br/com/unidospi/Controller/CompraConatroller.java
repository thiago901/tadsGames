/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarEmpresa;
import br.com.unidospi.Acoes.EditarEmpresa;
import br.com.unidospi.Acoes.FormCadastrarEmpresa;
import br.com.unidospi.Acoes.FormEditarEmpresa;
import br.com.unidospi.Acoes.ListarEmpresas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henrique.abastos
 */
@WebServlet(name = "CompraConatroller", urlPatterns = {"/inputCompra"})
public class CompraConatroller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        if(paramAction.equals("FormComprar")){
            ListarEmpresas action = new ListarEmpresas();
            action.executa(req,resp);
            
        }
        
        
    }




}
