/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * De esta clase se instancian objetos de Tipo fuel en el mapa 
 *
 */
public class Fuel {
    
    private int InitY;
    private int InitX;
    private ImageIcon image;
    private Icon icon;
    private JLabel fuel;

    public Fuel(int InitX, int InitY) {
        this.InitY = InitY;
        this.InitX = InitX;
        
        fuel = new JLabel();
        fuel.setBounds(InitX, InitY, 50, 50);
        image = new ImageIcon("Resources/fuel.png");
        icon = new ImageIcon(image.getImage().getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_SMOOTH));
        fuel.setIcon(icon);

    }
    
    public void desplazarse(int SPEED){
        
        fuel.setLocation(fuel.getX(), fuel.getY()+SPEED-2);
        
    }

    public JLabel getFuel() {
        return fuel;
    }
   
    
}
