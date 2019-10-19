/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.Produto;
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
public class ListarProduto implements Executavel{
    
    @Override
    public String executa(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
       ArrayList<Produto> lista = ProdutoController.listarProduto();
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("Produto/listarProduto.jsp");
        rd.forward(req, resp);
        return "";
    }
        
    
}
