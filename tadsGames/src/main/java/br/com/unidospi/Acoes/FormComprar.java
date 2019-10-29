/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.Controller.ProdutoController;
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
 * @author henrique.abastos
 */
public class FormComprar implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<EmpresaLista> E = EmpresaController.listarEmpresas();
        ArrayList<Produto> P = ProdutoController.listarProduto();
        
        req.setAttribute("empresas", E);
        req.setAttribute("produtos", P);
        
        RequestDispatcher rd = req.getRequestDispatcher("jsp/compra/formCompra.jsp");
        rd.forward(req, resp);
        return "";
    }

}
