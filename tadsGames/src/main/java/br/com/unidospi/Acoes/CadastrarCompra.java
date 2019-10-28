/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.CompraDAO;
import br.com.unidospi.model.Compra;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henrique.abastos
 */
public class CadastrarCompra implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       int idEmpresa = Integer.parseInt(req.getParameter("empresa"));
       int idProduto = Integer.parseInt(req.getParameter("produto"));
       int qtdCompra = Integer.parseInt(req.getParameter("qtdComprada"));
       float valorCompra = Float.parseFloat(req.getParameter("vlrUnitario"));
       String StringDtCompra = req.getParameter("dtEntrada");
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(StringDtCompra);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
        Compra compra = new Compra(idEmpresa, idProduto, qtdCompra, dataCriacao, valorCompra);
        
        compra.salvar();
       
       return "";
    }
    
}
