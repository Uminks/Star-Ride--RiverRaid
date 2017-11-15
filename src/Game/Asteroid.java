/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Clase Asteroide hereda de Enemy.
 * @author LuisF
 */
public class Asteroid extends Enemy{
    
    private Timer animacion;
    private int Frame;
    private String Frames[] = {
        "a10000.png",
        "a10001.png",
        "a10002.png",
        "a10003.png",
        "a10004.png",
        "a10005.png",
        "a10006.png",
        "a10007.png",
        "a10008.png",
        "a10009.png",
        "a10010.png",
        "a10011.png",
        "a10012.png",
        "a10013.png",
        "a10014.png",
        "a10015.png"
    };
    
    /**
     * Constructor de Asteroid
     * @param InitX Posicion Inicial X
     * @param InitY Posicion Inicial Y
     */
    public Asteroid(int InitX, int InitY) {
        super(InitX, InitY, 7, new ImageIcon("Resources/Asteroides/a10000.png"));
        this.initComponents();
        animacion.start();
    }
    
    /**
     * Inicializar componentes
     */
    public void initComponents(){
        
        Frame = 0;
        animacion = new Timer(100 , new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
               ImageIcon image = new ImageIcon("Resources/Asteroides/"+Frames[Frame++]);
               Icon icon = new ImageIcon(image.getImage().getScaledInstance( Asteroid.super.getEnemy().getWidth() , Asteroid.super.getEnemy().getHeight() , Image.SCALE_SMOOTH));
               Asteroid.super.getEnemy().setIcon(icon);
                
               if( Frame >= 15 ){
                   Frame = 0;
               }
               
            }
            
        });
        
    }
    
    /**
     * Este metodo proporciona el movimiento del enemigo, colocando limites de izquierda a derecha y proporcionando
     * un desplazamiento hacia abajo
     * @Override
     */
    @Override
    public void desplazarse(int SPEED) {
       super.getEnemy().setLocation( super.getEnemy().getX()+ super.getVelocidad(), super.getEnemy().getY()+SPEED-2);
    }
    
}
