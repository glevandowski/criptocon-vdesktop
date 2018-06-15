package views;

import API.DownloadAPI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Coin;
import service.CoinService;
import util.ButtonColumn;
import util.CustomColor;
import util.HintText;
import util.IsEmpty;
import util.Progress;
import views.listeners.ApiListener;

public class GUIListCoin extends javax.swing.JInternalFrame implements ApiListener {
private final  ArrayList<Coin> coinArrayList = new ArrayList<>();
private final JProgressBar progress = new JProgressBar();
private final Progress progressModel = new Progress();
private final CustomColor color = new CustomColor();
private final IsEmpty isEmpty = new IsEmpty();
private final DownloadAPI downloadAPI;
private ArrayList<Coin>arrayBank = new ArrayList<>();

 DefaultTableModel dtm = new DefaultTableModel(
    new Object[][]{},
    new Object[]{"Rank","Simbolo","Moeda","Cotação","1h", "24h","7d","Total de Ofertas","Max. Moedas","Ultima atualização","Favoritar"}
    );
 
 
    public GUIListCoin() {
        initComponents();
        downloadAPI = new DownloadAPI(this,this,progressModel,progress,jLProgress,jButton1,jtSearch);
        DownloadAPI.addCoinDownload();
        jTable.setModel(dtm);
        setupSearch();
    }

    private void cleanTable(){
        dtm.setNumRows(0);
    }

    private void searchTable(){
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        jTable.setRowSorter(sorter);
        String text = jtSearch.getText();
      if (text.length() == 0){  
           sorter.setRowFilter(null);  
      }else {  
         try {
              RowFilter<TableModel, Object> rf;    
              rf = RowFilter.regexFilter("(?i)" + text, 0,1,2);
              sorter.setRowFilter(rf); 
                }catch (java.util.regex.PatternSyntaxException e) {
                    JOptionPane.showMessageDialog(rootPane, "Moeda não localizada");
                } 
         }    
     }
              
    private void addFavoriteButton(int i){    
       Action add = new AbstractAction(){
       @Override
       public void actionPerformed(ActionEvent e){
            int row = jTable.getSelectedRow(); 
            String object = String.valueOf(jTable.getValueAt(row,2));
             Coin coinCrazy = new Coin();
            isValidRegister(i, object, coinCrazy);
            refreshItens();
       }    
      };
     ButtonColumn buttonColumn = new ButtonColumn(jTable, add, 10);
     buttonColumn.setMnemonic(KeyEvent.VK_D);
      }
   
    public void registerCoin(int i){
         try {
            Coin coinModel = new Coin();
            int row = jTable.getSelectedRow(); 
             parametersRegisterCoin(coinModel, row);
       
            CoinService coin = service.ServiceFactory.getDevService();
            coin.registerCoin(coinModel);
            
            JOptionPane.showMessageDialog(this, "Moeda Favorita registrada com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this,"Erro! "+e.getMessage(),"erro",JOptionPane.ERROR_MESSAGE);
           }
        }

    private void parametersRegisterCoin(Coin coinModel, int row){
            coinModel.setRank(String.valueOf(jTable.getValueAt(row,0)));
            coinModel.setSymbol(String.valueOf(jTable.getValueAt(row,1)));
            coinModel.setName(String.valueOf(jTable.getValueAt(row,2)));
            coinModel.setPrice_brl(String.valueOf(jTable.getValueAt(row,3)));  
            coinModel.setPercent_change_1h(String.valueOf(jTable.getValueAt(row,4)));
            coinModel.setPercent_change_24h( String.valueOf(jTable.getValueAt(row,5)));                
            coinModel.setPercent_change_7d(String.valueOf(jTable.getValueAt(row,6)));
            coinModel.setTotal_supply(String.valueOf(jTable.getValueAt(row,7)));
            coinModel.setMax_supply( String.valueOf(jTable.getValueAt(row,8)));
            coinModel.setLast_updated(String.valueOf(jTable.getValueAt(row,9)));
       } 
       
    private void isValidRegister(int i,String object,Coin coinCrazy){
           ArrayList<Coin>arrayBank;
        try {
         CoinService coinService = service.ServiceFactory.getDevService();
          arrayBank = coinService.searchCoin("");
         
         if(!arrayBank.isEmpty()){
           for(int coin=0; coin <arrayBank.size();coin++){
             coinCrazy.setName(arrayBank.get(coin).getName());
           }
            
        if(coinCrazy.getName().equalsIgnoreCase(object)){
                JOptionPane.showMessageDialog(rootPane, "Moeda ja está na sua lista de favoritos"); 
           }else
           {
           registerCoin(i);
           }
          }
         
         else{
       registerCoin(i);
           }
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(rootPane, "Servidor não está respondendo");
         }
       }

    private void setupSearch(){
        HintText hintText = new HintText(jtSearch, "Pesquise pelo ranking, símbolo ou nome da moeda...");
        jtSearch.setPreferredSize(new Dimension(300, 24));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLProgress = new javax.swing.JLabel();
        jtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Moeda", "Cotação", "1hr", "24hrs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Angleterre Book", 0, 24)); // NOI18N
        jLabel2.setText("CriptoCon");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/criptocon_desktop_oficial.png"))); // NOI18N

        jtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtSearchKeyReleased(evt);
            }
        });

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSearchKeyReleased
        searchTable();
    }//GEN-LAST:event_jtSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       refreshItens();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void refreshItens(){
        cleanTable();
        coinArrayList.clear();
        progressModel.isProgress(progress, jLProgress, 0);
        DownloadAPI.addCoinDownload();
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addCoin(List<Coin> coinAux) {
            if(!coinArrayList.isEmpty())return;
        for (Coin c : coinAux) {
                     coinArrayList.add(c);
                    }
           
                for(int i = 0; i< coinArrayList.size(); i++){
                
                 //11-favoriteCoin 12-delete Coin
                 isEmpty.isEmptyColumn(i,11, dtm,coinArrayList,jTable,color);
                 addFavoriteButton(i);
                  progressModel.isProgress(progress,jLProgress,i); 
                }
          
                  jTable.setModel(dtm);
              }
          
}
        

