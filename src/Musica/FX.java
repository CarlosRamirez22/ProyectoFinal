
package Musica;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
/**
 * Esta clase FX es la encargada de carga los efectos de sonido cortos del juego
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class FX {
    
    
    private AudioClip Menu;
    private AudioClip Disparo;
    private AudioClip Explosion;
    private AudioClip Juego;
    private AudioClip Click;
    private AudioClip SoundAcelerar;
    private AudioClip SoundGas;
    private AudioClip Puntos;
    private AudioClip Lose;
    private AudioClip Life;
    private URL url2;

    public FX() {
        URL url = getClass().getResource("Disparo.wav");
        Disparo = Applet.newAudioClip(url);
        url = getClass().getResource("Explosion.wav");
        Explosion = Applet.newAudioClip(url);
        url = getClass().getResource("Click.wav");
        Click = Applet.newAudioClip(url);
    }
    
    public void SonidoMenu(){
        URL url = getClass().getResource("Menu.wav");
        Menu = Applet.newAudioClip(url);  
        Menu.loop();
    }
    
    public void DetenerSonidoMenu(){
        URL url = getClass().getResource("Menu.wav");
        Menu = Applet.newAudioClip(url); 
        Menu.stop();
    }
    
    public void SonidoJuego(){
        URL url = getClass().getResource("Juego.wav");
        Juego = Applet.newAudioClip(url);  
        Juego.loop();
    }
    
    public void SonidoMenosLife(){
        URL url = getClass().getResource("life.wav");
        Life = Applet.newAudioClip(url);
        Life.play();
        
    }
    
    public void DetenerSonidoJuego(){
        URL url = getClass().getResource("Juego.wav");
        Juego = Applet.newAudioClip(url);
        Juego.play();
        Juego.stop();
    }
    
    public void SonidoDisparo(){                 
        Disparo.play();    
    }
    
    public void SonidoExplosion(){     
        Explosion.play();
    }
    
    public void SonidoClick(){
        Click.play();
    }
    
    public void pararSonidoClick(){
        Click.stop();
    }
    
    public void SonidoGas(){
        URL url = getClass().getResource("RecargaGas.wav");
        SoundGas = Applet.newAudioClip(url);
        SoundGas.play();
    }
    
    public void DetenerSonidoGas(){
        URL url = getClass().getResource("RecargaGas.wav");
        SoundGas = Applet.newAudioClip(url);
        SoundGas.stop();
    }
     
    public void SonidoAcelerar(){
        URL url = getClass().getResource("acelerar.wav");
        SoundAcelerar = Applet.newAudioClip(url);
        SoundAcelerar.play();
    }
    
    public void SonidoPuntos(){
        URL url = getClass().getResource("Point.wav");
        Puntos = Applet.newAudioClip(url);
        Puntos.play();
    }
    
    public void SonidoLosePuntos(){
        URL url = getClass().getResource("Lose.wav");
        Lose = Applet.newAudioClip(url);
        Lose.play();
    }
}
