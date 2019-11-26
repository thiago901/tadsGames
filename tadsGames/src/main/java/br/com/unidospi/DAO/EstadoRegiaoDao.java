/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;


import br.com.unidospi.model.EstadoRegiao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thiago.srocha4
 */
public class EstadoRegiaoDao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "!zxcASD50";
    private static Connection conexao;
    
    // Retorna uma lista de estados e regiões
    public static ArrayList <EstadoRegiao> listarEstadosRegioes() {
        ArrayList <EstadoRegiao>listaEstadosRegioes = new ArrayList();
        
        try{
            Class.forName(DRIVER);
            String sql="select * from EstadoRegiao";
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet  rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idEstado");
                String uf = rs.getString("uf");
                String estado = rs.getString("estado");
                String capital = rs.getString("capital");
                String regiao = rs.getString("regiao");
                String pais = rs.getString("pais");
                
                EstadoRegiao er = new EstadoRegiao(id, uf, estado, capital, regiao, pais);
                listaEstadosRegioes.add(er);
            }
            return listaEstadosRegioes;

        }catch(SQLException | ClassNotFoundException e){
            e.getMessage();
        }
        return null;
    }
    
    
}
