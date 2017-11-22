/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * Clase encargada de registrar el combustible, score y otro registros.
 * @author Brayan Montañez & Luis Vargas
 */
public class PanelScore extends JPanel{
    /** Fuente usada en esta sección*/
    private Font StarJedi;
    /** Campo donde está contenida la palabra combustible*/
    private JLabel iconFuel;
    /** Barra que refleja el consumo de combustible*/
    private JProgressBar fuel;
    private int intTiempo, intScore, intLives;
    private JLabel iconTiempo, iconScore, iconLives;
    private JLabel tiempo, score, lives;
    /** Manejadores del consumo de combustible  y tiempo de juego*/
    private Timer timerFuel, timerTiempo;
    /** Imagen de fondo de este panel*/
    private Image background = new ImageIcon("Resources/ScoreBorder.gif").getImage();;
    
    public PanelScore(){
        super.setLayout(null);
        super.setBackground(Color.black);
        super.setBounds(600, 0, 200, 600); 
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        if( isVisible() ){
           g.drawImage(background, 0, 0, getWidth(), getHeight(),this); 
        }
    
    }
    
    /**
     * Inicia los componentes del panel del Score
     */
    public void initComponents(){
        int extra = 30;
        //FUENTE
        StarJedi = this.cargarFuente("../Starjedi.ttf");
        
        /**
         * TODO TIEMPO
         */
        iconTiempo = new JLabel("tiempo");               
        iconTiempo.setBounds(40, 10+extra, 200, 50);
        iconTiempo.setForeground(Color.yellow);
        iconTiempo.setFont(StarJedi);
        
        intTiempo = 0;
        tiempo = new JLabel(String.valueOf(intTiempo));
        tiempo.setBounds(82, 80+extra, 100, 30);
        tiempo.setForeground(Color.yellow);
        tiempo.setFont(StarJedi.deriveFont(1, 22f));
        
        /**
         * TODO SCORE
         */
        iconScore = new JLabel("score");               
        iconScore.setBounds(45, 130+extra, 200, 50);
        iconScore.setForeground(Color.yellow);
        iconScore.setFont(StarJedi);
        
        intScore = 0;
        score = new JLabel(String.valueOf(intScore));
        score.setForeground(Color.yellow);
        score.setFont(StarJedi.deriveFont(1, 22f));
        score.setBounds(90, 200+extra, 100, 30);
        
        /**
         * TODO COMBUSTIBLE
         */
        iconFuel = new JLabel();               
        iconFuel.setBounds(10, 250+extra, 200, 50);
        iconFuel.setForeground(Color.yellow);
        iconFuel.setFont(StarJedi.deriveFont(1, 22f));
        iconFuel.setText("Combustible");
        
        fuel = new JProgressBar(0);
        fuel.setBounds(25, 325+extra, 150, 30);  
        fuel.setValue(100);
        fuel.setBackground(Color.BLACK);
        
        /**
         * TODO VIDAS
         */
        iconLives = new JLabel();               
        iconLives.setBounds(43, 380+extra, 200, 50);
        iconLives.setForeground(Color.yellow);
        iconLives.setFont(StarJedi);
        iconLives.setText("vidas");
        
        intLives = 3;
        lives = new JLabel(String.valueOf(intLives));
        lives.setForeground(Color.yellow);
        lives.setFont(StarJedi.deriveFont(1, 22f));
        lives.setBounds(90, 450+extra, 100, 30);
        
        super.add(iconTiempo, 0);
        super.add(tiempo, 0);
        super.add(iconScore, 0);
        super.add(score, 0);
        super.add(iconFuel, 0);
        super.add(fuel, 0);
        super.add(iconLives, 0);
        super.add(lives, 0);
    }
    
    /**
     * Metodo para iniciar el decrecimiento de Combustible
     */
    public void start(){
                
        timerFuel = new Timer(800, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fuel.setValue(fuel.getValue()-2);
                
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
    
     /**
     * Metodo para Cargar fuentes personalizadas
     * @param ruta Ruta del Archivo
     * @return retorna una fuente personalizada
     */
    public Font cargarFuente(String ruta){
        Font fuente=null; 
        InputStream entrada = getClass().getResourceAsStream(ruta);
        
        try {                 
            fuente = Font.createFont(Font.TRUETYPE_FONT, entrada);
            fuente = fuente.deriveFont(1,28f);

        } catch (FontFormatException ex) {
            fuente = new Font("Arial", Font.PLAIN, 19);  
            System.out.println("Error de Formato");
        } catch (IOException ex) {
            fuente = new Font("Arial", Font.PLAIN, 19);
            System.out.println(entrada);
            System.out.println("Error de Entrada y Salida de Datos");
        }
     
        return fuente;  
    }
}
