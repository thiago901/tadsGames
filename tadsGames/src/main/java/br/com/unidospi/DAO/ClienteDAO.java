/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.DAO;


import br.com.unidospi.model.Cliente;
import br.com.unidospi.model.ClienteLista;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique.abastos
 */
public class ClienteDAO {
    // &useTimezone=true&serverTimezone=UTC
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dbGames?useUnicode=yes&characterEncoding=UTF-8";
    static final String USUARIO = "root";
    static final String SENHA = "adminadmin";
    static Connection conexao;
    
    /* recebe um objeto cliente e retorna 1 caso obtenha sucesso em salvar cliente
     * ou 0 caso não obtenha sucesso */   
    public static int salvar(Cliente cliente)  {
            
        int retorno = 0;
        try {
            String sql= "insert into Cliente (nome, sobrenome, sexo, idEmpresa, cpf, dtNasc, ativo) values(?,?,?,?,?,?,?)";
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            
            
            java.sql.Date dtSQL = new java.sql.Date(cliente.getDataNasc().getTime());
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobrenome());
            ps.setString(3, cliente.getSexo());
            ps.setInt(4,cliente.getIdEmpresa());
            ps.setString(5, cliente.getCpf());
            ps.setDate(6, dtSQL);
            ps.setBoolean(7, cliente.isAtivo());
    
            ps.executeUpdate();
            return 1;
                                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return retorno;
    }
    
    // retorna uma lista de clientes
    public static ArrayList<ClienteLista> listarClientes() {
        ArrayList<ClienteLista> listaClientes = new ArrayList<>();
        String query = "SELECT 	a.idCliente, " +
                      "a.nome,	\n" +
        "		a.sobrenome,\n" +
        "		a.CPF,\n" +
               "        a.dtNasc,\n" +
               "        a.sexo,\n" +
               "        a.idempresa,\n" +
               "        b.nome as nomeEmpresa,\n" +
               "        a.ativo\n" +
        "\n" +
                    "FROM cliente a \n" +
                    "left join empresa b on \n" +
                    "a.idempresa = b.idempresa;";
        
        try {
            Calendar c = Calendar.getInstance();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                int idCliente=rs.getInt("idCliente");
                String nome=rs.getString("nome"); 
                String sobrenome=rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                Date dtNasc=rs.getDate("dtNasc");
                String sexo=rs.getString("sexo");
                int idempresa =rs.getInt("idEmpresa");
                String nomeEmpresa=rs.getString("nomeEmpresa");; 
                boolean ativo=rs.getBoolean("ativo") ;
                ClienteLista cliente = new ClienteLista(idCliente, nome, sobrenome, cpf, dtNasc, sexo, idempresa, nomeEmpresa, ativo);
                listaClientes.add(cliente);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return listaClientes;
    }
    //Retorna o id, nome e sobrenome do ultimo cliente cadastrado no sistema
    public static Cliente ultCliente() {
        String query = "Select idCliente, nome,sobrenome from Cliente where (select max(idCliente) from Cliente)=idCliente;";
        Cliente cliente = null;
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                int idCliente=rs.getInt("idCliente");
                String nome=rs.getString("nome"); 
                String sobrenome=rs.getString("sobrenome");
                
                cliente = new Cliente(idCliente, nome, sobrenome);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return cliente;
    }
    
    
    
    public static boolean validaNovoCPF(String cpf){
        String query = "Select c.nome from CLIENTE c where c.cpf LIKE ?;";
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
    
    
     public static ArrayList<Cliente> listarClientes(String nomePesquisado) {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        
        String query = "select * from cliente where nome LIKE ? or cpf like ? order by nome;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, "%"+ nomePesquisado +"%");
            ps.setString(2, "%"+ nomePesquisado +"%");
            ResultSet rs = ps.executeQuery();
            
            
            
            while (rs.next()) {
                int idProduto = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String sexo = rs.getString("sexo");
                int idEmpresa = rs.getInt("idEmpresa");
                String cpf = rs.getString("cpf");
                Date dtNasc = rs.getDate("dtNasc");
                boolean ativo = rs.getBoolean("ativo");
                Cliente c = new Cliente(idProduto, idEmpresa, nome, sobrenome, sexo, cpf, dtNasc, ativo);
                lista.add(c);
                
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
    
    // retorna um cliente localizando pelo identificador
    public static ClienteLista listarClientes(int id) {
        
        String query = "SELECT 	a.idCliente, " +
                      "a.nome,	\n" +
        "		a.sobrenome,\n" +
        "		a.CPF,\n" +
               "        a.dtNasc,\n" +
               "        a.sexo,\n" +
               "        a.idempresa,\n" +
               "        b.nome as nomeEmpresa,\n" +
               "        a.ativo\n" +
                        "\n" +
                    "FROM cliente a \n" +
                    "left join empresa b on \n" +
                    "a.idempresa = b.idempresa "
                + "where a.idCliente = ?;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idCliente=rs.getInt("idCliente");
                String nome=rs.getString("nome"); 
                String sobrenome=rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                Date dtNasc=rs.getDate("dtNasc");
                String sexo=rs.getString("sexo");
                int idempresa =rs.getInt("idEmpresa");
                String nomeEmpresa=rs.getString("nomeEmpresa");; 
                boolean ativo=rs.getBoolean("ativo") ;
                ClienteLista cliente = new ClienteLista(idCliente, nome, sobrenome, cpf, dtNasc, sexo, idempresa, nomeEmpresa, ativo);
                return cliente;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return null;
    }
    
    /* Recebe um objeto cliente e retrna 1 caso o registro do cliente seja salvo
     * ou zero caso não seja salvo */
    public static int alterar(Cliente cliente) {
        
        String query = "update cliente\n" +
                        "SET nome=?,	\n" +
                        "	sobrenome=?,\n" +
                        "	dtNasc=?,\n" +
                        "	sexo=?,\n" +
                        "	idempresa=?,\n" +
                        "	ativo =?\n" +
                        "where idCliente=?;";
        
        try {                        
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            
            PreparedStatement ps = conexao.prepareStatement(query);
            
            java.sql.Date dtSQL = new java.sql.Date(cliente.getDataNasc().getTime());
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobrenome());
            ps.setDate(3, dtSQL);
            ps.setString(4, cliente.getSexo());
            ps.setInt(5,cliente.getIdEmpresa());       
            ps.setBoolean(6, cliente.isAtivo());
            ps.setInt(7, cliente.getId());
            
            ps.executeUpdate();
            return 1;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return 0;
    }
    
}
