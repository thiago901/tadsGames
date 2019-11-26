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
import br.com.unidospi.util.GeraLogI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author henrique.abastos
 */
public class CadastrarCompra implements Executavel, GeraLogI{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       String idEmpresaStr = req.getParameter("empresa");
       String idProdutoStr = req.getParameter("produto");
       String qtdCompraStr = req.getParameter("qtdComprada");
       String valorCompraStr = req.getParameter("vlrUnitario");
       //String StringDtCompra = req.getParameter("dtEntrada");
       
       boolean validacaoServidor = false;
        
        
        Date dataCriacao =new Date();
       
        
        if (idEmpresaStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoEmpresa", true);
        }
        if (idProdutoStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoProduto", true);
        }
        
        if (qtdCompraStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("qtdComprada", true);
        } else if (qtdCompraStr.matches("[0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("qtdComprada", true);
        }
        if (valorCompraStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("vlrUnitario", true);
        } else if (valorCompraStr.matches("[0-9.]*") == false) {
            validacaoServidor = true;
            req.setAttribute("vlrUnitario", true);
        }
        if (validacaoServidor){
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputCompra?action=FormComprar");
            dispatcher.forward(req, resp);
        }
        else {
            int qtdCompra = Integer.parseInt(qtdCompraStr);
            float valorCompra = Float.parseFloat(valorCompraStr);
            int idEmpresa = Integer.parseInt(idEmpresaStr);
            int idProduto = Integer.parseInt(idProdutoStr);
            
            
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

                resp.sendRedirect(req.getContextPath() + "/sucesso.html");
            }
        }
       return "";
    }

    @Override
    public void gerarLog(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        File arquivo = null;
        FileReader fileReader;
        BufferedReader bufferedReader;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        String home = System.getProperty("user.home")+"\\Documents\\NetBeansProjects\\tadsGames\\tadsGames\\Log\\Registro2.txt";
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
        
        
        String acao = "compra";
        Compra c = CompraDAO.ultCliente();
    }
    
}
