/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Esta clase hereda de Enemigo, implementa el metodo desplazarse.
 * @author LuisF
 */
public class TIE extends Enemy {
  
    public TIE(int InitX, int InitY, int Velocidad) {
        super(InitX, InitY, Velocidad, new ImageIcon("Resources/TIE.png"));
    }
    
    public int getX(){
        return super.getInitX();
    }
    
    public int getY(){
        return super.getInitY();
    }
   
    @Override
    /**
     * Este metodo proporciona el movimiento del enemigo, colocando limites de izquierda a derecha y proporcionando
     * un desplazamiento hacia abajo
     */
    public void desplazarse() {
        
        super.getEnemy().setLocation( super.getEnemy().getX()+ super.getVelocidad(), super.getEnemy().getY()+2);
       
        
    }
    
}
