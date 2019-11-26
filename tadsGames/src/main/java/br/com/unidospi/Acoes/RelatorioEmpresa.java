/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.RelatoriosController;
import br.com.unidospi.model.RelatorioGeral;
import br.com.unidospi.model.RelatorioTop10;
import br.com.unidospi.model.UsuarioFuncionario;
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
public class RelatorioEmpresa implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        
        int idEmpresa =usuario.getIdEmpresa();
        float valorTotal=0;
        
        ArrayList<RelatorioTop10>  RelTopProdutoRegiao = RelatoriosController.rel_top10_vendas_dia(idEmpresa);
        
        for(RelatorioTop10 v:RelTopProdutoRegiao){
            valorTotal +=v.getVALOR();
        }
        
        
        req.setAttribute("valorTotal", valorTotal);
        req.setAttribute("ListaRegiao", RelTopProdutoRegiao);
        
        
        
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/Relatorio/RelatorioEmpresaDiario.jsp");
        rd.forward(req, resp);
        return "";
    }
    
    
    
}
