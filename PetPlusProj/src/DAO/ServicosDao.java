
package DAO;

import Conexao.conectar;
import classes.Servicos;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServicosDao {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Servicos> lista = new ArrayList<>();


    public void cadastrarServico(Servicos objservico) {
        String sql = "insert into tabelaServicos (servico, descricao, preco) values (?,?,?)";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objservico.getNome_servico());
            pstm.setString(2, objservico.getDescricao_servico());
            pstm.setDouble(3, objservico.getPreco_servico());
          

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ServicosDao" + erro);
        }
    }

    
    public void alterarServicos(Servicos objservico) {
        String sql = "UPDATE tabelaServicos set servico = ?, descricao = ?, preco = ? WHERE idServico = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(4, objservico.getIdServico());
            pstm.setString(1, objservico.getNome_servico());
            pstm.setString(2, objservico.getDescricao_servico());
            pstm.setDouble(3, objservico.getPreco_servico());
    
            

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ServicosDAO alterar: " + erro);
        }
    }
    
    
    public void excluirServicos(Servicos objservico) {
        String sql = "DELETE from tabelaServicos WHERE idServico = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objservico.getIdServico());
            
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ServicosDAO excluir: " + erro);
        }
    }
    
    
    public ArrayList<Servicos> pesquisarServicos() {
        String sql = "SELECT * from tabelaServicos";
        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Servicos objservico = new Servicos();
                objservico.setIdServico(rs.getInt("idServico"));
                objservico.setNome_servico(rs.getString("servico"));
                objservico.setDescricao_servico(rs.getString("descricao"));
                objservico.setPreco_servico(rs.getDouble("preco"));
                

                lista.add(objservico);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ServicosDAO pesquisar: " + erro);
        }
        return lista;
       
    }
    

}
