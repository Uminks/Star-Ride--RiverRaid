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
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class Top10 extends JPanel {
    
    
    private String pathBase = "Resources/Top 10/top10.png";
    private Image background = new ImageIcon(pathBase).getImage();
    private JLabel volverMenu;
    private String pathBaseLabel = "Resources/Top 10/";
    private BufferedReader archivo;
    private String Nombres[];
    private int Puntos[];
    private JLabel Name[];
    private JLabel Score[];
    private JLabel Position[];
    private Font StarJedi;
    private static int TopPlayers = -1;
    
    
    public Top10(){
        
        super.setLayout(null);
        super.setBounds(0, 0, 800, 600);
        this.initComponents();    
        this.cargarLabels();      
        super.add(volverMenu);
        
    }
    
    
    /**
     * Metodo para inicializar componentes.
     */
     public void initComponents(){
        
        volverMenu = new JLabel();
        volverMenu.setBounds(680, 410, 100, 100);
        volverMenu.setIcon(AsignLabelDimension(new ImageIcon(pathBaseLabel+"Flecha-1.png"), volverMenu));
        volverMenu.addMouseListener(new MouseEvents());
        Position = new JLabel[10];
        Score = new JLabel[10];
        Name = new JLabel[10]; 
        Nombres = new String[10];
        Puntos = new int[10];
        StarJedi = cargarFuente("../Starjedi.ttf");
        try {
            this.leerArchivo();
        } catch (IOException ex) {
            System.out.println("Error de Entrada y Salida de Datos");
        }
        
    }
    
     /**
      * Metodo Para Leer Archivos del TOP10 De la carpeta principal.
      * @throws FileNotFoundException
      * @throws IOException 
      */
     public void leerArchivo() throws FileNotFoundException, IOException{
         
        String linea = null;
        archivo = new BufferedReader( new FileReader("top10.txt"));
        
         
        try {
            linea = archivo.readLine();
        } catch (IOException ex) {
            System.out.println("Error al Leer el Archivo");
        }
        
        StringTokenizer token;
        
        while(linea != null){
            
            token = new StringTokenizer(linea,"-");
            
            Nombres[++TopPlayers] = token.nextToken();
            Puntos[TopPlayers] = Integer.parseInt(token.nextToken());
            
            linea = archivo.readLine();
            
        }
         
        
     }
    
    /**
     * Metodo Para Cargar informacion de los labels.
     */
     public void cargarLabels(){
         
         int PositionX = 130;
         int NameX = 320;
         int ScoreX = 570;
         int YInit = 100;
         
         for (int i = 0; i <= TopPlayers; i++) {
             
            
             Name[i] = new JLabel(Nombres[i]);
             Score[i] = new JLabel(String.valueOf(Puntos[i]));
             Position[i] = new JLabel(String.valueOf(i+1));
            
            // POSICIONES
            Position[i].setBounds(PositionX,YInit, 150, 40);
            Position[i].setFont(StarJedi);
            Position[i].setForeground(Color.WHITE);
             
            // NOMBRES
            Name[i].setBounds(NameX, YInit, 300, 40);
            Name[i].setFont(StarJedi);
            Name[i].setForeground(Color.WHITE);
            
            // SCORES
            Score[i].setBounds(ScoreX,YInit,150,40);
            Score[i].setFont(StarJedi);
            Score[i].setForeground(Color.WHITE);
            
            YInit += 45;
             
             super.add(Name[i]);
             super.add(Score[i]);
             super.add(Position[i]);
         }
         
         
         
        
         
         
         
    
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
     * Metodo para Cargar fuentes personalizadas
     * @param ruta Ruta del Archivo
     * @return retorna una fuente personalizada
     */
    public Font cargarFuente(String ruta){
        Font fuente=null; 
        InputStream entrada = getClass().getResourceAsStream(ruta);
        
        try {                 
            fuente = Font.createFont(Font.TRUETYPE_FONT, entrada);
            fuente = fuente.deriveFont(1,16f);

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
     * Getter de Label volverMenu.
     * @return Jlabel volverMenu
     */
    public JLabel getvolverMenu(){
        return volverMenu;
    }
    
    
}
