/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.RelatoriosController;
import br.com.unidospi.DAO.RelatorioDao;
import br.com.unidospi.model.RelatorioFaturaDia;
import br.com.unidospi.model.RelatorioPercentagem;
import br.com.unidospi.model.RelatorioTop10;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class Relatorio implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<RelatorioTop10> rel_top10_vendas_dia = RelatoriosController.rel_top10_vendas_dia();
        ArrayList<RelatorioFaturaDia> rel_fatura_dia =RelatoriosController.rel_fatura_dia();
        ArrayList<RelatorioPercentagem> rel_total_empresa_porcentagem = RelatoriosController.rel_total_empresa_porcentagem();
        req.setAttribute("top10", rel_top10_vendas_dia);
        req.setAttribute("faturaDia", rel_fatura_dia);
        req.setAttribute("totalEmpresa", rel_total_empresa_porcentagem);
        
        RequestDispatcher rd = req.getRequestDispatcher("tads/WEB-INF/jsp/Relatorio/Relatorio.jsp");
        rd.forward(req, resp);
        return "";
    }
    
    
    
}
