/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Venda;
import br.com.unidospi.model.VendaDetalhe;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago.srocha4
 */
public class VendaDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "!zxcASD50";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    /* recebe um usuário e retorna 1 caso os dados sejam salvos com sucesso
     e 0 caso não seja salvo com sucesso */
    private static int salvarVendaDetalhe(List<VendaDetalhe> vd,int idVenda) {
        String sql = "INSERT INTO DetalheVenda(idVenda, idProduto, qtdVenda, vlrVenda,vlrTotalItem ) "
                + " VALUES(?, ?, ?, ?,?)";
        

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
           for(VendaDetalhe v : vd){
                ps.setInt(1, idVenda);
                ps.setInt(2, v.getIdProduto());
                ps.setInt(3, v.getQtdVenda());
                ps.setFloat(4, v.getVlrUnitario());
                ps.setFloat(5, v.getVlrTotal());
                ps.executeUpdate();
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
        return 0;
    }
    
    //Retorna todos os dados da ultima venda cadastrada no sistema
    public static Venda ultVenda() {
        String query = "Select * from Venda where (select max(idVenda) from Venda)=idVenda;";
        Venda v = null;
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idVenda=rs.getInt("idVenda");
                int idFuncionario=rs.getInt("idFuncionario");
                int idCliente=rs.getInt("idCliente");
                int idEmpresa=rs.getInt("idEmpresa");
                float valorTotal=rs.getFloat("valorTotal");
                Date dtVenda=rs.getDate("dataVenda");
                String status=rs.getString("statusPedido"); 
                
                v = new Venda(idVenda, idCliente, idEmpresa, idFuncionario, valorTotal, dtVenda, status);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return v;
    }
    
    public static int salvar(Venda venda) {

        String sql = "INSERT INTO Venda(idCliente,idEmpresa,valorTotal, dataVenda, statusPedido,idFuncionario ) "
                + " VALUES(?, ?, ?, ?, ?,?)";

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
            java.sql.Date dataSql = new java.sql.Date(venda.getDtVenda().getTime());

            ps.setInt(1, venda.getIdCliente());
            ps.setInt(2, venda.getIdEmpresa());
            ps.setFloat(3, venda.getVlrVenda());
            ps.setDate(4, dataSql);
            ps.setString(5, venda.getStatusVenda());
            ps.setInt(6, venda.getIdFuncionario());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                int chaveVenda = rs.getInt(1);
                salvarVendaDetalhe(venda.getVendaDetalhe(),chaveVenda);
                return chaveVenda;
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
        return 0;

    }

}
