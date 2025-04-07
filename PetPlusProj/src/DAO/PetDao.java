package DAO;

import Conexao.conectar;
import classes.Pet;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author maste
 */
public class PetDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Pet> lista = new ArrayList<>();

    public void cadastrarPet(Pet objPet) {
        String sql = "INSERT into tabelaPet (nomePet, idadePet, idCliente, racaPet) values (?,?,?,?)";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPet.getNomePet());
            pstm.setString(2, objPet.getIdadePet());
            pstm.setInt(3, objPet.getIdCliente());
            pstm.setString(4, objPet.getRacaPet());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PetDAO cadastrar: " + erro);
        }
    }

    public ArrayList<Pet> pesquisarPet() {
        String sql = "SELECT * from tabelaPet";
        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Pet objPet = new Pet();
                objPet.setIdPet(rs.getInt("idPet"));
                objPet.setNomePet(rs.getString("nomePet"));
                objPet.setIdadePet(rs.getString("idadePet"));
                objPet.setIdCliente(rs.getInt("idCliente"));
                objPet.setRacaPet(rs.getString("racaPet"));

                lista.add(objPet);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PetDAO pesquisar: " + erro);
        }
        return lista;
    }
    
    public void alterarPet(Pet objPet) {
        String sql = "UPDATE tabelaPet set nomePet = ?, idadePet = ?, idCliente = ?, racaPet = ?  WHERE idPet = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(5, objPet.getIdPet());
            pstm.setString(1, objPet.getNomePet());
            pstm.setString(2, objPet.getIdadePet());
            pstm.setInt(3, objPet.getIdCliente());
            pstm.setString(4, objPet.getRacaPet());
            

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pet alterado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PetDAO alterar: " + erro);
        }
    }
    
    public void excluirPet(Pet objPet) {
        String sql = "DELETE from tabelaPet WHERE idPet = ?";

        conn = new conectar().getConnection();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objPet.getIdPet());
            
            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pet excluido com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PetDAO excluir: " + erro);
        }
    }

}
