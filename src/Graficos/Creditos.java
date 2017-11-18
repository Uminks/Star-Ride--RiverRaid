/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Esta clase contiene el Panel Creditos.
 */
public class Creditos extends JPanel{
    
    private String pathBase = "Resources/Creditos/Creditos.png";
    private Image background = new ImageIcon(pathBase).getImage();
    private JLabel volverMenu;
    private String pathBaseLabel = "Resources/Creditos/";
    
    public Creditos(){
        
        super.setLayout(null);
        super.setBounds(0, 0, 800, 580);
        this.initComponents();
        super.add(volverMenu);
        
    }
    
    public void initComponents(){
        
        volverMenu = new JLabel();
        volverMenu.setBounds(650, 400, 100, 100);
        volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
        volverMenu.addMouseListener(new MouseEvents());
        
        
    }
    
    
    
     /**
     * @Override
     * Sobrecarga el metodo paintComponent para poder dibujar la Imagen en el Panel
     */
    @Override
    public void paintComponent(Graphics g){
        
        g.drawImage(background, 0, 0, getWidth(), getHeight(),this);
        
    }
    
    /**
    * Este Metodo Retorna un Objeto de Tipo ImageIcon Redimensionado a un contenedor Padre del Tipo JLabel
    * 
    * @param Button Recibe un Objeto del tipo ImageIcon el cual Colocará en el Label
    * @param Container Recibe el Contenedor padre, es Decir el Label para que el ImageIcon Se adapte a este.
    * @return Retorna un Objeto del tipo ImageIcon Redimensionado al contenedor padre.
    */
    private Icon AsignLabelDimension(ImageIcon Button, JLabel Container) {
        
        return new ImageIcon(Button.getImage().getScaledInstance(Container.getWidth(),Container.getHeight(),Image.SCALE_SMOOTH));

    }
 
    
    /**
     * Clase privada para gestionar eventos del mouse.
     */
    private class MouseEvents implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-3.png"), volverMenu));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
             if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-2.png"), volverMenu));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
            }
        }

    }
    
    /**
     * Getter de Label volverMenu.
     * @return Jlabel volverMenu
     */
    public JLabel getvolverMenu(){
        return volverMenu;
    }
    
}