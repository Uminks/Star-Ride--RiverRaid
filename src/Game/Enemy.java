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
 * Clase abstracta de enemigos
 * 
 */
public abstract class Enemy {
    
    private int InitY;
    private int InitX;
    private int Velocidad;
    private ImageIcon image;
    private Icon icon;
    private JLabel enemy;
    private boolean noComprobar;
        
    /**
     * Constructor de la clase Enemy asigna valores iniciales de su aparición, asigna velocidad y recibe un ImageIcon que posteriormente transformara en Icon.
     * @param InitY Posicion Inicial Y
     * @param InitX Posicion Inicial X
     * @param Velocidad Velocidad de desplazamiento en Pixeles
     * @param image Imagen del Enemigo
     */
    public Enemy(int InitX, int InitY, int Velocidad, ImageIcon image) {
        this.InitY = InitY;
        this.InitX = InitX;
        this.Velocidad = Velocidad;
        this.image = image;
        enemy = new JLabel();
        enemy.setBounds(InitX, InitY, 55, 55);
        icon = new ImageIcon(image.getImage().getScaledInstance(enemy.getWidth(), enemy.getHeight(), Image.SCALE_SMOOTH));
        enemy.setIcon(icon);
        noComprobar = false;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public int getInitY() {
        return InitY;
    }

    public void setInitY(int InitY) {
        this.InitY = InitY;
    }

    public int getInitX() {
        return InitX;
    }

    public void setInitX(int InitX) {
        this.InitX = InitX;
    }

    public JLabel getEnemy() {
        return enemy;
    }

    public void setEnemy(JLabel enemy) {
        this.enemy = enemy;
    }  

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }
    
    public abstract void desplazarse(int SPEED);

    public boolean isNoComprobar() {
        return noComprobar;
    }

    public void setNoComprobar(boolean noComprobar) {
        this.noComprobar = noComprobar;
    }
    
    
}
