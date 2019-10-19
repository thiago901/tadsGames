/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.Diretor;
import br.com.unidospi.model.FuncionarioAdministrativo;
import br.com.unidospi.model.FuncionarioRetaguarda;
import br.com.unidospi.model.FuncionarioTI;
import br.com.unidospi.model.FuncionarioVenda;
import br.com.unidospi.model.GerenteGlobal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class CadastrarFuncionario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        String idEmpresa = req.getParameter("idEmpresa");
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String cpfStr = req.getParameter("cpf");
        String dtNascStr = req.getParameter("dtNasc");
        String salarioStr = req.getParameter("salario");
        String deptoStr = req.getParameter("depto");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        int idEmpresaSelecionada = Integer.parseInt(req.getParameter("tpEmpresa"));            
        String cargo = req.getParameter("tpFuncionario");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String sexo = req.getParameter("sexo");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;
            
        try {
            dtNasc = formatter.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return "";
    }
    
}
