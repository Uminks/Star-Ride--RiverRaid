/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * Clase encargada de registrar el combustible, score y otro registros
 * 
 */
public class PanelScore extends JPanel{
    
    private JProgressBar fuel;
    private int intTiempo, intScore, intLives;
    private JLabel tiempo, score, lives;
    private Timer timerFuel, timerTiempo;
    
    public PanelScore(){
        super.setLayout(null);
        super.setBounds(600, 0, 200, 600);       
    }
    
    /**
     * Inicia los componentes del panel del Score
     */
    public void initComponents(){
        fuel = new JProgressBar(0);
        fuel.setBounds(25, 50, 150, 30);  
        fuel.setValue(100);
        
        intTiempo = 0;
        tiempo = new JLabel(String.valueOf(intTiempo));
        tiempo.setBounds(95, 5, 100, 30);
        
        intScore = 0;
        score = new JLabel(String.valueOf(intScore));
        score.setBounds(98, 110, 100, 10);
        
        intLives = 3;
        lives = new JLabel(String.valueOf(intLives));
        lives.setBounds(99, 130, 10, 10);
        
        super.add(fuel);
        super.add(tiempo);
        super.add(score);
        super.add(lives);
    }
    
    /**
     * Metodo para iniciar el decrecimiento de Combustible
     */
    public void start(){
                
        timerFuel = new Timer(800, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fuel.setValue(fuel.getValue()-1);
                
            }
            
        });
        timerFuel.start();
    }
    
    /**
     * Metodo para el conteo regresivo del tiempo
     */
    public void timeGame(int segundos){
        
        intTiempo = segundos;
        tiempo.setText(String.valueOf(intTiempo));
        
        timerTiempo = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                intTiempo -= 1;
                tiempo.setText(String.valueOf(intTiempo));
                
            }
            
        });
        timerTiempo.start();
        
        
    }

    /**
     * Retorna la Barra de Progresa para su posterior modificación
     * @return fuel Referencia de la ProgressBar
     */
    public JProgressBar getFuel() {
        return fuel;
    }

    /**
     * Registra el score del jugador
     * @param intScore modificador de score
     */
    public void setIntScore(int intScore) {
        this.intScore = intScore;
        score.setText(String.valueOf(this.intScore));
    }

    /**
     * Registra las vidas del jugador
     * @param intlives modificador de Vidas
     */
    public void setIntLives(int intLives) {
        this.intLives = intLives;
        lives.setText(String.valueOf(intLives));
    }

    /**
     * Pra administrar las vidas del Player
     * @return intLives Numero de vidas actuales
     */
    public int getIntLives() {
        return intLives;
    }
    
    /**
     * Pra administrar el tiempo del juego
     * @return intTiempo Numero de vidas actuales
     */
    public int getIntTiempo() {
        return intTiempo;
    }
    
    /**
     * Metodo que Retorna el Timer en Ejecucion del combustible
     * @return timerFuel el Timer que produce movimiento de la JProgressBar
     */
    public Timer getTimerFuel() {
        return timerFuel;
    }

    /**
     * Metodo que Retorna el Timer en Ejecucion del Tiempo de Juego
     * @return timerTiempo el Timer que produce el decrecimiento del tiempo
     */
    public Timer getTimerTiempo() {
        return timerTiempo;
    }
}
