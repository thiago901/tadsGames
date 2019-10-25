/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Cidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Thiago
 */
public class CidadeDAO {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String USUARIO="root";
    private static final String SENHA = "adminadmin";
    private static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;
    
    // retorna uma lista de cidades
    public static ArrayList listaCidade() {
        try{
            ArrayList <Cidade> cid = new ArrayList();
            String sql ="select * from Cidade";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"), rs.getInt("idEstado"));
                cid.add(cidade);
            }
            return cid;
            
        }catch(ClassNotFoundException | SQLException e){
            e.getMessage();
        }finally{
            try{
                conexao.close();
            }catch(SQLException e){
                e.getMessage();    
            }
        }
        
        return null;
        
    }
    
    // recebe um uf e retorna uma lista de cidades da uf especificada
    public static ArrayList listaCidade(int uf) {
        try{
            ArrayList <Cidade> cid = new ArrayList();
            String sql ="select * from Cidade where idEstado = ?";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, uf);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"), rs.getInt("idEstado"));
                cid.add(cidade);
            }
            return cid;
            
        }catch(ClassNotFoundException | SQLException e){
            e.getMessage();
        }finally{
            try{
                conexao.close();
            }catch(SQLException e){
                e.getMessage();    
            }
        }
        
        return null;
        
    }
}
