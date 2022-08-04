
package Musica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 * Esta clase es la encargada de poner la musica del juego
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Musica {
    
    private AudioStream au1,au2;
    
    public Musica() throws FileNotFoundException, IOException{
        InputStream in = new FileInputStream("src/Musica/Menu.wav");
        au1 = new AudioStream(in);
        InputStream in2 = new FileInputStream("src/Musica/Juego.wav");
        au2 = new AudioStream(in2);
    }
    
    public void SonidoMenu() throws FileNotFoundException, IOException{
        AudioPlayer.player.start(au1);
    }
    
    public void DetenerSonidoMenu()throws FileNotFoundException, IOException{
        AudioPlayer.player.stop(au1);
    }
    
    public void SonidoJuego() throws FileNotFoundException, IOException{
        AudioPlayer.player.start(au2); 
    }
    
    public void DetenerSonidoJuego()throws FileNotFoundException, IOException{
        AudioPlayer.player.stop(au2);
    }
}
