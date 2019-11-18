/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.FormIndex;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco.assilva8
 */

@WebServlet(name = "IndexController", urlPatterns = {"/indexHome"})
public class IndexController extends HttpServlet{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        FormIndex action = new FormIndex();
        action.executa(req, resp);   
    
    }
}
