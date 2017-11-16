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
    private int intScore;
    private JLabel score;
    private int intLives;
    private JLabel lives;
    private Timer timer;
    
    public PanelScore(){
        super.setLayout(null);
        super.setBounds(600, 0, 200, 600);
        
        fuel = new JProgressBar(0);
        fuel.setBounds(25, 50, 150, 30);  
        fuel.setValue(100);
        
        intScore = 0;
        score = new JLabel(String.valueOf(intScore));
        score.setBounds(98, 110, 100, 10);
        
        intLives = 3;
        lives = new JLabel(String.valueOf(intLives));
        lives.setBounds(99, 130, 10, 10);
        
        super.add(fuel);
        super.add(score);
        super.add(lives);
    }
    
    /**
     * Metodo para iniciar el decrecimiento de Combustible
     */
    public void start(){
                
        timer = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fuel.setValue(fuel.getValue()-2);
                
            }
            
        });
        timer.start();
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
     * Metodo que Retorna el Timer en Ejecucion del combustible
     * @return timer el Timer que produce movimiento de la JProgressBar
     */
    public Timer getTimer() {
        return timer;
    }

 
}
