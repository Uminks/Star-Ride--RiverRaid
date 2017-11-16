
package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Clase encargada de Cargar y crear las colisiones del mundo */
public class CollisionsWorld {
    
    //CONSTANTES
    private final int ANCHO_EXTREMO = 50;
    private final int ALTO_EXTREMO = 4200;
    public int SPEED = 5;
    private boolean changeCollisions;
    
    private JLabel []conjuntoCollisionsRight;
    
    
    private JLabel []conjuntoCollisionsLeft;
    private JLabel []conjuntoCollisionsLeftAux;
    
    private JLabel []conjuntoCollisionsCenter;
    
  
    public CollisionsWorld(){
        
                
        conjuntoCollisionsLeft = new JLabel[4];
         
        conjuntoCollisionsRight = new JLabel[4];
        conjuntoCollisionsCenter = new JLabel[3];
        
         for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
                    
            conjuntoCollisionsLeft[i] = new JLabel(new ImageIcon("Resources/world/starblack.png"));
            
            conjuntoCollisionsRight[i] = new JLabel(new ImageIcon("Resources/world/starblack.png"));
         }
        initComponentsCollisions();
    }

    /** Inicia Componentes en su valor por defecto */
    public void initComponentsCollisions(){    

        for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
                                   
            switch (i) {
                case 0:
                    conjuntoCollisionsLeft[i].setBounds(0, -3600, ANCHO_EXTREMO, ALTO_EXTREMO);
                                        
                    conjuntoCollisionsRight[i].setBounds(550, -3600, ANCHO_EXTREMO, ALTO_EXTREMO);
                    break;
                case 1:
                    conjuntoCollisionsLeft[i].setBounds(50, -2800, ANCHO_EXTREMO*2, 500);
                                       
                    conjuntoCollisionsRight[i].setBounds(450, -2800, ANCHO_EXTREMO*2, 500);
                    break;
                case 2:
                    conjuntoCollisionsLeft[i].setBounds(50, -1550, ANCHO_EXTREMO*3, 300);
                                         
                    conjuntoCollisionsRight[i].setBounds(400, -1550, ANCHO_EXTREMO*3, 300);
                    break;
                case 3:
                    conjuntoCollisionsLeft[i].setBounds(50, -600, ANCHO_EXTREMO*2, 600);
                                        
                    conjuntoCollisionsRight[i].setBounds(450, -600, ANCHO_EXTREMO*2, 600);
                    break;
            }
            
        }
        
       changeCollisions = true;
        

    }

     /**
     * Mueve el mapa de obstaculos 
     */  
    public void moverColisiones(){
            
        if(conjuntoCollisionsLeft[1].getY() >= 600){
            
            this.initComponentsCollisions();
        }
        
        else{         
            for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
             conjuntoCollisionsLeft[i].setLocation(conjuntoCollisionsLeft[i].getX(), conjuntoCollisionsLeft[i].getY()+SPEED);
             conjuntoCollisionsRight[i].setLocation(conjuntoCollisionsRight[i].getX(), conjuntoCollisionsRight[i].getY()+SPEED);
            } 
        } 
        
    }
    
    
    
    /** Eventos del teclado (rapidez) para los obstaculos
     * @param game Panel del juego al que aplican los eventos de teclado
     */
    public void eventos(JPanel game, final PanelScore panelScore){
        game.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP && SPEED >0){  

                    panelScore.getFuel().setValue(panelScore.getFuel().getValue()-1);                    
                    SPEED = 20;                     
                }                            
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP){ 
                    SPEED = 5;
                }
                    
                
            }
        });
    }
    
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/
    
    /**
     * 
     * @param SPEED Modifica la velocidad de desplazamiento
     */ 
    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }  

    public int getSPEED() {
        return SPEED;
    }
       

    /**
     *
     * @return conjuntoCollisionsLeft[] Label izquierdo de acuerdo al index 
     * @param  index Label en una posicion dada
     */
    public JLabel getConjuntoCollisionsLeft(int index) {
        return conjuntoCollisionsLeft[index];
    }    
    
    /**
     * @return vector completo de labels por izquierda
     */
    public JLabel[] getConjuntoCollisionsLeft() {
        return conjuntoCollisionsLeft;
    }    

    /**
     *
     * @return conjuntoCollisionsRight[] Label derecho de acuerdo al index 
     * @param  index Label en una posicion dada
     */
    public JLabel getConjuntoCollisionsRight(int index) {
        return conjuntoCollisionsRight[index];
    }  
    
    /**
     *
     * @return borderCollisionsRight vector completo de labels por derecha
     */
    public JLabel[] getConjuntoCollisionsRight() {
        return  conjuntoCollisionsRight;
    }    
    
 
    
    
}
