
package views;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Authentication;
import service.AuthenticationService;
import util.IsFocusDialog;


public class GUIRecoveredKey extends javax.swing.JInternalFrame {
private ArrayList<Authentication> authBank = new ArrayList<>();
private IsFocusDialog isFocusDialog = new IsFocusDialog();
private static int FLAG_CONTROLL_FOCUS;

    public GUIRecoveredKey() {
        initComponents();
        this.downloadBank(); 
    }
    
private void downloadBank(){
     AuthenticationService auth = service.ServiceFactory.getAuthenticationService();
       
    try {
        authBank = auth.searchPassw();
        jtPassw.setEnabled(false);
       jtPasswTwo.setEnabled(false);
    } catch (SQLException ex) {
        Logger.getLogger(GUIRecoveredKey.class.getName()).log(Level.SEVERE, null, ex);
    }
   }

   private void registerBank(){
         char[] pswd = jtPassw.getPassword();
         char[] psw2 = jtPasswTwo.getPassword();
         String password=new String(pswd);
         String password2=new String(psw2);
         
        if(!(jtKey.getText().isEmpty()||password.isEmpty()||password2.isEmpty())){
             Authentication authModel = new Authentication();
             AuthenticationService auth = service.ServiceFactory.getAuthenticationService();
             authModel.setPassword(jtPasswTwo.getText());
            try {
                if(!(jtPassw.getText().length()<6||password.length()<6||!password.equals(password2))){
                    
                auth.updateRecoveredKey(authModel);
                dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GUIRecoveredKey.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Ops.. Alguns campos não foram preenchidos corretamente");
        }
    }
   
   private void submitKey(){
      downloadBank();
        if(jtKey.getText().equals(authBank.get(0).getRecoveredkey())){
                   jtPassw.setEnabled(true);
                   jtPasswTwo.setEnabled(true);
            }else{
            JOptionPane.showMessageDialog(rootPane, "Ops...Chave não encontrada");
        }
       }
   
  private void authenticate(){
        this.isFocusDialog.isFocus(FLAG_CONTROLL_FOCUS, jbRegister, jtPassw, jlAlertPassw, jtPasswTwo, jlAlertPasswTwo,jtKey,jlAlertKey);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbRegister = new javax.swing.JButton();
        jtKey = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtPassw = new javax.swing.JPasswordField();
        jtPasswTwo = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jlAlertPassw = new javax.swing.JLabel();
        jlAlertPasswTwo = new javax.swing.JLabel();
        jlAlertKey = new javax.swing.JLabel();

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Digite sua nova senha");

        jLabel2.setText("Digite novamente");

        jbRegister.setText("Recuperar");
        jbRegister.setToolTipText("");
        jbRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegisterActionPerformed(evt);
            }
        });
        jbRegister.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbRegisterKeyPressed(evt);
            }
        });

        jtKey.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtKeyFocusLost(evt);
            }
        });
        jtKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtKeyActionPerformed(evt);
            }
        });
        jtKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtKeyKeyPressed(evt);
            }
        });

        jLabel3.setText("Informe a sua chave de recuperação");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtPassw.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtPasswFocusLost(evt);
            }
        });
        jtPassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPasswKeyPressed(evt);
            }
        });

        jtPasswTwo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtPasswTwoFocusLost(evt);
            }
        });
        jtPasswTwo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPasswTwoKeyPressed(evt);
            }
        });

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jbRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jtKey, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jtPassw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jtPasswTwo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertPassw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertPasswTwo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertKey, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAlertKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jtKey)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlAlertPassw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtPasswTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(jtPassw)
                                    .addComponent(jlAlertPasswTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 217, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jlAlertKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jlAlertPassw)
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPasswTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAlertPasswTwo)
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegister)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       submitKey();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegisterActionPerformed

        registerBank();
    }//GEN-LAST:event_jbRegisterActionPerformed

    private void jtKeyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtKeyKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1.grabFocus();
        }
    }//GEN-LAST:event_jtKeyKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             submitKey();
            jtPassw.grabFocus();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jtPasswKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPasswKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jtPasswTwo.grabFocus();
        }
    }//GEN-LAST:event_jtPasswKeyPressed

    private void jtPasswTwoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPasswTwoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jbRegister.grabFocus();
        }
    }//GEN-LAST:event_jtPasswTwoKeyPressed

    private void jbRegisterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbRegisterKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            registerBank();
        }
    }//GEN-LAST:event_jbRegisterKeyPressed

    private void jtKeyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtKeyFocusLost
         FLAG_CONTROLL_FOCUS = 3;
         authenticate();
    }//GEN-LAST:event_jtKeyFocusLost

    private void jtPasswFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPasswFocusLost
         FLAG_CONTROLL_FOCUS = 1;
         authenticate();
    }//GEN-LAST:event_jtPasswFocusLost

    private void jtPasswTwoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPasswTwoFocusLost
       FLAG_CONTROLL_FOCUS = 2;
         authenticate();
    }//GEN-LAST:event_jtPasswTwoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtKeyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jbRegister;
    private javax.swing.JLabel jlAlertKey;
    private javax.swing.JLabel jlAlertPassw;
    private javax.swing.JLabel jlAlertPasswTwo;
    private javax.swing.JTextField jtKey;
    private javax.swing.JPasswordField jtPassw;
    private javax.swing.JPasswordField jtPasswTwo;
    // End of variables declaration//GEN-END:variables
}
