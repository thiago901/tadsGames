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
import br.com.unidospi.DAO.EmpresaDao;
import br.com.unidospi.DAO.EstadoRegiaoDao;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "EmpresaServelet", urlPatterns = {"/input"})
public class EmpresaController extends HttpServlet {
    
    // Recebe uma lista de Estados
    public static ArrayList<EstadoRegiao> listaEstadoRegiao(){
        return EstadoRegiaoDao.listarEstadosRegioes();
    }
    
    /* Recebe uma empresa e retorna verdadeiro caso o(s) dado(s) do registro
       da empresa sej(a)m alterados ou falso caso o contrário */
    public static boolean alterar(Empresa e) {
        return EmpresaDao.alterar(e);
    }

    // retorna uma lista de empresas
    public static ArrayList listarEmpresas() {
        return EmpresaDao.listarEmpresas();
    }

    // Recebe um identificador e retorna a empresa identificada pelo mesmo
    public static EmpresaLista listarEmpresas(int id) {
        return EmpresaDao.listarEmpresas(id);
    }

    /* Recebe requisição e resposta por parâmetro e determina qual ação será 
       realizada atraves do atributo de requisição @paramAction após varios testes */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        HttpSession sessao = req.getSession();
        
        if (sessao.getAttribute("usuario") != null) {
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
        } else {
            resp.sendRedirect(req.getContextPath() + "/inputLogin?action=FormLogin");
        }
    }

    

}
