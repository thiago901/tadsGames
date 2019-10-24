/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ClienteController;
import br.com.unidospi.model.ClienteLista;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class ListarCliente implements Executavel {
    @Override
    public String executa(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
       ArrayList<ClienteLista> lista = ClienteController.listarClientes();
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("Cliente/listarCliente.jsp");
        rd.forward(req, resp);
        return "";
    }
}
