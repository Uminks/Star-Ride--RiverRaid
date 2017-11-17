/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Graficos.Menu;
import Ventana.VentanaTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
    private int Score, timeOFgame;
    private boolean dejarDisparar,playerColisiona, TERMINA_JUEGO;
    private static int execute = 0;
       
    private PanelScore panelScore;
    private Menu refMenu; 
    private String namePlayer;
    private SaveScore guardarTOP;
    
    public RunGame(PanelScore panelScore, Menu menu){
        
        this.panelScore = panelScore;
        this.refMenu = menu;
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
        timeOFgame = 60; 
        dejarDisparar = false;
        TERMINA_JUEGO = false;
        playerColisiona=false;
        
        
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
        this.add(colisiones.getCollisionsCenter());
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
        
        /**
         * Inicio cuenta Regresiva del Tiempo de Juego
         */
        panelScore.timeGame(timeOFgame);
        
        /**
         * Inicio dinámica de Juego
         */
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
               if(detectorColisiones.BorderCollisionsRight(player, colisiones) == true
                       || detectorColisiones.BorderCollisionsLeft(player, colisiones) == true
                       || detectorColisiones.collisionsCenter(player, colisiones)==true){

                   playerColisiona = true;
                   
               }
               
               
               /**
                * Validar colisiones de todos los enemigos.
                */
               for( Enemy enemigos : enemyList){
                    if(enemigos.getEnemy().isVisible()){  
                            //Player => Enemigos
                            if(detectorColisiones.collisionPlayerEnemy(player, enemigos)==true){
                                playerColisiona = true;
                            }

                            //Enemigo => Obstaculos
                            detectorColisiones.BorderCollisionsEnemyRight(enemigos, colisiones, 55);
                            detectorColisiones.BorderCollisionsEnemyLeft(enemigos, colisiones, 55);
                            detectorColisiones.collisionsCenterEnemy(enemigos, colisiones);

                            /**
                             * Colisiones de balas con otros componentes
                             */
                            for(Shoot balas: shootList){

                                    /**
                                     * Enemigo => Balas
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
                                     * Bala => fuels
                                     */                             
                                    for(Fuel fuel: fuelList){

                                         if(fuel.getFuel().getY()+fuel.getFuel().getHeight() > balas.getShoot().getY()
                                            && fuel.getFuel().getY() < balas.getShoot().getY()
                                            && fuel.getFuel().getX() < balas.getShoot().getX()
                                            && fuel.getFuel().getX() + fuel.getFuel().getWidth() > balas.getShoot().getX()){

                                                /**
                                                 * Si elimina un combustible -20
                                                 */
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
               
               /**
                * Colisiones player y enemigos
                */
               
               
               /************************************************************/
               /****************** STOPS EN EJECUCIÓN ***********************/
               /************************************************************/
                /**
                 * Validando Combustible = 0 
                 */
                if(panelScore.getFuel().getValue()<=0){
                    //Resto vidas Al Player
                   panelScore.setIntLives(panelScore.getIntLives()-1);
                    System.out.println(namePlayer+" => SIN COMBUSTIBLE");
                    panelScore.getFuel().setValue(100);
                }
                if(playerColisiona == true){
                    player.initComponentsPlayer();
                    //Resto vidas Al Player
                    panelScore.setIntLives(panelScore.getIntLives()-1);
                    panelScore.getFuel().setValue(100);
                    //Reinio mapa
                    colisiones.initComponentsCollisions();
                    //Elimino enemigos visibles en el mapa
                    for(Enemy enemigo : enemyList){
                        enemigo.getEnemy().setVisible(false);
                        enemigo.getEnemy().setLocation(-600, 0);
                    }
                    playerColisiona = false;
                }
                /**
                 * Validando Vidas = 0
                 */
                if(panelScore.getIntLives()==0){
                    TERMINA_JUEGO = true;
                    System.out.println(namePlayer+" =>SIN VIDAS");
                }
                /**
                 * Validando el tiempo de Juego = 0;
                 */
                if(panelScore.getIntTiempo()==0){
                    TERMINA_JUEGO = true;                
                    System.out.println(namePlayer+" =>SIN TIEMPO");                   
                }
                
                
                if(TERMINA_JUEGO == true){
                    gameOver();
                }
           }
           
       });
       timerGame.start();
       
       /**
        * ESCUCHADORA ENCARGADA DE GENERAR DISPAROS
        */
      
       if( execute == 0 ){
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
                /**
                 * PAUSE
                 */
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                   detenerProcesos();
                }
                else if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    reiniciarProcesos();
                }
            }
       });
       }
       
    }


    /**
     * Metodo que remueve todos los componentes usados anteriormente y ejecuta GAME OVER
     */
    public void gameOver(){
        
        timerGame.stop();
        player.setMover_Left(0);
        player.setMover_Right(0);
        panelScore.getTimerTiempo().stop();
        panelScore.getTimerFuel().stop();
        addRandomEnemy.stop();
        addRandomFuel.stop();
        dejarDisparar = true;
        
        /**
         * Guardar en el archivo
         */
        guardarTOP = new SaveScore(namePlayer, Score);
        
        execute++;      
        RunGame.super.removeAll();
        RunGame.super.setFocusable(false);
        
        removeAll();
        panelScore.removeAll();
        refMenu.setVisible(true);
    }
    
    /**
     * Metodo para parar los procesos en ejecucion
     */
    public void detenerProcesos(){
        timerGame.stop();
        colisiones.setSPEED(0);
        player.setMover_Left(0);
        player.setMover_Right(0);
        panelScore.getTimerTiempo().stop();
        panelScore.getTimerFuel().stop();       
        dejarDisparar = true;
        addRandomEnemy.stop();
        addRandomFuel.stop();
        for(Shoot balas: shootList){
            balas.getTimerDisparo().stop();
        }
    }
    
    /**
     * Reiniciar Procesos
     */
    public void reiniciarProcesos(){
        timerGame.start();
        colisiones.setSPEED(5);
        player.setMover_Left(10);
        player.setMover_Right(10);
        panelScore.getTimerTiempo().start();
        panelScore.getTimerFuel().start();
        dejarDisparar = false;
        addRandomEnemy.start();
        addRandomFuel.start();
        for(Shoot balas: shootList){
            balas.getTimerDisparo().start();
        }
    }
    
    
    /**
     * Utilizado para iniciar el Panel de Score en la Ventana
     * @return panelScore Panel del registro de score
     */
    public PanelScore getPanelScore() {
        return panelScore;
    }

    /**
     * Retorna referencia del Timer
     * @return 
     */
    public Timer getTimerGame() {
        return timerGame;
    }

    /**
     * Modifica el nombre Ingresodo por el usuario
     * @param namePlayer nombre a asignar
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }
  
}


