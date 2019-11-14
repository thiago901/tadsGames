/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.RelatorioFaturaDia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago.srocha4
 */
public class RelatorioDao {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "adminadmin";
    static Connection conexao;

    

    

    
    
    /* Retorna uma lista de empresas */
    public static ArrayList<String[]> rel_top10_vendas_dia() {
        try{
            String sql = "select * from rel_top10_vendas_dia;";
            
            ArrayList <String[]> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Date dataVenda= rs.getDate("DATA_VENDA");
                String produto= rs.getString("PRODUTO");
                String empresa= rs.getString("EMPRESA");
                int qtd= rs.getInt("QUANTIDADE");
                le.add(new String[]{
                    String.valueOf(dataVenda),
                    produto,
                    empresa,
                    String.valueOf(qtd)
                });
            }
            return le;
        }catch(SQLException | ClassNotFoundException e ){
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
    
    public static ArrayList<RelatorioFaturaDia> rel_fatura_dia() {
        try{
            String sql = "select * from rel_fatura_dia;";
            
            ArrayList <RelatorioFaturaDia> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Date dataVenda= rs.getDate("DATA_VENDA");
                String empresa= rs.getString("EMPRESA");
                int total= rs.getInt("TOTAL");
                le.add(new RelatorioFaturaDia(dataVenda,empresa,total));
                
            }
            return le;
        }catch(SQLException | ClassNotFoundException e ){
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
    
    
    public static ArrayList<String[]> rel_total_empresa_porcentagem() {
        try{
            String sql = "select * from rel_total_empresa_porcentagem;";
            
            ArrayList <String[]> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String empresa= rs.getString("EMPRESA");
                String total= rs.getString("TOTAL_FATURADO");
                double percentagem= rs.getDouble("PORCENTAGEM");
                le.add(new String[]{
                    empresa,
                    total,
                    String.valueOf(percentagem)
                });
            }
            return le;
        }catch(SQLException | ClassNotFoundException e ){
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
