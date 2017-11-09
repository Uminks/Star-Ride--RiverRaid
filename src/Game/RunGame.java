/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brayan Montañez
 */
public class RunGame extends JPanel{
    
    private World mundo;
    private Player player;
    private CollisionsWorld colisiones;
    
    public RunGame(){
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        
        
        mundo = new World();
        player = new Player();
        colisiones = new CollisionsWorld();
        
       
        player.eventos(this);
        mundo.eventos(this);
        
        this.setFocusable(true);
        this.add(player.getPlayer());
        this.add(colisiones.getBorderCollisionsLeft());
        this.add(colisiones.getBorderCollisionsRight());
        this.add(mundo.getWorld_1());
        this.add(mundo.getWorld_2());
        
        run();
    }
    
    
    public World getMundo() {
        return mundo;
    }  
    
    public void run(){
        
        Timer timer = new Timer(18, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               getMundo().moveWorld();
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

