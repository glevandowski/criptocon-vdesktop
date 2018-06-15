
package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomColor  extends DefaultTableCellRenderer {
    
  public DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       if(value !=null);
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
  
        String str = (String) value;
        if (str.substring(0,1).contains("-")) {
            c.setForeground(Color.RED);
        }else if(str.equals(" --")){
            c.setForeground(Color.GRAY);
        }else {
            c.setForeground(Color.GREEN);
        }
        return c;
    }
};   
}
