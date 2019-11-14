/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.model.VendaDetalhe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thiago
 */
public class CadastrarItemVenda implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        if(sessao.getAttribute("itemVenda")==null){
            sessao.setAttribute("itemVenda", new ArrayList<VendaDetalhe>());
        }
        
         if(sessao.getAttribute("idLinhaItemVenda")==null){
            sessao.setAttribute("idLinhaItemVenda", 0);
         }else{
            sessao.setAttribute("idLinhaItemVenda", (int) sessao.getAttribute("idLinhaItemVenda")+1); 
         }
        sessao.setAttribute("idCliente", req.getParameter("idCliente"));
        sessao.setAttribute("idCliente", req.getParameter("idCliente"));

        sessao.setAttribute("nomeCliente2", req.getParameter("nomeCliente"));
        
        List<VendaDetalhe> itensVenda = (List<VendaDetalhe>)sessao.getAttribute("itemVenda");
           
        
            int idProduto = Integer.parseInt(req.getParameter("idProduto"));
            int qtd =Integer.parseInt(req.getParameter("qtd"));
            System.out.println("Quantidade é "+qtd);
            float vlrUnitario = Float.parseFloat(req.getParameter("vlrUnitario"));
            float vlrUnitarioTotal = qtd*vlrUnitario;

            
            VendaDetalhe vd = new VendaDetalhe(idProduto, qtd, vlrUnitario, vlrUnitarioTotal);
            vd.setItem((int) sessao.getAttribute("idLinhaItemVenda"));
            vd.setNomeProduto(ProdutoController.listarProduto(idProduto).getNome());
            itensVenda.add(vd);

        resp.sendRedirect(req.getContextPath() + "/inputVenda?action=FormVenda");
        return "";
    }
    
}
