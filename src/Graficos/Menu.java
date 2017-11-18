/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase contiene todos los elementos del Menu y componen propiamente el mismo.
 * 
 */
public class Menu extends JPanel {
    
    private static int BWidth = 300;
    private static int BHeight = 50;
    private static int X = 450;
    private static int Y = 100;
    private static String PathBase = "Resources/BotonesMenu/";
    private static String png = ".png";
    private static String BackUrl = "Resources/Portada.png";
    private static Image background = new ImageIcon(BackUrl).getImage();
    private JLabel jugar, instrucciones, top10, creditos, salir;
    
    
    /**
     * Constructor Del Panel Menu, Otorga un Layout nulo, inicia los valores predeterminada de las imagenes y agrega los componentes (Botones) a la lamina.
     */
    public Menu(){
           
        this.setLayout(null);
        this.InitButtons();
        this.add(jugar);
        this.add(instrucciones);
        this.add(top10);
        this.add(creditos);
        this.add(salir);
        
        
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
     * Inicializa con las imagenes predeterminadas el menu
     */
    public void InitButtons(){
         
        this.jugar = new JLabel();
        this.jugar.setBounds(X, Y, BWidth, BHeight);
        this.jugar.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-05"+png),jugar));
        this.jugar.addMouseListener(new MouseEvent());
        this.jugar.setFocusable(false);
        
        this.instrucciones = new JLabel();
        this.instrucciones.setBounds(X, Y+80, BWidth, BHeight);
        this.instrucciones.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-04"+png),instrucciones));
        this.instrucciones.addMouseListener(new MouseEvent());
        this.instrucciones.setFocusable(false);
        
        this.top10 = new JLabel();
        this.top10.setBounds(X, Y+160, BWidth, BHeight);
        this.top10.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-01"+png),top10));
        this.top10.addMouseListener(new MouseEvent());
        this.top10.setFocusable(false);
        
        this.creditos = new JLabel();
        this.creditos.setBounds(X, Y+240, BWidth, BHeight);
        this.creditos.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-02"+png),creditos));
        this.creditos.addMouseListener(new MouseEvent());
        this.creditos.setFocusable(false);
        
        this.salir = new JLabel();
        this.salir.setBounds(X, Y+320, BWidth, BHeight);
        this.salir.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-03"+png),salir));
        this.salir.addMouseListener(new MouseEvent());
        this.salir.setFocusable(false);
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
        
        /**
         * Programar Eventos de los botones del menu
         * @param e evento
         */
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            
           if( e.getSource() == salir){
                System.exit(0);
            }
            
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            
            if( e.getSource() == jugar ){
                jugar.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-11"+png), jugar));
            }
            if( e.getSource() == instrucciones){
                instrucciones.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-12"+png), instrucciones));
            }
            if( e.getSource() == top10){
                top10.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-13"+png), top10));
            }
            if( e.getSource() == creditos){
                creditos.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-14"+png), creditos));
            }
            if( e.getSource() == salir){
                salir.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-15"+png),salir));
            }
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            
           if( e.getSource() == jugar ){
                jugar.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-06"+png), jugar));
            }
            if( e.getSource() == instrucciones){
                instrucciones.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-07"+png), instrucciones));
            }
            if( e.getSource() == top10){
                top10.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-08"+png), top10));
            }
            if( e.getSource() == creditos){
                creditos.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-09"+png), creditos));
            }
            if( e.getSource() == salir){
                salir.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-10"+png),salir));
            }
            
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            
            if( e.getSource() == jugar ){
                jugar.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-06"+png), jugar));
            }
            if( e.getSource() == instrucciones){
                instrucciones.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-07"+png), instrucciones));
            }
            if( e.getSource() == top10){
                top10.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-08"+png), top10));
            }
            if( e.getSource() == creditos){
                creditos.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-09"+png), creditos));
            }
            if( e.getSource() == salir){
                salir.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-10"+png),salir));
            }
            
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            
            if( e.getSource() == jugar ){
                jugar.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-05"+png), jugar));
            }
            if( e.getSource() == instrucciones){
                instrucciones.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-04"+png), instrucciones));
            }
            if( e.getSource() == top10){
                top10.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-01"+png), top10));
            }
            if( e.getSource() == creditos){
                creditos.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-02"+png),  creditos));
            }
            if( e.getSource() == salir){
                salir.setIcon(AsignButtonDimension(new ImageIcon(PathBase+"Botones-Menu-03"+png), salir));
            }
            
        }
    
}

    public JLabel getJugar() {
        return jugar;
    }

    public JLabel getInstrucciones() {
        return instrucciones;
    }
    
    public JLabel getCreditos(){
        return creditos;
    }
      
}