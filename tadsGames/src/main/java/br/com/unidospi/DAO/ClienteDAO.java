/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;


import br.com.unidospi.model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author henrique.abastos
 */
public class ClienteDAO {
    
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "adminadmin";
    static Connection conexao;
    
    public static void salvar(Cliente cliente)  {

        try {
            String sql= "insert into Cliente (idEmpresa,nome, sobrenome, sexo, cpf, dataNasc, ativo) values(?,?,?,?,?,?,?)";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            Date dt =Date.valueOf(LocalDate.now());
            ps.setString(1, "1");
            ps.setString(2, "Nome");
            ps.setString(3, "Sobrenome");
            ps.setString(4, "Sexo");
            ps.setString(5, "123456");
            ps.setDate(6, dt);
            ps.setBoolean(7, true);
                        
            System.out.println(ps.execute());
            
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }

        }

    }
    
}
