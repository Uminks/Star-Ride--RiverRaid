
package Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Clase encargada de gestionar el disparo 
 */
public class Shoot {
    
    private int ANCHO = 5;
    private int ALTO = 25;
    
    private JLabel shoot;
    Timer timerDisparo;
    
    public Shoot(int x){
        
        shoot = new JLabel();
        shoot.setBounds(x, 400, ANCHO, ALTO); 
        ImageIcon ima = new ImageIcon("Resources/player/LaserVerde.png");
        Icon image = new ImageIcon(ima.getImage().getScaledInstance(shoot.getWidth(), shoot.getHeight(), Image.SCALE_SMOOTH));
    
        shoot.setIcon(image); 
        
        this.Disparar();
    }

    /**
     * 
     * @return shoot Objeto con todos los atributos del label
     */
    public JLabel getShoot() {
        return shoot;
    }
    
    /**
     * Metodo encargado de generar el disparo proveniente del player
     */
    public void Disparar(){
        timerDisparo = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                   shoot.setLocation(shoot.getX(), shoot.getY()-4);
                   detenerDisparo();           
            }
        });  
        timerDisparo.start();         
    } 
    
    /**
     * Comprueba cuando el disparo tiene que volverse null y desaparecer de la ejecucion
     */
    public void detenerDisparo(){       
        if((shoot.getY()+shoot.getHeight()+ALTO) < 0){
            timerDisparo.stop();
            shoot.setLocation(0, 2000);
            shoot.setEnabled(false);
            shoot.setVisible(false);
        }
    }
    
}
