/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.DAO.UsuarioDAO;
import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
 * @author gabri
 */
public class CadastrarUsuario implements Executavel, Registravel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {      
        int retorno = 0;
        String idFuncionarioStr = req.getParameter("idFuncionario");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        LocalDate dtCadastro = LocalDate.now();
        
        
        int idFuncionario = Integer.parseInt(idFuncionarioStr);
        
        boolean validacaoServidor = false;
        
        if (login.length() > 50 || login.length()< 2 || login.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else if (login.substring(0, 1).matches("[A-z 0-9.]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (senha.length() > 16 || senha.trim().equals("") || senha.length() < 6 ) {
            validacaoServidor = true;
            req.setAttribute("erroSenha", true);
        }else if (login.substring(0, 1).matches("[A-z 0-9]*") == false) {
            validacaoServidor = true;
            req.setAttribute("erroSenha2", true);
        }
        
        if (validacaoServidor){
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("inputUsuario?action=FormCadastrarUsuario");
            dispatcher.forward(req, resp);
        }
        else {
            Date dDtCadastro = Date.from(dtCadastro.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            
            Usuario usuario = new Usuario(login, senha, dDtCadastro, status, idFuncionario);

            retorno = UsuarioDAO.salvar(usuario);
            if (retorno > 0){
                HttpSession sessao = req.getSession();
                UsuarioFuncionario u = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "cadastro de Usuario";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, u);
                
                CadastrarUsuario registra = new CadastrarUsuario();
                registra.gerarLog(req, resp);
                
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
        
        String acao = "cadastro de usuario";
        UsuarioFuncionario u = UsuarioDAO.obterUsuarioFuncionarioPorId(UsuarioDAO.ultUsuario());
        
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
                            + usuario.getNomeUsuario() + " realizou um " + acao + " no sistema, cadastrando o Usuario: "
                            + u.getNomeUsuario() + " e atribuindo ao Funcionario: " + u.getNomeFuncionario() + " "
                            + u.getSobrenome() + ".");
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
