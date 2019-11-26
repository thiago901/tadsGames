/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import static br.com.unidospi.DAO.ClienteDAO.DRIVER;
import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.Produto;
import br.com.unidospi.model.ProdutoLista;
import java.sql.Connection;
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
 * @author marco.assilva8
 * @author lucas.sfaria5
 */
public class ProdutoDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    static final String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String SENHA = "!zxcASD50";

    private static Connection conexao;
    
    
    /* Recebe um produto e retorna 1 caso o registro do produto seja salvo
       na base de dados ou 0 caso não seja salvo */
    public static int salvar(Produto produto) throws SQLException {
        int retorno = 0;
        String sql = "INSERT INTO Produto (idProduto, nome, descricao, tipo, ativo)"
                                         + " VALUES (?, ?, ?, ?, ?);";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, produto.getIdProduto());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getTipo());
            ps.setBoolean(5, produto.getAtivo());
            
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0)
                retorno = linhasAfetadas;
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return retorno;
    }
    
    /* Recebe um produto e retorna 1 caso o(s) dado(s) do registro do produto
       seja(m) alterado(s) ou 0 caso não seja(s) alterado(s) */
    public static boolean editar(Produto produto) {
        String query = "update Produto set nome=?,descricao=?, tipo=?, ativo=? where idProduto=?";
        
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setString(3, produto.getTipo());
            ps.setBoolean(4, produto.getAtivo());
            ps.setInt(5, produto.getIdProduto());
                                  
            
            ps.execute();
            return true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }
    
    public static boolean alterarStatus(Produto produto) {
        
        
        return true;
    }
    //Retorna o id, nome do ultimo produto cadastrado no sistema
    public static Produto ultProduto() {
        String query = "Select idProduto, nome from Produto where (select max(idProduto) from Produto)=idProduto;";
        Produto p = null;
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                int idProduto=rs.getInt("idProduto");
                String nome=rs.getString("nome"); 
                
                p = new Produto(idProduto, nome);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return p;
    }
    // Retorna uma lista de produtos
    public static ArrayList<Produto> listarProduto() {
        ArrayList<Produto> lista = new ArrayList<>();
        String query = "SELECT * FROM Produto;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String tipo = rs.getString("tipo");
                Boolean ativo = rs.getBoolean("ativo");
                
                Produto p = new Produto(idProduto, nome, descricao, tipo, ativo);
                lista.add(p);
                
            }
            for (int i = 0; i > lista.size(); i++) {
                System.out.println(lista.get(i));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
   
    public static ArrayList<ProdutoLista> listarProduto(String nomePesquisado,int idEmpresa) {
        ArrayList<ProdutoLista> lista = new ArrayList<>();
        
        
        String query = "select p.idProduto,p.nome, e.qtdEstoque, e.valorVendaUnitario from Produto p\n" +
                    "inner join Estoque e on\n" +
                    "p.idProduto = e.idProduto"
                + " where (p.nome LIKE ? or p.idProduto LIKE ?) and e.idEmpresa=?;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, "%"+ nomePesquisado +"%");
            ps.setString(2, "%"+ nomePesquisado +"%");
            ps.setInt(3,idEmpresa);
            ResultSet rs = ps.executeQuery();
            
            
            
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                int qtdEstoque = rs.getInt("qtdEstoque");
                float vlrUnitario = rs.getFloat("valorVendaUnitario");
                
                ProdutoLista p = new ProdutoLista(idProduto, nome, qtdEstoque, vlrUnitario);
                lista.add(p);
                
            }
            for (int i = 0; i > lista.size(); i++) {
                System.out.println(lista.get(i));
            }

        } catch (ClassNotFoundException ex) {
            ex.getMessage();
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    /* Recebe um identificador de um produto e retorna o produto */
    public static Produto listarProduto(int id) {
        String query = "SELECT * FROM Produto where idProduto = ?";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String tipo = rs.getString("tipo");
                Boolean ativo = rs.getBoolean("ativo");
                
                Produto p = new Produto(idProduto, nome, descricao, tipo, ativo);
                return p;
                
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
