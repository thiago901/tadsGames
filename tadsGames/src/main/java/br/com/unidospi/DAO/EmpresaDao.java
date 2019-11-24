/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;

import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
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
public class EmpresaDao {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://dbgames.czyozk3ol6md.us-east-1.rds.amazonaws.com:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    static final String USUARIO = "root";
    static final String SENHA = "!zxcASD50";
    static Connection conexao;

    
    /* Recebe uma empresa e retorna verdadeiro caso o registro da empresa seja salvo
     * retorna falso casp p registro da empresa não seja salvo na base de dados */
    public static boolean salvar(Empresa empr)  {
        
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
            
            ps.execute();
            return true;
            
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            
        }
        return false;
    }
    // Retorna a ultima empresa cadastrada no sistema
    public static Empresa ultEmpresa() {
        String query = "Select idEmpresa, nome,cnpj from Empresa where (select max(idCliente) from Empresa)=idEmpresa;";
        Empresa e = null;
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                int idEmpresa=rs.getInt("idEmpresa");
                String nome=rs.getString("nome"); 
                String cnpj=rs.getString("cnpj");
                
                e = new Empresa(idEmpresa, nome, cnpj);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return e;
    }
    
    
    
    public static boolean validaNovoCPF(String cpf){
        String query = "Select c.nome from Cliente c where c.cpf LIKE ?;";
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1,  cpf);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                if (rs.getString("nome") != null)
                    return false;
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
    
    /* Recebe uma empresa e retorna verdaidero caso o(s) dado(s) do registro 
       sejam alterados ou falso caso não sejam alterados */
    public static boolean alterar(Empresa empr){
        try{
            Class.forName(DRIVER);
            String sql = "UPDATE Empresa "
                        + "SET nome=?, "
                        + "dataCriacao=?, "
                        + "idEstado=?, "
                        + "idCidade=?, "
                        + "matriz=?, "
                        + "ativo=? "
                        + "where idEmpresa =?";
            
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            
            java.sql.Date dataSql = new java.sql.Date(empr.getDataCriacao().getTime());
            
            ps.setString(1, empr.getNome());
            ps.setDate(2, dataSql);
            ps.setInt(3, empr.getEstado());
            ps.setInt(4, empr.getCidade());
            ps.setBoolean(5, empr.getMatriz());
            ps.setBoolean(6, empr.getStatus());
            ps.setInt(7, empr.getCod());
            
            ps.execute();
            return true;
            
            
        }catch(ClassNotFoundException | SQLException e){
            
        }finally{
            try{
                conexao.close();
            
            }catch(SQLException e){

            }
        }
        return false;
    }

        public static boolean validaNovoCnpj(String cnpj){
        String query = "Select e.nome from Empresa e where e.cnpj LIKE ?;";
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1,  cnpj);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                if (rs.getString("nome") != null)
                    return false;
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
    /* Retorna uma lista de empresas */
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
                        " from Empresa a\n" +
                        "left join EstadoRegiao b on \n" +
                        "a.idEstado = b.idEstado\n" +
                        "left join cidade c on\n" +
                        "c.idCidade = a.idCidade "
                    + "order by a.nome;";
            ArrayList <EmpresaLista> le = new ArrayList<>();
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
                EmpresaLista listaEmpresa = new EmpresaLista
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
    
    // Recebe o identificador de uma empresa e retorna a empresa
    public static EmpresaLista listarEmpresas(int id) {
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
                        " from Empresa a\n" +
                        "left join EstadoRegiao b on \n" +
                        "a.idEstado = b.idEstado\n" +
                        "left join cidade c on\n" +
                        "c.idCidade = a.idCidade \n"
                      + " where a.idEmpresa = ?;";
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
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
                EmpresaLista emp = new EmpresaLista
                                        (idEmpresa, nome, cnpj, dataCriacao, idEstado, uf, regiao, idCidade, nomeCidade, ativo,matriz);
                
                return emp;
                
                
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
        return null;
    }

    
}
