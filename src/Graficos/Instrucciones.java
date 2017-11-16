/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Aqui se muestran las instrucciones de juego
 *
 */
public class Instrucciones extends JPanel{
    
    private String pathBase = "Resources/Instrucciones/Instrucciones.png";
    private Image background = new ImageIcon(pathBase).getImage();
    private String pathBaseLabel = "Resources/Instrucciones/";
    private JLabel volverMenu;
    
    
    public Instrucciones(){
        super.setLayout(null);
        super.setBounds(0, 0, 800, 600);
        this.initButtons();
        super.add(volverMenu);
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
     * Inicializa con las imagenes predeterminadas
     */
    public void initButtons(){
        volverMenu = new JLabel();
        volverMenu.setBounds(650, 450, 100, 100);
        volverMenu.setIcon(AsignButtonDimension(new ImageIcon(pathBaseLabel+"Flecha-2.png"), volverMenu));
        volverMenu.addMouseListener(new MouseEvent());
    }
    
    
    /**
    * Este Metodo Retorna un Objeto de Tipo ImageIcon Redimensionado a un contenedor Padre del Tipo JLabel
    * 
    * @param Button Recibe un Objeto del tipo ImageIcon el cual Colocará en el Label
    * @param Container Recibe el Contenedor padre, es Decir el Label para que el ImageIcon Se adapte a este.
    * @return Retorna un Objeto del tipo ImageIcon Redimensionado al contenedor padre.
    */
    public Icon AsignButtonDimension(ImageIcon Button, JLabel Container){
        
       return new ImageIcon(Button.getImage().getScaledInstance(Container.getWidth(),Container.getHeight(),Image.SCALE_SMOOTH));
       
    }
    
    /**
     * Esta Clase Interna Gestiona los eventos del mouse en el Label del Menu Principal
     */
    private class MouseEvent implements MouseListener{

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignButtonDimension(new ImageIcon(pathBaseLabel+"Flecha-3.png"), volverMenu));
            }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignButtonDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignButtonDimension(new ImageIcon(pathBaseLabel+"Flecha-2.png"), volverMenu));
            }
        }
        
    }

    public JLabel getVolverMenu() {
        return volverMenu;
    }
  
}
