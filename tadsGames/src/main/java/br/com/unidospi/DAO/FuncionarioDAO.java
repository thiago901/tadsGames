 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Funcionario;
import br.com.unidospi.model.FuncionarioEmpresa;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class FuncionarioDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "!zxcASD50";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    /* Recebe um funcionario e retorna 1 caso o registro do funcionário seja salvo
       ou 0 caso o registro não seja salvo na base de dados */
    public static int salvar(Funcionario funcionario) {
        int retorno = 0;
        String sql = "INSERT INTO Funcionario (idEmpresa, nomeFuncionario, sobrenome, sexo, cpf, dtNasc," +
                " ativo, salario, cargo, departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date dataSql = new java.sql.Date(funcionario.getDataNasc().getTime());
            
            ps.setInt(1, funcionario.getIdEmpresa());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setString(4, funcionario.getSexo());
            ps.setString(5, funcionario.getCpf());
            ps.setDate(6, dataSql);
            ps.setBoolean(7, funcionario.isAtivo());
            ps.setFloat(8, (float) funcionario.getSalario());
            ps.setString(9, funcionario.getCargo());
            ps.setString(10, funcionario.getDepartamento());
            
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
    
    // Retorna uma lista de funcionários
    public static ArrayList<FuncionarioEmpresa> obterFuncionarios() {
        ArrayList<FuncionarioEmpresa> listaFuncionarioEmpresas = 
                new ArrayList<>();
        
        String query = "SELECT f.idFuncionario,\n"
                    + "f.nomeFuncionario,\n" +
                     " f.sobrenome,\n" +
                     " f.cpf,\n" +
                     " f.sexo,\n" +
                     " f.dtNasc,\n" +
                     " f.ativo,\n" +
                     " f.salario,\n" +
                     " f.cargo,\n" +
                     " f.departamento,\n" +
                     " e.idEmpresa,\n" +
                     " e.nome\n" +
                     " FROM Funcionario f\n"
                   + "LEFT JOIN Empresa e\n"
                   + "ON f.idEmpresa = e.idEmpresa;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                FuncionarioEmpresa funcionarioEmpresa = new FuncionarioEmpresa(
                    rs.getInt("idFuncionario"),
                    rs.getString("nomeFuncionario"),
                    rs.getString("sobrenome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getDate("dtNasc"),
                    rs.getBoolean("ativo"),
                    rs.getFloat("salario"),
                    rs.getString("cargo"),  
                    rs.getString("departamento"),                                      
                    rs.getInt("idEmpresa"),                        
                    rs.getString("nome")
                );
                
                listaFuncionarioEmpresas.add(funcionarioEmpresa);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFuncionarioEmpresas;
    }
    
//    /* Recebe um identificador de um funcionário 
//       e retorna o funcionário identificado */
//    public static Funcionario obterFuncionarioPorId(int id) {
//        Funcionario funcionario = null;
//        String query = "SELECT * FROM Funcionario WHERE idFuncionario = ?";
//        
//        try {
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
//            PreparedStatement ps = conexao.prepareStatement(query);                                                
//            
//            ps.setInt(1, id);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                int idEmpresa = rs.getInt("idEmpresa");
//                String nome = rs.getString("nomeFuncionario");
//                String sobrenome = rs.getString("sobrenome");
//                String sexo = rs.getString("sexo");
//                String cpf = rs.getString("cpf");
//                Date dtNasc = rs.getDate("dtNasc");
//                boolean ativo = rs.getBoolean("ativo");
//                String login = rs.getString("login");
//                String senha = rs.getString("senha");
//                float salario = rs.getFloat("salario");
//                String cargo = rs.getString("cargo");
//                String departamento = rs.getString("departamento");
//                
//                funcionario = new Funcionario(salario, departamento, cargo, 
//                        login, senha, id, idEmpresa, nome, sobrenome, sexo, cpf, dtNasc, 
//                        ativo);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }            
//                
//        return funcionario;
//    }
    
//    /* retorna uma lista de empresas sem os dados de funcionarios */
//    public static ArrayList<Empresa> obterEmpresas() {
//        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
//        String query = "SELECT * FROM Empresa";
//        
//        try {                        
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
//            PreparedStatement ps = conexao.prepareStatement(query);
//            ResultSet rs = ps.executeQuery(query);
//            
//            while (rs.next()) {
//                Empresa empresa = new Empresa(
//                    rs.getInt("idEmpresa"), 
//                    rs.getString("nome"),
//                    rs.getString("cnpj"),
//                    rs.getDate("dataCriacao"),
//                    rs.getInt("idEstado"),
//                    2,
//                    rs.getBoolean("matriz"),
//                    rs.getBoolean("ativo")                    
//                );
//                
//                listaEmpresas.add(empresa);
//            }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return listaEmpresas;
//    }
    
//    /* Retorna uma lista de Funcionarios sem os dados de emprsas */
//    public static ArrayList<Funcionario> obterFuncionario() {
//        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
//        String query = "SELECT * FROM Funcionario";
//        
//        try {                        
//            Class.forName(DRIVER);
//            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
//            PreparedStatement ps = conexao.prepareStatement(query);
//            ResultSet rs = ps.executeQuery(query);
//            
//            while (rs.next()) {
//                Funcionario funcionario = new Funcionario(
//                    rs.getFloat("salario"),
//                    rs.getString("cargo"),  
//                    rs.getString("departamento"),
//                    rs.getString("login"),
//                    rs.getString("senha"),
//                    rs.getInt("idFuncionario"),
//                    rs.getInt("idEmpresa"),
//                    rs.getString("nomeFuncionario"),
//                    rs.getString("sobrenome"),
//                    rs.getString("sexo"),
//                    rs.getString("cpf"),
//                    rs.getDate("dtNasc"),
//                    rs.getBoolean("ativo")
//                );
//                
//                listaFuncionario.add(funcionario);
//            }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return listaFuncionario;
//    }
    
    /* Recebe um funcionário e retorna 1 caso o(s) dado(s) do registro do
       funcionário seja(m) alterado(s) ou 0 caso não sejam alterado(s) */
    public static int alterar(Funcionario funcionario) {
        int retorno = 0;
        String query = "UPDATE Funcionario " +
                       "SET idEmpresa = ?,"
                     + "nomeFuncionario = ?," 
                     + "sobrenome = ?,"
                     + "sexo = ?,"
                     + "dtNasc = ?,"
                     + "ativo = ?,"
                     + "salario = ?,"
                     + "cargo = ?,"
                     + "departamento = ?"
                     + "WHERE idFuncionario = ?;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date dataSql = new java.sql.Date(funcionario.getDataNasc().getTime());
            
            ps.setInt(1, funcionario.getIdEmpresa());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setString(4, funcionario.getSexo());
            ps.setDate(5, dataSql);
            ps.setBoolean(6, funcionario.isAtivo());
            ps.setFloat(7, (float) funcionario.getSalario());
            ps.setString(8, funcionario.getCargo());
            ps.setString(9, funcionario.getDepartamento());
            ps.setInt(10, funcionario.getId());
            
            
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
    public static boolean validaNovoCPF(String cpf){
        String query = "Select f.nomeFuncionario from Funcionario f where f.cpf LIKE ?;";
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1,  cpf);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                if (rs.getString("nomeFuncionario") != null)
                    return false;
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    /* Recebe um identificador de um fucionário e retorna o funcionário
       identificado pelo id */
    public static FuncionarioEmpresa obterFuncionarioEmpresaPorId(int id) {
        FuncionarioEmpresa funcionarioEmpresa = null;
        
        String query = "SELECT f.idFuncionario, \n"
                    + " f.nomeFuncionario, \n" +
                     " f.sobrenome, \n" +
                     " f.cpf, \n" +
                     " f.sexo, \n" +
                     " f.dtNasc, \n" +
                     " f.ativo, \n" +
                     " f.salario, \n" +
                     " f.cargo, \n" +
                     " f.departamento, \n" +
                     " e.idEmpresa, \n" +
                     " e.nome \n" +
                     " FROM Funcionario f \n"
                   + " LEFT JOIN Empresa e \n"
                   + " ON f.idEmpresa = e.idEmpresa \n"
                   + " WHERE f.idFuncionario = ?;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                funcionarioEmpresa = new FuncionarioEmpresa(
                    id,
                    rs.getString("nomeFuncionario"),
                    rs.getString("sobrenome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getDate("dtNasc"),
                    rs.getBoolean("ativo"),
                    rs.getFloat("salario"),
                    rs.getString("cargo"),  
                    rs.getString("departamento"),                                      
                    rs.getInt("idEmpresa"),                        
                    rs.getString("nome")
                );
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionarioEmpresa;
    }
}
