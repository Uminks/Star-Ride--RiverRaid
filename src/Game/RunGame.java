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
    private ArrayList<Fuel> fuelList;
    private Timer addRandomEnemy, addRandomFuel;
    private CollisionsWorld colisiones;
    private DetectorDeColisiones detectorColisiones;
    private Timer timerGame;
    private int Score;
    private boolean dejarDisparar, pause;
    
    private PanelScore panelScore;
    
    public RunGame(PanelScore panelScore){
        
        this.panelScore = panelScore;
  
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
        fuelList = new ArrayList<Fuel>();
        colisiones = new CollisionsWorld();
        detectorColisiones = new DetectorDeColisiones();
        Score = 0;               
        dejarDisparar = false;
        pause = false;
        
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
        
        
        this.addRandomEnemy.start();
        addRandomEnemy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addRandomEnemy.setDelay(RandomTime()*1000);
            }
        
        });
        
        
        addRandomFuel = new Timer((RandomTime()-1)*1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int Position = RandomEnemy();
                
                if(Position==1){
                    fuelList.add(new Fuel(200, -100));
                }else if(Position==1){
                    fuelList.add(new Fuel(300, -100));
                }else{
                    fuelList.add(new Fuel(400, -100));
                }
                    
                addFuel();
            }
        
        });
        

        this.addRandomFuel.start();
        addRandomFuel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addRandomFuel.setDelay((RandomTime()-1)*1000);
            }
        
        });
        
     
        player.eventos(this);
        colisiones.eventos(this, panelScore);
        
        this.setFocusable(true);
        this.add(player.getPlayer());
  
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
            this.add(colisiones.getConjuntoCollisionsLeft(i));
            this.add(colisiones.getConjuntoCollisionsRight(i));
        }      

        this.add(mundo.getWorld_1());
        this.add(mundo.getWorld_2());
        

    }
    
    
     /**
     * Este metodo agrega enemigos de Tipo JLabel al panel para ser mostrados.
     */
    public void addEnemy(){

        for( Enemy enemigos: enemyList){
            if(enemigos.getEnemy().isVisible()==true){
                super.add(enemigos.getEnemy(),0);
            }
            

        }
        
    }
    
    /**
     * Este metodo agrega disparos de Tipo JLabel al panel para ser mostrados.
     */
    public void addShoot(){      
        for(Shoot balas: shootList){
            super.add(balas.getShoot(),0); 
            
        }
    }
    
    /**
     * Este metodo agrega combustibles de Tipo JLabel al panel para ser mostrados.
     */
    public void addFuel(){      
        for(Fuel fuel: fuelList){
            if(fuel.getFuel().isVisible() == true){
                super.add(fuel.getFuel(), 0); 
            }
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
     * Este metodo retorna un numero aleatorio que tiene un significado para la logica de los villanos y el fuel.
     * @return random entero para la ubicacion del enemigo y fuel
     */
    public int RandomEnemy(){
        int max = 3;
        
        return (int)(Math.random() * (max) + 1);
    }
    
    /**
     * Ejecuta todas la funciones de ejecuciones del juego
     */
    public void run(){
        
        timerGame = new Timer(18, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               
               mundo.moveWorld();
               colisiones.moverColisiones();
               /**
                * Desplazar todos los enemigos.
                */
               for( Enemy enemigos : enemyList){
                   if(enemigos.getEnemy().isVisible()==true){
                       enemigos.desplazarse(colisiones.getSPEED());
                   }                
               }
               /**
                * Desplazar Combustible
                */
               for( Fuel fuel : fuelList){
                   if(fuel.getFuel().isVisible() == true){
                       fuel.desplazarse(colisiones.getSPEED()); 
                   }                       
               }
               
               /**
                * Colisiones del Jugador con los obstáculos
                */
               
               if(detectorColisiones.BorderCollisionsRight(player, colisiones, mundo) == true
                       || detectorColisiones.BorderCollisionsLeft(player, colisiones, mundo) == true){

                   player.initComponentsPlayer();
                   //Resto vidas Al Player
                   panelScore.setIntLives(panelScore.getIntLives()-1);
                   
               }
               
               
               /**
                * Validar colisiones de todos los enemigos.
                */
               for( Enemy enemigos : enemyList){
                       
                        detectorColisiones.BorderCollisionsEnemyRight(enemigos, colisiones, 55);
                        detectorColisiones.BorderCollisionsEnemyLeft(enemigos, colisiones, 55);
                        
                        /**
                         * Colisiones de balas con otros componentes
                         */
                        for(Shoot balas: shootList){
                                
                                /**
                                 * Bala => Enemigo
                                 */
                                if(enemigos.getEnemy().getY()+enemigos.getEnemy().getHeight() > balas.getShoot().getY()
                                        && enemigos.getEnemy().getY() < balas.getShoot().getY()
                                        && enemigos.getEnemy().getX() < balas.getShoot().getX()
                                        && enemigos.getEnemy().getX() + enemigos.getEnemy().getWidth() > balas.getShoot().getX()){

                                        /**
                                         * Si elimina un TIE +30
                                         */
                                        if(enemigos instanceof TIE){
                                            Score += 30;
                                        }
                                        /**
                                         * Si elimina un asteroide +50
                                         */
                                        else if(enemigos instanceof Asteroid){
                                            Score += 50;
                                        }

                                        enemigos.getEnemy().setVisible(false);
                                        enemigos.getEnemy().setLocation(-600, 0);

                                        balas.getShoot().setVisible(false);
                                        balas.getShoot().setLocation(-100, 0);

                                        panelScore.setIntScore(Score);
                                } 
                                
                                /**
                                 * Balas => fuel
                                 */                             
                                for(Fuel fuel: fuelList){
                                    
                                     if(fuel.getFuel().getY()+fuel.getFuel().getHeight() > balas.getShoot().getY()
                                        && fuel.getFuel().getY() < balas.getShoot().getY()
                                        && fuel.getFuel().getX() < balas.getShoot().getX()
                                        && fuel.getFuel().getX() + fuel.getFuel().getWidth() > balas.getShoot().getX()){
                                     
                                            int auxScore = Score-20;
                                            
                                            if(auxScore <= 0){
                                                Score = 0;
                                            } else{
                                                Score = auxScore;
                                            }
                                            
                                            panelScore.setIntScore(Score);
                                            
                                            fuel.getFuel().setVisible(false);
                                            fuel.getFuel().setLocation(-600, 0);

                                            balas.getShoot().setVisible(false);
                                            balas.getShoot().setLocation(-100, 0);
                                         
                                     }
                                    
                                }
                            

                        }
                        
                        //Si el enemigo sale del mapa
                        if(enemigos.getEnemy().getY() >= 650){
                            enemigos.getEnemy().setVisible(false);
                        }
                                        
               }
               
               /**
                *  Colisiones player y fuel
                */
               for( Fuel fuel : fuelList){
                   
                   if(detectorColisiones.collisionFuel(player, fuel)==true){
                       fuel.getFuel().setLocation(-600, 0);
                       fuel.getFuel().setVisible(false);
                       
                       panelScore.getFuel().setValue(100);
                   }
               
               }
               
               /************************************************************/
               /****************** STOP EN EJECUCIÓN ***********************/
               /************************************************************/
                /**
                 * Validando Combustible = 0 
                 */
                if(panelScore.getFuel().getValue()<=0){
                    timerGame.stop();
                    player.setMover_Left(0);
                    player.setMover_Right(0);
                    System.out.println("SIN COMBUSTIBLE");
                    dejarDisparar = true;
                }
                /**
                 * Validando Vidas = 0
                 */
                if(panelScore.getIntLives()==0){
                    timerGame.stop();
                    player.setMover_Left(0);
                    player.setMover_Right(0);
                    panelScore.getTimer().stop();
                    System.out.println("SIN VIDAS");
                    dejarDisparar = true;
                }
               
           }
       
       });
        
        /* ---> Para trabajar
        Timer endGame = new Timer( 15*1000 , new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });*/
       
       timerGame.start();
       
       
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
                
                if((e.getKeyCode() == KeyEvent.VK_SPACE) && (dejarDisparar == false)){
                    shootList.add(new Shoot(player.getPlayer().getX()+(player.getPlayer().getWidth()/2)-2));
                    addShoot();                  
                }
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    timerGame.stop();
                }
            }
       });
       
    }

    /**
     * Utilizado para iniciar el Panel de Score en la Ventana
     * @return panelScore Panel del registro de score
     */
    public PanelScore getPanelScore() {
        return panelScore;
    }
    
    
}


