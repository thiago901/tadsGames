
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
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
 * @author gabriel.gisidorio
 */
public class Login implements Executavel, Registravel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        UsuarioFuncionario usuario = UsuarioDAO.obterUsuarioLogado(login, senha);
        
        if (usuario != null) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario", usuario);
            
            String acao = "Login";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, usuario);
            Login registra = new Login ();
            registra.gerarLog(req, resp);
            
            resp.sendRedirect(req.getContextPath()+"/indexHome");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
//            dispatcher.forward(req, resp);
            //resp.sendRedirect(req.getContextPath() + "/inputLogin?action=Login");

        } else {
            req.setAttribute("msgErro", "Usuario inexistente ou senha inválida");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login/Login.jsp");
//            dispatcher.forward(req, resp);
            resp.sendRedirect(req.getContextPath()+"/inputLogin?action=FormLogin");
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
        
        
        String acao = "login";
        

        try {
                    //ESPECIFICAR O CAMINHO DA PASTA AQUI

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
                            + usuario.getNomeUsuario() + " realizou um " + acao + " no sistema.");
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
