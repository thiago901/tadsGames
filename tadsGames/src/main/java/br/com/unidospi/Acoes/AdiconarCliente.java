/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ProdutoController;
import static br.com.unidospi.DAO.EstoqueDAO.qtdEstoque;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.model.VendaDetalhe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thiago
 */
public class AdiconarCliente implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        
        String idCliente = req.getParameter("idCliente");
        if(!idCliente.equals("")){
            sessao.setAttribute("idCliente", req.getParameter("idCliente"));
            sessao.setAttribute("nomeCliente2", req.getParameter("nomeCpf"));
            sessao.setAttribute("cpfCliente", req.getParameter("cpfCliente"));
        }
        
        resp.sendRedirect(req.getContextPath() + "/tads/inputVenda?action=FormVenda");

        return "";
    }

}
