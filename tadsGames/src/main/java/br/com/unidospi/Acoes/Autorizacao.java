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
        servletNames = { "HomeServlet", "FuncionarioController", "EmpresaController", "CompraController", 
                        "ClienteController", "ProdutoController", "RelatoriosController", "UsuarioController",
                        "VendaController"},
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
        }///////// ACESSO RETAGUARDA ///////
        else if ((urlAcessada.endsWith("/tads/inputProduto")||(urlAcessada.endsWith("/tads/inputCompra"))) 
                && (usuario.getCargo().equals("Diretor")|| usuario.getDepartamento().equals("Retaguarda"))) {
            return true;
        //////////ACESSO VENDA///////////////
        }else if ((urlAcessada.endsWith("/tads/inputVenda")||urlAcessada.endsWith("/tads/inputCliente")||urlAcessada.endsWith("/tads/inputProduto"))
                && (usuario.getCargo().equals("Diretor")||usuario.getDepartamento().equals("Vendas"))) {
            return true;
        /////////ACESSO TI///////////////
        }else if (urlAcessada.endsWith("/tads/inputUsuario")
                && (usuario.getCargo().equals("Diretor")||usuario.getDepartamento().equals("TI"))) {
            return true;
        /////////ACESSO ADMINISTRATIVO//////////
        }else if ((urlAcessada.endsWith("/tads/inputFuncionario")||urlAcessada.endsWith("/tads/input")) 
                && (usuario.getCargo().equals("Diretor")||usuario.getDepartamento().equals("Administrativo"))) {
            return true;
        //////////ACESSO A RELATÓRIOS/////////////
        } else if (urlAcessada.endsWith("/tads/inputRelatorios")
                && (usuario.getCargo().equals("Diretor")||usuario.getCargo().equals("Gerente Global")||
                usuario.getCargo().equals("Gerente Regional"))) {
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
