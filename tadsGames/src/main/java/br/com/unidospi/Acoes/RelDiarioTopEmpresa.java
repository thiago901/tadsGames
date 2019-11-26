/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.RelatoriosController;
import br.com.unidospi.model.RelatorioGeral;
import br.com.unidospi.model.RelatorioTop10;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class RelDiarioTopEmpresa implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        HttpSession sessao = req.getSession();
        
        int idEmpresa = Integer.parseInt(req.getParameter("top10DetalheEmpresa"));
        sessao.setAttribute("top10DetalheEmpresa", idEmpresa);
        ArrayList<RelatorioTop10> rel_top10_vendas_dia = RelatoriosController.rel_top10_vendas_dia(idEmpresa);
        sessao.setAttribute("top10Empresa", rel_top10_vendas_dia);

       
        
        
        resp.sendRedirect(req.getContextPath()+ "/tads/inputRelatorios?action=RelatorioDiario");
        
        return "";
    }
    
    
    
}
