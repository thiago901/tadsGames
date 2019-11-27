/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.Registravel;
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

/**
 *
 * @author gabri
 */
public class EditarUsuario implements Executavel, Registravel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("idUsuario"));
        String username = req.getParameter("login");
        String senha = req.getParameter("senha");
        boolean status = Boolean.valueOf(req.getParameter("status"));

        boolean validacaoServidor = false;

        if (username.length() > 50 || username.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        } else if (username.substring(0, 2).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (senha.length() > 16 || username.equals("") || senha.length() < 6) {
            validacaoServidor = true;
            req.setAttribute("erroSenha", true);
        } else if (username.substring(0, 2).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("erroSenha2", true);
        }
        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputUsuario?action=FormEditarUsuario&idUsuario="
                            + Integer.parseInt(req.getParameter("idUsuario")));
            dispatcher.forward(req, resp);
        } else {
            Usuario user = new Usuario(id, username, senha, status);
            boolean retorno = UsuarioDAO.editar(user);

            if (retorno) {
                HttpSession sessao = req.getSession();
                sessao.setAttribute("user", user);
                EditarUsuario registra = new EditarUsuario();
                registra.gerarLog(req, resp);

                resp.sendRedirect(req.getContextPath() + "/sucesso.jsp");
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
        String home = System.getProperty("user.home") + "\\Documents\\NetBeansProjects\\tadsGames\\tadsGames\\Log\\Registro2.txt";
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");

        String acao = "edicao de usuario";
        Usuario u = (Usuario) sessao.getAttribute("user");
        UsuarioFuncionario uf = UsuarioDAO.obterUsuarioFuncionarioPorId(u.getIdUsuario());
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
                    + usuario.getNomeUsuario() + " realizou uma " + acao + " no sistema, editando o Usuario: "
                    + u.getNomeUsuario() + ", que pertence ao Funcionario " + uf.getNomeFuncionario() + " "
                    + uf.getSobrenome() + ".");
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
