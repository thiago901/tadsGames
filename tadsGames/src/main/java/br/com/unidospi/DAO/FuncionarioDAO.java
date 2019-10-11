/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class FuncionarioDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://localhost:3306/produtobd?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    public static int salvar(Funcionario funcionario) {
        int retorno = 0;
        String sql = "INSERT INTO FUNCIONARIO (idEmpresa, nome, cpf, dtNasc," +
                " ativo, salario, cargo, departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
//            ps.setInt(1, funcionario.getIdEmpresa());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCpf());
            ps.setDate(4, funcionario.getDataNasc());
            ps.setBoolean(5, funcionario.isAtivo());
            ps.setFloat(6, (float) funcionario.getSalario());
            ps.setString(7, funcionario.getCargo());
            ps.setString(8, funcionario.getDepartamento());
            
            int linhasAfetadas = ps.executeUpdate();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
}
