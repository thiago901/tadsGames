/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "EmpresaAlterarController", urlPatterns = {"/alterarEmpresa"})
public class EmpresaAlterarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id =Integer.parseInt(req.getParameter("id"));
        EmpresaLista e = EmpresaController.listarEmpresas(id);
        req.setAttribute("e", e);
        RequestDispatcher rd = req.getRequestDispatcher("/alterarEmpresa.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEmpresa=Integer.parseInt(req.getParameter("idEmpresa"));
        String nome=req.getParameter("nome");
        String cnpj=req.getParameter("cnpj");
        String strDataCriacao =req.getParameter("dataCriacao");
        int idEstado =Integer.parseInt(req.getParameter("estado"));
        int idCidade =Integer.parseInt(req.getParameter("cidade"));
        boolean status = Boolean.valueOf(req.getParameter("status"));
        boolean matriz = Boolean.valueOf(req.getParameter("matriz"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(strDataCriacao);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
    
        
        Empresa empr = new Empresa(idEmpresa,nome, cnpj, dataCriacao, idEstado,idCidade, status, matriz);
        empr.alterar();
    }              
}
