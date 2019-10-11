/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "EmpresaController", urlPatterns = {"/cadastroEmpresa"})
public class EmpresaController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/listaEstadoRegiao");
        rd.forward(request, response);
       
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome=request.getParameter("nome");
        String cnpj=request.getParameter("cnpj");
        String strDataCriacao =request.getParameter("dataCriacao");
        int idEstado =Integer.parseInt(request.getParameter("estado"));
        String StrStatus = request.getParameter("status");
        String StrMatriz =request.getParameter("matriz");
        
        
        boolean status = Boolean.getBoolean(StrStatus);
        boolean matriz = Boolean.getBoolean(StrMatriz);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(strDataCriacao);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
    
        
        Empresa empr = new Empresa(nome, cnpj, dataCriacao, idEstado, status, matriz);
        empr.salvar();
        
       
    }

    

}
