/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.Venda;
import br.com.unidospi.model.VendaDetalhe;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class CadastrarVenda implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idEmpresa =Integer.parseInt(req.getParameter("empresa"));
        int idCliente=Integer.parseInt(req.getParameter("cliente"));
        float vlrVenda=Float.parseFloat(req.getParameter("vlrTotal"));
        String idProduto[] = req.getParameterValues("idProdutos[]");
        String qtd[] = req.getParameterValues("qtds[]");
        String vlr[] = req.getParameterValues("vlrUnitarios[]");
        

        Date dtVenda = new Date();
        Venda venda = new Venda(idCliente, idEmpresa, vlrVenda, dtVenda, "Finalizado");
        VendaDetalhe vendaDetalhe = new VendaDetalhe(idCliente, idCliente, idCliente, vlrVenda, vlrVenda);
        
        
        venda.salvar();
        
        return "";
    }
    
}
