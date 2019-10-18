/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarCliente;
import br.com.unidospi.Acoes.EditarCliente;
import br.com.unidospi.Acoes.FormCadastrarCliente;
import br.com.unidospi.Acoes.FormEditarCliente;

import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
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


@WebServlet(name = "ClienteController", urlPatterns = {"/inputCliente"})
public class ClienteController extends HttpServlet{
    
    
    public static ArrayList<ClienteLista> listarClientes(){
        return ClienteDAO.listarClientes();
    }
    public static ClienteLista listarClientes(int id){
        return ClienteDAO.listarClientes(id);
    }

    
    
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        if(paramAction.equals("FormCadastrarCliente")){
            ArrayList<ClienteLista> listaClientes= ClienteController.listarClientes();
            ArrayList<ClienteLista> listaEmpresa= EmpresaController.listarEmpresas();
            req.setAttribute("listaEmpresa", listaEmpresa);
            req.setAttribute("listaCliente", listaClientes);
            FormCadastrarCliente action = new FormCadastrarCliente();
            action.executa(req,resp);
            
        }else if(paramAction.equals("CadastrarCliente")){
            CadastrarCliente action = new CadastrarCliente();
            action.executa(req,resp);
            
        }else if(paramAction.equals("EditarCliente")){
            EditarCliente action = new EditarCliente();
            action.executa(req,resp);
            
        }else if(paramAction.equals("FormEditarCliente")){
            ArrayList<ClienteLista> listaClientes= ClienteController.listarClientes();
            ArrayList<ClienteLista> listaEmpresa= EmpresaController.listarEmpresas();
            req.setAttribute("listaEmpresa", listaEmpresa);
            req.setAttribute("listaCliente", listaClientes);
            FormEditarCliente action = new FormEditarCliente();
            action.executa(req,resp);
            
        }
    }

    
    
}
