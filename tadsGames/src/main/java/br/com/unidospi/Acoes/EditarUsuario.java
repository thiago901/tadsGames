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
public class EditarUsuario implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("idUsuario"));
        String username = req.getParameter("login");
        String senha = req.getParameter("senha");
        boolean status = Boolean.valueOf(req.getParameter("status"));
        
        boolean validacaoServidor = false;
        
        if (username.length() > 50 || username.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else if (username.substring(0, 2).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (senha.length() > 16 || username.equals("") || senha.length() < 6 ) {
            validacaoServidor = true;
            req.setAttribute("erroSenha", true);
        }else if (username.substring(0, 2).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("erroSenha2", true);
        } 
        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputUsuario?action=FormEditarUsuario&idUsuario="
                            + Integer.parseInt(req.getParameter("idUsuario")));
            dispatcher.forward(req, resp);
        }
        else {            
            Usuario usuario = new Usuario(id, username, senha, status);
            boolean retorno = UsuarioDAO.editar(usuario);

            if (retorno) {
                resp.sendRedirect(req.getContextPath() + "/sucesso.html");
            }
        }
        
        return "";
    }
    
}
