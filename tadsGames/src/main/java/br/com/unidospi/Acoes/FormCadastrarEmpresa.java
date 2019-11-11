/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.CidadeController;
import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.Cidade;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EstadoRegiao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class FormCadastrarEmpresa implements Executavel{

    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
               ArrayList<EstadoRegiao> ufs  = EmpresaController.listaEstadoRegiao();
        
               ArrayList<Cidade> cid = CidadeController.listarCidade();
        
        req.setAttribute("ufs", ufs);
        req.setAttribute("cids", cid);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/empresa/cadastrarEmpresa.jsp");
        rd.forward(req, resp);
        return "";
        
    }

 
    
}
