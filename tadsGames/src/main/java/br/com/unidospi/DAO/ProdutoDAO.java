/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
    private static final String SENHA = "";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://localhost:3306/dbgames?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    public static int salvar(Produto produto) throws SQLException {
        int retorno = 0;
        String sql = "INSERT INTO Produto (idProduto, nome, descricao, regiao, status)"
                                         + " VALUES (?, ?, ?, ?, ?);";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, produto.getIdProd());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setString(4, produto.getRegiao());
            ps.setBoolean(5, produto.getStatus());
            
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
    
    public static boolean editar(Produto produto) {
        
        
        return true;
    }
    
    public static boolean alterarStatus(Produto produto) {
        
        
        return true;
    }

    public static boolean incluir(Produto produto) {
        
        
        return true;
    }
}
