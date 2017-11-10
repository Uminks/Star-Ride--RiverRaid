
package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Clase encargada de Cargar y crear las colisiones del mundo */
public class CollisionsWorld {
    
    //CONSTANTES
    private final int ANCHO_NORMAL = 45;
    private final int ALTO_NORMAL = 2400;
    
    
    private JLabel borderCollisionsLeft;
    private JLabel borderCollisionsRight;
    private JLabel borderCollisions;
  
    public CollisionsWorld(){
        initComponentsCollisions();
    }

    /** Inicia Componentes en su valor por defecto */
    public void initComponentsCollisions(){
        
        borderCollisionsLeft = new JLabel(new ImageIcon("Resources/world/border.png"));
        borderCollisionsLeft.setBounds(0, -1800, ANCHO_NORMAL, ALTO_NORMAL);
        
        
        borderCollisionsRight = new JLabel(new ImageIcon("Resources/world/border.png"));
        borderCollisionsRight.setBounds(555, -1800, ANCHO_NORMAL, ALTO_NORMAL);      

    }

        
    /**********************************************************/
    /************************ GETTERS *************************/
    /**********************************************************/
    
    /**
     *
     * @return borderCollisionsLeft Borde por defecto de colision por la izquierda
     */
    public JLabel getBorderCollisionsLeft() {
        return borderCollisionsLeft;
    }    
    
    /**
     *
     * @return borderCollisionsRight Borde por defecto de colision por la derecha
     */
    public JLabel getBorderCollisionsRight() {
        return borderCollisionsRight;
    }    
}
