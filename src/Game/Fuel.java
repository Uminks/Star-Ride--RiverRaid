/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * De esta clase se instancian objetos de Tipo fuel en el mapa 
 * @author Brayan Montañez & Luis Vargas
 */
public class Fuel {
    /** Coordenada inicial en x*/
    private int InitY;
    /** Coordenada inicial en y*/
    private int InitX;
    /** Imagen combustible*/
    private ImageIcon image;
    private Icon icon;
    /** Campo donde está el combustible*/
    private JLabel fuel;

    public Fuel(int InitX, int InitY) {
        this.InitY = InitY;
        this.InitX = InitX;
        
        fuel = new JLabel();
        fuel.setBounds(InitX, InitY, 50, 50);
        image = new ImageIcon("Resources/EnergyFinal.gif");
        icon = new ImageIcon(image.getImage().getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_SMOOTH));
        fuel.setIcon(image);
  
    }
    
    public void desplazarse(int SPEED){
        
        fuel.setLocation(fuel.getX(), fuel.getY()+SPEED-2);
        
    }

    public JLabel getFuel() {
        return fuel;
    }
   
    
}
