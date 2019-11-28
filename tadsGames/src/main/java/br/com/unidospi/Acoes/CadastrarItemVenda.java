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
        String idProdutoStr = req.getParameter("inputIdProduto");
        int qtdEstoque = Integer.parseInt(req.getParameter("qtdEstoque"));
        int qtd = Integer.parseInt(req.getParameter("quantideComprada"));
        UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
        String vlrUnitarioStr = req.getParameter("inputVlrUnitario");
        int idProduto = -1;
        int auxTotal = 0;
        float vlrUnitario = 0;
        
        
        
        if (idProdutoStr.length() > 50 || idProdutoStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else{
            idProduto = Integer.parseInt(idProdutoStr);
            req.setAttribute("idProduto", idProduto);
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

        
        
        if (validacaoServidor){
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputVenda?action=FormVenda");
            dispatcher.forward(req, resp);
        }else {
            float vlrUnitarioTotal = qtd * vlrUnitario;
            if (sessao.getAttribute("itemVenda") == null) {
                sessao.setAttribute("itemVenda", new ArrayList<VendaDetalhe>());
            }
//            else {
//                ArrayList<VendaDetalhe> aux = new ArrayList<>();
//                for (int i = 0; i < aux.size(); i++) {
//                    if (i == Integer.parseInt(req.getAttribute("idProduto").toString())){
//                        for (int j = 0; j < aux.size(); j++){
//                            auxTotal = auxTotal + aux.get(j).getQtdVenda();
//                            if (auxTotal > qtdEstoque){
//                                validacaoServidor = true;
//                            }
//                        }
//                        auxTotal = 0;
//                    }
//                }
//                
//            }
                

            if (sessao.getAttribute("idLinhaItemVenda") == null) {
                sessao.setAttribute("idLinhaItemVenda", 0);
            } else {
                sessao.setAttribute("idLinhaItemVenda", (int) sessao.getAttribute("idLinhaItemVenda") + 1);
                
            }
            if(sessao.getAttribute("vlrTotal") == null){
                sessao.setAttribute("vlrTotal", Float.parseFloat(req.getParameter("inputVlrTotal")));
            }else{
                float vlr = (float) sessao.getAttribute("vlrTotal");
                float vlrAnterior = Float.parseFloat(req.getParameter("inputVlrTotal"));
                sessao.setAttribute("vlrTotal", vlrAnterior+vlr);
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
