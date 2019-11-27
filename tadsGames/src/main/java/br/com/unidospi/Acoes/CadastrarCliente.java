/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCPF.isCPF;
import br.com.unidospi.Controller.ClienteController;
import br.com.unidospi.DAO.ClienteDAO;
import static br.com.unidospi.DAO.ClienteDAO.validaNovoCPF;
import br.com.unidospi.model.Cliente;
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
 * @author thiago.srocha4
 */
public class CadastrarCliente implements Executavel, Registravel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        int retorno;
        int idEmpresa = 0; 
        String idEmpresaStr = req.getParameter("tpEmpresa");
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String cpf = req.getParameter("cpf");
        String dtNascm = req.getParameter("dtNasc");
        String sexo = req.getParameter("sexo");
        boolean ativo = Boolean.valueOf(req.getParameter("status"));
        
        boolean validacaoServidor = false;
        boolean testeCPF;
        boolean cpfDisponivel;
        
        testeCPF=isCPF(cpf);
        cpfDisponivel = validaNovoCPF(cpf);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;
            
        try {
            dtNasc = formatter.parse(dtNascm);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //VALIDAÇÃO PROVISÓRIA------------------------------------------------
        if (nome.length() > 50 || nome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome", true);
        }else if (nome.matches("[A-z ]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (sobrenome.length() > 50 || sobrenome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome", true);
        }else if (sobrenome.matches("[A-z ]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome2", true);
        }
        
        if (testeCPF == false || cpfDisponivel==false) {
            validacaoServidor = true;
            req.setAttribute("validacaoCPF", true);
        }
        if (dtNascm.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoDtNasc", true);
        }
        
        if (idEmpresaStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoEmpresa", true);
        } else 
            idEmpresa = Integer.parseInt(idEmpresaStr);  
        
        if (validacaoServidor) {
            RequestDispatcher dispatcher = 
                    req.getRequestDispatcher("inputCliente?action=FormCadastrarCliente");
            dispatcher.forward(req, resp);
        } else {                

            Cliente p = new Cliente(idEmpresa, nome, sobrenome, sexo, cpf, dtNasc, ativo) ;
            retorno = ClienteDAO.salvar(p);
            if (retorno > 0){
                HttpSession sessao = req.getSession();
                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "cadastro de Cliente";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, p);
                
                CadastrarCliente registra = new CadastrarCliente();
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
        String home = System.getProperty("user.home")+"\\Documents\\NetBeansProjects\\tadsGames\\tadsGames\\Log\\Registro2.txt";
        HttpSession sessao = req.getSession();
        UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
        
        
        
        String acao = "cadastro de cliente";
        Cliente c = ClienteDAO.ultCliente();

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
                            + usuario.getNomeUsuario() + " realizou um " + acao + " no sistema, cadastrando o Cliente: "
                            + c.getNome() + " " + c.getSobrenome() + ".");
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
