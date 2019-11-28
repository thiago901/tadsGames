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
        int offset =0;
        HttpSession sessao = req.getSession();
        if(sessao.getAttribute("offset")==null){
            sessao.setAttribute("offset", 0);
        }else{
            String mv = req.getParameter("page");
            offset = (int) sessao.getAttribute("offset");
            if (!(mv == null)) {
                if (mv.equals("next")) {
                    offset += 10;
                } else {
                    offset -= 10;
                }
                sessao.setAttribute("offset", offset);
            }
        }
        
        

        ArrayList<EmpresaLista> le = EmpresaController.listarEmpresasPaginada(offset);
        req.setAttribute("pagina", String.valueOf(offset));
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/empresa/listarEmpresa.jsp");
        req.setAttribute("lista", le);
        rd.forward(req, resp);
        return "Executou";
    }

}
