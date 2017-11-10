/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *  Clase encargada de detectar cualquier tipo de colisión con obtetos de Límites
 * 
 */
public class DetectorDeColisiones {
    
    /** Detecta colisiones de extremos básicas
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    */
    public void BorderCollisions(Player player, CollisionsWorld colisiones){
        
        /** Colision Por la Izquierda **/
        if(player.getPlayer().getX() == (colisiones.getBorderCollisionsLeft().getX()+45)){
            player.setMover_Left(0);
            System.out.println("Colision izquierda");
        } else{
            player.setMover_Left(10);
        }
        
        /** Colision Por la Derecha **/
        if((player.getPlayer().getX()+110) == (colisiones.getBorderCollisionsRight().getX())){
            player.setMover_Right(0);
            System.out.println("Colision derecha");
        } else{
            player.setMover_Right(10);
        }
        
    }
    
}
