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
public class FormRelatorio implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
                
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/cliente/Relatorio.jsp");
        rd.forward(req, resp);
        return "";
    }
    
    
    
}
