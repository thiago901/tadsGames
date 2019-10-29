/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class EditarProduto implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean retorno;
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        boolean ativo = Boolean.valueOf(req.getParameter("ativo"));
        
        boolean validacaoServidor = false;
        
        if (nome.length() < 1 || nome.length() > 50) {
            validacaoServidor = true;
            req.setAttribute("erroNome", true);
        }
        
        if (tipo == null) {
            validacaoServidor = true;
            req.setAttribute("erroTipo", true);
        }
        
        if (validacaoServidor) {
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("inputProduto?action=FormEditarProduto&idProduto=" +
                            Integer.parseInt(req.getParameter("id")));
            dispatcher.forward(req, resp);
        }

        Produto p = new Produto (Integer.parseInt(req.getParameter("id")), nome, descricao, tipo, ativo);
        retorno = ProdutoDAO.editar(p);
        if (retorno) {
            resp.sendRedirect("sucesso.html");
        }
        return "";
    }
    
}
