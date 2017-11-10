/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brayan Montañez
 */
public class RunGame extends JPanel{
    
    private World mundo;
    private Player player;
    private Enemy enemigo;
    private CollisionsWorld colisiones;
    private DetectorDeColisiones detectorColisiones;
    
    public RunGame(){
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        
        ImageIcon img = new ImageIcon("Resources/TIE.png"); // Enemigo BETA 
        enemigo = new TIE(0,50,6,img); // Enemigo BETA 
        
        mundo = new World();
        player = new Player();
        colisiones = new CollisionsWorld();
        detectorColisiones = new DetectorDeColisiones();
       
        player.eventos(this);
        mundo.eventos(this);
        
        this.setFocusable(true);
        this.add(player.getPlayer());
        this.add(enemigo.getEnemy()); // Enemigo BETA 
        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
            this.add(colisiones.getConjuntoCollisionsLeft(i));
            this.add(colisiones.getConjuntoCollisionsRight(i));
        }      

        this.add(mundo.getWorld_1());
        this.add(mundo.getWorld_2());
        
        run();
    }
    
    
    public World getMundo() {
        return mundo;
    }  
    
    public Enemy getEnemy(){ // Enemigo BETA 
        return enemigo;
    }
    
    public void run(){
        
        Timer timer = new Timer(18, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               
               getMundo().moveWorld();
               colisiones.moverColisionesLeft();
               colisiones.moverColisionesRight();
               getEnemy().desplazarse();
               detectorColisiones.BorderCollisionsRight(player, colisiones, mundo);
               detectorColisiones.BorderCollisionsLeft(player, colisiones, mundo);              
               
           }
       
       });
       
       timer.start();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * 
 */

