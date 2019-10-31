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

/**
 *
 * @author thiago.srocha4
 */
public class CadastrarCliente implements Executavel{

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
        testeCPF=isCPF(cpf);
        
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
        }      
        if (sobrenome.length() > 50 || sobrenome.equals("")) {
            validacaoServidor = true;
            req.setAttribute("validacaoSobrenome", true);
        }
        
        if (testeCPF == false) {
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
                resp.sendRedirect("sucesso.html");
            }
        }
        
        return "";
    }

   
    
   
}
