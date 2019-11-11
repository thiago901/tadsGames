/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.CidadeController;
import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.Cidade;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.EstadoRegiao;
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
public class FormEditarEmpresa implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<EstadoRegiao> ufs  = EmpresaController.listaEstadoRegiao();
        
        ArrayList<Cidade> cid = CidadeController.listarCidade();
        req.setAttribute("ufs", ufs);
        req.setAttribute("cids", cid);
        
        int id =Integer.parseInt(req.getParameter("id"));
        EmpresaLista e = EmpresaController.listarEmpresas(id);
        req.setAttribute("e", e);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/empresa/alterarEmpresa.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
