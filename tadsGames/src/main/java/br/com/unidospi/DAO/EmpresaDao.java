/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author thiago.srocha4
 */
public class EmpresaDao {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "adminadmin";
    static Connection conexao;

    public static void salvar(Empresa empr)  {

        try {
            String sql= "insert into Empresa (nome, cnpj, dataCriacao, idEstado, matriz, ativo) values(?,?,?,?,?,?)";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            java.sql.Date dataSql = new java.sql.Date(empr.getDataCriacao().getTime());
            ps.setString(1, empr.getNome());
            ps.setString(2, empr.getCnpj());
            ps.setDate(3, dataSql);
            ps.setInt(4, empr.getEstado());
            ps.setBoolean(5, empr.getMatriz());
            ps.setBoolean(6, empr.getStatus());
            
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
