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
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Coin;
import service.CoinService;
import service.ServiceFactory;
import util.ButtonColumn;
import util.CustomColor;
import util.HintText;
import util.IsEmpty;
import views.listeners.ApiListener;


public class GUIFavoriteCoin extends javax.swing.JInternalFrame implements ApiListener {
private final CustomColor color = new CustomColor();
private final IsEmpty isEmpty = new IsEmpty();
private ArrayList<Coin> coinArrayListFavorite = new ArrayList<>();
private ArrayList<Coin> coinArrayApi = new ArrayList<>();
private DownloadAPI downloadAPI;
private Coin coinAPI = new Coin();
private Coin coinBank = new Coin();


DefaultTableModel table =  new DefaultTableModel(
   new Object[][]{},
   new Object[]{"Rank","Simbolo", "Moeda","Cotação","1h","24h","7d","Oferta total","Quantidade Máxima","Ultima Atualização",""}
   );

    public GUIFavoriteCoin() {
         initComponents();
         this.setupSearch();
         this.init();
    }
    
    private void init(){
        downloadAPI = new DownloadAPI(this,this,null,null,null,jButton1,jtSearch);
        jTableList.setModel(table);  
        filterTable();
        if(coinAPI == null){
        updateCoin();
        }
    }
     private void cleanTable(){
        table.setNumRows(0);
    }
  
   private void filterTable(){
     try{
       CoinService coin = service.ServiceFactory.getDevService();
       
       coinArrayListFavorite = coin.searchCoin("");
       
       if(coinArrayListFavorite.isEmpty())return;
    
          for(int i = 0; i< coinArrayListFavorite.size(); i++){
            isEmpty.isEmptyColumn(i,12, table,coinArrayListFavorite,jTableList,color);
                  deleteFavorite(i);
               }
       jTableList.setModel(table);                
       }
       catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Erro :"+e.getMessage());
       }
     }

       private void searchTable(){
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table);
        jTableList.setRowSorter(sorter);
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
      
  private void deleteFavorite(int i) {
      
           Action delete = new AbstractAction(){
       @Override
       public void actionPerformed(ActionEvent e)
       {                   
          int row = jTableList.getSelectedRow();
       CoinService CoinServ = ServiceFactory.getDevService();
       String name = jTableList.getValueAt(row, 2).toString();                  
    
           try {
               CoinServ.deleteCoin(name);
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, "Erro ao deletar");
           }
       JTable table = (JTable)e.getSource();
       row = Integer.valueOf( e.getActionCommand() );
       ((DefaultTableModel)table.getModel()).removeRow(row);       
       }};
      ButtonColumn buttonColumn = new ButtonColumn(jTableList, delete, 10);
      buttonColumn.setMnemonic(KeyEvent.VK_D);   
}
  
      public void updateCoin(){
        downloadAPI.addCoinDownload();
        if(coinArrayApi.isEmpty())return;
        int totalRows = jTableList.getRowCount();
        CoinService coinService = service.ServiceFactory.getDevService();
       
        for (int i = 0; i < coinArrayApi.size(); i++) {
         coinFavoriteParameters(coinAPI, i);
       
        for (int a = 0; a < totalRows; a++) {
            coinBankParameters(coinBank, a);
               
           //TESTE JOptionPane.showMessageDialog(rootPane, coinBank.getName()+" "+coinBank.getPrice_brl()+" "+coinAPI.getName()+" "+coinAPI.getPrice_brl());
           if(coinBank.getName().equals(coinAPI.getName())){
                try {
                    coinService.updateCoin(coinAPI);
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(rootPane, "Verifique sua conexão à internet");
                }
           }
          }}

      }
      
      //AUXILIAR
      private void coinFavoriteParameters(Coin coinAPI,int i){
            coinAPI.setRank(String.valueOf(coinArrayApi.get(i).getRank()));
            coinAPI.setSymbol(String.valueOf(coinArrayApi.get(i).getSymbol()));
            coinAPI.setName(String.valueOf(coinArrayApi.get(i).getName()));
            coinAPI.setPrice_brl(String.valueOf(coinArrayApi.get(i).getPrice_brl()));  
            coinAPI.setPercent_change_1h(String.valueOf(coinArrayApi.get(i).getPercent_change_1h()));
            coinAPI.setPercent_change_24h(String.valueOf(coinArrayApi.get(i).getPercent_change_24h()));                
            coinAPI.setPercent_change_7d(String.valueOf(coinArrayApi.get(i).getPercent_change_7d()));
            coinAPI.setTotal_supply(String.valueOf(coinArrayApi.get(i).getTotal_supply()));
            coinAPI.setMax_supply(String.valueOf(coinArrayApi.get(i).getMax_supply()));
            coinAPI.setLast_updated(String.valueOf(coinArrayApi.get(i).getLast_updated()));     
      }
      private void coinBankParameters(Coin coinBank, int a){
            coinBank.setRank(String.valueOf(jTableList.getModel().getValueAt(a, 0)));
            coinBank.setSymbol(String.valueOf(jTableList.getModel().getValueAt(a, 1)));
            coinBank.setName(String.valueOf(jTableList.getModel().getValueAt(a, 2)));
            coinBank.setPrice_brl(String.valueOf(jTableList.getModel().getValueAt(a, 3)));  
            coinBank.setPercent_change_1h(String.valueOf(jTableList.getModel().getValueAt(a, 4)));
            coinBank.setPercent_change_24h( String.valueOf(jTableList.getModel().getValueAt(a, 5)));                
            coinBank.setPercent_change_7d(String.valueOf(jTableList.getModel().getValueAt(a, 6)));
            coinBank.setTotal_supply(String.valueOf(jTableList.getModel().getValueAt(a, 7)));
            coinBank.setMax_supply( String.valueOf(jTableList.getModel().getValueAt(a, 8)));
            coinBank.setLast_updated(String.valueOf(jTableList.getModel().getValueAt(a, 9)));
      }
      
      private void setupSearch(){
        HintText hintText = new HintText(jtSearch, "Pesquise pelo ranking, símbolo ou nome da moeda...");
        jtSearch.setPreferredSize(new Dimension(300, 24));
    }
     
      private String isEmptyModel(int i,int column){
         return isEmpty.isEmpty(i,column, coinArrayListFavorite, jTableList, color);
     }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JTable();
        jtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Moeda", "Cotação", "1hr", "24hrs", "7d", "Oferta Total", "Quantidade Máxima", "Ultima Atualização", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableList);
        if (jTableList.getColumnModel().getColumnCount() > 0) {
            jTableList.getColumnModel().getColumn(0).setResizable(false);
            jTableList.getColumnModel().getColumn(1).setResizable(false);
            jTableList.getColumnModel().getColumn(2).setResizable(false);
            jTableList.getColumnModel().getColumn(3).setResizable(false);
            jTableList.getColumnModel().getColumn(4).setResizable(false);
            jTableList.getColumnModel().getColumn(5).setResizable(false);
            jTableList.getColumnModel().getColumn(6).setResizable(false);
            jTableList.getColumnModel().getColumn(7).setResizable(false);
            jTableList.getColumnModel().getColumn(8).setResizable(false);
        }

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSearchKeyReleased
        searchTable();
    }//GEN-LAST:event_jtSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cleanTable();
        filterTable();
        updateCoin();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableList;
    private javax.swing.JTextField jtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addCoin(List<Coin> coinAux) {
          if(coinArrayApi.isEmpty())return;
            for (Coin c : coinAux) {
                     coinArrayApi.add(c);
                    }    
          }
   }

