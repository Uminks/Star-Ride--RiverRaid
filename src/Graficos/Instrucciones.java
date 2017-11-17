/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Aqui se muestran las instrucciones de juego
 *
 */
public class Instrucciones extends JPanel{
    
    private String pathBase = "Resources/Instrucciones/fondo.png";
    private Image background = new ImageIcon(pathBase).getImage();
    private String pathBaseLabel = "Resources/Instrucciones/";
    private JLabel volverMenu, up, left, right, keyboard, fuel, pause, enter;
    private JLabel combustible, pausa, reanudar;
    private Timer animationArrows;
    private static Font StarJedi;
    int changeImage;
    
    public Instrucciones(){
        super.setLayout(null);
        super.setBounds(0, 0, 800, 600);
        this.initButtons();
        super.add(volverMenu);
        super.add(up);
        super.add(left);
        super.add(right);
        super.add(keyboard);
        super.add(fuel);
        super.add(pause);
        super.add(enter);
        super.add(combustible);
        super.add(reanudar);
        super.add(pausa);
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
        volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
        volverMenu.addMouseListener(new MouseEvent());
        
        left = new JLabel();
        left.setBounds(60, 370, 60, 60);
        left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-1.png"), left));
    
        up = new JLabel();
        up.setBounds(120, 310, 60, 60);
        up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-1.png"), up));
        
        right = new JLabel();
        right.setBounds(180, 370, 60, 60);
        right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-1.png"), right));
        
        
        keyboard = new JLabel();
        keyboard.setBounds(100, 430, 120, 70);
        keyboard.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"KeyBoard-1.png"), keyboard));
        
        fuel = new JLabel();
        fuel.setBounds(450, 320, 50, 50);
        fuel.setIcon(new ImageIcon("Resources/EnergyFinal.gif"));
        
        
        pause = new JLabel();
        pause.setBounds(460, 380, 40, 40);
        pause.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"escape2.png"), pause));
        
        enter = new JLabel();
        enter.setBounds(460, 430, 40, 40);
        enter.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"enter.png"), enter));
        
        combustible = new JLabel();
        combustible.setBounds(510, 325, 150, 40);
        StarJedi = cargarFuente("/Resources/Starjedi.ttf");
        combustible.setForeground(Color.WHITE);
        combustible.setFont(StarJedi);
        combustible.setText("Combustible");
        
        reanudar = new JLabel();
        reanudar.setBounds(510, 430, 150, 40);
        reanudar.setForeground(Color.WHITE);
        reanudar.setFont(StarJedi);
        reanudar.setText("Reanudar Juego");
        
        pausa = new JLabel();
        pausa.setBounds(510, 375, 150, 40);
        pausa.setForeground(Color.WHITE);
        pausa.setFont(StarJedi);
        pausa.setText("Pausar Juego");
        
    }
    
    
    /**
     * Metodo para Cargar fuentes personalizadas
     * @param ruta Ruta del Archivo
     * @return retorna una fuente personalizada
     */
    public Font cargarFuente(String ruta){
        
        Font fuente=null;  
        InputStream entrada = getClass().getClassLoader().getResourceAsStream(ruta); 
        
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, entrada);
            fuente = fuente.deriveFont(1,24f);
        } catch (FontFormatException ex) {
            fuente = new Font("Arial", Font.PLAIN, 19);  
            System.out.println("Error de Formato");
        } catch (IOException ex) {
            fuente = new Font("Arial", Font.PLAIN, 19);
            System.out.println(entrada);
            System.out.println("Error de Entrada y Salida de Datos");
        }
        
        
        
        return fuente;  
    }
    
    /**
     * Este metodo hace la animación vizualizada en las Instrucciones
     */
    public void animation(){
        changeImage = 0;
        /**
         * Imagenes por defecto
         */
        left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-1.png"), left));
        up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-1.png"), up));
        right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-1.png"), right));
        
        /**
         * Animacion de Flechas
         */
        animationArrows = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(changeImage == 0){
                    left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-2.png"), left));
                    up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-1.png"), up));
                    right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-1.png"), right));
                    keyboard.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"KeyBoard-1.png"), keyboard));
                    changeImage = 1;
                } else if(changeImage == 1){                  
                    up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-2.png"), up));
                    right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-1.png"), right));
                    left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-1.png"), left));
                    keyboard.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"KeyBoard-1.png"), keyboard));
                    changeImage = 2;
                } else if(changeImage == 2){
                    right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-2.png"), right));
                    left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-1.png"),left));
                    up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-1.png"), up));
                    keyboard.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"KeyBoard-1.png"), keyboard));
                    changeImage = 3;
                } else if(changeImage == 3){
                    left.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Izquierda-1.png"), left));
                    up.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Arriba-1.png"), up));
                    right.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Derecha-1.png"), right));
                    keyboard.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"KeyBoard-2.png"), keyboard));
                    changeImage = 0 ;
                }
                
            }            
        });
        animationArrows.start();
        
    }
    
    /**
    * Este Metodo Retorna un Objeto de Tipo ImageIcon Redimensionado a un contenedor Padre del Tipo JLabel
    * 
    * @param Button Recibe un Objeto del tipo ImageIcon el cual Colocará en el Label
    * @param Container Recibe el Contenedor padre, es Decir el Label para que el ImageIcon Se adapte a este.
    * @return Retorna un Objeto del tipo ImageIcon Redimensionado al contenedor padre.
    */
    public Icon AsignLabelDimension(ImageIcon Button, JLabel Container){
        
       
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
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-3.png"), volverMenu));
            }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-2.png"), volverMenu));
            }
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if(e.getSource() == volverMenu){
                volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
            }
        }
        
    }

    public JLabel getVolverMenu() {
        return volverMenu;
    }

    public Timer getAnimationArrows() {
        return animationArrows;
    }
     
}