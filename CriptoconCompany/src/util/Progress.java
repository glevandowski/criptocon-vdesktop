package util;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Progress {
    
    public void isProgress(JProgressBar progress , JLabel progressLabel, int value){
        progress.setBounds(new Rectangle(10, 10, 170, 10));
        progress.setMinimum(0);
        progress.setMaximum(100);
        progress.setValue(value);
        progressLabel.add(progress);
    }
}
