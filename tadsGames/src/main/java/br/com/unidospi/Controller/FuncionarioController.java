/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarFuncionario;
import br.com.unidospi.Acoes.EditarFuncionario;
import br.com.unidospi.Acoes.FormCadastrarFuncionario;
import br.com.unidospi.Acoes.FormEditarFuncionario;
import br.com.unidospi.Acoes.ListarFuncionarios;
import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.Diretor;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.FuncionarioAdministrativo;
import br.com.unidospi.model.FuncionarioEmpresa;
import br.com.unidospi.model.FuncionarioRetaguarda;
import br.com.unidospi.model.FuncionarioTI;
import br.com.unidospi.model.FuncionarioVenda;
import br.com.unidospi.model.GerenteGlobal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
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
@WebServlet(name = "FuncionarioController", urlPatterns = {"/inputFuncionario"})
public class FuncionarioController extends HttpServlet {
    
    /* Recebe requisição e resposta por parâmetro e determina qual ação será 
       realizada atraves do atributo de requisição @paramAction após varios testes */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String parametroAcao = req.getParameter("action");
        
        if (parametroAcao.equals("FormCadastrarFuncionario")) {
            ArrayList<FuncionarioEmpresa> listaFuncionarios = FuncionarioDAO.obterFuncionarios();
            ArrayList<Empresa> listaEmpresas = EmpresaController.listarEmpresas();
            req.setAttribute("funcionarios", listaFuncionarios);
            req.setAttribute("empresas", listaEmpresas);
            FormCadastrarFuncionario acao = new FormCadastrarFuncionario();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("CadastrarFuncionario")) {
            CadastrarFuncionario acao = new CadastrarFuncionario();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("FormEditarFuncionario")) {
            FormEditarFuncionario acao = new FormEditarFuncionario();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("EditarFuncionario"))  {
            EditarFuncionario acao = new EditarFuncionario();
            acao.executa(req, resp);
        } else if (parametroAcao.equals("ListarFuncionarios")) {
            ListarFuncionarios acao = new ListarFuncionarios();
            acao.executa(req, resp);
        }
    } 
}
