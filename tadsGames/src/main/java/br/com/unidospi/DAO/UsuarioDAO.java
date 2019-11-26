/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Usuario;
import br.com.unidospi.model.UsuarioFuncionario;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.gisidorio
 */
public class UsuarioDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "!zxcASD50";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    
    /* recebe um usuário e retorna 1 caso os dados sejam salvos com sucesso
       e 0 caso não seja salvo com sucesso */
    public static int salvar(Usuario usuario) {
        int retorno = 0;
        String query = "INSERT INTO Usuario(nomeUsuario, senha, dataCadastro, ativo, idFuncionario) " +
                " VALUES(?, ?, ?, ?, ?)";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            java.sql.Date dataSql = new java.sql.Date(usuario.getDtCadastro().getTime());
            
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setDate(3, dataSql);
            ps.setBoolean(4, usuario.getStatus());
            ps.setInt(5, usuario.getIdFuncionario());
            
            int linhasAfetadas = ps.executeUpdate();
            
            if (linhasAfetadas > 0)
                retorno = linhasAfetadas;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
    /* retorna uma lista de usuarios associados com funcionarios */
    public static ArrayList<UsuarioFuncionario> obterFuncionariosSemUsuario() {
        ArrayList<UsuarioFuncionario> listaUsuarios = new ArrayList<>();
        
        String query = "SELECT f.idFuncionario,\n" + 
                       " f.nomeFuncionario,\n" + 
                       " f.sobrenome,\n" + 
                       " f.departamento,\n" + 
                       " f.cargo\n" + 
                       " FROM Usuario u\n" +
                       " RIGHT JOIN Funcionario f\n" +
                       " ON u.idFuncionario = f.idFuncionario\n" +
                       " WHERE u.idFuncionario IS NULL\n" +
                       " AND f.ativo = true;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                UsuarioFuncionario usuarioFuncionario = new UsuarioFuncionario(
                        rs.getInt("idFuncionario"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("sobrenome"),
                        rs.getString("departamento"),
                        rs.getString("cargo")
                );
                
                listaUsuarios.add(usuarioFuncionario);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUsuarios;        
    }
    
    //Retorna o id do ultimo Usuario cadastrado no sistema
    public static int ultUsuario() {
        String query = "Select idFuncionario from Funcionario where (select max(idFuncionario) from Funcionario)=idFuncionario;";
        int idFuncionario = 0;
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                idFuncionario=rs.getInt("idFuncionario");
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return idFuncionario;
    }
    
    public static UsuarioFuncionario obterUsuarioFuncionarioPorId(int id) {
        UsuarioFuncionario usuarioFuncionario = null;
        
        String query = "SELECT f.idFuncionario,\n" + 
                       " f.nomeFuncionario,\n" + 
                       " f.sobrenome,\n" + 
                       " f.departamento,\n" + 
                       " f.cargo\n" + 
                       " FROM Usuario u\n" +
                       " RIGHT JOIN Funcionario f\n" +
                       " ON u.idFuncionario = f.idFuncionario\n" +
                       " WHERE u.idFuncionario IS NULL\n" +
                       " AND f.ativo = true\n" +
                       " AND f.idFuncionario = ?;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()) {
                usuarioFuncionario = new UsuarioFuncionario(
                        rs.getInt("idFuncionario"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("sobrenome"),
                        rs.getString("departamento"),
                        rs.getString("cargo")
                );
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarioFuncionario;
    }
    
    public static UsuarioFuncionario obterUsuarioLogado(String login, String senha)  {
        UsuarioFuncionario usuarioFuncionario = null;
        
        String query = "SELECT u.idUsuario,\n "
                     + " u.nomeUsuario,\n"
                     + " f.departamento,\n"
                     + " f.cargo,\n"
                     + "f.idEmpresa,\n"
                     + "f.idFuncionario\n"
                     + " FROM Usuario u\n"
                     + " INNER JOIN Funcionario f\n"
                     + " ON u.idFuncionario = f.idFuncionario\n"
                     + " WHERE   u.nomeUsuario = ?\n"
                     + " AND     u.senha = ?;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                usuarioFuncionario = new UsuarioFuncionario(
                        rs.getInt("idUsuario"),
                        rs.getString("nomeUsuario"),
                        rs.getString("departamento"),
                        rs.getString("cargo"),
                        rs.getInt("idEmpresa"),
                        rs.getInt("idFuncionario")
                );
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return usuarioFuncionario;
    }
    
    public static ArrayList<UsuarioFuncionario> obterUsuarios() {
        ArrayList<UsuarioFuncionario> listaUsuarios = new ArrayList<>();
        
        String query = "SELECT u.idUsuario,\n"
                     + " f.nomeFuncionario,\n "
                     + " f.sobrenome,\n"
                     + " u.nomeUsuario,\n"
                     + " u.ativo\n"
                     + " FROM Usuario u\n"
                     + " INNER JOIN Funcionario f\n"
                     + " ON u.idFuncionario = f.idFuncionario";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                UsuarioFuncionario usuarioFuncionario = new UsuarioFuncionario(
                        rs.getInt("idUsuario"),
                        rs.getString("nomeUsuario"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("sobrenome"),
                        rs.getBoolean("ativo")
                );
                
                listaUsuarios.add(usuarioFuncionario);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUsuarios;
    }
    
    public static Usuario obterUsuarioPorId(int id) {
        Usuario usuario = null;
        
        String query = "SELECT u.idUsuario,\n"
                     + " u.nomeUsuario,\n"
                     + " u.senha,\n"
                     + " u.ativo\n"
                     + " FROM Usuario u"
                     + " WHERE u.idUsuario = ?;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())  {
                usuario = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nomeUsuario"),
                    rs.getString("senha"),
                    rs.getBoolean("ativo")
                );
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    public static boolean editar(Usuario usuario) {
        String query = "UPDATE Usuario SET nomeUsuario = ?,\n"
                                        + "senha = ?,\n"
                                        + "ativo = ?\n"
                                        + "WHERE idUsuario = ?;";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setBoolean(3, usuario.getStatus());
            ps.setInt(4, usuario.getIdUsuario());
            
            ps.execute();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
