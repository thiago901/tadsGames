/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EstoqueController;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.model.Venda;
import br.com.unidospi.model.VendaDetalhe;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        int retorno = 0;
        HttpSession sessao = req.getSession();
        List<VendaDetalhe> vd = (ArrayList<VendaDetalhe> ) sessao.getAttribute("itemVenda");
        
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        
        int idEmpresa = usuario.getIdEmpresa();
        int idCliente= Integer.parseInt(sessao.getAttribute("idCliente").toString());
        float vlrVenda=0;
        int idFuncionario= usuario.getIdFuncionario();

          for(VendaDetalhe item:vd){
            vlrVenda += item.getVlrTotal();
        }
        
        Date dtVenda = new Date();
        Venda venda = new Venda(idCliente, idEmpresa,idFuncionario, vlrVenda, dtVenda, "Finalizado");
        
        for(VendaDetalhe item:vd){
            int idProduto =item.getIdProduto();
            int qtd = item.getQtdVenda();
            float vlrUnitario = item.getVlrUnitario();
            float vlrUnitarioTotal = item.getVlrTotal();
            venda.adiciona(new VendaDetalhe(idProduto, qtd, vlrUnitario, vlrUnitarioTotal));
        }
        EstoqueController.atualizarEstoque(venda);
        retorno = venda.salvar();
        
        if (retorno > 0){
            sessao.removeAttribute("itemVenda");
            sessao.removeAttribute("idLinhaItemVenda");
            sessao.removeAttribute("idCliente");
            sessao.removeAttribute("nomeCliente2");
            String acao = "Venda";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, venda);
        }
        
        resp.sendRedirect(req.getContextPath() + "/tads/inputVenda?action=FormVenda");
        
        return "";
    }
    
}
