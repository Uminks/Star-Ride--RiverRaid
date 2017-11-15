/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * 
 */
public class PanelScore extends JPanel{
    
    private JProgressBar fuel;
    private int prueba;
    
    public PanelScore(){
        super.setLayout(null);
        super.setBounds(600, 0, 200, 600);

        fuel = new JProgressBar(0);
        fuel.setBounds(25, 0, 150, 30);  
        fuel.setValue(100);
        
        super.add(fuel);
        
    }
    
    public void start(){
                
        Timer t = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fuel.setValue(fuel.getValue()-2);
                
            }
            
        });
        t.start();
    }

    public JProgressBar getFuel() {
        return fuel;
    }
    
    
    
    
    
}
