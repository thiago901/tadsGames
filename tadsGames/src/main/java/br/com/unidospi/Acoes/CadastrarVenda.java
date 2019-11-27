/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Acoes;

import br.com.unidospi.Controller.EstoqueController;
import br.com.unidospi.DAO.ClienteDAO;
import br.com.unidospi.DAO.VendaDAO;
import br.com.unidospi.model.ClienteLista;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.model.Venda;
import br.com.unidospi.model.VendaDetalhe;
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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.unidospi.util.Registravel;

/**
 *
 * @author thiago.srocha4
 */
public class CadastrarVenda implements Executavel, Registravel{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int retorno = 0;
        HttpSession sessao = req.getSession();
        List<VendaDetalhe> vd = (ArrayList<VendaDetalhe> ) sessao.getAttribute("itemVenda");
        
        UsuarioFuncionario usuario = (UsuarioFuncionario) sessao.getAttribute("usuario");
        
        int idEmpresa = usuario.getIdEmpresa();
        int idCliente= Integer.parseInt(sessao.getAttribute("idCliente").toString());
        float vlrVenda=0;
        int idFuncionario= usuario.getIdFuncionario();

          for(VendaDetalhe item:vd){
            vlrVenda += item.getVlrTotal();
        }
        
        Date dtVenda = new Date();
        Venda venda = new Venda(idCliente, idEmpresa,idFuncionario, vlrVenda, dtVenda, "Finalizado");
        
        for(VendaDetalhe item:vd){
            int idProduto =item.getIdProduto();
            int qtd = item.getQtdVenda();
            float vlrUnitario = item.getVlrUnitario();
            float vlrUnitarioTotal = item.getVlrTotal();
            venda.adiciona(new VendaDetalhe(idProduto, qtd, vlrUnitario, vlrUnitarioTotal));
        }
        EstoqueController.atualizarEstoque(venda);
        retorno = venda.salvar();
        
        if (retorno > 0){
            sessao.removeAttribute("itemVenda");
            sessao.removeAttribute("idLinhaItemVenda");
            sessao.removeAttribute("idCliente");
            sessao.removeAttribute("nomeCliente2");
            String acao = "Venda";
            GeraLog registro = new GeraLog();
            registro.escreverLog(usuario, acao, venda);
            
            CadastrarVenda registra = new CadastrarVenda();
            registra.gerarLog(req, resp);
        }
        
        resp.sendRedirect(req.getContextPath() + "/tads/inputVenda?action=FormVenda");
        
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
        
        String acao = "venda";
        Venda v = VendaDAO.ultVenda();
        ClienteLista c = ClienteDAO.listarClientes(v.getIdCliente());
        
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
                            + usuario.getNomeUsuario() + " registrou uma " + acao + " no sistema, efetuada pelo Funcionario: "
                            + usuario.getNomeFuncionario() + " destinada ao Cliente: " + c.getNome() + " "
                            + c.getSobrenome() + ", no valor de: " + v.getVlrVenda() + ".");
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
