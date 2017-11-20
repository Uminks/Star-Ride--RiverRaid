
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
    
    public EfectosSonido(){
        URL url = getClass().getResource("laser.WAV");
        clipShoot = Applet.newAudioClip(url);
        url = getClass().getResource("explosion.wav");
        clipExplosion = Applet.newAudioClip(url);
        url = getClass().getResource("menu.mid");
        clipMenu = Applet.newAudioClip(url);
        url = getClass().getResource("juego.mid");
        clipJuego = Applet.newAudioClip(url);
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

}
