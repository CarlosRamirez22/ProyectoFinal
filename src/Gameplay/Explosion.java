
package Gameplay;

import Enemigos.Enemigos;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Clase donde se cargan los distintos tipos de explosiones que pueden haber en el juego
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Explosion {
        
    /** tiempo de ejecución de la animación*/
    private Timer timer;
    /** lleva el conteo*/
    private int cont; 
    /** Icon que se reproduce*/
    private ImageIcon icon;
    private Icon icon1;
    
    
    /**
     * Metodo para crear la animacion de la explosion del jugador
     * @param nave nave que manipula el jugador
     * @param timerG timer de juego
     */
    public void animacionExplosion(final Nave nave, Timer timerG){ 
        
        icon = new ImageIcon("recursos/Explosion.gif");
        animacion(nave, 0, timerG);
        
    }
    
    /**
     * Metodo para crear la explosion del enemigo
     * @param enemigo es el enemigo
     */
    public void animacionExplosion(final Enemigos enemigo){ 
        icon = new ImageIcon("recursos/explosionEnemigo.gif");
        animacion(enemigo);
    }
    
 
    /**
     * Animacion de explosion para el enemigo
     * @param en enemigo
     */
    private void animacion(final Enemigos en){
        
        cont = 0;
            timer = new Timer(0, new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(timer.getDelay()==0){
                       timer.setDelay(700);
                   }
                   
                   cont += timer.getDelay(); 
                   
                   en.getEnemigo().setIcon(icon);
                   icon.getImage().flush();
                   
                   if(cont == 1400){                    
                       en.getEnemigo().setVisible(false);
                       en.getEnemigo().setLocation(-600, 0);
                       timer.stop();
                   }

               }

           });
        timer.start();
    }

    
    /**
     * Animacion de explosion para el jugador (nave)
     * @param nave  es la nave del jugador
     * @param cambio  para reiniciar el timer e imagen
     * @param timerG  timer de juego
     */
    private void animacion(final Nave nave, int cambio, final Timer timerG){
        if(cambio == 1){
            timerG.start();
        }
        else{
            cont = 0;
            timer = new Timer(0, new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(timer.getDelay()==0){
                       timer.setDelay(1500);
                   }
                   
                   cont += timer.getDelay(); 
                   
                   nave.getNave().setIcon(icon);
                   icon.getImage().flush();
                   
                   if(cont == 3000){
                       timer.stop();
                       animacion(nave, 1, timerG);                    
                       
                   }

               }

           });
            timer.start();
        }
        
         
    }
}
