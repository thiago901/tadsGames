/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.ListaPaginada;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.gisidorio
 */
public class ListarUsuarios implements Executavel {

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
            ListaPaginada lp = new ListaPaginada(UsuarioDAO.qtdRegitro(), qtdRegistoPorPagina, numPagina);
            qtdPagina = lp.getQtdPaginas();
            numPagina= lp.getNumPagina();
            offset = lp.offset();
        }

        req.setAttribute("pagina", String.valueOf(numPagina));
        req.setAttribute("qtdPagina", (int)qtdPagina);
        ArrayList<UsuarioFuncionario> listaUsuarios = UsuarioDAO.obterUsuarios(offset);
        req.setAttribute("usuarios", listaUsuarios);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/usuario/listarUsuarios.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
