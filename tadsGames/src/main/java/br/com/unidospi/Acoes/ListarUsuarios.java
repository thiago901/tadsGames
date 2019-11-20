/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.UsuarioFuncionario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.gisidorio
 */
public class ListarUsuarios implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        ArrayList<UsuarioFuncionario> listaUsuarios = UsuarioDAO.obterUsuarios();
        req.setAttribute("usuarios", listaUsuarios);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/usuario/listarUsuarios.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
