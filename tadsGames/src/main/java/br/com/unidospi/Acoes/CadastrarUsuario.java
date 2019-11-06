/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        Usuario usuario = new Usuario(login, senha, dtCadastro, status, idFuncionario);
        
        retorno = UsuarioDAO.salvar(usuario);
        if (retorno > 0)
            resp.sendRedirect("sucesso.html");
        
        return "";
    }
    
}