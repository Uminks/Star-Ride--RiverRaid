
package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * Clase encargada de crear y cargar al Mundo
 * @author Brayan Montañez & Luis Vargas
 */
public class World {
    /** constantes de ancho y alto de las colisiones*/
    private final int ANCHO = 600;
    private final int ALTO = 2400;
    
    /** Labels en los que se muestra el mundo*/
    private JLabel world_1;
    private JLabel world_2;
    /** Velocidad con que baja el mundo*/
    private int SPEED;
    /** Indica cuando debe cambiar de mundo*/
    private boolean changeWorld;
    
    public World(){
        world_1 = new JLabel(new ImageIcon("Resources/world/world.png"));
        world_2 = new JLabel(new ImageIcon("Resources/world/world.png")); 
        initComponentsWorld();
    }
    
    /** Inicia Componentes en su valor por defecto */
    public void initComponentsWorld(){  
        
        
        world_1.setBounds(0, -1800, ANCHO, ALTO);      
        
        world_2.setBounds(0, -2400, ANCHO, ALTO);

        changeWorld = true;   
        
        SPEED = 2;
    }
    
    /** Algoritmo de Movimiento independiente infinito */   
    public void moveWorld(){
        
        if(changeWorld == true){
            world_1.setLocation(world_1.getX(), world_1.getY()+SPEED);
        }
        else if(changeWorld == false){
            world_2.setLocation(world_2.getX(), world_2.getY()+SPEED);
        }
        
        //Movimiento paralelo de ambos universos en referencia a world_1
        if(world_1.getY() >= 0  && world_1.getY() < 600){
            world_2.setLocation(world_2.getX(), world_2.getY()+SPEED);
        }
        
        //Fin de Movimiento Paralelo y cambio de movimiento
        if(world_1.getY() >= 600){
            //Cambio de mundo
            changeWorld = false;
            //reinicio el world_1
            world_1.setLocation(world_1.getX(), -2400);
        }
        
        //Movimiento paralelo de ambos universos en referencia a world_2
        if(world_2.getY() >= 0  && world_2.getY() < 600){
            world_1.setLocation(world_1.getX(), world_1.getY()+SPEED);
        }
        
        //Fin de Movimiento Paralelo y cambio de movimiento
        if(world_2.getY() >= 600){
            //Cambio de mundo
            changeWorld = true;
            //reinicio el world_2
            world_2.setLocation(world_2.getX(), -2400);
        }
        
    }
    
    
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/
    
    /** Retorna world_1
     * @return world_1 Primer mundo que aparece
     */
    public JLabel getWorld_1() {
        return world_1;
    }
    
    /** Retorna world_2
     * @return  world_2 Segundo mundo que se carga para seguir avanzando
     */
    public JLabel getWorld_2() {
        return world_2;
    }
    
    /**
     * 
     * @param SPEED Modifica la velocidad de desplazamiento
     */ 
    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    } 
    
    
}
