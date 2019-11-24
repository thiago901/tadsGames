/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import br.com.unidospi.model.RelatorioFaturaDia;
import br.com.unidospi.model.RelatorioGeral;
import br.com.unidospi.model.RelatorioPercentagem;
import br.com.unidospi.model.RelatorioTop10;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago.srocha4
 */
public class RelatorioDao {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "!zxcASD50";
    static Connection conexao;

   

    

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
       
       public static ArrayList<RelatorioGeral> relatorioGeral() {
        try{
            String sql = "SELECT\n" +
                        "    r0.idEmpresa, \n" +
                        "    r0.nome, \n" +
                        "    r1.TOTAL AS \"Valor Faturado (A)\",\n" +
                        "    r2.TOTAL AS \"Valor Faturado (B)\",\n" +
                        "    (r2.TOTAL-r1.TOTAL)/r1.TOTAL as \"Variação\"\n" +
                        " \n" +
                        "FROM\n" +
                        "    (SELECT DISTINCT \n" +
                        "        a.idEmpresa,\n" +
                        "        c.nome\n" +
                        "     FROM venda a\n" +
                        "     INNER JOIN empresa c on \n" +
                        "		c.idempresa = a.idEmpresa) r0\n" +
                        "    left JOIN (SELECT \n" +
                        "				a.idEmpresa,\n" +
                        "				concat(year(a.datavenda),month(a.datavenda)) AS AnoMes,\n" +
                        "				sum(b.vlrTotalItem) AS TOTAL\n" +
                        "			FROM venda a\n" +
                        "			INNER JOIN detalheVenda b\n" +
                        "				ON b.idVenda = a.idVenda\n" +
                        "			where (month((LAST_DAY(curdate() - INTERVAL 1 MONTH))) =month(a.datavenda) and \n" +
                        "			year((LAST_DAY(curdate() - INTERVAL 1 MONTH))) = year(a.datavenda)) \n" +
                        "			group by a.idEmpresa) r1\n" +
                        "        ON r1.idEmpresa = r0.idEmpresa\n" +
                        "    left JOIN (SELECT a.idEmpresa,\n" +
                        "				sum(b.vlrTotalItem) AS TOTAL\n" +
                        "				FROM venda a\n" +
                        "				INNER JOIN detalheVenda b ON \n" +
                        "				b.idVenda = a.idVenda\n" +
                        "				where 	month(dataVenda) = month(curdate()) AND\n" +
                        "						YEAR(dataVenda) = YEAR(curdate())\n" +
                        "				group by a.idEmpresa) r2\n" +
                        "        ON r2.idEmpresa = r0.idEmpresa\n" +
                        "ORDER BY  r0.idEmpresa;";
            
            
            
            ArrayList <RelatorioGeral> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idEmpresa =rs.getInt("idEmpresa");
                String nome=rs.getString("nome");
                float valorFaturaA=rs.getFloat("Valor Faturado (A)");
                float valorFaturaB=rs.getFloat("Valor Faturado (B)");
                double variacao=rs.getDouble("Variação");
                le.add(new RelatorioGeral(idEmpresa, nome, valorFaturaA, valorFaturaB, variacao));
                
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
       public static ArrayList<RelatorioGeral> relatorioDiario() {
        try{
            String sql = "SELECT * from rel_fatura_dia;";
            
            
            
            ArrayList <RelatorioGeral> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idEmpresa =rs.getInt("idEmpresa");
                String nome=rs.getString("NomeEmpresa");
                float total=rs.getFloat("TOTAL");
                le.add(new RelatorioGeral(idEmpresa, nome, total));
                
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
       public static float totalMes() {
        try{
            String sql = "select * from TotalFaturadoMes;";
            
            ArrayList <RelatorioGeral> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                float total=rs.getFloat("TOTAL");
                return total;
            }
            
        }catch(SQLException | ClassNotFoundException e ){
            e.getMessage();
        }finally{
            try{
                conexao.close();
            }catch(SQLException e){
                e.getMessage();
            }
        }
        return 0;
    } 
       public static float totalDia() {
        try{
            String sql = "select * from TotalFaturadoDia;";
            
            ArrayList <RelatorioGeral> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                float total=rs.getFloat("TOTAL");
                return total;
            }
            
        }catch(SQLException | ClassNotFoundException e ){
            e.getMessage();
        }finally{
            try{
                conexao.close();
            }catch(SQLException e){
                e.getMessage();
            }
        }
        return 0;
    } 
    
    /* Retorna uma lista de empresas */
    public static ArrayList<RelatorioTop10> rel_top10_vendas_dia() {
        try{
            String sql = "select * from rel_top10_vendas_dia;";
            
            ArrayList <RelatorioTop10> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                String produto= rs.getString("PRODUTO");
                String empresa= rs.getString("EMPRESA");
                int qtd= rs.getInt("QUANTIDADE");
                float valor= rs.getFloat("Valor");
                le.add(new RelatorioTop10(produto, empresa, qtd,valor));
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
    
   
    
    public static ArrayList<RelatorioPercentagem> rel_total_empresa_porcentagem() {
        try{
            String sql = "select * from rel_total_empresa_porcentagem;";
            
            ArrayList <RelatorioPercentagem> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String empresa= rs.getString("EMPRESA");
                double total= rs.getDouble("TOTAL_FATURADO");
                double percentagem= rs.getDouble("PORCENTAGEM");
                le.add(new RelatorioPercentagem(empresa, total, percentagem));
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
