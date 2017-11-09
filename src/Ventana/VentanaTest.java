/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Game.RunGame;
import Graficos.Menu;
import javax.swing.JFrame;


/**
 *
 * @author Brayan Montañez & Luis Vargas
 */

public class VentanaTest extends JFrame{
    
    public VentanaTest(){
        
        this.setBounds(0, 0, 800, 600);
        this.setTitle("Star Raid");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        //this.add(new Menu());
        this.add(new RunGame());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
 
    public static void main(String[] args) {
       
        VentanaTest test = new VentanaTest();
        
    }
    
}
