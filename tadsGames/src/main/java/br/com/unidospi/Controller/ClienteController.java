/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.Empresa;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
 * @author henrique.abastos
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/CadastroCliente"})
public class ClienteController extends HttpServlet{
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/Cliente/Cliente.jsp");
        dispatcher.forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int retorno;
        int idEmpresa = 0;
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String dtNascm = request.getParameter("dtNasc");
        String sexo = request.getParameter("sexo");
        boolean ativo = Boolean.valueOf(request.getParameter("ativo"));
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;
            
        try {
            dtNasc = formatter.parse(dtNascm);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cliente p = new Cliente(idEmpresa, nome, sobrenome, sexo, cpf, dtNasc, ativo) ;
        retorno = ClienteDAO.salvar(p);
            if (retorno > 0){
            response.sendRedirect("sucesso.html");
        }


    }
    
}
