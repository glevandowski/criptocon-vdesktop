package views;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import model.Authentication;
import service.AuthenticationService;
import views.listeners.AuthListener;
import views.listeners.RemovedPasswListener;


public class GUICoins extends javax.swing.JFrame implements InternalFrameListener,AuthListener,RemovedPasswListener {
  private static boolean FLAG_LIST_COIN = false;
  private static boolean FLAG_LIST_FAVORITE_COIN = false;
  private static boolean FLAG_REGISTER_COIN = false;
  private static boolean FLAG_MANAGMENT = false;
  private GUIFavoriteCoin gcpFavorite = new GUIFavoriteCoin();
  private GUIListCoin gcp = new GUIListCoin();
  private GUIAuth authGui ;
  private ArrayList<Authentication> authenticationArrayList = new ArrayList<>();
  public static boolean FLAG_RESULT_AUTH=false;
  
    public GUICoins() {
         initComponents();
         authGui = new GUIAuth(this);
         this.searchAuth();
         this.isAuthenticated();
         this.setExtendedState(getExtendedState() | GUICoins.MAXIMIZED_BOTH);
    }  
   
    private void searchAuth(){
         AuthenticationService coin = service.ServiceFactory.getAuthenticationService();
       try {
          authenticationArrayList = coin.searchPassw(); 
      } catch (SQLException ex) {
          Logger.getLogger(GUICoins.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
  
    private void isAuthenticated(){
       if(!authenticationArrayList.isEmpty()){
              jMenuItem1.setEnabled(false);
              jMenuItem2.setEnabled(false);
              jbOpenCoins.setEnabled(false);
              jbOpenFavorites.setEnabled(false);
              authGui.setVisible(true);
              jDesktopPane2.add(authGui);
              authGui.addInternalFrameListener(this);
              
         }else if(authenticationArrayList.isEmpty()){
               jMenuItem2.setEnabled(false);
               
           try {
               Thread.currentThread().sleep(5000);
               openListCoins();
           } catch (InterruptedException ex) {
               Logger.getLogger(GUICoins.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
      }
 
    private void isEditPassw(){
       jMenuItem2.setEnabled(false);
         }
    
    private void openListCoins(){
        GUIListCoin gcp = new GUIListCoin();
         if(FLAG_LIST_COIN==true)return;
         gcp.setVisible(true);
         jDesktopPane2.add(gcp);
         FLAG_LIST_COIN = true; 
         gcp.addInternalFrameListener(this);
          }
    
    private void openFavoriteCoins(){
     GUIFavoriteCoin gcp = new GUIFavoriteCoin();
    if(FLAG_LIST_FAVORITE_COIN==true)return;
        gcp.setVisible(true);
        jDesktopPane2.add(gcp);
        FLAG_LIST_FAVORITE_COIN = true; 
       gcp.addInternalFrameListener(this);
    }
    
    private void openGUIRegister(){
         GUIPassw gcf = new GUIPassw(this);
    if(FLAG_REGISTER_COIN==true)return;
        gcf.setVisible(true);
        jDesktopPane2.add(gcf);
        FLAG_REGISTER_COIN = true; 
       gcf.addInternalFrameListener(this);
    } 
      
    private void openGUIManagement(){
        GUIManagement gm = new GUIManagement(this);
        if(FLAG_MANAGMENT==true)return;
        gm.setVisible(true);
        jDesktopPane2.add(gm);
        FLAG_MANAGMENT = true;
       gm.addInternalFrameListener(this);
    }
    private void controllFlags(){
        FLAG_REGISTER_COIN=false;
        FLAG_LIST_COIN=false;
        FLAG_LIST_FAVORITE_COIN=false;
        FLAG_MANAGMENT = false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jbOpenCoins = new javax.swing.JButton();
        jbOpenFavorites = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jClouse = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane2.setLayout(new java.awt.FlowLayout());

        jLayeredPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbOpenCoins.setText("Cotações");
        jbOpenCoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpenCoinsActionPerformed(evt);
            }
        });

        jbOpenFavorites.setText("Favoritos");
        jbOpenFavorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpenFavoritesActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jbOpenCoins, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jbOpenFavorites, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbOpenCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOpenFavorites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jbOpenCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbOpenFavorites, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );

        jMenu1.setText("Configuração");

        jMenuItem1.setText("Definir Senha de Acesso ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Alterar Senha de Acesso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jClouse.setText("Sair");
        jClouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClouseMouseClicked(evt);
            }
        });
        jMenuBar1.add(jClouse);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jDesktopPane2))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClouseMouseClicked
         System.exit(0);
    }//GEN-LAST:event_jClouseMouseClicked

    private void jbOpenCoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpenCoinsActionPerformed
      openListCoins();
    }//GEN-LAST:event_jbOpenCoinsActionPerformed

    private void jbOpenFavoritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpenFavoritesActionPerformed
     openFavoriteCoins();
    }//GEN-LAST:event_jbOpenFavoritesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      openGUIRegister();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        openGUIManagement();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) { 
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICoins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jClouse;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton jbOpenCoins;
    private javax.swing.JButton jbOpenFavorites;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }
    

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        if(e.getInternalFrame() instanceof GUIListCoin){
            FLAG_LIST_COIN = false;
            
        }else if(e.getInternalFrame() instanceof GUIFavoriteCoin){
            FLAG_LIST_FAVORITE_COIN = false;
        }else if(e.getInternalFrame() instanceof GUIPassw){
            FLAG_REGISTER_COIN=false;
       }else if(e.getInternalFrame() instanceof GUIManagement){
            FLAG_MANAGMENT = false;
        }
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
      
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    @Override
    public void isResultPassword(boolean FLAG_RESULT) {
      jbOpenCoins.setEnabled(true);
      jbOpenFavorites.setEnabled(true);
      jMenuItem1.setEnabled(false);
      jMenuItem2.setEnabled(true);
      controllFlags();
    }

    @Override
    public void isExistPassw(boolean FLAG_RESULT) {
        jMenuItem2.setEnabled(false);
        jMenuItem1.setEnabled(true);
        controllFlags();
    }
}



