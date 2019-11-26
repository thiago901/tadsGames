/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCPF.isCPF;
import br.com.unidospi.DAO.FuncionarioDAO;
import static br.com.unidospi.DAO.FuncionarioDAO.validaNovoCPF;
import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
public class CadastrarFuncionario implements Executavel, Registravel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String strIdEmpresa = req.getParameter("tpEmpresa");
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String cpfStr = req.getParameter("cpf");
        String dtNascStr = req.getParameter("dtNasc");
        String salarioStr = req.getParameter("salario");
        String deptoStr = req.getParameter("depto");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));         
        int idEmpresaSelecionada = 0;
        String cargo = req.getParameter("tpFuncionario");
        String sexo = req.getParameter("sexo");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;

        try {
            dtNasc = formatter.parse(dtNascStr);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean validacaoServidor = false;
        boolean testeCPF;
        boolean cpfDisponivel;
        testeCPF = isCPF(cpfStr);
        cpfDisponivel = validaNovoCPF(cpfStr);
        
        if (nome.length() > 50 || nome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        } else if (nome.matches("[A-z ]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (sobrenome.length() > 50 || sobrenome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome", true);
        } else if (sobrenome.matches("[A-z ]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome2", true);
        }
        if (testeCPF == false  || cpfDisponivel==false) {
            validacaoServidor = true;
            req.setAttribute("validacaoCPF", true);
        }
        if (dtNascStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoDtNasc", true);
        }
        if (strIdEmpresa == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoEmpresa", true);

        } else {
            idEmpresaSelecionada = Integer.parseInt(strIdEmpresa);
        }
        if (salarioStr.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSalario", true);
        } else if (salarioStr.matches("[0-9.]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoSalario2", true);
        }
        if (deptoStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoDept", true);
        }
        if (cargo == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoCargo", true);
        }
        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputFuncionario?action=FormCadastrarFuncionario");
            dispatcher.forward(req, resp);
        } else {
            Funcionario funcionario = new Funcionario(
                    Double.parseDouble(salarioStr), deptoStr, cargo,
                    idEmpresaSelecionada, nome, sobrenome, sexo, cpfStr,
                    dtNasc, status);
            FuncionarioDAO.salvar(funcionario);
            
            HttpSession sessao = req.getSession();
            UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
            String acao = "cadastro de Funcionario";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, funcionario);
            
            CadastrarFuncionario registra = new CadastrarFuncionario();
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
        
        String acao = "cadastro de funcionário";
        Funcionario f = FuncionarioDAO.ultFuncionario();
        
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
                            + usuario.getNomeUsuario() + " realizou um " + acao + " no sistema, cadastrando o Funcionario: "
                            + f.getNome() + " " + f.getSobrenome() + ".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        gerarLog(req, resp);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } catch (IOException e) {
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
    }

}
