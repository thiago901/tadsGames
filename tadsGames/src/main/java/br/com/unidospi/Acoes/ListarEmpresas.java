/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.EmpresaLista;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class ListarEmpresas implements Executavel{
    
    @Override
    public String executa(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        ArrayList<EmpresaLista> le = EmpresaController.listarEmpresas();
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/empresa/listarEmpresa.jsp");
        req.setAttribute("lista", le);
        rd.forward(req, resp);
        return "Executou";
    }
        
    
}
