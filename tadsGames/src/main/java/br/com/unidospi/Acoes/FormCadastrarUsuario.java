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

/**
 *
 * @author gabri
 */
public class FormCadastrarUsuario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        int idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
        
        UsuarioFuncionario usuarioFuncionario = 
                UsuarioDAO.obterUsuarioFuncionarioPorId(idFuncionario);
        
        req.setAttribute("f", usuarioFuncionario);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("Usuario/CadastrarUsuario.jsp");
        dispatcher.forward(req, resp);
        return "";
    }
    
}
