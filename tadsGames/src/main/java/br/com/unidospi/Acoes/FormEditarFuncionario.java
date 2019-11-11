
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.FuncionarioEmpresa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class FormEditarFuncionario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        FuncionarioEmpresa funcionario = FuncionarioDAO.obterFuncionarioEmpresaPorId(id);
        ArrayList<Empresa> listaEmpresas = EmpresaController.listarEmpresas();
        
        req.setAttribute("funcionario", funcionario);
        req.setAttribute("empresas", listaEmpresas);
        
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("/WEB-INF/jsp/funcionario/AlterarFuncionario.jsp");
        dispatcher.forward(req, resp);
        
        return "";
    }    
}
