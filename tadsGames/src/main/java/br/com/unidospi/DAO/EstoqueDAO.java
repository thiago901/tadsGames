/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import static br.com.unidospi.DAO.EmpresaDao.DRIVER;
import br.com.unidospi.model.Estoque;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thiago.srocha4
 */
public class EstoqueDAO {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "!zxcASD50";
    static Connection conexao;
    
    
    public static boolean alterar(Estoque est) {
        try {
            String sql = "UPDATE Estoque "
                        + "SET qtdEstoque=?, "
                        + "valorVendaUnitario=? "
                        + "where idProduto =? and idEmpresa =?";
            
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, est.getQtdEstoque());
            ps.setFloat(2, est.getVlrVendaUnitario());
            ps.setInt(3, est.getIdProduto());
            ps.setInt(4, est.getIdEmpresa());

            
            ps.execute();
            return true;
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            
        }
        return false;
        
    }
    public static boolean salvar(Estoque est) {
        try {
            String sql= "insert into Estoque (idProduto, idEmpresa, qtdEstoque, valorVendaUnitario) values(?,?,?,?)";
            
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, est.getIdProduto());
            ps.setInt(2, est.getIdEmpresa());
            ps.setInt(3, est.getQtdEstoque());
            ps.setFloat(4, est.getVlrVendaUnitario());
            

            
            ps.execute();
            return true;
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            
        }
        return false;
        
    }
    public static boolean temEstoque(int idProduto, int idEmpresa) {
        try {
            String sql= "select count(idProduto) as qtd from Estoque where idProduto=? and idEmpresa=?;";
            
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, idProduto);
            ps.setInt(2, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               int resultado = rs.getInt("qtd");
               if(resultado>0){
                   return true;
               }else{
                   return false;
               }
            }
           
            
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            
        }
        return false;
        
    }
    
    public static int qtdEstoque(int idProduto, int idEmpresa) {
        int resultado=0;
        try {
            String sql= "select qtdEstoque as qtd from Estoque where idProduto=? and idEmpresa=?;";
            
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, idProduto);
            ps.setInt(2, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               resultado = rs.getInt("qtd");
               return resultado;
            }
           
            
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            
        }
        return resultado;
        
    }
    
}
