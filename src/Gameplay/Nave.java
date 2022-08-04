
package Gameplay;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Esta clase es la encargada de manejar la nave que manipula el jugador
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Nave {
    /** Variables de velocidad de movimiento inicial sobre la nave */
    private int move_izquierda = 10;
    private int move_derecha = 10;
    /**JLabel usado para cargar la nave */
    private JLabel nave;
    
    
    public Nave() {
        
        nave = new JLabel();
        nave.setBounds(245, 420, 80, 100);  
        inicializar();
    }
    /**
     * Metodo que se encarga de inicializar la nave y setear su imagen
     */
    public void inicializar(){
        nave.setBounds(245, 420, 80, 100);  
        ImageIcon ima = new ImageIcon("recursos/nave/nave.png");
        Icon imag = new ImageIcon(ima.getImage().getScaledInstance(nave.getWidth(), nave.getHeight(), Image.SCALE_SMOOTH));
        nave.setIcon(imag); 
       
    }
    
    /**
     * Eventos por teclado que puede realizar la nave
     * @param sea hace referencia al mundo
     */
    public void teclado(final JPanel sea){
    
        sea.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {}

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                    nave.setLocation(nave.getX()-move_izquierda, nave.getY());
                }
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                    nave.setLocation(nave.getX()+move_derecha, nave.getY());
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {}
        });
    }
    /**
     * 
     * @return retorna la nave
     */
    public JLabel getNave() {
        return nave;
    }

    /**
     * 
     * @param move_izquierda se recibe la velocidad hacia la izquierda de la nave 
     */
    public void setMove_izquierda(int move_izquierda) {
        this.move_izquierda = move_izquierda;
    }

    /**
     * 
     * @param move_derecha se recibe la velocidad hacia la derecha de la nave 
     */
    public void setMove_derecha(int move_derecha) {
        this.move_derecha = move_derecha;
    }
    
    
    
}
