package views;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Authentication;
import service.AuthenticationService;
import util.IsFocusDialog;
import views.listeners.AuthListener;

public class GUIPassw extends javax.swing.JInternalFrame{
  private IsFocusDialog isFocusDialog = new IsFocusDialog();
  private static int FLAG_CONTROLL_FOCUS = 0;
  private AuthListener authListener;
  private Authentication auth = new Authentication();
  private ArrayList<Authentication> arrayPassw = new ArrayList<>();
  
    public GUIPassw(AuthListener authListener) {
        initComponents();
        this.authListener = authListener;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbPassw = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jlAlertOne = new javax.swing.JLabel();
        jlAlertTwo = new javax.swing.JLabel();
        jtpassw = new javax.swing.JPasswordField();
        jtpassw2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTKeyRecovered = new javax.swing.JTextField();
        jlAlertKeyRecovered = new javax.swing.JLabel();

        setClosable(true);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Ative uma senha: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Configurações");

        jLabel3.setText("Confirme a senha:");

        jbPassw.setText("Cadastrar");
        jbPassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPasswActionPerformed(evt);
            }
        });
        jbPassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbPasswKeyPressed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtpassw.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtpasswFocusLost(evt);
            }
        });
        jtpassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpasswKeyPressed(evt);
            }
        });

        jtpassw2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtpassw2FocusLost(evt);
            }
        });
        jtpassw2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpassw2KeyPressed(evt);
            }
        });

        jLabel4.setText("Frase para recuperação de senha:");

        jTKeyRecovered.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTKeyRecoveredFocusLost(evt);
            }
        });
        jTKeyRecovered.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTKeyRecoveredKeyPressed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jbPassw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertOne, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertTwo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jtpassw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jtpassw2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTKeyRecovered, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jlAlertKeyRecovered, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTKeyRecovered)
                            .addComponent(jlAlertTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jlAlertOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtpassw)
                            .addComponent(jtpassw2)
                            .addComponent(jlAlertKeyRecovered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 257, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtpassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jlAlertOne)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtpassw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAlertTwo)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTKeyRecovered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAlertKeyRecovered)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbPassw, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void jbPasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPasswActionPerformed
        registerPassword();
    }//GEN-LAST:event_jbPasswActionPerformed

    private void jbPasswKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbPasswKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           registerPassword();
         }
    }//GEN-LAST:event_jbPasswKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtpasswKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpasswKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           jtpassw2.grabFocus();
         }
    }//GEN-LAST:event_jtpasswKeyPressed

    private void jtpassw2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpassw2KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           jTKeyRecovered.grabFocus();
         }
    }//GEN-LAST:event_jtpassw2KeyPressed

    private void jtpasswFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtpasswFocusLost
       FLAG_CONTROLL_FOCUS = 1;
        authenticate();
    }//GEN-LAST:event_jtpasswFocusLost

    private void jtpassw2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtpassw2FocusLost
       FLAG_CONTROLL_FOCUS = 2;
         authenticate();
    }//GEN-LAST:event_jtpassw2FocusLost

    private void jTKeyRecoveredFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTKeyRecoveredFocusLost
         FLAG_CONTROLL_FOCUS = 3;
         authenticate();
    }//GEN-LAST:event_jTKeyRecoveredFocusLost

    private void jTKeyRecoveredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTKeyRecoveredKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           jbPassw.grabFocus();
         }
    }//GEN-LAST:event_jTKeyRecoveredKeyPressed

    public void registerPassword(){
         char[] pswd = jtpassw.getPassword();
         char[] psw2 = jtpassw2.getPassword();
         String password=new String(pswd);
         String password2=new String(psw2);
       if(!(password.length()<6||password2.length()<6)){
     
        String key = jTKeyRecovered.getText();
        if(key.length()<6)return;
        if(password.equals(password2)&&!key.isEmpty()){
            AuthenticationService authService = service.ServiceFactory.getAuthenticationService();
                        
            try{
            auth.setPassword(password2);            
            auth.setRecoveredkey(key);
            
            authService.registerPassword(auth);
            JOptionPane.showMessageDialog(rootPane, "Senha cadastrada com sucesso");
            authListener.isResultPassword(false);
            dispose();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane, "Aconteceu algum erro ao cadastrar Senha");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Verifique os dados digitados");
        }
       }
    }
  
    private void authenticate(){
        this.isFocusDialog.isFocus(FLAG_CONTROLL_FOCUS, jbPassw, jtpassw, jlAlertOne, jtpassw2, jlAlertTwo,jTKeyRecovered,jlAlertKeyRecovered);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTKeyRecovered;
    private javax.swing.JButton jbPassw;
    private javax.swing.JLabel jlAlertKeyRecovered;
    private javax.swing.JLabel jlAlertOne;
    private javax.swing.JLabel jlAlertTwo;
    private javax.swing.JPasswordField jtpassw;
    private javax.swing.JPasswordField jtpassw2;
    // End of variables declaration//GEN-END:variables

  
}
