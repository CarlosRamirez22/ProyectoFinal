
package Gameplay;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * Clase encargada de generar los disparos
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */

public class Disparo {
    
    /** Ancho y alto del misil a disparar*/
    private int ancho=15,alto=15;
    /** Label donde se va a guardar la imagen del misil */
    private JLabel disparo;
    /** El timer que impulsa al misil hacia adelante */ 
    private Timer disparoTime;

    public Disparo(int e) {
        
        disparo =new JLabel();
        disparo.setBounds(e,400,ancho,alto);
        ImageIcon mi = new ImageIcon("recursos/disparo/misil.png");
        Icon image = new ImageIcon(mi.getImage().getScaledInstance(disparo.getWidth(), disparo.getHeight(), Image.SCALE_SMOOTH));
        disparo.setIcon(image);
        this.Disparar();
    }
    
    
    /**
     * Metodo que se encarga de generar los misiles y disparalos
     */
    public void Disparar(){
       disparoTime = new Timer(5, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                   disparo.setLocation(disparo.getX(), disparo.getY()-1);
                   detenerDisparo();
            }
        });  
        disparoTime.start();         
    } 
    
    /**
     * Este metodo hace la verificacion cuando el misil tiende a volverse nulo y asi borrarlo de la ejecucion
     */
        public void detenerDisparo(){       
        if((disparo.getY()+disparo.getHeight()+alto) < 0){
            disparoTime.stop();
            disparo.setLocation(0, 2000);
            disparo.setEnabled(false);
            disparo.setVisible(false);
        }
    }

    public Timer getDisparoTime() {
        return disparoTime;
    }

    public JLabel getDisparo() {
        return disparo;
    }
    
        
}
