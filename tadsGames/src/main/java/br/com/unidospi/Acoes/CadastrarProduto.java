/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class CadastrarProduto implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int retorno;
        
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        boolean ativo = Boolean.valueOf(req.getParameter("ativo"));                
        
        boolean validacaoServidor = false;
        
        if (nome.length() < 1 || nome.length() > 25) {
            validacaoServidor = true;
            req.setAttribute("erroNome", true);
        }
        
        if (tipo == null) {
            validacaoServidor = true;
            req.setAttribute("erroTipo", true);
        }
        
        if (validacaoServidor) {
            
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("Produto/Produto.jsp");
            dispatcher.forward(req, resp);
        } else {
        
        
            Produto p = new Produto (nome, descricao, tipo, ativo);
            try {
                retorno = ProdutoDAO.salvar(p);
                if (retorno > 0) {
                resp.sendRedirect("sucesso.html");
            }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        
        return "";
    }
}
