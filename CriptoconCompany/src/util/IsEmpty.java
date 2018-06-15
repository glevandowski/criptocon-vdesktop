package util;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Coin;

public class IsEmpty {
 
   public String isEmpty (int i,int FLAG_CONTROLL_ARRAY, ArrayList<Coin> coinArrayList,JTable jTable,CustomColor color){
       if(coinArrayList !=null || coinArrayList.get(i)!=null);
       
       if(FLAG_CONTROLL_ARRAY == 1){
                     if(coinArrayList.get(i).getRank() != null){
                      return String.valueOf(coinArrayList.get(i).getRank());
                     }else{
                      return " --";
                     }
                    }
       if(FLAG_CONTROLL_ARRAY == 2){
                         if(coinArrayList.get(i).getSymbol() != null){
                       return String.valueOf(coinArrayList.get(i).getSymbol());
                     }else{
                           return " --";
                     }
                   }
       if(FLAG_CONTROLL_ARRAY == 3){
                     if(coinArrayList.get(i).getName()!= null){
                       return String.valueOf(coinArrayList.get(i).getName());
                     }else{
                           return " --";
                     }    
                   }
        if(FLAG_CONTROLL_ARRAY == 4){
                    if(coinArrayList.get(i).getPrice_brl()!= null){
                       return coinArrayList.get(i).getPrice_brl();
                     }else{
                           return " --";
                     }
                   }
        if(FLAG_CONTROLL_ARRAY == 5){
                     if(coinArrayList.get(i).getPercent_change_1h()!= null){
                       jTable.getColumnModel().getColumn(4).setCellRenderer(color.renderer);
                       return String.valueOf(coinArrayList.get(i).getPercent_change_1h());
                     }else if(coinArrayList.get(i).getPercent_change_1h()==null){
                           return " --";
                     }
           
                    }
        if(FLAG_CONTROLL_ARRAY == 6){
                     if(coinArrayList.get(i).getPercent_change_24h()!= null){
                      jTable.getColumnModel().getColumn(5).setCellRenderer(color.renderer);
                      return String.valueOf(coinArrayList.get(i).getPercent_change_24h());
                     }else{
                      return " --";
                     }
                   }
        if(FLAG_CONTROLL_ARRAY == 7){
                      if(coinArrayList.get(i).getPercent_change_7d()!= null){
                      jTable.getColumnModel().getColumn(6).setCellRenderer(color.renderer);
                      return String.valueOf(coinArrayList.get(i).getPercent_change_7d());
                     }else{
                     return " --";
                     }
                    }
        if(FLAG_CONTROLL_ARRAY == 8){
                    if(coinArrayList.get(i).getTotal_supply() != null){
                       return String.valueOf(coinArrayList.get(i).getTotal_supply());
                     }else{
                           return " --";
                     }
                    }
        if(FLAG_CONTROLL_ARRAY == 9){
                     if(coinArrayList.get(i).getMax_supply() != null){
                       return String.valueOf(coinArrayList.get(i).getMax_supply());
                     }else{
                           return " --";
                     }
                    }
        if(FLAG_CONTROLL_ARRAY == 10){
                     if(coinArrayList.get(i).getLast_updated() != null){
                       return String.valueOf(coinArrayList.get(i).getLast_updated());
                         }else{
                           return " --";
                     }
                    }
           if(FLAG_CONTROLL_ARRAY == 11){
                    return "Favoritar";
                    }
              if(FLAG_CONTROLL_ARRAY == 12){
                  return "Excluir";
                    }
               return " --";
         }
   
    /***
     * 
     * @param i controll position object
     * @param FLAG_CONTROLL_BUTTON controll buttons between classes 11- Favorite 12- Delete Coin
     * 
     */
    public void isEmptyColumn(int i,int FLAG_CONTROLL_BUTTON,DefaultTableModel dtm, ArrayList<Coin> coinArrayList,JTable jTable,CustomColor color){
                 if(coinArrayList != null);
                  dtm.addRow(new String[]{
                     isEmpty(i,1,coinArrayList,jTable,color),
                     isEmpty(i,2,coinArrayList,jTable,color),
                      isEmpty(i,3,coinArrayList,jTable,color),
                       isEmpty(i,4,coinArrayList,jTable,color),
                        isEmpty(i,5,coinArrayList,jTable,color),
                         isEmpty(i,6,coinArrayList,jTable,color),
                          isEmpty(i,7,coinArrayList,jTable,color),
                           isEmpty(i,8,coinArrayList,jTable,color),
                            isEmpty(i,9,coinArrayList,jTable,color),
                             isEmpty(i,10,coinArrayList,jTable,color),
                             isEmpty(i, FLAG_CONTROLL_BUTTON, coinArrayList, jTable, color)
                });
         }
}
