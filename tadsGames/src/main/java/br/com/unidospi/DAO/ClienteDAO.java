/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;


import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.Empresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique.abastos
 */
public class ClienteDAO {
    
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "adminadmin";
    static Connection conexao;
    
    public static int salvar(Cliente cliente)  {
            
        int retorno = 0;
        try {
            String sql= "insert into Cliente (idEmpresa,nome, sobrenome, sexo, cpf, dataNasc, ativo) values(?,?,?,?,?,?,?)";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            Date dt = new Date(cliente.getDataNasc().getTime());
            ps.setInt(1,cliente.getIdEmpresa());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSobrenome());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getCpf());
            ps.setDate(6, dt);
            ps.setBoolean(7, cliente.isAtivo());
                        
            int linhasAfetadas = ps.executeUpdate();
            
            if (linhasAfetadas > 0)
                retorno = linhasAfetadas;
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return retorno;
    }
    
    public static ArrayList<Cliente> obterClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                   rs.getInt("idCliente"),
                    rs.getInt("idEmpresa"), 
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getDate("dtNasc"),
                    rs.getBoolean("ativo")                                                                               
                );
                
                listaClientes.add(cliente);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }
    
     public static ArrayList<Empresa> obterEmpresas() {
        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        String query = "SELECT * FROM Empresa";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                Empresa empresa = new Empresa(
                    rs.getInt("idEmpresa"), 
                    rs.getString("nome"),
                    rs.getString("cnpj"),
                    rs.getDate("dataCriacao"),
                    rs.getInt("idEstado"),
                    2,
                    rs.getBoolean("matriz"),
                    rs.getBoolean("ativo")                    
                );
                
                listaEmpresas.add(empresa);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEmpresas;
    }
    
}
