/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.EstadoRegiaoDao;
import br.com.unidospi.model.EstadoRegiao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "EstadoRegiaoController", urlPatterns = {"/listaEstadoRegiao"})
public class EstadoRegiaoController  extends HttpServlet{
    public static ArrayList<EstadoRegiao> listaEstadoRegiao(){
        return EstadoRegiaoDao.listarEstadosRegioes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ArrayList<EstadoRegiao> ufs  = EstadoRegiaoController.listaEstadoRegiao();
        req.setAttribute("ufs", ufs);
        
        
        RequestDispatcher rd = req.getRequestDispatcher("/cadastrarEmpresa.jsp");
        rd.forward(req, resp);

        
    }
    
}
