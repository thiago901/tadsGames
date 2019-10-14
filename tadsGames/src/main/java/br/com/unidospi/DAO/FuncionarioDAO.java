 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class FuncionarioDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://localhost:3306/dbgames?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    public static int salvar(Funcionario funcionario) {
        int retorno = 0;
        String sql = "INSERT INTO Funcionario (idEmpresa, nome, sobrenome, sexo, cpf, dtNasc," +
                " ativo, login, senha, salario, cargo, departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Date dataSql = new Date(funcionario.getDataNasc().getTime());
            
            ps.setInt(1, funcionario.getIdEmpresa());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setString(4, funcionario.getSexo());
            ps.setString(5, funcionario.getCpf());
            ps.setDate(6, dataSql);
            ps.setBoolean(7, funcionario.isAtivo());
            ps.setString(8, funcionario.getLogin());
            ps.setString(9, funcionario.getSenha());
            ps.setFloat(10, (float) funcionario.getSalario());
            ps.setString(11, funcionario.getCargo());
            ps.setString(12, funcionario.getDepartamento());
            
            int linhasAfetadas = ps.executeUpdate();
            
            if (linhasAfetadas > 0)
                retorno = linhasAfetadas;
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return retorno;
    }
    
    public static ArrayList<Funcionario> obterFuncionarios() {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getFloat("salario"),
                    rs.getString("departamento"),
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getInt("idFuncionario"),
                    rs.getInt("idEmpresa"), 
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getDate("dtNasc"),
                    rs.getBoolean("ativo")                                                                               
                );
                
                listaFuncionarios.add(funcionario);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFuncionarios;
    }
    
    public static ArrayList<Empresa> obterEmpresas() {
        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        String query = "SELECT * FROM Empresa";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
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
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEmpresas;
    }
}
