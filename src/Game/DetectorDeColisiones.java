/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *  Clase encargada de detectar cualquier tipo de colisión con obtetos de Límites
 *  @author Brayan Montañez & Luis Vargas
 */
public class DetectorDeColisiones {
    
    /** Detecta colisiones de extremos básicos por la Izquierda
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @return true or false de la colision
    */
    public boolean BorderCollisionsLeft(Player player, CollisionsWorld colisiones){
        

        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
                     
            if(player.getPlayer().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                && player.getPlayer().getY() <= colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsLeft(i).getHeight()
                    && player.getPlayer().getY()+player.getPlayer().getHeight() >= colisiones.getConjuntoCollisionsLeft(i).getY()){
                
                return true;
            }
            
            else if(player.getPlayer().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                    && player.getPlayer().getY() == colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()){
                
                return true;
            }
            
            else{
                //Si no hay colision continúo con la ejecución normal
                player.setMover_Left(10);
                colisiones.setSPEED(5);
                
            }        
        }
        
         return false;              
    }
    
    /** Detecta colisiones de extremos básicos por la Derecha
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @return true or false de la colision
    */
    public boolean BorderCollisionsRight(Player player, CollisionsWorld colisiones){
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsRight().length; i++) {
            
            if(player.getPlayer().getX()+player.getPlayer().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && player.getPlayer().getY() <= colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()
                    && player.getPlayer().getY()+player.getPlayer().getHeight()>= colisiones.getConjuntoCollisionsRight(i).getY()){
                
                return true;
            }
            
            
            else if(player.getPlayer().getX()+player.getPlayer().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && player.getPlayer().getY() == colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()){
                
                return true;
            }
            
             else{
                 //Si no hay colision continúo con la ejecución normal
                player.setMover_Right(10);
                colisiones.setSPEED(5);
            }
 
        }

        return false;
    }
   
    /** Detecta colisiones del bloque del centro
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @return true or false de la colision
     */
    public boolean collisionsCenter(Player player, CollisionsWorld colisiones){
        
        if(colisiones.getCollisionsCenter().getY() + colisiones.getCollisionsCenter().getHeight() >= player.getPlayer().getY()
                && colisiones.getCollisionsCenter().getY() <=  player.getPlayer().getY() + player.getPlayer().getHeight()
                && colisiones.getCollisionsCenter().getX() <= player.getPlayer().getX() + player.getPlayer().getWidth()
                && colisiones.getCollisionsCenter().getX()+ colisiones.getCollisionsCenter().getWidth() >= player.getPlayer().getX()){
            
            return true;
            
        }

        return false;
        
    }
    
    /**
     * Detecta la colision Enemigo-Juagdor
     * @param player referencia al jugador
     * @param enemy refferencia al enemigo
     */
    public boolean collisionPlayerEnemy(Player player, Enemy enemy){
        
        if(player.getPlayer().getY() <= enemy.getEnemy().getY()+enemy.getEnemy().getHeight()
                && player.getPlayer().getY()+player.getPlayer().getHeight() >= enemy.getEnemy().getY()
                && player.getPlayer().getX() <= enemy.getEnemy().getX()+enemy.getEnemy().getWidth()
                && player.getPlayer().getX()+player.getPlayer().getWidth() >= enemy.getEnemy().getX()){
            
            return true;
        }
            
        
       return false; 
    }
    /** Detecta colisiones Con el enemigo
    * @param enemy Es la referencia al enemigo
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param PIXELES Es el tamaño del label del enemigo
    */
    public void BorderCollisionsEnemyRight(Enemy enemy, CollisionsWorld colisiones, int PIXELES){

        for (int i = 0; i < colisiones.getConjuntoCollisionsRight().length; i++) {
            
            if(enemy.getEnemy().getX()+enemy.getEnemy().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && enemy.getEnemy().getY() <= colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()
                    && enemy.getEnemy().getY()+PIXELES >= colisiones.getConjuntoCollisionsRight(i).getY()){
                
                enemy.setVelocidad(enemy.getVelocidad()*(-1));
                enemy.getEnemy().setLocation(enemy.getEnemy().getX()+ enemy.getVelocidad(), enemy.getEnemy().getY()); 
                break;
            } 
        }     
    }
    
    /** Detecta colisiones con el enemigo
    * @param enemy Es la referencia al enemigo
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param PIXELES Es el tamaño del label del enemigo
    */
    public void BorderCollisionsEnemyLeft(Enemy enemy, CollisionsWorld colisiones, int PIXELES){
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
                     
            if(enemy.getEnemy().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                && enemy.getEnemy().getY() <= colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsLeft(i).getHeight()
                    && enemy.getEnemy().getY()+PIXELES >= colisiones.getConjuntoCollisionsLeft(i).getY()){
                
                enemy.setVelocidad(enemy.getVelocidad()*(-1));
                enemy.getEnemy().setLocation(enemy.getEnemy().getX()+ enemy.getVelocidad(), enemy.getEnemy().getY()); 
                break;
            }               
        }               
    }
    /** Detecta colisiones del bloque del centro para el enemigo
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @return true or false de la colision
     */
    public void collisionsCenterEnemy(Enemy enemy, CollisionsWorld colisiones){
        
        if(colisiones.getCollisionsCenter().getY() + colisiones.getCollisionsCenter().getHeight() >= enemy.getEnemy().getY()
                && colisiones.getCollisionsCenter().getY() <=  enemy.getEnemy().getY() + enemy.getEnemy().getHeight()
                && colisiones.getCollisionsCenter().getX() <= enemy.getEnemy().getX() + enemy.getEnemy().getWidth()
                && colisiones.getCollisionsCenter().getX()+ colisiones.getCollisionsCenter().getWidth() >= enemy.getEnemy().getX()){
            
            enemy.setVelocidad(enemy.getVelocidad()*(-1));
            enemy.getEnemy().setLocation(enemy.getInitX()+ enemy.getVelocidad(), enemy.getInitY());          
        }
        
    }
    
    /** Detecta clisiones Fuel y player
     * @param player Es la referencia al jugador
     * @param fuel Es la referencia a la caja de combustible
     */
    public boolean collisionFuel(Player player, Fuel fuel){
        
        if(player.getPlayer().getX() <= fuel.getFuel().getX()+fuel.getFuel().getWidth()
                &&player.getPlayer().getX() + player.getPlayer().getWidth() >= fuel.getFuel().getX()
                    && player.getPlayer().getY() <= fuel.getFuel().getY()+fuel.getFuel().getHeight()
                        && player.getPlayer().getY()+player.getPlayer().getWidth()>= fuel.getFuel().getY()){
            
            return true;
            
        }
       
        return false;
    }
    
}


