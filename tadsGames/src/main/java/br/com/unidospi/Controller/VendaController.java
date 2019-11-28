/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.Acoes.AdiconarCliente;
import br.com.unidospi.Acoes.CadastrarItemVenda;
import br.com.unidospi.Acoes.CadastrarVenda;
import br.com.unidospi.Acoes.ExcluirItemVenda;
import br.com.unidospi.Acoes.FormVenda;



//import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
@WebServlet(name = "VendaController", urlPatterns = {"/tads/inputVenda"})
public class VendaController extends HttpServlet {

    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        
        HttpSession sessao = req.getSession();
        
        if (sessao.getAttribute("usuario") != null) {
            if(paramAction.equals("FormVenda")){
                FormVenda action = new FormVenda();
                action.executa(req, resp);

            }else if(paramAction.equals("CadastrarVenda")){
                CadastrarVenda action = new CadastrarVenda();
                action.executa(req, resp);
            }
            else if(paramAction.equals("CadastrarItemVenda")){
                CadastrarItemVenda action = new CadastrarItemVenda();
                action.executa(req, resp);

            } else if(paramAction.equals("ExcluirItemVenda")){
                ExcluirItemVenda action = new ExcluirItemVenda();
                action.executa(req, resp);
            } else if(paramAction.equals("AdiconarCliente")){
                AdiconarCliente action = new AdiconarCliente();
                action.executa(req, resp);
            } 
        } else {
            resp.sendRedirect(req.getContextPath() + "/tads/inputLogin?action=FormLogin");
        } 
    }    
}
