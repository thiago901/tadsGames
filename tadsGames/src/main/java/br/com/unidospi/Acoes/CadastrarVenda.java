/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.UsuarioFuncionario;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class CadastrarVenda implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        int idEmpresa = usuario.getIdEmpresa();//Integer.parseInt(req.getParameter("empresa"));
        int idCliente= Integer.parseInt(req.getParameter("nomeCliente"));
        float vlrVenda=30;//Float.parseFloat(req.getParameter("vlrTotal"));
        String arrayIdProduto[] = req.getParameterValues("idProdutos[]");
        String arrayQtd[] = req.getParameterValues("qtds[]");
        String arrayVlr[] = req.getParameterValues("vlrUnitarios[]");
        

        Date dtVenda = new Date();
        Venda venda = new Venda(idCliente, idEmpresa, vlrVenda, dtVenda, "Finalizado");
        for(int i =0;i<arrayIdProduto.length;i++){
            int idProduto = Integer.parseInt(arrayIdProduto[i]);
            int qtd = Integer.parseInt(arrayQtd[i]);
            float vlrUnitario = Float.parseFloat(arrayVlr[i]);
            float vlrUnitarioTotal = qtd*vlrUnitario;
            venda.adiciona(new VendaDetalhe(idProduto, qtd, vlrUnitario, vlrUnitarioTotal));
        }

        venda.salvar();
        return "";
    }
    
}
