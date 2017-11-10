
package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Clase encargada de Cargar y crear las colisiones del mundo */
public class CollisionsWorld {
    
    //CONSTANTES
    private final int ANCHO_EXTREMO = 45;
    private final int ALTO_EXTREMO = 4200;
    public int SPEED = 5;
    
    private JLabel []conjuntoCollisionsRight;
    private JLabel []conjuntoCollisionsLeft;
    private JLabel []conjuntoCollisionsCenter;
  
    public CollisionsWorld(){
        
                
        conjuntoCollisionsLeft = new JLabel[4];     
        conjuntoCollisionsRight = new JLabel[4];
        conjuntoCollisionsCenter = new JLabel[3];
        
         for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
                    
            conjuntoCollisionsLeft[i] = new JLabel(new ImageIcon("Resources/world/border.png"));
            conjuntoCollisionsRight[i] = new JLabel(new ImageIcon("Resources/world/border.png"));
         }
        initComponentsCollisions();
    }

    /** Inicia Componentes en su valor por defecto */
    public void initComponentsCollisions(){

         

        for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
            
            conjuntoCollisionsLeft[i] = new JLabel(new ImageIcon("Resources/world/border.png"));
            conjuntoCollisionsRight[i] = new JLabel(new ImageIcon("Resources/world/border.png"));
            
            switch (i) {
                case 0:
                    conjuntoCollisionsLeft[i].setBounds(0, -3600, ANCHO_EXTREMO, ALTO_EXTREMO);
                    conjuntoCollisionsRight[i].setBounds(555, -3600, ANCHO_EXTREMO, ALTO_EXTREMO);
                    break;
                case 1:
                    conjuntoCollisionsLeft[i].setBounds(45, -2800, ANCHO_EXTREMO*2, 500);
                    conjuntoCollisionsRight[i].setBounds(465, -2800, ANCHO_EXTREMO*2, 500);
                    break;
                case 2:
                    conjuntoCollisionsLeft[i].setBounds(45, -1250, ANCHO_EXTREMO*2, 400);
                    conjuntoCollisionsRight[i].setBounds(465, -1250, ANCHO_EXTREMO*2, 400);
                    break;
                case 3:
                    conjuntoCollisionsLeft[i].setBounds(45, -300, ANCHO_EXTREMO*2, 600);
                    conjuntoCollisionsRight[i].setBounds(465, -300, ANCHO_EXTREMO*2, 600);
                    break;
            }
            
        }
        
       
        

    }

     /**
     * Mueve el mapa de obstaculos izquierdos
     */  
    public void moverColisionesLeft(){
        for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
            conjuntoCollisionsLeft[i].setLocation(conjuntoCollisionsLeft[i].getX(), conjuntoCollisionsLeft[i].getY()+SPEED);
        }
    }
    
    /**
     * Mueve el mapa de obstaculos derechos
     */
    public void moverColisionesRight(){
        for (int i = 0; i < conjuntoCollisionsLeft.length; i++) {
            conjuntoCollisionsRight[i].setLocation(conjuntoCollisionsRight[i].getX(), conjuntoCollisionsRight[i].getY()+SPEED);
        }
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
