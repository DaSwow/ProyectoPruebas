/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import daos.UsuariosDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import objetosnegocio.Usuario;

/**
 *
 * @author DssX
 */
public class FrmInicio extends javax.swing.JFrame {
    
    public static Usuario usuarioLogged;
    /**
     * Creates new form Inicio
     */
    public FrmInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        cbVer = new javax.swing.JCheckBox();
        txtContraseña = new javax.swing.JPasswordField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Faceboot");

        jLabel2.setText("Usuario");

        jLabel4.setText("Contraseña");

        btnInicio.setText("Ingresar");
        btnInicio.setToolTipText("");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Nuevo Usuario");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbVer.setText("Ver");
        cbVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVerActionPerformed(evt);
            }
        });

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnInicio)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbVer)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbVer)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(btnInicio)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        FrmRegistro abrir = new FrmRegistro();
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        this.inicioSesion();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void cbVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVerActionPerformed
        if(cbVer.isSelected()){
            txtContraseña.setEchoChar((char)0);
        } else {
            txtContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_cbVerActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        this.BuscarEnter(evt);
    }//GEN-LAST:event_txtContraseñaKeyPressed
    
    /**
     * Validar que los campos de inicio de sesion contengan informacion.
     */
    private void inicioSesion(){
        UsuariosDAO usuarioTemp = new UsuariosDAO();
        usuarioLogged = usuarioTemp.buscarPorCorreo(txtUsuario.getText());
        if ("".equals(txtUsuario.getText()) || "".equals(txtContraseña.getText())) {
            JOptionPane.showMessageDialog(this, "El campo de Correo o Contraseña estan vacios", "Información", JOptionPane.WARNING_MESSAGE);
        } else {
            if (usuarioLogged.getContraseña() == null ? (txtContraseña.getText()) != null : !usuarioLogged.getContraseña().equals(txtContraseña.getText())) {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta, favor de verificar", "Información", JOptionPane.WARNING_MESSAGE);
            } else {
                FrmMuro abrir = new FrmMuro();
                abrir.setVisible(true);
                this.setVisible(false);
                
            }
        }
            
    }
    
    /**
     * Simple codigo de escucha que espera el presionado de la tecla Enter para correr el codigo de inicioSesion
     * @param evt 
     */
    private void BuscarEnter (java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.inicioSesion();
        }
    } 
    
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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox cbVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
