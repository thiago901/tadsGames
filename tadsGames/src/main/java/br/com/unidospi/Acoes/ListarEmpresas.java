/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.EmpresaLista;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class ListarEmpresas implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        String n = req.getParameter("offset");
        int offset = 0;
        if (n == null) {
            req.setAttribute("offset", 0);
        } else {
            int aux =Integer.parseInt(n);
            if(aux>=0){
                offset = aux;
            }else{
                offset=0;
            }
            req.setAttribute("offset", offset);
        }
        
        

        ArrayList<EmpresaLista> le = EmpresaController.listarEmpresasPaginada(offset);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/empresa/listarEmpresa.jsp");
        req.setAttribute("lista", le);
        rd.forward(req, resp);
        return "Executou";
    }

}
