/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class FormEditarUsuario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("idUsuario"));
        Usuario usuario = UsuarioDAO.obterUsuarioPorId(id);
        req.setAttribute("u", usuario);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/usuario/EditarUsuario.jsp");
        dispatcher.forward(req, resp);
        return "";
    }
    
}
