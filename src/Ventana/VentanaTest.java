/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Game.PanelScore;
import Game.RunGame;
import Graficos.Creditos;
import Sounds.EfectosSonido;
import Graficos.Instrucciones;
import Graficos.Menu;
import Graficos.Top10;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Brayan Montañez & Luis Vargas
 * @version 1.0
 */

public class VentanaTest extends JFrame{
    
    private Menu menu;
    private RunGame game;
    private PanelScore panelScore;
    private Instrucciones instrucciones;
    private Creditos creditos;
    private Top10 top10;
    private EfectosSonido sonido;
    
    public VentanaTest(){
        
        super.setBounds(0, 0, 800, 600);
        super.setTitle("Star Raid");
        super.setResizable(false);
        
        super.setIconImage(new ImageIcon("Resources/icon.png").getImage());
        super.setLocationRelativeTo(null);
        
        super.setFocusable(false);
        
        //MENU
        menu = new Menu();
        menu.setVisible(true);
        

        //GAME
        panelScore = new PanelScore();
        panelScore.setVisible(false);
        game = new RunGame(panelScore, menu); 
        game.setFocusable(true);
        
        //INSTRUCCIONES
        instrucciones = new Instrucciones();
        instrucciones.setVisible(false);
        
        //CREDITOS
        creditos = new Creditos();
        creditos.setVisible(false);
        
        //TOP10
        top10 = new Top10();
        top10.setVisible(false);
        
        //SONIDO
        sonido = new EfectosSonido();
        sonido.reproducirSonidoMenu();
        
        super.add(panelScore);
        super.add(game);
        super.add(instrucciones, 0);
        super.add(creditos, 0);
        super.add(top10,0);
        super.add(menu, 0);
        
        
        this.eventos();
        
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * Metodo que valida el ingreso correcto del nombre
     * @param nombre es el string ingresado por el usuario
     * @return numero este numero identifica la accion a ejecutar
     */
    public int validarNombre(String nombre){
        
        // 0 error
        // 1 continue al juego
        // 2 regrese al menu 
        try{

            if(nombre.length() > 8){
                JOptionPane.showMessageDialog(null, "Ingresó más de Ocho caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            } else if(nombre.replaceAll(" ", "").length()==0){
                JOptionPane.showMessageDialog(null, "Está en blanco ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);                      
                return 0;
            }
            else{
                return 1;
            }

         }
         catch(Exception e){
             return 2;
         }
        
    }
    
    
    public void eventos(){
        
        /**
         * Boton de menu para ir a Jugar
         */
        menu.getJugar().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                sonido.pararSonidoMenu();
          
                int continuar=0;
                String nombre;
                
                do{
                    
                     nombre = JOptionPane.showInputDialog(null, "Nombre del Jugador", "");
                     continuar = validarNombre(nombre);
                     
                }while(continuar == 0);
                
                
                if(continuar == 1){
                    
                    game.setNamePlayer(nombre);              
                    menu.setVisible(false); 
                    game.initComponents();                           
                    game.getPanelScore().initComponents();
                    game.getPanelScore().start();
                    game.getPanelScore().setVisible(true);
                    game.run();
                    
                }
                         
            }
            
        });
        
        
        /**
         * Boton de menu pero ir a top10.
         */
        menu.getTop10().addMouseListener(new MouseAdapter(){
        
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(false);
                top10.setVisible(true);
                top10.Update();
            }
            
        });
        
        /**
         * Boton de menu para ir a instrucciones
         */
        menu.getInstrucciones().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(false);
                instrucciones.setVisible(true);
                instrucciones.animation();
                         
            }
            
        });
        
        /**
         * Boton de menu para ir a creditos.
         */
        menu.getCreditos().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(false);
                creditos.setVisible(true);
                         
            }
        });
        
        /**
         * Boton de Instrucciones para volver al menu pricipal.
         */
        instrucciones.getVolverMenu().addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(true);
                instrucciones.setVisible(false);
                instrucciones.getAnimationArrows().stop();
                         
            }
            
        });
        
        /**
         * Boton de Creditos para volver al menu pricipal
         */
        creditos.getvolverMenu().addMouseListener(new MouseAdapter(){
             
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(true);
                creditos.setVisible(false);
                
            }
        
        });
        
        /**
         * Boton de Top10 para volver al menu principal.
         */
        
        top10.getvolverMenu().addMouseListener(new MouseAdapter(){
        
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                
                sonido.reproducirSonidoClick();
                menu.setVisible(true);
                top10.setVisible(false);
                
            }
            
        });
        
    }
    
    
    
    public static void main(String[] args) {
       
        VentanaTest test = new VentanaTest();
        
    }
    
}
