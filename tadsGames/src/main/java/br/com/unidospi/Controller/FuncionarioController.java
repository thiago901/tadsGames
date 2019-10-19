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
@WebServlet(name = "FuncionarioController", urlPatterns = {"/novoFuncionario"})
public class FuncionarioController extends HttpServlet {
    
    HashMap<String, Integer> mapaEmpresas = new HashMap<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Empresa> listaEmpresas = FuncionarioDAO.obterEmpresas();
        ArrayList<Funcionario> listaFuncionarios = FuncionarioDAO.obterFuncionario();
                        
        for (Empresa empresa : listaEmpresas) 
            mapaEmpresas.put(empresa.getNome(), empresa.getCod());
          
        request.setAttribute("empresasAttr", listaEmpresas);
        request.setAttribute("funcionariosAttr", listaFuncionarios);
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/Funcionario/Funcionario.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                                                
            
            int idEmpresaSelecionada = 0;
            String idEmpresa = request.getParameter("idEmpresa");
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String cpfStr = request.getParameter("cpf");
            String dtNascStr = request.getParameter("dtNasc");
            String salarioStr = request.getParameter("salario");
            String deptoStr = request.getParameter("depto");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            String empresaSelecionada = request.getParameter("tpEmpresa");            
            String cargo = request.getParameter("tpFuncionario");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String sexo = request.getParameter("sexo");
                                    
            Set<String> chavesMapaEmpresas = mapaEmpresas.keySet();
            
            for (String chave : chavesMapaEmpresas) {
                if (chave.equals(empresaSelecionada))
                    idEmpresaSelecionada = mapaEmpresas.get(chave);
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dtNasc = null;
            
        try {
            dtNasc = formatter.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            switch (cargo) {
                case "Funcionario Venda" :
                    FuncionarioVenda funcionarioVenda = new FuncionarioVenda(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Venda", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, sexo, cpfStr, 
                            dtNasc, status);

                    FuncionarioDAO.salvar(funcionarioVenda);
                    break;
                case "Funcionario Administrativo" :
                    FuncionarioAdministrativo funcionarioAdm = new FuncionarioAdministrativo(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Administrativo", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.salvar(funcionarioAdm);
                    break;
                case "Diretor" :
                    Diretor diretor = new Diretor(
                            Double.parseDouble(salarioStr), deptoStr, "Diretor", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.salvar(diretor);
                    break;
                case "Funcionario TI" :
                    FuncionarioTI funcionarioTI = new FuncionarioTI(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario TI", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.salvar(funcionarioTI);
                    break;
                case "Gerente Global" :
                    GerenteGlobal gerenteGlobal = new GerenteGlobal(
                            Double.parseDouble(salarioStr), deptoStr, "Gerente Global", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, 
                            sexo, cpfStr, dtNasc, status);
                    FuncionarioDAO.salvar(gerenteGlobal);
                    break;
                case "Funcionario Retaguarda" :
                    FuncionarioRetaguarda funcionarioRetaguarda = new FuncionarioRetaguarda(
                            Double.parseDouble(salarioStr), deptoStr, "Funcionario Retaguarda", login,
                            senha, idEmpresaSelecionada, nome, sobrenome, sexo, 
                            cpfStr, dtNasc, status);
                    FuncionarioDAO.salvar(funcionarioRetaguarda);
                    break;
            }
                                    
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("Funcionario/resultado.jsp");
            dispatcher.forward(request, response);

    }
}
