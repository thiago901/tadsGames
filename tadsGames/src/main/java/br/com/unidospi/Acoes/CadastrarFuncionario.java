/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCPF.isCPF;
import br.com.unidospi.DAO.FuncionarioDAO;
import static br.com.unidospi.DAO.FuncionarioDAO.validaNovoCPF;
import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class CadastrarFuncionario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        //String idEmpresa = req.getParameter("idEmpresa");
        String strIdEmpresa = req.getParameter("tpEmpresa");
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String cpfStr = req.getParameter("cpf");
        String dtNascStr = req.getParameter("dtNasc");
        String salarioStr = req.getParameter("salario");
        String deptoStr = req.getParameter("depto");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
//        int idEmpresaSelecionada = Integer.parseInt(req.getParameter("tpEmpresa"));            
        int idEmpresaSelecionada = 0;
        String cargo = req.getParameter("tpFuncionario");
        String sexo = req.getParameter("sexo");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;

        try {
            dtNasc = formatter.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //VALIDAÇÃO PROVISÓRIA------------------------------------------------
        boolean validacaoServidor = false;
        boolean testeCPF;
        boolean cpfDisponivel;
        testeCPF = isCPF(cpfStr);
        cpfDisponivel = validaNovoCPF(cpfStr);
        
        if (nome.length() > 50 || nome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        } else if (nome.matches("[A-z]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (sobrenome.length() > 50 || sobrenome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome", true);
        } else if (sobrenome.matches("[A-z]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome2", true);
        }
        if (testeCPF == false  || cpfDisponivel==false) {
            validacaoServidor = true;
            req.setAttribute("validacaoCPF", true);
        }
        if (dtNascStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoDtNasc", true);
        }
        if (strIdEmpresa == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoEmpresa", true);

        } else {
            idEmpresaSelecionada = Integer.parseInt(strIdEmpresa);
        }
        if (salarioStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSalario", true);
        } else if (salarioStr.matches("[0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoSalario2", true);
        }
        if (deptoStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoDept", true);
        }
        if (cargo == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoCargo", true);
        }
        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputFuncionario?action=FormCadastrarFuncionario");
            dispatcher.forward(req, resp);
        } else {
            Funcionario funcionario = new Funcionario(
                    Double.parseDouble(salarioStr), deptoStr, cargo,
                    idEmpresaSelecionada, nome, sobrenome, sexo, cpfStr,
                    dtNasc, status);
            FuncionarioDAO.salvar(funcionario);
            
            HttpSession sessao = req.getSession();
            UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
            String acao = "cadastro de Funcionario";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, funcionario);
            resp.sendRedirect("sucesso.html");
            
        }

        return "";
    }

}
