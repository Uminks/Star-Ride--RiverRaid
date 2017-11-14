/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brayan Montañez
 */
public class RunGame extends JPanel{
    
    private World mundo;
    private Player player;
    private ArrayList<Shoot> shootList;
    private ArrayList<Enemy> enemyList;
    private Timer addRandomEnemy, changeDelay;
    private CollisionsWorld colisiones;
    private DetectorDeColisiones detectorColisiones;
    
    public RunGame(){
        
        
        this.initComponents();
        
        
       
        this.addRandomEnemy.start();
        addRandomEnemy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addRandomEnemy.setDelay(RandomTime()*1000);
            }
        
        });
        
        
        player.eventos(this);
        colisiones.eventos(this);
        
        this.setFocusable(true);
        this.add(player.getPlayer());

        
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
            this.add(colisiones.getConjuntoCollisionsLeft(i));
            this.add(colisiones.getConjuntoCollisionsRight(i));
        }      

        this.add(mundo.getWorld_1());
        this.add(mundo.getWorld_2());
        
        //run();
    }
   
    
    
    /**
     * Este metodo inicializa todos los componentes básicos del RunGame.
     */
    public void initComponents(){
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        mundo = new World();
        player = new Player();
        enemyList = new ArrayList<Enemy>();
        shootList = new ArrayList<Shoot>();
        colisiones = new CollisionsWorld();
        detectorColisiones = new DetectorDeColisiones();
        
        addRandomEnemy = new Timer( RandomTime()*1000 , new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int Type = RandomEnemy();
                int Position = RandomEnemy();
                
                if(Type == 2){
                    
                    if( Position == 1){
                       enemyList.add(new Asteroid(200,-60)); 
                    }else if( Position == 2){
                        enemyList.add(new Asteroid(300,-60)); 
                    }else{
                        enemyList.add(new Asteroid(400,-60)); 
                    }
      
                }else if ( Type == 1 || Type == 3){
                    
                    
                     if( Position == 1){
                       enemyList.add(new  TIE(200,-60)); 
                    }else if ( Position == 2 ){
                        enemyList.add(new TIE(300,-60)); 
                    }else{
                        enemyList.add(new TIE(400,-60));
                    }
                     
                }
                
                addEnemy();
            }
            
        });
        

    } 
    
     /**
     * Este metodo agrega enemigos de Tipo JLabel al panel para ser mostrados.
     */
    public void addEnemy(){

        for( Enemy enemigos: enemyList){
            super.add(enemigos.getEnemy(),0);
        }
        
    }
    
    /**
     * Este metodo agrega disparos de Tipo JLabel al panel para ser mostrados.
     */
    public void addShoot(){      
        for(Shoot balas: shootList){
           this.add(balas.getShoot(),0);           
        }
    }
    
       
    /**
     * Este metodo retorna un numero aleatorio que representa el tiempo de espera en segundos.
     * @return retorna un tiempo en segundos aleatoriamente de tipo Integer. 
     */
    public int RandomTime(){
        
        int max = 6; int min = 2;
        
        return min + (int)(Math.random() * ((max - min) + 1));
        
    }
    
    
    /**
     * Este metodo retorna un numero aleatorio que tiene un significado para la logica de los villanos.
     * @return 
     */
    public int RandomEnemy(){
        int max = 3; int min = 1;
        
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    
    /**
     * Ejecuta todas la funciones de ejecuciones del juego
     */
    public void run(){
        
        Timer timer = new Timer(18, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               
               mundo.moveWorld();
               colisiones.moverColisiones();
               
               /**
                * Desplazar todos los enemigos.
                */
               for( Enemy enemigos : enemyList){
                   enemigos.desplazarse();
               }
               
               detectorColisiones.BorderCollisionsRight(player, colisiones, mundo); 
               detectorColisiones.BorderCollisionsLeft(player, colisiones, mundo);  
               
               /**
                * Validar colisiones de todos los enemigos.
                */
               for( Enemy enemigos : enemyList){
                    detectorColisiones.BorderCollisionsEnemyRight(enemigos, colisiones, 55);
                    detectorColisiones.BorderCollisionsEnemyLeft(enemigos, colisiones, 55);
                    //Colisiones enemigos y balas
                    for(Shoot balas: shootList){
                        if(enemigos.getEnemy().getY()+enemigos.getEnemy().getHeight() > balas.getShoot().getY()
                                && enemigos.getEnemy().getY() < balas.getShoot().getY()
                                && enemigos.getEnemy().getX() < balas.getShoot().getX()
                                && enemigos.getEnemy().getX() + enemigos.getEnemy().getWidth() > balas.getShoot().getX()){
                            
                            //En beta Eliminar xDDDDDDDD
                            enemigos.getEnemy().setLocation(0, 6000);
                            enemigos.getEnemy().setVisible(false);
                            
                            balas.getShoot().setLocation(0, 0);
                            balas.getShoot().setVisible(false);
                        }           
                    }
               }
               
           }
       
       });
        
        /* ---> Para trabajar
        Timer endGame = new Timer( 15*1000 , new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });*/
       
       timer.start();
       
       
       /**
        * ESCUCHADORA ENCARGADA DE GENERAR DISPAROS
        */
       super.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                }

            @Override
            public void keyPressed(KeyEvent e) {
                }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    shootList.add(new Shoot(player.getPlayer().getX()+(player.getPlayer().getWidth()/2)-2));
                    addShoot();                  
                }
            }
       });
       
    }
}


