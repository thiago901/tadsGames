/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCPF.isCPF;
import br.com.unidospi.Controller.ClienteController;
import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class EditarCliente implements Executavel {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int retorno;
        int idEmpresa = 0; 
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        String idEmpresaStr = req.getParameter("tpEmpresa");
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        //String cpf = req.getParameter("cpf");
        String dtNascm = req.getParameter("dtNasc");
        String sexo = req.getParameter("sexo");
        boolean ativo = Boolean.valueOf(req.getParameter("status"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNasc = null;

        boolean validacaoServidor = false;
        //boolean testeCPF;
        //testeCPF = isCPF(cpf);

        try {
            dtNasc = formatter.parse(dtNascm);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

//        if (testeCPF == false) {
//            validacaoServidor = true;
//            req.setAttribute("validacaoCPF", true);
//        }
        if (dtNascm.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoDtNasc", true);
        }

        if (idEmpresaStr == null) {
            validacaoServidor = true;
            req.setAttribute("validacaoEmpresa", true);
        } else {
            idEmpresa = Integer.parseInt(idEmpresaStr);
        }

        if (validacaoServidor) {
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("inputCliente?action=FormEditarCliente&idCliente="+
                            Integer.parseInt(req.getParameter("idCliente")));
            dispatcher.forward(req, resp);
        } else {
            Cliente p = new Cliente(idCliente, idEmpresa, nome, sobrenome, sexo, dtNasc, ativo);
            retorno = ClienteDAO.alterar(p);
            if (retorno > 0) {
                HttpSession sessao = req.getSession();
                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "edição de Cliente";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, p);
                
                resp.sendRedirect(req.getContextPath() + "/sucesso.html");
            }
        }
        return "";
    }

}
