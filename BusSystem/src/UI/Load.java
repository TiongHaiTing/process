package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Load{
    JWindow window;
    JPanel panel;
    JLabel lbl;
    JProgressBar progBar;
    Timer timer;
    int count =0;
    
    public static void main(String[] args) {
        Load load = new Load();
    }

    public Load(){
        window = new JWindow();
        //panel = new JPanel();
        lbl = new JLabel();
        lbl.setIcon(new ImageIcon(getClass().getResource("../icons/l.png")));
        
        progBar = new JProgressBar();
        progBar.setStringPainted(true);
        
        timer = new Timer(50,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                count++;
                progBar.setValue(count);
                
                if(progBar.getValue() <100)
                    progBar.setValue(progBar.getValue() +1);
                else
                {
                    timer.stop();
                    new Login().setVisible(true);
                    window.dispose();
                }
            }
        });
        timer.start();
        
        
        
        window.add(lbl, BorderLayout.CENTER);
        window.add(progBar, BorderLayout.SOUTH);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    
}