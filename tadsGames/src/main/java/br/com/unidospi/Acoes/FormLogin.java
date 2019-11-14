/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

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
public class FormLogin implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        if (sessao.getAttribute("usuario") != null) {
            resp.sendRedirect(req.getContextPath() + "/inputHome");
            return "";
        }
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("WEB-INF/jsp/login/Login.jsp");
        dispatcher.forward(req, resp);
        return "";
    }
    
}
