
package Gameplay;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta Clase es la encargada de Cargar y crear el fondo del mundo 
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Mundo {
    /**JLabels que se usan para cargar la imagen del mundo */
    private JLabel mundo1;
    private JLabel mundo2;
    /** Velocidad con la cual se mueve el mundo */
    private int movimiento;
    /** Esta variable boolean se encarga de verificar cuando un mundo se acabe y cargar seguidamente el otro*/
    private boolean cambiarMundo;

    public Mundo() {
        mundo1 = new JLabel(new ImageIcon("recursos/mundo/mundo.png"));
        mundo2 = new JLabel(new ImageIcon("recursos/mundo/mundo.png"));
        inicializar();
    }
    /**Este metodo inicializa los componentes en sus valores por defecto */
    public void inicializar(){
        mundo1.setBounds(0, -1800, 600, 2400);      
        mundo2.setBounds(0, -2400, 600, 2400);
        cambiarMundo = true;   
        movimiento = 2;  
    }
    
    /**Este metodo se encarga de mover el mundo de forma indefinida hasta que se acabe el juego */
    public void moverMundo(){
        
        if(cambiarMundo == true){
            mundo1.setLocation(mundo1.getX(), mundo1.getY()+movimiento);
        }
        else if(cambiarMundo == false){
            mundo2.setLocation(mundo2.getX(), mundo2.getY()+movimiento);
        }
        
        
        if(mundo1.getY() >= 0  && mundo1.getY() < 600){
            mundo2.setLocation(mundo2.getX(), mundo2.getY()+movimiento);
        }
        
       //se realiza el cambio de mundo 1 a mundo 2
        if(mundo1.getY() >= 600){
            //Cambio de mundo
            cambiarMundo = false;
            //se reinicia el mundo1
            mundo1.setLocation(mundo1.getX(), -2400);
        }
        
        //Movimiento del mundo 2
        if(mundo2.getY() >= 0  && mundo2.getY() < 600){
            mundo1.setLocation(mundo1.getX(), mundo1.getY()+movimiento);
        }
        
        //Fin de Movimiento y cambio de movimiento
        if(mundo2.getY() >= 600){
            //Cambio de mundo
            cambiarMundo = true;
            //reinicio el world_2
            mundo2.setLocation(mundo2.getX(), -2400);
        }
        
    }
    /**
     * 
     * @return retorna el mundo 1 que es el primero en verse 
     */
    public JLabel getMundo1() {
        return mundo1;
    }

    /**
     * 
     * @return retorna el mundo 2 que se carga para seguir en el juego
     */
    public JLabel getMundo2() {
        return mundo2;
    }

    /**Set de la velocidad del mun
     * @param movimiento movimiento*/
    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    
    
    
}
