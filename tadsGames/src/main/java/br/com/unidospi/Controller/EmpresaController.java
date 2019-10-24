/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarEmpresa;
import br.com.unidospi.Acoes.EditarEmpresa;
import br.com.unidospi.Acoes.FormCadastrarEmpresa;
import br.com.unidospi.Acoes.FormEditarEmpresa;
import br.com.unidospi.Acoes.ListarEmpresas;
import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.DAO.EmpresaDao;
import br.com.unidospi.DAO.EstadoRegiaoDao;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.EstadoRegiao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "EmpresaServelet", urlPatterns = {"/input"})
public class EmpresaController extends HttpServlet {
    
    public static ArrayList<EstadoRegiao> listaEstadoRegiao(){
        return EstadoRegiaoDao.listarEstadosRegioes();
    }

    public static boolean alterar(Empresa e) {
        return EmpresaDao.alterar(e);
    }

    public static ArrayList listarEmpresas() {
        return EmpresaDao.listarEmpresas();
    }

    public static EmpresaLista listarEmpresas(int id) {
        return EmpresaDao.listarEmpresas(id);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        if(paramAction.equals("ListarEmpresas")){
            ListarEmpresas action = new ListarEmpresas();
            action.executa(req,resp);
            
        }else if(paramAction.equals("FormEditarEmpresa")){
            FormEditarEmpresa action = new FormEditarEmpresa();
            action.executa(req,resp);
            
            
        }else if(paramAction.equals("EditarEmpresa")){
        EditarEmpresa action =new EditarEmpresa();
            action.executa(req,resp);
            
        }else if(paramAction.equals("FormCadastrarEmpresa")){
        FormCadastrarEmpresa action =new FormCadastrarEmpresa();
            action.executa(req,resp);
        }
        else if(paramAction.equals("CadastrarEmpresa")){
            CadastrarEmpresa action = new CadastrarEmpresa();
            action.executa(req,resp);
        }
        
        
    }

    

}
