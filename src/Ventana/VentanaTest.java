/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Game.PanelScore;
import Game.RunGame;
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
    
    public VentanaTest(){
        
        super.setBounds(0, 0, 800, 600);
        super.setTitle("Star Raid");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        super.setFocusable(false);
        
        menu = new Menu();
        menu.setVisible(true);
        
        game = new RunGame();
        game.setFocusable(true);
        
        panelScore = new PanelScore();
         
   
        super.add(panelScore);
        super.add(game);
        super.add(menu, 0);
        
        menu.getJugar().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                menu.setVisible(false);              
                game.run();
                
                
            }
            
        });
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    
    public static void main(String[] args) {
       
        VentanaTest test = new VentanaTest();
        
    }
    
}
