/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

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
import java.io.PrintWriter;
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
 * @author gabri
 */
@WebServlet(name = "AlterarFuncionarioController", urlPatterns = {"/alterarFuncionario"})
public class AlterarFuncionarioController extends HttpServlet {
    
    HashMap<String, Integer> mapaEmpresas = new HashMap<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
//        Funcionario funcionario = FuncionarioDAO.obterFuncionarioPorId(id);
        ArrayList<Empresa> listaEmpresas = FuncionarioDAO.obterEmpresas();
        
        
        FuncionarioEmpresa funcionarioEmpresa = FuncionarioDAO.obterFuncionarioEmpresaPorId(id);
        
        for (Empresa empresa : listaEmpresas) 
            mapaEmpresas.put(empresa.getNome(), empresa.getCod());
        
//        request.setAttribute("funcionarioAttr", funcionario);
        request.setAttribute("empresasAttr", listaEmpresas);
        
        request.setAttribute("fe", funcionarioEmpresa);
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("Funcionario/AlterarFuncionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("idFuncionario"));
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String cpfStr = request.getParameter("cpf");
            String dtNascStr = request.getParameter("dtNasc");
            String salarioStr = request.getParameter("salario");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            String deptoStr = request.getParameter("depto");
            int empresaSelecionada = Integer.parseInt(request.getParameter("tpEmpresa"));
            String tpFuncStr = request.getParameter("tpFuncionario");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String sexo = request.getParameter("sexo");
                                    
            Set<String> chavesMapaEmpresas = mapaEmpresas.keySet();;
            
//            for (String chave : chavesMapaEmpresas) {
//                if (chave.equals(empresaSelecionada))
//                    idEmpresaSelecionada = mapaEmpresas.get(chave);
//            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dtNasc = null;
            
        try {
            dtNasc = formatter.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            switch (tpFuncStr) {
                case "Funcionario Venda" :
                    FuncionarioVenda funcionarioVenda = new FuncionarioVenda(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Venda", login,
                            senha, id, empresaSelecionada, nome, sobrenome, sexo, cpfStr, 
                            dtNasc, status);

                    FuncionarioDAO.alterar(funcionarioVenda);
                    break;
                case "Funcionario Administrativo" :
                    FuncionarioAdministrativo funcionarioAdm = new FuncionarioAdministrativo(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Administrativo", login,
                            senha, id, empresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.alterar(funcionarioAdm);
                    break;
                case "Diretor" :
                    Diretor diretor = new Diretor(
                            Double.parseDouble(salarioStr), deptoStr, "Diretor", login,
                            senha, id, empresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.alterar(diretor);
                    break;
                case "Funcionario TI" :
                    FuncionarioTI funcionarioTI = new FuncionarioTI(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario TI", login,
                            senha, id, empresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.alterar(funcionarioTI);
                    break;
                case "Gerente Global" :
                    GerenteGlobal gerenteGlobal = new GerenteGlobal(
                            Double.parseDouble(salarioStr), deptoStr, "Gerente Global", login,
                            senha, id, empresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.alterar(gerenteGlobal);
                    break;
                case "Funcionario Retaguarda" :
                    FuncionarioRetaguarda funcionarioRetaguarda = new FuncionarioRetaguarda(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Retaguarda", login,
                            senha, id, empresaSelecionada, nome, sobrenome, sexo, 
                            cpfStr, dtNasc, status);
                    FuncionarioDAO.alterar(funcionarioRetaguarda);
                    break;
            }
                                    
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("Funcionario/resultado.jsp");
            dispatcher.forward(request, response);
    }
}
