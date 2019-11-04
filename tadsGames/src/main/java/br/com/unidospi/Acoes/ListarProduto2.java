/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.model.Produto;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class ListarProduto2 implements Executavel{
    
    @Override
    public String executa(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
       ArrayList<Produto> lista = ProdutoController.listarProduto();
        req.setAttribute("lista", lista);
        
        Produto p = new Produto(0, "Homem Aranha", "Batman é muito melhor", "Avenduta", true);
        
        Gson g = new Gson();
        String json = g.toJson(lista);
         try (PrintWriter out = resp.getWriter()) {
             out.println(json);
         }
             
         
        
        return "";
    }
        
    
}
