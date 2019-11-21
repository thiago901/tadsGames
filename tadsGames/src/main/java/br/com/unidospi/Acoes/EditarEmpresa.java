/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import static br.com.unidospi.Acoes.ValidaCNPJ.isCNPJ;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.util.GeraLog;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thiago.srocha4
 */
public class EditarEmpresa implements Executavel{

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
                UsuarioFuncionario usuario = (UsuarioFuncionario)sessao.getAttribute("usuario");
                String acao = "edição de Empresa";
                GeraLog registro = new GeraLog();
                registro.escreverLog(usuario, acao, empr);
                
                resp.sendRedirect(req.getContextPath() + "/sucesso.html");
            }
        }
        
        return "";
    }
    
}
