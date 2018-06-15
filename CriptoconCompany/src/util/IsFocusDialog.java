
package util;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class IsFocusDialog {
 public void isFocus(int FLAG_CONTROLL_FOCUS,JButton jbRegister,JPasswordField jtPasswordOne,JLabel jlTitleValidadePassOne,JPasswordField jtPasswordTwo,JLabel jlTitleValidadePassTwo,JTextField jtKey,JLabel jlAlertKey){
        switch(FLAG_CONTROLL_FOCUS){
            case 1:
        if(jtPasswordOne.getText().equalsIgnoreCase(jtPasswordTwo.getText())){
            jtPasswordOne.setBorder(BorderFactory.createLineBorder(Color.black));
            jlTitleValidadePassOne.setText("");
         }
        break;
            case 2:
        if(jtPasswordTwo.getText().length()<6){
           jtPasswordTwo.setBorder(BorderFactory.createLineBorder(Color.red));
            jlTitleValidadePassTwo.setText("Deve conter 6 caracteres");
            jlTitleValidadePassTwo.setForeground(Color.red);
        } else if(!jtPasswordOne.getText().equalsIgnoreCase(jtPasswordTwo.getText())){
            jtPasswordTwo.setBorder(BorderFactory.createLineBorder(Color.red));
            jlTitleValidadePassTwo.setText("Verifique a senha digitada");
            jlTitleValidadePassTwo.setForeground(Color.red);
         }else if(jtPasswordOne.getText().equalsIgnoreCase(jtPasswordTwo.getText())){
            jtPasswordTwo.setBorder(BorderFactory.createLineBorder(Color.black));
            jlTitleValidadePassTwo.setText("");
        }
        break;
          case 3:
        if(jtKey.getText().length()<6){
           jtKey.setBorder(BorderFactory.createLineBorder(Color.red));
            jlAlertKey.setText("Deve conter 6 caracteres");
            jlAlertKey.setForeground(Color.red);
        } else{
            jtKey.setBorder(BorderFactory.createLineBorder(Color.black));
            jlAlertKey.setText("");
        }
        break;
        }
 }   
}
