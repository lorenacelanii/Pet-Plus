/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import DAO.FuncionarioDao;
import UTIL.Conversao;
import classes.Pessoa;
import static classes.Pessoa.ValidarCPF;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author geral
 */
public class cadastroFuncionario extends javax.swing.JFrame {
    Color corFundo = new Color(244, 208, 106);
    String nome = null;
    List<FuncionarioDao> listaFdao;
    ImageIcon foto;
    int acesso;
    
    /**
     * Creates new form cadastroFuncionario
     */
    public cadastroFuncionario() {
        initComponents();
                
        lerTabela();
        
    }
    public cadastroFuncionario(String nome,ImageIcon foto,int acesso) {
        initComponents();
        this.nome = nome;
        this.foto = foto;
        this.acesso = acesso;

        lerTabela();
        
    }
    
    private void verTabela(){
        
        if(tabelaF.getSelectedRow() != -1){
            FuncionarioDao fdao = listaFdao.get(tabelaF.getSelectedRow());
            campoNome.setText(fdao.getNome());
            campoCpf.setText(fdao.getCpf());
            campoLogin.setText(fdao.getLogin());
            campoSenha.setText(fdao.getSenha());
                
                
            
            try {
                ImageIcon imgI = new ImageIcon(fdao.getFotoFuncionario());
                imgI.setImage(imgI.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
                lblFoto.setIcon(imgI);
            } catch (Exception e) {
                lblFoto.setIcon(null);
            }
   
        }
    }
    
    public void lerTabela(){
        DefaultTableModel tabela = (DefaultTableModel) tabelaF.getModel();
        tabela.setNumRows(0);
        FuncionarioDao fdao = new FuncionarioDao();
        listaFdao = fdao.listar();
        
        for (FuncionarioDao f : listaFdao) {
                tabela.addRow(new Object[]{
                    
                    f.getNome(),
                    f.getCpf(),
                    f.getLogin(),
                    f.getSenha()
                    }
                );
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoSenha = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        bttPesquisarFoto = new javax.swing.JButton();
        bttCadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bttAtualizar = new javax.swing.JButton();
        bttDeletar = new javax.swing.JButton();
        bttVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaF = new javax.swing.JTable();
        lblCaminho = new javax.swing.JLabel();
        campoCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(670, 500));
        setMinimumSize(new java.awt.Dimension(670, 500));
        setPreferredSize(new java.awt.Dimension(670, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setBackground(new java.awt.Color(12, 196, 216));
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome:");
        lblNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 196, 216)));
        lblNome.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(12, 196, 216));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login:");
        jLabel2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(36, 16));

        jLabel3.setBackground(new java.awt.Color(12, 196, 216));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha:");
        jLabel3.setOpaque(true);

        lblCPF.setBackground(new java.awt.Color(12, 196, 216));
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPF.setText("CPF:");
        lblCPF.setOpaque(true);

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bttPesquisarFoto.setText("Pesquisar Foto");
        bttPesquisarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttPesquisarFotoActionPerformed(evt);
            }
        });

        bttCadastrar.setBackground(new java.awt.Color(51, 215, 116));
        bttCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        bttCadastrar.setText("Cadastrar");
        bttCadastrar.setBorder(null);
        bttCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel5.setText("  Cadastro De Funcionário");
        jLabel5.setOpaque(true);

        bttAtualizar.setBackground(new java.awt.Color(51, 215, 116));
        bttAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttAtualizar.setText("Atualizar");
        bttAtualizar.setBorder(null);
        bttAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAtualizarActionPerformed(evt);
            }
        });

        bttDeletar.setBackground(new java.awt.Color(51, 215, 116));
        bttDeletar.setForeground(new java.awt.Color(255, 255, 255));
        bttDeletar.setText("Deletar");
        bttDeletar.setBorder(null);
        bttDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttDeletarActionPerformed(evt);
            }
        });

        bttVoltar.setBackground(new java.awt.Color(255, 51, 51));
        bttVoltar.setForeground(new java.awt.Color(255, 255, 255));
        bttVoltar.setText("Voltar");
        bttVoltar.setBorder(null);
        bttVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttVoltarActionPerformed(evt);
            }
        });

        tabelaF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Login", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaF.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFMouseClicked(evt);
            }
        });
        tabelaF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaFKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaF);

        campoCpf.setColumns(11);
        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCpfFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(lblCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bttPesquisarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(lblCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(bttPesquisarFoto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bttCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bttAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bttDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(bttVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        getContentPane().setBackground(corFundo);
        lblCaminho.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void bttPesquisarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttPesquisarFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser arquivos = new JFileChooser();
        arquivos.setDialogTitle("Procurando Foto");
        arquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg ou png", "jpg","png");
        arquivos.setFileFilter(filtro);
        
        if (arquivos.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
             File arquivo = arquivos.getSelectedFile();
             BufferedImage img = null;
             
            try {
                img = ImageIO.read(new File(arquivo.getPath()));
                lblCaminho.setText(arquivo.getPath());
                
            } catch (IOException ex) {
                Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             ImageIcon imgI = new ImageIcon(img);
             imgI.setImage(imgI.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
             
             
             
             lblFoto.setIcon(imgI);
             
        }
    }//GEN-LAST:event_bttPesquisarFotoActionPerformed

    private void bttCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCadastrarActionPerformed
        FuncionarioDao fdao = new FuncionarioDao();
        Conversao converte = new Conversao();
        BufferedImage img = null;
        String caminho = lblCaminho.getText();
        byte [] imgB = null;
        
        
        try {
            img = ImageIO.read(new File(lblCaminho.getText()));
             imgB = converte.arquivoParaByte(img,caminho);
             fdao.setFotoFuncionario(imgB);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: "+e);
        }
        
        
        
        fdao.setLogin(campoLogin.getText());
        fdao.setSenha(campoSenha.getText());
        fdao.setNome(campoNome.getText());
        fdao.setCpf(campoCpf.getText());
        
        campoNome.setText("");
        campoLogin.setText("");
        campoCpf.setText("");
        campoSenha.setText("");
        
        
        if(Pessoa.ValidarCPF(campoCpf.getText())){
            fdao.adicionar(fdao);
            lerTabela();
        }else {
            JOptionPane.showMessageDialog(null, "CPF invalido");
        }
        
        
    }//GEN-LAST:event_bttCadastrarActionPerformed

    private void bttAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAtualizarActionPerformed
        FuncionarioDao fdao = new FuncionarioDao();
        Conversao converte = new Conversao();
        BufferedImage img = null;
        String caminho = lblCaminho.getText();
        byte [] imgB = null;
        
        FuncionarioDao f = listaFdao.get(tabelaF.getSelectedRow());

        if(tabelaF.getSelectedRow() != -1){

            if(!"".equals(lblCaminho.getText())){
                try {
                    img = ImageIO.read(new File(lblCaminho.getText()));
                    imgB = converte.arquivoParaByte(img,lblCaminho.getText());
                    fdao.setFotoFuncionario(imgB);
                    
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "error: "+e);
                }
            } else {
                
                fdao.setFotoFuncionario(f.getFotoFuncionario());
                
            }




                fdao.setNome(campoNome.getText());
                fdao.setSenha(campoSenha.getText());
                fdao.setLogin(campoLogin.getText());
                fdao.setCpf(campoCpf.getText());
                fdao.setIdFuncionario(f.getIdFuncionario());



                campoNome.setText("");
                campoLogin.setText("");
                campoCpf.setText("");
                campoSenha.setText("");
                lblCaminho.setText("");

                if(ValidarCPF(fdao.getCpf())){
                    fdao.atualizar(fdao);
                    lerTabela();
                }else {
                    JOptionPane.showMessageDialog(null, "CPF invalido");
                }
        }   
   
    }//GEN-LAST:event_bttAtualizarActionPerformed
    
    private void bttDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttDeletarActionPerformed
        // TODO add your handling code here:
        if(tabelaF.getSelectedRow() != -1){
            FuncionarioDao fdao = new FuncionarioDao();
        
            
            FuncionarioDao f = listaFdao.get(tabelaF.getSelectedRow());
            fdao.setIdFuncionario(f.getIdFuncionario());

            campoNome.setText("");
            campoLogin.setText("");
            campoCpf.setText("");
            campoSenha.setText("");
        
            
                    fdao.deletar(fdao);
                    lerTabela();
            
        
        }else {
            JOptionPane.showMessageDialog(null, "Escolha um funcionário para apagar do sistema");
        }
        
    }//GEN-LAST:event_bttDeletarActionPerformed

    private void bttVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttVoltarActionPerformed
        if (acesso == 1){
                try {
                    new paginaInicialGerente(nome,foto,acesso).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }else {
                try {
                    new paginaInicial(nome,foto,acesso).setVisible(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro: "+e);
                }

                this.dispose();
                }
    }//GEN-LAST:event_bttVoltarActionPerformed

    private void tabelaFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFMouseClicked
        verTabela();
    }//GEN-LAST:event_tabelaFMouseClicked

    private void tabelaFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFKeyReleased
        // TODO add your handling code here:
        verTabela();
    }//GEN-LAST:event_tabelaFKeyReleased

    private void campoCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCpfFocusLost
        // TODO add your handling code here:
        System.out.println(campoCpf.getText());
    }//GEN-LAST:event_campoCpfFocusLost

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
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAtualizar;
    private javax.swing.JButton bttCadastrar;
    private javax.swing.JButton bttDeletar;
    private javax.swing.JButton bttPesquisarFoto;
    private javax.swing.JButton bttVoltar;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCaminho;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tabelaF;
    // End of variables declaration//GEN-END:variables
}
