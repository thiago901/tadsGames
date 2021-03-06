/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;


import br.com.unidospi.Controller.ProdutoController;

import br.com.unidospi.model.ProdutoLista;
import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class ListarProduto2 implements Executavel{
    
    @Override
    public String executa(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        usuario.getIdEmpresa();
        String nomePesquisado = req.getParameter("nome");
        ArrayList<ProdutoLista> lista = ProdutoController.listarProduto(nomePesquisado,usuario.getIdEmpresa());
        req.setAttribute("lista", lista);
        
        
        
        
        Gson g = new Gson();
        String json = g.toJson(lista);
         try (PrintWriter out = resp.getWriter()) {
             out.println(json);
         }
             
         
        
        return "";
    }
        
    
}
