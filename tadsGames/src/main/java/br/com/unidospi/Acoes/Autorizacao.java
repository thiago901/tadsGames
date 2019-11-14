/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */

@WebFilter(filterName = "Autorizacao")


public class Autorizacao implements Filter {

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String parametroAcao = httpRequest.getParameter("action");
        
        HttpSession sessao = httpRequest.getSession();
        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuario") == null);
        boolean ehUmaAcaoProtegida = !(parametroAcao.equals("Login") || (parametroAcao.equals("FormLogin")));
        
        if (usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
            httpResponse.sendRedirect("inputLogin?acao=FormLogin");
            return;
        }
        else {
            httpRequest.getRequestDispatcher("/WEB-INF/index.jsp")
                    .forward(httpRequest, httpResponse);
        }
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
  
    }   

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
