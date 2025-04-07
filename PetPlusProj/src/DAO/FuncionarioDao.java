
package DAO;
import classes.Funcionario;
import Conexao.conectar;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class FuncionarioDao  extends Funcionario {
    

    
    public boolean LoginCheck(String login,String senha){
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaFuncionarios WHERE loginFuncionario=? and senhaFuncionario=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs= stmt.executeQuery();
            if(rs.next()){
                check = true;
                setNome(rs.getString("nomeFuncionario"));
                setAcessoSuperior(rs.getInt("acessoSuperior"));
                setFotoFuncionario(rs.getBytes("imagemFuncionario"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+ e);
        }
        
        return check;
    }
    
    public void adicionar (FuncionarioDao fdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tabelaFuncionarios (nomeFuncionario,cpfFuncionario,loginFuncionario,senhaFuncionario,imagemFuncionario) "
                    + "VALUES(?,?,?,?,?) ");
            
            stmt.setString(1, fdao.getNome());
            stmt.setString(2, fdao.getCpf());
            stmt.setString(3, fdao.getLogin());
            stmt.setString(4, fdao.getSenha());
            stmt.setBytes(5, fdao.getFotoFuncionario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    

    public void atualizar (FuncionarioDao fdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tabelaFuncionarios SET nomeFuncionario = ?, cpfFuncionario = ?, loginFuncionario = ?, senhaFuncionario = ?, imagemFuncionario = ? WHERE idFuncionario=?");
            
            stmt.setString(1, fdao.getNome());
            stmt.setString(2, fdao.getCpf());
            stmt.setString(3, fdao.getLogin());
            stmt.setString(4, fdao.getSenha());
            stmt.setBytes(5,fdao.getFotoFuncionario());
            stmt.setInt(6,getIdFuncionario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    
    public void deletar (FuncionarioDao fdao){
    
        Connection con = conectar.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tabelaFuncionarios WHERE idFuncionario=?");
            
            stmt.setInt(1,getIdFuncionario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar "+ ex);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
    }
    

    public List<FuncionarioDao> listar(){
        Connection con = conectar.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FuncionarioDao> listaFuncionario = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabelaFuncionarios");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                FuncionarioDao fDao = new FuncionarioDao();
                fDao.setIdFuncionario(rs.getInt("idFuncionario"));
                fDao.setNome(rs.getString("nomeFuncionario"));
                fDao.setCpf(rs.getString("cpfFuncionario"));
                fDao.setLogin(rs.getString("loginFuncionario"));
                fDao.setSenha(rs.getString("senhaFuncionario"));
                fDao.setFotoFuncionario(rs.getBytes("imagemFuncionario"));
                
                listaFuncionario.add(fDao);
                
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "erro"+e);
        }finally{
            conectar.closeConnection(con, stmt, rs);
        }
        
        return listaFuncionario;
        
        
    }

}
