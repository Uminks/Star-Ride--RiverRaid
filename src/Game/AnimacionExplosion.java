
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * @author Brayan Montañez
 */
public class AnimacionExplosion {
    
    private Timer timer;
    private int cont; 
    private ImageIcon icon;
    
    /**
     * Metodo para llamar a la animacion de la explosion
     * @param player referencia al Jugador
     * @param timerG timer de juego
     */
    public void animacionExplosion(final Player player, Timer timerG){ 
        timerG.stop();
        icon = new ImageIcon("Resources/Explosion1.gif");
        animacion(player, 0, timerG);
    }
    
    /**
     * Metodo para llamar a la animacion de la explosion
     * @param enemy referencia al enemigo
     * @param timerG timer de juego
     */
    public void animacionExplosion(final Enemy enemy){ 
        icon = new ImageIcon("Resources/Explosion1.gif");
        animacion(enemy);
    }
    
    /**
     * Animacion de explosion para el enemigo
     * @param enemy referencia al enemigo
     */
    private void animacion(final Enemy enemy){
        
        cont = 0;
            timer = new Timer(0, new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(timer.getDelay()==0){
                       timer.setDelay(700);
                   }
                   
                   cont += timer.getDelay(); 
                   
                   enemy.getEnemy().setIcon(icon);
                   icon.getImage().flush();
                   
                   if(cont == 1400){                    
                       enemy.getEnemy().setVisible(false);
                       enemy.getEnemy().setLocation(-600, 0);
                       timer.stop();
                   }

               }

           });
        timer.start();
    }
    
    
    /**
     * Animacion de explosion para el player
     * @param player  referencia al Jugador
     * @param cambio  para reiniciar el timer e imagen
     * @param timerG  timer de juego
     */
    private void animacion(final Player player, int cambio, final Timer timerG){
        if(cambio == 1){
            timerG.start();
        }
        else{
            cont = 0;
            timer = new Timer(0, new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(timer.getDelay()==0){
                       timer.setDelay(700);
                   }
                   
                   cont += timer.getDelay(); 
                   
                   player.getPlayer().setIcon(icon);
                   icon.getImage().flush();
                   
                   if(cont == 1400){
                       timer.stop();
                       animacion(player, 1, timerG);                    
                       
                   }

               }

           });
            timer.start();
        }
        
         
    }
    

    
}
