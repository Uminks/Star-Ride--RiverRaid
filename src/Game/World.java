
package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Clase encargada de crear y acargar al Mundo
 */
public class World {
    
    private JLabel world_1;
    private JLabel world_2;
    public int SPEED;
    private boolean changeWorld;
    
    public World(){                     
        initComponentsWorld();
    }
    
    /*
     * Inicia Componentes en su valor por defecto
    */
    public void initComponentsWorld(){  
        
        world_1 = new JLabel(new ImageIcon("Resources/world/world.png"));
        world_1.setBounds(0, -1800, 600, 2400);
        
        world_2 = new JLabel(new ImageIcon("Resources/world/world.png")); 
        world_2.setBounds(0, -2400, 600, 2400);

        changeWorld = true;   
        
        SPEED = 2;
    }
    
    /*
    * Algoritmo de Movimiento independiente infinito
    */   
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
    
    
    public void eventos(JPanel game){
        game.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP){                      
                    SPEED = 10;                     
                }                            
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP){               
                    SPEED = 2;
                }
                    
                
            }
        });
    }
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/
    
    /*
    * Retorna world_1
    */
    public JLabel getWorld_1() {
        return world_1;
    }
    
    /*
    * Retorna world_2
    */
    public JLabel getWorld_2() {
        return world_2;
    }
    
}
