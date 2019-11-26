/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.VendaDetalhe;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class ExcluirItemVenda implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        HttpSession sessao = req.getSession();
        int itemVenda =Integer.parseInt(req.getParameter("itemVenda"));
        List<VendaDetalhe> l = (List<VendaDetalhe>) sessao.getAttribute("itemVenda");
        float vlrTotal = (float) sessao.getAttribute("vlrTotal");
        float vlrTotalAtual = vlrTotal-l.get(itemVenda).getVlrTotal();
        if(vlrTotalAtual==0){
            sessao.removeAttribute("vlrTotal");
        }else{
            sessao.setAttribute("vlrTotal", vlrTotalAtual);
        }
        
        l.remove(itemVenda);
        sessao.setAttribute("idLinhaItemVenda", (int) sessao.getAttribute("idLinhaItemVenda") - 1);
        for(int i = 0;i<l.size();i++){
            l.get(i).setItem(i);
        }
        resp.sendRedirect(req.getContextPath() + "/tads/inputVenda?action=FormVenda");
        
        return "";
    }
    
}
