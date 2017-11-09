
package Game;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Clase encargada de crear y cargar al Jugador
 */
public class Player {
    
    private JLabel player;
    
    public Player(){
        initComponentsPlayer();
    }
    
    /*
     * Inicia Componentes en su valor por defecto
    */
    public void initComponentsPlayer(){
        player = new JLabel();
        player.setBounds(245, 420, 110, 130);
        ImageIcon ima = new ImageIcon("Resources/player/xwing.png");
        Icon image = new ImageIcon(ima.getImage().getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_SMOOTH));
    
        player.setIcon(image);   
        //Para Probar colisiones    
        player.setBorder(new LineBorder(Color.RED));
    }
    
    /*
     * Eventos de Jugador
    */
    public void eventos(JPanel game){
        game.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                              
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    player.setLocation(player.getX()-10, player.getY());
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.setLocation(player.getX()+10, player.getY());
                }
            
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
 
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/
    
    /*
    * Retorna player
    */
    public JLabel getPlayer() {
        return player;
    }
    
}
