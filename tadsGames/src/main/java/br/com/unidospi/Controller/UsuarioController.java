/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarUsuario;
import br.com.unidospi.Acoes.FormCadastrarUsuario;
import br.com.unidospi.Acoes.ListarFuncionariosUsuarioCadastravel;
import br.com.unidospi.Acoes.ListarUsuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author henrique.abastos
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/inputUsuario"})
public class UsuarioController extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        String parametroAcao = req.getParameter("action");
        
        HttpSession sessao = req.getSession();
        
        if (sessao.getAttribute("usuario") != null) {
            if (parametroAcao.equals("ListarFuncionariosUsuarioCadastravel")) {
                ListarFuncionariosUsuarioCadastravel action = 
                        new ListarFuncionariosUsuarioCadastravel();
                action.executa(req, resp);
            } else if (parametroAcao.equals("FormCadastrarUsuario")) {
                FormCadastrarUsuario action = new FormCadastrarUsuario();
                action.executa(req, resp);
            } else if (parametroAcao.equals("CadastrarUsuario")) {
                CadastrarUsuario action = new CadastrarUsuario();
                action.executa(req, resp);
            } else if (parametroAcao.equals("ListarUsuarios")) {
                ListarUsuarios action = new ListarUsuarios();
                action.executa(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/inputLogin?action=FormLogin");
        }
    }
}
