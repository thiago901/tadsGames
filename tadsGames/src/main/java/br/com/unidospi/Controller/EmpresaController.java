/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.EmpresaDao;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static ArrayList listarEmpresas() {
        return EmpresaDao.listarEmpresas();
    }

    public static EmpresaLista listarEmpresas(int id) {
        return EmpresaDao.listarEmpresas(id);
    }

    public static void alterar(Empresa e) {
        EmpresaDao.alterar(e);
    }

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/listaEstadoRegiao");
        rd.forward(request, response);
        
       
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean retorno = false;
        String nome=request.getParameter("nome");
        String cnpj=request.getParameter("cnpj");
        String strDataCriacao =request.getParameter("dataCriacao");
        int idEstado =Integer.parseInt(request.getParameter("estado"));
        int idCidade =Integer.parseInt(request.getParameter("cidade"));
        boolean status = Boolean.valueOf(request.getParameter("status"));
        boolean matriz = Boolean.valueOf(request.getParameter("matriz"));
        
        
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
            response.sendRedirect("sucesso.html");
        }
        
       
    }

    

}
