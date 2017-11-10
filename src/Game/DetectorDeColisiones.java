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
    * @param world Es la referencia al mundo (Puede no ser necesaria)
    */
    public void BorderCollisionsLeft(Player player, CollisionsWorld colisiones, World world){
        

        /** Colision Por la Izquierda del Límite**/
        if(player.getPlayer().getX() == (colisiones.getConjuntoCollisionsLeft(0).getX()+45)){
            
           //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        } 
        
        
        
        /*********************************************************************************/
        /***********************     VERIFICANDO 1 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colisión en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsLeft(1).getY()+500) &&
                (player.getPlayer().getX()) < colisiones.getConjuntoCollisionsLeft(1).getX()+90){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX() == (colisiones.getConjuntoCollisionsLeft(1).getX()+90)) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsLeft(1).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsLeft(1).getY()+500)){
               
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        } 
        
        
        
        
        /*********************************************************************************/
        /***********************     VERIFICANDO 2 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colición en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsLeft(2).getY()+400) &&
                (player.getPlayer().getX()) <= colisiones.getConjuntoCollisionsLeft(2).getX()+90){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX() == (colisiones.getConjuntoCollisionsLeft(2).getX()+90)) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsLeft(2).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsLeft(2).getY()+400)){
               
           //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        } 
        
        
        
        
         /*********************************************************************************/
        /***********************     VERIFICANDO 3 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colición en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsLeft(3).getY()+600) &&
                (player.getPlayer().getX()) < colisiones.getConjuntoCollisionsLeft(3).getX()+90){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX() == (colisiones.getConjuntoCollisionsLeft(3).getX()+90)) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsLeft(3).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsLeft(3).getY()+600)){
               
           //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Left(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        } 
        
        /*********************************************************************************/
        /***************************     NO HAY COLISION    *****************************/
        /********************************************************************************/
        else{
            //Si no hay colision continúo con la ejecución normal
            player.setMover_Left(10);
            colisiones.setSPEED(5);
            world.setSPEED(2);
        }
        
    }
    
    /** Detecta colisiones de extremos básicas
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param world Es la referencia al mundo (Puede no ser necesaria)
    */
    public void BorderCollisionsRight(Player player, CollisionsWorld colisiones, World world){
        
        
        /** Colision Por la Derecha **/
        if((player.getPlayer().getX()+110) == (colisiones.getConjuntoCollisionsRight(0).getX())){
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        }

        /*********************************************************************************/
        /***********************     VERIFICANDO 1 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colisión en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsRight(1).getY()+500) &&
                (player.getPlayer().getX()+110) > colisiones.getConjuntoCollisionsRight(1).getX()){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX()+110 == (colisiones.getConjuntoCollisionsRight(1).getX())) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsRight(1).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsRight(1).getY()+500)){
               
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        } 
        
        
        
        
        /*********************************************************************************/
        /***********************     VERIFICANDO 2 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colición en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsRight(2).getY()+400) &&
                (player.getPlayer().getX()+110) > colisiones.getConjuntoCollisionsRight(2).getX()){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
            
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX()+110 == (colisiones.getConjuntoCollisionsRight(2).getX())) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsRight(2).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsRight(2).getY()+400)){
               
           //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        }
      
         /*********************************************************************************/
        /***********************     VERIFICANDO 3 OBSTACULO    *************************/
        /********************************************************************************/
        /** verifico su colición en X*/
        else if(((player.getPlayer().getY()) == colisiones.getConjuntoCollisionsRight(3).getY()+600) &&
                (player.getPlayer().getX()+110) > colisiones.getConjuntoCollisionsRight(3).getX()){
            
            //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        }
        /** verifico su colición en Y*/
        else if((player.getPlayer().getX()+110 == (colisiones.getConjuntoCollisionsRight(3).getX())) &&
                ((player.getPlayer().getY()+130) > colisiones.getConjuntoCollisionsRight(3).getY()) &&
                ((player.getPlayer().getY()) < colisiones.getConjuntoCollisionsRight(3).getY()+600)){
               
           //Reinicio el Jugador
            //player.initComponentsPlayer();
            player.setMover_Right(0);
            colisiones.setSPEED(0);
            world.setSPEED(0);
        } 
        
        /*********************************************************************************/
        /***************************     NO HAY COLISION    *****************************/
        /********************************************************************************/
        else{
            //Si no hay colision continúo con la ejecución normal
            player.setMover_Right(10);
            colisiones.setSPEED(5);
            world.setSPEED(2);
        }
        
    }
   
}


