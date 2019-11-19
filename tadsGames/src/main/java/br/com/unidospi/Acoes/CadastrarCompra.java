/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EstoqueController;
import br.com.unidospi.model.Compra;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
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
 * @author henrique.abastos
 */
public class CadastrarCompra implements Executavel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       int idEmpresa = Integer.parseInt(req.getParameter("empresa"));
       int idProduto = Integer.parseInt(req.getParameter("produto"));
       int qtdCompra = Integer.parseInt(req.getParameter("qtdComprada"));
       float valorCompra = Float.parseFloat(req.getParameter("vlrUnitario"));
       //String StringDtCompra = req.getParameter("dtEntrada");
       
       
        
        
        Date dataCriacao =new Date();
       
        
        Compra compra = new Compra(idEmpresa, idProduto, qtdCompra, dataCriacao, valorCompra);
        boolean salvou=compra.salvar();
        
        //verifica se a compra foi salva no banco
        if(salvou){
            //funcao estocar ira acrescentar produto ou add quantidade
            
            EstoqueController.estocar(compra);
            
            HttpSession sessao = req.getSession();
            UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
            String acao = "Compra";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, compra);
            resp.sendRedirect("sucesso.html");
        }
       return "";
    }
    
}
