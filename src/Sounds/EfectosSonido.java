
package Sounds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Aqui se encuentran encapsulados todos los efectos de sonido
 * @author Brayan Montañez
 */
public class EfectosSonido {
    
    private AudioClip clipMenu;
    private AudioClip clipShoot;
    private AudioClip clipExplosion;
    private AudioClip clipJuego;
    private AudioClip clipClick;
    private AudioClip clipAcelerar;
    private AudioClip clipEnergy;
    private AudioClip clipJuego2;
    
    public EfectosSonido(){
        URL url = getClass().getResource("laser.WAV");
        clipShoot = Applet.newAudioClip(url);
        url = getClass().getResource("explosion.wav");
        clipExplosion = Applet.newAudioClip(url);
        url = getClass().getResource("menu.mid");
        clipMenu = Applet.newAudioClip(url);
        url = getClass().getResource("juego.mid");
        clipJuego = Applet.newAudioClip(url);
        url = getClass().getResource("Beep.WAV");
        clipClick = Applet.newAudioClip(url);
        url = getClass().getResource("Acelerar.wav");
        clipAcelerar = Applet.newAudioClip(url);
        url = getClass().getResource("EnergyTake.wav");
        clipEnergy = Applet.newAudioClip(url);
        url = getClass().getResource("juego2.wav");
        clipJuego2 = Applet.newAudioClip(url);
    }
    
    public void reproducirSonidoMenu(){  
        clipMenu.loop();
    }
    
    public void pararSonidoMenu(){
        clipMenu.stop();
    }
    
    public void reproducirSonidoJuego(){
        clipJuego.loop();
    }
    
    public void pararSonidoJuego(){
        clipJuego.stop();
    }
    
    public void reproducirSonidoShoot(){                 
            clipShoot.play();    
    }
    
    public void reproducirSonidoExplosion(){     
            clipExplosion.play();
    }
    
    public void reproducirSonidoClick(){
        clipClick.play();
    }
    
    public void pararSonidoClick(){
        clipClick.stop();
    }
    
    public void reproducirSonidoAcelerar(){
        clipAcelerar.play();
    }
    
    public void pararSonidoAcelerar(){
        clipAcelerar.stop();
    }
    
    public void reproducirSonidoTomarEnergia(){
        clipEnergy.play();
    }
    
    public void pararSonidoTomarEnergia(){
        clipEnergy.stop();
    }
    
    public void reproducirSonidoJuego2(){
        clipJuego2.loop();
    }
    
    public void pararSonidoJuego2(){
        clipJuego2.stop();
    }

}
