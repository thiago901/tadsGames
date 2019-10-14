/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.ListaEmpresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
            String sql= "insert into Empresa (nome, cnpj, dataCriacao, idEstado,idCidade, matriz, ativo) values(?,?,?,?,?,?,?)";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            java.sql.Date dataSql = new java.sql.Date(empr.getDataCriacao().getTime());
            ps.setString(1, empr.getNome());
            ps.setString(2, empr.getCnpj());
            ps.setDate(3, dataSql);
            ps.setInt(4, empr.getEstado());
            ps.setInt(5, empr.getCidade());
            ps.setBoolean(6, empr.getMatriz());
            ps.setBoolean(7, empr.getStatus());
            
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

    public static ArrayList listarEmpresas() {
        try{
            String sql = "select a.idEmpresa,\n" +
                        "        a.nome,\n" +
                        "        a.cnpj,\n" +
                        "        a.dataCriacao,\n" +
                        "        a.idEstado,\n" +
                        "        b.uf,\n" +
                        "        b.regiao,\n" +
                        "        a.idCidade,\n" +
                        "        c.nomeCidade,\n" +
                        "        a.ativo,\n" +
                        "        a.matriz\n" +
                        " from empresa a\n" +
                        "left join estadoregiao b on \n" +
                        "a.idEstado = b.idEstado\n" +
                        "left join cidade c on\n" +
                        "c.idCidade = a.idCidade;";
            ArrayList <ListaEmpresa> le = new ArrayList<>();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idEmpresa= rs.getInt("idEmpresa");
                String nome= rs.getString("nome");
                String cnpj= rs.getString("cnpj");
                Date dataCriacao= rs.getDate("dataCriacao");
                int idEstado= rs.getInt("idEstado");
                String uf= rs.getString("uf");
                String regiao= rs.getString("regiao");
                int idCidade= rs.getInt("idCidade");
                String nomeCidade= rs.getString("nomeCidade");
                Boolean ativo= rs.getBoolean("ativo");
                Boolean matriz= rs.getBoolean("matriz");
                ListaEmpresa listaEmpresa = new ListaEmpresa
                                        (idEmpresa, nome, cnpj, dataCriacao, idEstado, uf, regiao, idCidade, nomeCidade, ativo,matriz);
                
                le.add(listaEmpresa);
                
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