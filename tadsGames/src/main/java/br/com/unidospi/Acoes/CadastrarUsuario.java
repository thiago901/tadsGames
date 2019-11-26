/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class CadastrarUsuario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {      
        int retorno = 0;
        String idFuncionarioStr = req.getParameter("idFuncionario");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        LocalDate dtCadastro = LocalDate.now();
        
        
        int idFuncionario = Integer.parseInt(idFuncionarioStr);
        
        boolean validacaoServidor = false;
        
        if (login.length() > 50 || login.length()< 2 || login.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else if (login.substring(0, 1).matches("[A-z 0-9.]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (senha.length() > 16 || senha.trim().equals("") || senha.length() < 6 ) {
            validacaoServidor = true;
            req.setAttribute("erroSenha", true);
        }else if (login.substring(0, 1).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("erroSenha2", true);
        }
        
        if (validacaoServidor){
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("inputUsuario?action=FormCadastrarUsuario");
            dispatcher.forward(req, resp);
        }
        else {
            Date dDtCadastro = Date.from(dtCadastro.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            
            Usuario usuario = new Usuario(login, senha, dDtCadastro, status, idFuncionario);

            retorno = UsuarioDAO.salvar(usuario);
            if (retorno > 0){
                HttpSession sessao = req.getSession();
                UsuarioFuncionario u = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "cadastro de Usuario";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, u);
                
                resp.sendRedirect(req.getContextPath() + "/sucesso.html");
            }
        }
        return "";
    }
    
}
