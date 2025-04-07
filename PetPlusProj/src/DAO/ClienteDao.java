/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.conectar;
import classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rakon
 */
public class ClienteDao extends Cliente {

    
    public void adicionar (ClienteDao cdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("insert into tabelaClientes (nomeCliente, cpfCliente, enderecoCliente,telefoneCliente, anoNascimento) values (?,?,?,?,?)");
            
            stmt.setString(1, cdao.getNome());
            stmt.setString(2, cdao.getCpf());
            stmt.setString(3, cdao.getendereco());
            stmt.setString(4, cdao.gettelefone());
            stmt.setInt(5, cdao.getAnoNascimento());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    

    public void atualizar (ClienteDao cdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tabelaClientes SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefoneCliente = ?,anoNascimento = ? WHERE idCliente=?");
            stmt.setInt(6, cdao.getidcliente());
            stmt.setString(1, cdao.getNome());
            stmt.setString(2, cdao.getCpf());
            stmt.setString(3, cdao.getendereco());
            stmt.setString(4, cdao.gettelefone());
            stmt.setInt(5, cdao.getAnoNascimento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    
    public void deletar (ClienteDao cdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tabelaClientes WHERE idCliente=?");
            
            stmt.setInt(1,getidcliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    

      public List<ClienteDao> listar(){
        Connection con = conectar.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ClienteDao> listaCliente = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaClientes");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                ClienteDao cDao = new ClienteDao();
                cDao.setidcliente(rs.getInt("idCliente"));
                cDao.setNome(rs.getString("nomeCliente"));
                cDao.setCpf(rs.getString("cpfCliente"));
                cDao.setendereco(rs.getString("enderecoCliente"));
                cDao.settelefone(rs.getString("telefoneCliente"));
                cDao.setAnoNascimento(rs.getInt("anoNascimento"));

                
                listaCliente.add(cDao);
                
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
        return listaCliente;
        
        
    }



}
