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
import br.com.unidospi.Acoes.ListarCliente;
import br.com.unidospi.Acoes.ListarCliente2;

import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
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
 * @author henrique.abastos
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/tads/inputCliente"})
public class ClienteController extends HttpServlet {

    // Retorna uma lista de clientes
    public static ArrayList<ClienteLista> listarClientes() {
        return ClienteDAO.listarClientes();
    }
    public static ArrayList<ClienteLista> listarClientesPaginado(int offset) {
        return ClienteDAO.listarClientesPaginado(offset);
    }
    public static int qtdRegitro() {
        return ClienteDAO.qtdRegitro();
    }
    public static ArrayList<Cliente> listarClientes(String nomePesquisado) {
        return ClienteDAO.listarClientes(nomePesquisado);
    }
    
    /* Recebe um identificador de um cliente e retorna 
       o cliente identificado */
    public static ClienteLista listarClientes(int id) {
        return ClienteDAO.listarClientes(id);
    }

    /* Recebe requisição e resposta por parâmetro e determina qual ação será 
       realizada atraves do atributo de requisição @paramAction após varios testes */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String paramAction = req.getParameter("action");
        
        HttpSession sessao = req.getSession();
        
        if (sessao.getAttribute("usuario") != null) {
            if (paramAction.equals("FormCadastrarCliente")) {
                ArrayList<ClienteLista> listaClientes = ClienteController.listarClientes();
                ArrayList<ClienteLista> listaEmpresa = EmpresaController.listarEmpresas();
                req.setAttribute("listaEmpresa", listaEmpresa);
                req.setAttribute("listaCliente", listaClientes);
                FormCadastrarCliente action = new FormCadastrarCliente();
                action.executa(req, resp);

            } else if (paramAction.equals("CadastrarCliente")) {
                CadastrarCliente action = new CadastrarCliente();
                action.executa(req, resp);

            } else if (paramAction.equals("EditarCliente")) {
                EditarCliente action = new EditarCliente();
                action.executa(req, resp);

            } else if (paramAction.equals("FormEditarCliente")) {
                ArrayList<ClienteLista> listaClientes = ClienteController.listarClientes();
                ArrayList<ClienteLista> listaEmpresa = EmpresaController.listarEmpresas();
                req.setAttribute("listaEmpresa", listaEmpresa);
                req.setAttribute("listaCliente", listaClientes);
                FormEditarCliente action = new FormEditarCliente();
                action.executa(req, resp);

            } else if (paramAction.equals("ListarCliente")) {
                ListarCliente action = new ListarCliente();
                action.executa(req, resp);
            }
            else if (paramAction.equals("ListarCliente2")) {
                ListarCliente2 action = new ListarCliente2();
                action.executa(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/inputLogin?action=FormLogin");
        }
    }

}
