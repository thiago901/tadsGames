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
                    req.getRequestDispatcher("inputProduto?action=FormCadastrarProduto");
            dispatcher.forward(req, resp);
        } else {
        
        
            Produto p = new Produto (nome, descricao, tipo, ativo);
            try {
                retorno = ProdutoDAO.salvar(p);
                if (retorno > 0) {
                HttpSession sessao = req.getSession();
                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "cadastro de Produto";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, p);
                
                resp.sendRedirect("sucesso.html");
            }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        
        return "";
    }
}
