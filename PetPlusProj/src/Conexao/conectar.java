package Conexao;

import java.sql.ResultSet;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class conectar {
    private static final String URL ="jdbc:mysql://20.197.225.170/PetPlus";
    private static final String USER ="aplicacao";
    private static final String SENHA = "wasd1304@";


   
    
     public static Connection getConnection() {
         
     
		 try {
			return DriverManager.getConnection(URL,USER,SENHA);
		 }         
		 catch(SQLException ex) {
			throw new RuntimeException(ex);
		 }
     }
     
     
     public static void closeConnection (Connection con){
         
             try {
                 if (con != null) {
                    con.close();
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Erro: ", ex);
             }
     }
     
     
     public static void closeConnection (Connection con,PreparedStatement stmt){
            closeConnection(con);
             try {
                 if (stmt != null) {
                    stmt.close();
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Erro: ", ex);
             }
     }
     
     
     public static void closeConnection (Connection con,PreparedStatement stmt,ResultSet rs){
            closeConnection(con,stmt);
             try {
                 if (rs != null) {
                    rs.close();
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Erro: ", ex);
             }
     }
     
}


