/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.CadastrarProduto;
import br.com.unidospi.Acoes.EditarProduto;
import br.com.unidospi.Acoes.FormCadastrarProduto;
import br.com.unidospi.Acoes.FormEditarProduto;
import br.com.unidospi.Acoes.ListarProduto;
import br.com.unidospi.Acoes.ListarProduto2;
import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
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
    @WebServlet(name = "ProdutoServlet", urlPatterns = {"/inputProduto"})
public class ProdutoController extends HttpServlet {
    
    // retorna 
    public static ArrayList<Produto> listarProduto (){
        return ProdutoDAO.listarProduto();
    }
    public static ArrayList<Produto> listarProduto (String nomePesquisado){
        return ProdutoDAO.listarProduto(nomePesquisado);
    }
       
    /* Recebe requisição e resposta por parâmetro e determina qual ação será 
       realizada atraves do atributo de requisição @paramAction após varios testes */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        if(paramAction.equals("CadastrarProduto")){
            CadastrarProduto action = new CadastrarProduto();
            action.executa(req, resp);
            
        }else if(paramAction.equals("EditarProduto")){
            EditarProduto action = new EditarProduto();
            action.executa(req, resp);
        }else if(paramAction.equals("FormCadastrarProduto")){
            FormCadastrarProduto action = new FormCadastrarProduto();
            action.executa(req, resp);
            
        }else if(paramAction.equals("FormEditarProduto")){
            FormEditarProduto action = new FormEditarProduto();
            action.executa(req, resp);
            
        }else if(paramAction.equals("ListarProduto")){
            ListarProduto action = new ListarProduto();
            action.executa(req, resp);
        }else if(paramAction.equals("ListarProduto2")){
            ListarProduto2 action = new ListarProduto2();
            action.executa(req, resp);
        }
    }

    

}
