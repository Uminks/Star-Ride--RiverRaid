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
 * @author Brayan Montañez & Luis Vargas
 */
public class Player {
    
    /** Ancho del Personaje*/
    private final int ANCHO = 80;
    /** ALto del Personaje*/
    private final int ALTO = 100;
    /** Pixeles que se mueve a la izquierda*/
    private int Mover_Left = 10;
    /** Pixeles que se mueve a la derecha*/
    private int Mover_Right = 10;
    /** Campo donde está el jugador*/
    private JLabel player;
    
    public Player(){
        player = new JLabel();
        player.setBounds(245, 420, ANCHO, ALTO); 
            
        
        initComponentsPlayer();
    }
    
    /** Inicia Componentes en su valor por defecto */
    public void initComponentsPlayer(){
        
        player.setBounds(245, 420, ANCHO, ALTO); 
        ImageIcon ima = new ImageIcon("Resources/player/xwing.png");
        Icon image = new ImageIcon(ima.getImage().getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_SMOOTH));
        player.setIcon(image); 
        //Para Probar colisiones    
        //player.setBorder(new LineBorder(Color.RED));
    }
    
    /** Eventos del teclado para el Jugador
     * @param game Panel del juego al que aplican los eventos de teclado
     */
    public void eventos(final JPanel game){
        game.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            //MOVIMIENTO
            @Override
            public void keyPressed(KeyEvent e) {
                              
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    player.setLocation(player.getX()-Mover_Left, player.getY());
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.setLocation(player.getX()+Mover_Right, player.getY());
                }
            
            }
            
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
   
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/

    /** Retorna player
     * @return player jugador del juego y todos sus componentes
     */
    public JLabel getPlayer() {
        return player;
    }

    /**
     * 
     * @param Mover_Left Es el indicador por izquierda del movimiento que viene de la colision
     */
    public void setMover_Left(int Mover_Left) {
        this.Mover_Left= Mover_Left;
    }
    
    /**
     * 
     * @param Mover_Right Es el indicador por derecha del movimiento que viene de la colision
     */
    public void setMover_Right(int Mover_Right) {
        this.Mover_Right = Mover_Right;
    }
     
}
