/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Game.Player;
import Game.World;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brayan Montañez
 */
public class VentanaTest {

    private JFrame ventana;
    private JPanel game;
    World mundo;
    Player player;
    
    public void hola(){
        ventana= new JFrame("hola");
        ventana.setLayout(null);
        ventana.setBounds(0, 0, 800, 600);
        
        game = new JPanel();
        game.setLayout(null);
        game.setBounds(0, 0, 600, 600);
        
        
        mundo = new World();
        player = new Player();
         
        
       
        player.eventos(game);
        mundo.eventos(game);
        game.setFocusable(true);
        game.add(player.getPlayer());
        game.add(mundo.getWorld_1());
        game.add(mundo.getWorld_2());
        
        ventana.add(game);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    

    
    public World getMundo() {
        return mundo;
    }   
    
    public static void main(String[] args) {
       VentanaTest ventana = new VentanaTest();
       ventana.hola();
       
       Timer timer = new Timer(10, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               ventana.getMundo().moveWorld();
               System.out.println(ventana.getMundo().getWorld_2().getY());
           }
       
       });
       
       timer.start();
    }
    
}
