/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.FormLogin;
import br.com.unidospi.Acoes.Login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.gisidorio
 */

@WebServlet(name = "LoginController", urlPatterns = {"/inputLogin"})
public class LoginController extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        String parametroAcao = req.getParameter("action");
        
        if (parametroAcao.equals("FormLogin")) {
            FormLogin action = new FormLogin();
            action.executa(req, resp);
        } else if (parametroAcao.equals("Login")) {
            Login action = new Login();
            action.executa(req, resp);
        }
    }
}
