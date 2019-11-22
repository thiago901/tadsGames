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
public class CadastrarItemVenda implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        boolean validacaoServidor = false;
        String idProdutoStr = req.getParameter("idProduto");
        int qtd = Integer.parseInt(req.getParameter("qtd"));
        UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
        String vlrUnitarioStr = req.getParameter("vlrUnitario");
        int idProduto = -1;
        
        float vlrUnitario = 0;
        
        
        
        if (idProdutoStr.length() > 50 || idProdutoStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else{
            idProduto = Integer.parseInt(idProdutoStr);
        }
        if (qtd <= 0) {
            validacaoServidor = true;
            req.setAttribute("validacaoQtd", true);
        }
        if (qtd > qtdEstoque(idProduto, usuario.getIdEmpresa())) {
            validacaoServidor = true;
            req.setAttribute("validacaoQtd2", true);
        }
        if (vlrUnitarioStr.equals("")){
            validacaoServidor = true;
            req.setAttribute("validacaoUnt", true);
        }else
            vlrUnitario = Float.parseFloat(vlrUnitarioStr);
//        if (idProdutoStr.length() > 50 || idProdutoStr.equals("")) {
//            validacaoServidor = true;
//            req.setAttribute("validacaoNome", true);
//        }else
//            idProduto = Integer.parseInt(idProdutoStr);
//        if (idProdutoStr.length() > 50 || idProdutoStr.equals("")) {
//            validacaoServidor = true;
//            req.setAttribute("validacaoNome", true);
//        }else
//            idProduto = Integer.parseInt(idProdutoStr);
        
        
        if (validacaoServidor){
            if (sessao.getAttribute("idCliente")== null){
                sessao.setAttribute("idCliente", req.getParameter("idCliente"));
                sessao.setAttribute("nomeCliente2", req.getParameter("nomeCliente"));
            }
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputVenda?action=FormVenda");
            dispatcher.forward(req, resp);
        }
        else {
            float vlrUnitarioTotal = qtd * vlrUnitario;
            if (sessao.getAttribute("itemVenda") == null) {
                sessao.setAttribute("itemVenda", new ArrayList<VendaDetalhe>());
            }

            if (sessao.getAttribute("idLinhaItemVenda") == null) {
                sessao.setAttribute("idLinhaItemVenda", 0);
                sessao.setAttribute("idCliente", req.getParameter("idCliente"));
                sessao.setAttribute("nomeCliente2", req.getParameter("nomeCliente"));
            } else {
                sessao.setAttribute("idLinhaItemVenda", (int) sessao.getAttribute("idLinhaItemVenda") + 1);
            }
            
            
            List<VendaDetalhe> itensVenda = (List<VendaDetalhe>) sessao.getAttribute("itemVenda");




            VendaDetalhe vd = new VendaDetalhe(idProduto, qtd, vlrUnitario, vlrUnitarioTotal);
            vd.setItem((int) sessao.getAttribute("idLinhaItemVenda"));
            vd.setNomeProduto(ProdutoController.listarProduto(idProduto).getNome());
            itensVenda.add(vd);

            resp.sendRedirect(req.getContextPath() + "/tads/inputVenda?action=FormVenda");
        }
        
        
        return "";
    }

}
