/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.UsuarioFuncionario;
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
public class EditarEmpresa implements Executavel, Registravel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        boolean retorno = false;
        
        int idEmpresa=Integer.parseInt(req.getParameter("idEmpresa"));
        String nome=req.getParameter("nome");
        //String cnpj=req.getParameter("cnpj");
        String strDataCriacao =req.getParameter("dataCriacao");
        int idEstado =Integer.parseInt(req.getParameter("estado"));
        int idCidade =Integer.parseInt(req.getParameter("cidade"));
        boolean status = Boolean.valueOf(req.getParameter("status"));
        boolean matriz = Boolean.valueOf(req.getParameter("matriz"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        
        Date dataCriacao = null;
        try {
            dataCriacao = sdf.parse(strDataCriacao);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        //VALIDAÇÃO PROVISÓRIA------------------------------------------------
        boolean validacaoServidor = false;
//        boolean validarCNPJ = isCNPJ(cnpj);
//        if (nome.length() < 1 || nome.length() > 70) {
//            validacaoServidor = true;
//            req.setAttribute("erroNome", true);
//        }
//        if (cnpj.length() < 1 || cnpj.length() > 14 || validarCNPJ == false){
//            validacaoServidor = true;
//            req.setAttribute("erroCNPJ", true);
//        }
        if (dataCriacao == null){
            validacaoServidor = true;
            req.setAttribute("erroData", true);
        }
        if (req.getParameter("estado") == null){
            validacaoServidor = true;
            req.setAttribute("erroUF", true);
        }
        else
            idEstado = Integer.parseInt(req.getParameter("estado"));
        if (req.getParameter("cidade").equals("")){
            validacaoServidor = true;
            req.setAttribute("erroCidade", true);
        }
        else 
            idCidade = Integer.parseInt(req.getParameter("cidade"));
        //--------------------------------------------------------------------------
        if (validacaoServidor) {

            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/tads/input?action=FormEditarEmpresa&id=" + 
                            Integer.parseInt(req.getParameter("idEmpresa")));
            dispatcher.forward(req, resp);
        }
        else{

        Empresa empr = new Empresa(idEmpresa, nome, dataCriacao, idEstado, idCidade, status, matriz);
        retorno=empr.alterar();
            if(retorno){
                HttpSession sessao = req.getSession();
//                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
//                String acao = "edição de Empresa";
//                GeraLog registro = new GeraLog();
//                registro.escreverLog(usuario, acao, empr);
                
                sessao.setAttribute("empresa", empr);
                EditarEmpresa registra = new EditarEmpresa();
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
        
        String acao = "edicao de empresa";
        Empresa empr = (Empresa)sessao.getAttribute("empresa");
        
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
                            + usuario.getNomeUsuario() + " realizou uma " + acao + " no sistema, editando a Empresa: "
                            + empr.getNome() + ".");
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
