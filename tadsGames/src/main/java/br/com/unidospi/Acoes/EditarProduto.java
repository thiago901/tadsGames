/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class EditarProduto implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean retorno = false;
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
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputProduto?action=FormEditarProduto&idProduto="
                            + Integer.parseInt(req.getParameter("idProduto")));
            dispatcher.forward(req, resp);
            return "";
        }
        Produto p = new Produto(Integer.parseInt(req.getParameter("idProduto")), nome, descricao, tipo, ativo);
        retorno = ProdutoDAO.editar(p);

        if (retorno) {
            HttpSession sessao = req.getSession();
            UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
            String acao = "edição de Produto";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, p);
            
            resp.sendRedirect(req.getContextPath() + "/sucesso.html");
        }
        
        return "";
    }

}
