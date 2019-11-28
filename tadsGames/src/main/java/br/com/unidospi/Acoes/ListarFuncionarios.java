/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.FuncionarioDAO;
import br.com.unidospi.model.FuncionarioEmpresa;
import br.com.unidospi.util.ListaPaginada;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class ListarFuncionarios implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        
        double qtdRegistoPorPagina = 10;
        double qtdPagina = 1;
        int offset=0;
        
        String numPaginaStr = req.getParameter("pagina");
        int numPagina=1;
        
        if(!(numPaginaStr==null)){
            numPagina = Integer.parseInt(numPaginaStr);
            ListaPaginada lp = new ListaPaginada(FuncionarioDAO.qtdRegitro(), qtdRegistoPorPagina, numPagina);
            qtdPagina = lp.getQtdPaginas();
            numPagina= lp.getNumPagina();
            offset = lp.offset();
        }

        req.setAttribute("pagina", String.valueOf(numPagina));
        req.setAttribute("qtdPagina", (int)qtdPagina);
        
        ArrayList<FuncionarioEmpresa> listaFuncionarios = FuncionarioDAO.obterFuncionarios(offset);
        req.setAttribute("funcionarios", listaFuncionarios);
        RequestDispatcher dispatcher = 
                req.getRequestDispatcher("/WEB-INF/jsp/funcionario/ListarFuncionario.jsp");
        dispatcher.forward(req, resp);
        
        return "";
    }
    
}
