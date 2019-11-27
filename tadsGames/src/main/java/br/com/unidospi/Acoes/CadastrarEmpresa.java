/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCNPJ.isCNPJ;
import br.com.unidospi.DAO.EmpresaDao;
import static br.com.unidospi.DAO.EmpresaDao.validaNovoCnpj;
import br.com.unidospi.model.Empresa;
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
 * @author gisidorio
 */
public class CadastrarEmpresa implements Executavel, Registravel {

    /**
     *
     * @param req
     * @param resp
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean retorno = false;
        int idEstado = 0;
        int idCidade = 0;
        
        
        
        String nome = req.getParameter("nome");
        String cnpj = req.getParameter("cnpj");
        String strDataCriacao = req.getParameter("dataCriacao");
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
        boolean validarCNPJ = isCNPJ(cnpj);
        boolean cnpjDisponivel;
        
        cnpjDisponivel = validaNovoCnpj(cnpj);
        if (nome.length() < 1 || nome.length() > 70) {
            validacaoServidor = true;
            req.setAttribute("erroNome", true);
        } else if (nome.substring(0, 1).matches("[A-z ]*") == false) {
            validacaoServidor = true;
            req.setAttribute("validacaoNome2", true);
        }
        if (cnpj.length() < 1 || cnpj.length() > 14 || validarCNPJ == false || cnpjDisponivel==false) {
            validacaoServidor = true;
            req.setAttribute("erroCNPJ", true);
        }
        if (dataCriacao == null) {
            validacaoServidor = true;
            req.setAttribute("erroData", true);
        }
        if (req.getParameter("estado") == null) {
            validacaoServidor = true;
            req.setAttribute("erroUF", true);
        } else {
            idEstado = Integer.parseInt(req.getParameter("estado"));
        }
        if (req.getParameter("idCidade").equals("")) {
            validacaoServidor = true;
            req.setAttribute("erroCidade", true);
        } else {
            idCidade = Integer.parseInt(req.getParameter("idCidade"));
        }
        //--------------------------------------------------------------------------
        if (validacaoServidor) {

            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("input?action=FormCadastrarEmpresa");
            dispatcher.forward(req, resp);
        } else {
            
            Empresa empr = new Empresa(nome, cnpj, dataCriacao, idEstado, idCidade, status, matriz);
            
            retorno = empr.salvar();
            if (retorno) {
                HttpSession sessao = req.getSession();
                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "cadastro de Empresa";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, empr);
                
                CadastrarEmpresa registra = new CadastrarEmpresa();
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
        
        String acao = "cadastro de empresa";
        Empresa e = EmpresaDao.ultEmpresa();
        
        
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
                    + usuario.getNomeUsuario() + " realizou um " + acao + " no sistema, cadastrando a Empresa: "
                    + e.getNome() + ".");
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
        } catch (IOException ex) {
            Logger.getLogger(Registravel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
