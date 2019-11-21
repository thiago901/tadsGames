/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.util;

import static br.com.unidospi.DAO.ClienteDAO.listarClientes;
import static br.com.unidospi.DAO.ProdutoDAO.listarProduto;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
import br.com.unidospi.model.Compra;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.Produto;
import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import br.com.unidospi.model.Venda;
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

/**
 *
 * @author lucas
 */
public class GeraLog {
    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    
           
    public GeraLog() {
    }
    public void escreverLog(Object user, String acao, Object objeto){
        
        String tipo = acao;
        switch (tipo){
            case "Login":
                try {
                    //ESPECIFICAR O CAMINHO DA PASTA AQUI
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema.");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "cadastro de Empresa":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Empresa empr = (Empresa)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema, cadastrando a Empresa: "
                                        +empr.getNome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "cadastro de Cliente":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Cliente c = (Cliente)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema, cadastrando o Cliente: "
                                        +c.getNome()+" "+c.getSobrenome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "Compra":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Compra cmp = (Compra)objeto;
                    Produto produto = listarProduto(cmp.getIdProduto());
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou uma "+acao+" no sistema, referente a: "+
                                        cmp.getQtdCompra()+" unidade(s) do produto: "+produto.getNome()+", totalizando o valor de: "+
                                        cmp.getValorCompra()*cmp.getQtdCompra()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "cadastro de Funcionario":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Funcionario f = (Funcionario)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema, cadastrando o Funcionario: "
                                        +f.getNome()+" "+f.getSobrenome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "cadastro de Produto":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Produto p = (Produto)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema, cadastrando o Produto: "
                                        +p.getNome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "cadastro de Usuario":
                try {
                    Usuario usuario = (Usuario)user;
                    UsuarioFuncionario u = (UsuarioFuncionario)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou um "+acao+" no sistema, cadastrando o Usuario: "+
                                        u.getNomeUsuario()+" e atribuindo ao Funcionario: "+u.getNomeFuncionario()+" "+
                                        u.getSobrenome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "Venda":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Venda v = (Venda)objeto;
                    
                    ClienteLista c = listarClientes(v.getIdCliente());
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" registrou uma "+acao+" no sistema, efetuada pelo Funcionario: "+
                                        usuario.getNomeFuncionario()+" destinada ao Cliente: "+c.getNome()+" "+
                                        c.getSobrenome()+", no valor de: "+v.getVlrVenda()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            /////////////////////////EDIÇÕES///////////////////
            case "edição de Cliente":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Cliente c = (Cliente)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou uma "+acao+" no sistema, editando o Cliente: "
                                        +c.getNome()+" "+c.getSobrenome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "edição de Empresa":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Empresa empr = (Empresa)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou uma "+acao+" no sistema, editando a Empresa: "
                                        +empr.getNome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "edição de Funcionario":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Funcionario f = (Funcionario)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou uma "+acao+" no sistema, editando o Funcionario: "
                                        +f.getNome()+" "+f.getSobrenome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "edição de Produto":
                try {
                    UsuarioFuncionario usuario = (UsuarioFuncionario)user;
                    Produto p = (Produto)objeto;
                    arquivo = new File("C:\\Users\\lucas.sfaria5\\Documents\\RegistrosTadsGames\\Registro.txt");
                    LocalDateTime hora = LocalDateTime.now();

                    fileReader = new FileReader(arquivo);
                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> texto = new ArrayList();
                    while (bufferedReader.ready()){
                        texto.add(bufferedReader.readLine());
                    }
                    fileWriter  = new FileWriter (arquivo);
                    bufferedWriter = new BufferedWriter (fileWriter);
                
                    for (int i = 0; i < texto.size(); i++) {
                        bufferedWriter.write(texto.get(i));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write(hora.getDayOfMonth()+"/"+hora.getMonthValue()+"/"+hora.getYear()+" - "+
                                        hora.getHour()+"h"+hora.getMinute()+"m"+hora.getSecond()+"s - O usuario: "+
                                        usuario.getNomeUsuario()+" realizou uma "+acao+" no sistema, editando o registro do Produto: "
                                        +p.getNome()+".");
                    bufferedReader.close();
                    bufferedWriter.close();

                } catch (FileNotFoundException ex) {
                    try {
                        arquivo.createNewFile();
                        escreverLog(user, acao, objeto);
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                catch (IOException e){
                    Logger.getLogger(GeraLog.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
        }
    }
    
}
