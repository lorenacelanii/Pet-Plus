/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.conectar;
import classes.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author maste
 */
public class PedidoDao {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Pedido> lista = new ArrayList<>();

    public void cadastrarPedido(Pedido objPedido) {
        String sql = "INSERT into tabelaPedidos (idServico, idCliente, idPet) values (?,?,?)";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objPedido.getIdServico());
            pstm.setInt(2, objPedido.getIdCliente());
            pstm.setInt(3, objPedido.getIdPet());
        

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PedidoDAO cadastrar: " + erro);
        }
    }

    public ArrayList<Pedido> pesquisarPedido() {
        String sql = "SELECT * from tabelaPedidos";
        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Pedido objPedido = new Pedido();
                
                objPedido.setIdPedido(rs.getInt("idPedido"));
                objPedido.setIdServico(rs.getInt("idServico"));
                objPedido.setIdCliente(rs.getInt("idCliente"));
                objPedido.setIdPet(rs.getInt("idPet"));
                

                lista.add(objPedido);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PedidoDAO pesquisar: " + erro);
        }
        return lista;
    }
    
    public void alterarPedido(Pedido objPedido) {
        String sql = "UPDATE tabelaPedidos set idServico = ?, idCliente = ?, idPet = ? WHERE idPedido = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(4, objPedido.getIdPedido());
            pstm.setInt(1, objPedido.getIdServico());
            pstm.setInt(2, objPedido.getIdCliente());
            pstm.setInt(3, objPedido.getIdPet());
            
            

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pedido alterado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PedidoDAO alterar: " + erro);
        }
    }
    
    public void excluirPedido(Pedido objPedido) {
        String sql = "DELETE from tabelaPedidos WHERE idPedido = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objPedido.getIdPedido());
            
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pedido excluido com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PedidoDAO excluir: " + erro);
        }
    }
}
