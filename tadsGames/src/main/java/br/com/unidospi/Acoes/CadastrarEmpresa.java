/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gisidorio
 */
public class CadastrarEmpresa implements Executavel{

    /**
     *
     * @param req
     * @param resp
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
         boolean retorno = false;
        String nome=req.getParameter("nome");
        String cnpj=req.getParameter("cnpj");        
        String strDataCriacao =req.getParameter("dataCriacao");
        String strIdEstado = req.getParameter("estado");
        String strIdCidade = req.getParameter("cidade");
        int idEstado = 0;
        int idCidade = 0;
        boolean status = Boolean.valueOf(req.getParameter("status"));
        boolean matriz = Boolean.valueOf(req.getParameter("matriz"));
        
                
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(strDataCriacao);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
        
        boolean validacao = false;
        
        if (nome.length() > 50 || nome.equals("")) {
            validacao = true;
            req.setAttribute("erroNome", true);            
        }
        if (cnpj.length() > 14 || cnpj.equals("")) {
            validacao = true;
            req.setAttribute("erroCNPJ", true);            
        }
        if (strDataCriacao.equals("")) {
            validacao = true;
            req.setAttribute("erroDtCriacao", true);       
        }
        
        if (strIdEstado == null) {
            validacao = true;
            req.setAttribute("erroEstado", true);       
        } else {
            idEstado = Integer.parseInt(strIdEstado);
        }
        
        if (strIdCidade == null) {
            validacao = true;
            req.setAttribute("erroCidade", true);       
        } else {
            idCidade = Integer.parseInt(strIdCidade);
        }            
        
        if (validacao) {
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("cadastrarEmpresa.jsp");
            dispatcher.forward(req, resp);
        } else {
        
            Empresa empr = new Empresa(nome, cnpj, dataCriacao, idEstado,idCidade, status, matriz);
            retorno =empr.salvar();
            if(retorno){
                resp.sendRedirect("sucesso.html");
            }
        }
        return "";
    }
    
    
    
}
