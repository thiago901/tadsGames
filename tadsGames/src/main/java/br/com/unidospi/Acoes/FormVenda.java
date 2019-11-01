/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.ClienteController;
import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.Controller.ProdutoController;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author thiago.srocha4
 */
public class FormVenda implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<ClienteLista> clientes = ClienteController.listarClientes();
        ArrayList<EmpresaLista> empresas = EmpresaController.listarEmpresas();
        ArrayList<Produto> produtos = ProdutoController.listarProduto();
        
        req.setAttribute("cliente", clientes);
        req.setAttribute("produto", produtos);
        req.setAttribute("empresa", empresas);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/venda/formVenda.jsp");
        rd.forward(req, resp);
        return "";
    }
    
}
