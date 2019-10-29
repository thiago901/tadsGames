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
        int idEstado =Integer.parseInt(req.getParameter("estado"));
        int idCidade =Integer.parseInt(req.getParameter("cidade"));
        boolean status = Boolean.valueOf(req.getParameter("status"));
        boolean matriz = Boolean.valueOf(req.getParameter("matriz"));
        
        boolean validacao = false;
        
        if (nome.length() > 50 || nome.equals("")) {
            req.setAttribute("erroNome", true);
        }
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(strDataCriacao);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
    
        
        Empresa empr = new Empresa(nome, cnpj, dataCriacao, idEstado,idCidade, status, matriz);
        retorno =empr.salvar();
        if(retorno){
            resp.sendRedirect("sucesso.html");
        }
        return "";
    }
    
    
    
}
