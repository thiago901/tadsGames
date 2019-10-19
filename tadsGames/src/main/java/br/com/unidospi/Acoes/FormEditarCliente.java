/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;



import br.com.unidospi.Controller.ClienteController;
import br.com.unidospi.model.ClienteLista;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class FormEditarCliente implements Executavel{

    /**
     *
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id =Integer.parseInt(req.getParameter("idCliente"));
        ClienteLista c = ClienteController.listarClientes(id);
        req.setAttribute("c", c);
        RequestDispatcher rd = req.getRequestDispatcher("/Cliente/AlterarCliente.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
