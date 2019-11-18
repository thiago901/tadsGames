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

@WebFilter(filterName = "Autorizacao",
        servletNames = { "HomeServlet", "FuncionarioController",
                        "ClienteController", "ProdutoController"},
        urlPatterns = { "/tads/*" })
public class Autorizacao implements Filter {

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String parametroAcao = httpRequest.getParameter("action");
        
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");//PROFESSOR
            return;
        }
        // Verificar se usuario tem permissao de acesso na pagina
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        if (verificarPermissaoAcesso(httpRequest, usuario)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }
    }
    
    private boolean verificarPermissaoAcesso(
            HttpServletRequest httpRequest, UsuarioFuncionario usuario) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/home")) {
            return true;
        } else if (urlAcessada.endsWith("/tads/inputFuncionario") 
                && usuario.getCargo().equals("Diretor")) {
            return true;
        } else if (urlAcessada.endsWith("/tads/inputCliente")
                && usuario.getCargo().equals("Diretor")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputEmpresa")
                && usuario.getCargo().equals("Diretor")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputProduto")
                && usuario.getDepartamento().equals("Retaguarda")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputUsuario")
                && usuario.getCargo().equals("Diretor")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputCompra")
                && usuario.getCargo().equals("Diretor")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputRelatorios")
                && usuario.getCargo().equals("Diretor")) {
            return true;
        }else if (urlAcessada.endsWith("/tads/inputVenda")
                && usuario.getDepartamento().equals("Vendas")) {
            return true;
        }
        return false;
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
  
    }   

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
