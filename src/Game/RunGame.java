/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private ArrayList<Enemy> list;
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
     * Este metodo agrega enemigos de Tipo JLabel al panel para ser mostrados.
     */
    public void addEnemy(){
        
        for( Enemy enemigos: list){
            this.add(enemigos.getEnemy(),0);
        }
        
    }
    
    
    /**
     * Este metodo inicializa todos los componentes básicos del RunGame.
     */
    public void initComponents(){
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        mundo = new World();
        player = new Player();
        list = new ArrayList<Enemy>();
        colisiones = new CollisionsWorld();
        detectorColisiones = new DetectorDeColisiones();
        
        addRandomEnemy = new Timer( RandomTime()*1000 , new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(new TIE(200,0,5));
                addEnemy();
            }
            
        });
        

    } 
    
    
    
    
    
    /**
     * Este metodo retorna un numero aleatorio que representa el tiempo de espera en segundos.
     * @return retorna un tiempo en segundos aleatoriamente de tipo Integer. 
     */
    public int RandomTime(){
        
        int max = 8; int min = 2;
        
        return min + (int)(Math.random() * ((max - min) + 1));
        
    }
    
    
    public void run(){
        
        Timer timer = new Timer(18, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               
               mundo.moveWorld();
               colisiones.moverColisiones();
               
               /**
                * Desplazar todos los enemigos.
                */
               for( Enemy enemigos : list){
                   enemigos.desplazarse();
               }
               
               detectorColisiones.BorderCollisionsRight(player, colisiones, mundo); 
               detectorColisiones.BorderCollisionsLeft(player, colisiones, mundo);  
               
               /**
                * Validar colisiones de todos los enemigos.
                */
               for( Enemy enemigos : list){
                    detectorColisiones.BorderCollisionsEnemyRight(enemigos, colisiones, 55);
                    detectorColisiones.BorderCollisionsEnemyLeft(enemigos, colisiones, 55);
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
    }
}


