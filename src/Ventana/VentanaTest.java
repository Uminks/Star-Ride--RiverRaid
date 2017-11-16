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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


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
        game = new RunGame(panelScore); 
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
        
        menu.getJugar().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                
                menu.setVisible(false);
                game.initComponents();
                game.run();
                game.getPanelScore().initComponents();
                game.getPanelScore().start();
                         
            }
            
        });
        
        menu.getInstrucciones().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                menu.setVisible(false);
                instrucciones.setVisible(true);
                         
            }
            
        });
        
        instrucciones.getVolverMenu().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                menu.setVisible(true);
                instrucciones.setVisible(false);
                         
            }
            
        });
        
    }
    
    
    
    public static void main(String[] args) {
       
        VentanaTest test = new VentanaTest();
        
    }
    
}
