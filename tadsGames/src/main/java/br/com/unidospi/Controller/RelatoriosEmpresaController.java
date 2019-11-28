/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.FormRelatorio;
import br.com.unidospi.Acoes.RelDiarioTopEmpresa;
import br.com.unidospi.Acoes.Relatorio;
import br.com.unidospi.Acoes.RelatorioDiario;
import br.com.unidospi.Acoes.RelatorioEmpresa;
import br.com.unidospi.Acoes.RelatorioRegionalDiario;

import br.com.unidospi.DAO.RelatorioDao;
import br.com.unidospi.model.RelatorioFaturaDia;
import br.com.unidospi.model.RelatorioGeral;
import br.com.unidospi.model.RelatorioPercentagem;
import br.com.unidospi.model.RelatorioTop10;
import java.io.IOException;
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
@WebServlet(name = "RelatoriosEmpresaController", urlPatterns = {"/tads/inputRelatoriosEmpresa"})
public class RelatoriosEmpresaController extends HttpServlet {
    
//    public static ArrayList<RelatorioFaturaDia> rel_fatura_dia(){
//        return RelatorioDao.rel_fatura_dia();
//    }
//    public static String regiao(int empresa){
//        return RelatorioDao.regiao(empresa);
//    }
//    
//    public static ArrayList<RelatorioGeral> relatorioGeral(){
//        return RelatorioDao.relatorioGeral();
//    }
//    public static ArrayList<RelatorioGeral> relatorioDiario(){
//        return RelatorioDao.relatorioDiario();
//    }
//    public static float totalMes(){
//        return RelatorioDao.totalMes();
//    }
//    public static float totalDia(){
//        return RelatorioDao.totalDia();
//    }
//    
//    public static ArrayList<RelatorioTop10> rel_top10_vendas_dia(){
//        return RelatorioDao.rel_top10_vendas_dia();
//    }
//    public static ArrayList<RelatorioTop10> rel_top10_vendas_dia(int idEmpresa){
//        return RelatorioDao.rel_top10_vendas_dia(idEmpresa);
//    }
//    
//    public static ArrayList<RelatorioPercentagem> rel_total_empresa_porcentagem(){
//        return RelatorioDao.rel_total_empresa_porcentagem();
//    }
//
//    public static float relTotalRegiaoDiario(String nomeRegiao) {
//        return RelatorioDao.relTotalRegiaoDiario(nomeRegiao);
//    }
    public static ArrayList<RelatorioTop10>  RelTopProdutoRegiao(String nomeRegiao) {
        return RelatorioDao.RelTopProdutoRegiao(nomeRegiao);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
//        if (paramAction.equals("Relatorio")) {
//            Relatorio action = new Relatorio();
//            action.executa(req, resp);
//        }
//        else if (paramAction.equals("FormRelatorio")) {
//            FormRelatorio action = new FormRelatorio();
//            action.executa(req, resp);
//        }else if (paramAction.equals("RelatorioDiario")) {
//            RelatorioDiario action = new RelatorioDiario();
//            action.executa(req, resp);
//        }
//        else if (paramAction.equals("RelDiarioTopEmpresa")) {
//            RelDiarioTopEmpresa action = new RelDiarioTopEmpresa();
//            action.executa(req, resp);
//        }else if (paramAction.equals("RelatorioRegionalDiario")) {
//            RelatorioRegionalDiario action = new RelatorioRegionalDiario();
//            action.executa(req, resp);
        if (paramAction.equals("RelatorioEmpresa")) {
            RelatorioEmpresa action = new RelatorioEmpresa();
            action.executa(req, resp);
        }
        
        
        

    }
}
