/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.ProdutoDAO;
import br.com.unidospi.model.Produto;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.unidospi.util.Registravel;

/**
 *
 * @author thiago.srocha4
 */
public class EditarProduto implements Executavel, Registravel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean retorno = false;
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        boolean ativo = Boolean.valueOf(req.getParameter("ativo"));

        boolean validacaoServidor = false;

        if (nome.length() < 1 || nome.length() > 50) {
            validacaoServidor = true;
            req.setAttribute("erroNome", true);
        }

        if (tipo == null) {
            validacaoServidor = true;
            req.setAttribute("erroTipo", true);
        }

        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputProduto?action=FormEditarProduto&idProduto="
                            + Integer.parseInt(req.getParameter("idProduto")));
            dispatcher.forward(req, resp);
            return "";
        }
        Produto p = new Produto(Integer.parseInt(req.getParameter("idProduto")), nome, descricao, tipo, ativo);
        retorno = ProdutoDAO.editar(p);

        if (retorno) {
            HttpSession sessao = req.getSession();
            UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
            String acao = "edição de Produto";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, p);
            
            sessao.setAttribute("produto", p);
            EditarProduto registra = new EditarProduto();
            registra.gerarLog(req, resp);
            
            resp.sendRedirect(req.getContextPath() + "/sucesso.html");
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
        
        String acao = "edicao de produto";
        Produto p = (Produto)sessao.getAttribute("produto");
        
        try {
                    arquivo = new File(home);
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()) {
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter = new FileWriter(arquivo);
                    bufferedWriter = new BufferedWriter(fileWriter);

                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth() + "/" + hora.getMonthValue() + "/" + hora.getYear() + " - "
                            + hora.getHour() + "h" + hora.getMinute() + "m" + hora.getSecond() + "s - O usuario: "
                            + usuario.getNomeUsuario() + " realizou uma " + acao + " no sistema, editando o registro do Produto: "
                            + p.getNome() + ".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        gerarLog(req, resp);
                        Logger.getLogger(Registravel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(Registravel.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } catch (IOException e) {
                    Logger.getLogger(Registravel.class.getName()).log(Level.SEVERE, null, e);
                }
    }

}
