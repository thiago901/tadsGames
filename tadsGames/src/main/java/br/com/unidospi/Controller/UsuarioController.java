/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henrique.abastos
 */
public class UsuarioController extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) {
        
        String parametroAcao = req.getParameter("action");
        
        
    }
}
