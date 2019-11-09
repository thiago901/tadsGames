/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.UsuarioFuncionario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.gisidorio
 */
public class Login implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        UsuarioFuncionario usuario = UsuarioDAO.obterUsuarioLogado(login, senha);
        
        if (usuario != null) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario", usuario);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
//            dispatcher.forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            req.setAttribute("msgErro", "Usuario inexistente ou senha inválida");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login/Login.jsp");
            dispatcher.forward(req, resp);
        }
        return "";
    }
    
}
