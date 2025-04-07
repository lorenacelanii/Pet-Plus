/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import javax.swing.JOptionPane;
import DAO.FuncionarioDao;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author geral
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    Color corPadrao = new Color (3,152,158); 
    public Login() {
        initComponents();
        getContentPane().setBackground(corPadrao);
        
        
        
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPetPlus = new javax.swing.JLabel();
        rotuloLogin = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        rotuloSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoLogin = new javax.swing.JButton();
        lblImgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(3, 152, 158));
        setIconImage(getIconImage());
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(768, 451));
        setName("PetPlus"); // NOI18N
        setPreferredSize(new java.awt.Dimension(768, 451));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblPetPlus.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        lblPetPlus.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblPetPlus);
        lblPetPlus.setBounds(490, 20, 250, 130);

        rotuloLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotuloLogin.setText("Usuário:");
        getContentPane().add(rotuloLogin);
        rotuloLogin.setBounds(520, 160, 72, 20);

        campoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campoUsuario);
        campoUsuario.setBounds(520, 190, 204, 38);

        rotuloSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rotuloSenha.setText("Senha:");
        getContentPane().add(rotuloSenha);
        rotuloSenha.setBounds(520, 250, 72, 20);

        campoSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(campoSenha);
        campoSenha.setBounds(520, 280, 204, 38);

        botaoLogin.setBackground(new java.awt.Color(0, 0, 0));
        botaoLogin.setForeground(new java.awt.Color(255, 255, 255));
        botaoLogin.setText("Log in");
        botaoLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botaoLogin.setFocusPainted(false);
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botaoLogin);
        botaoLogin.setBounds(580, 330, 100, 38);
        getContentPane().add(lblImgLogin);
        lblImgLogin.setBounds(0, 0, 770, 450);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        // TODO add your handling code here:
        FuncionarioDao fdao = new FuncionarioDao();
        
        
        if(fdao.LoginCheck(campoUsuario.getText(),String.valueOf(campoSenha.getPassword()))){
            if (fdao.getAcessoSuperior() == 1){
                try {
                    new paginaInicialGerente(fdao.getNome(),fdao.getFotoFuncionario(),fdao.getAcessoSuperior()).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }else {
                try {
                    new paginaInicial(fdao.getNome(),fdao.getFotoFuncionario(),fdao.getAcessoSuperior()).setVisible(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro: "+e);
                }

                this.dispose();
                }
        
        }else{
            JOptionPane.showMessageDialog(null, "login invalido ");
        }
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ImageIcon imgLogin = new ImageIcon("src/Interface/imagens/imagemLogin.png");
        ImageIcon imgPetPlus = new ImageIcon("src/Interface/imagens/petplus.png");
        
        imgPetPlus.setImage(imgPetPlus.getImage().getScaledInstance(lblPetPlus.getWidth(), lblPetPlus.getHeight(), Image.SCALE_SMOOTH));
        imgLogin.setImage(imgLogin.getImage().getScaledInstance(lblImgLogin.getWidth(), lblImgLogin.getHeight(), Image.SCALE_SMOOTH));
        
        lblPetPlus.setIcon(imgPetPlus);
        lblImgLogin.setIcon(imgLogin);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel lblImgLogin;
    private javax.swing.JLabel lblPetPlus;
    private javax.swing.JLabel rotuloLogin;
    private javax.swing.JLabel rotuloSenha;
    // End of variables declaration//GEN-END:variables
}
