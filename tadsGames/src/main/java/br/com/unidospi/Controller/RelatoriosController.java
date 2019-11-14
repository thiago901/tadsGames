/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.Relatorio;
import br.com.unidospi.DAO.RelatorioDao;
import br.com.unidospi.model.RelatorioFaturaDia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "RelatoriosController", urlPatterns = {"/inputRelatorios"})
public class RelatoriosController extends HttpServlet {
    
    public static ArrayList<RelatorioFaturaDia> rel_fatura_dia(){
        return RelatorioDao.rel_fatura_dia();
    }
    
    public static ArrayList<String[]> rel_top10_vendas_dia(){
        return RelatorioDao.rel_top10_vendas_dia();
    }
    
    public static ArrayList<String[]> rel_total_empresa_porcentagem(){
        return RelatorioDao.rel_total_empresa_porcentagem();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        if (paramAction.equals("Relatorio")) {
            Relatorio action = new Relatorio();
            action.executa(req, resp);
        }

    }
}
