/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Game.PanelScore;
import Game.RunGame;
import Graficos.Instrucciones;
import Graficos.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Brayan Montañez & Luis Vargas
 */

public class VentanaTest extends JFrame{
    
    private Menu menu;
    private RunGame game;
    private PanelScore panelScore;
    Instrucciones instrucciones;
    
    public VentanaTest(){
        
        super.setBounds(0, 0, 800, 600);
        super.setTitle("Star Raid");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        super.setFocusable(false);
        
        //MENU
        menu = new Menu();
        menu.setVisible(true);
        

        //GAME
        panelScore = new PanelScore();       
        game = new RunGame(panelScore, menu); 
        game.setFocusable(true);
        
        //INSTRUCCIONES
        instrucciones = new Instrucciones();
        instrucciones.setVisible(false);
        
        super.add(panelScore);
        super.add(game);
        super.add(instrucciones, 0);
        super.add(menu, 0);
        
        
        this.eventos();
        
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void eventos(){
        
        /**
         * Boton de menu para ir a Jugar
         */
        menu.getJugar().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                game.setNamePlayer(JOptionPane.showInputDialog(null, null, "Nombre del Jugador", JOptionPane.PLAIN_MESSAGE));
                menu.setVisible(false); 
                game.initComponents();                           
                game.getPanelScore().initComponents();
                game.getPanelScore().start();
                game.run();              
                         
            }
            
        });
        
        /**
         * Boton de menu para ir a instrucciones
         */
        menu.getInstrucciones().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                menu.setVisible(false);
                instrucciones.setVisible(true);
                instrucciones.animation();
                         
            }
            
        });
        
        /**
         * Boton de Instrucciones para volver al menu pricipal
         */
        instrucciones.getVolverMenu().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                menu.setVisible(true);
                instrucciones.setVisible(false);
                instrucciones.getAnimationArrows().stop();
                         
            }
            
        });
        
    }
    
    
    
    public static void main(String[] args) {
       
        VentanaTest test = new VentanaTest();
        
    }
    
}
