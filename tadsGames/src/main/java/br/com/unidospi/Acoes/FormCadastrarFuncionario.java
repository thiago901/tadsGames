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

/**
 *
 * @author gabri
 */
public class FormCadastrarFuncionario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("/WEB-INF/jsp/funcionario/Funcionario.jsp");
        dispatcher.forward(req, resp);
        
        return "";
    }
    
}
