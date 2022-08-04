
package Enemigos;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Esta clase hereda de Enemigos y genera helicopteros 
 * @author Carlos Alejandoro Ramirez Mora
 * C.I:28131450
 */
public class Helicoptero extends Enemigos{
    /** Timer que ejecuta la animacion de las helices del helicoptero */
    private Timer animacion;
    /** Un contador de las imagenes que van pasando */
    private int cuadro;
    /** Imagenes de la animacion */
    private String Imagenes[]={"heli_1.png","heli_2.png","heli_3.png","heli_4.png","heli_1.png","heli_2.png","heli_3.png","heli_4.png"};

    /**
     * El constructor recibe dos parametros de tipo int aleatorios para realizar el set de los enemigos
     * @param X valor en x Aleatorio
     * @param Y valor en Y aleatorio
     */
    
     /**
      * Al constructor del padre se le pasa los datos X,Y,un int el cual es la velocidad con la cual se mueve el enemigo y su 
      * ImageIcon correspondiente.
     * @param X Valor aleatorio en X
     * @param Y Valor Aleatorio en Y
     */
    public Helicoptero(int X, int Y){
       
        super(X, Y, 7, new ImageIcon("recursos/Heli/heli_1.png"));
        this.iniciarHeli();
        animacion.start();
    }
    /**
     * Este metodo es solo para generar la animacion de las helices del helicoptero
     */
    public void iniciarHeli(){
        
        cuadro=0;
        
        animacion = new Timer(100,new ActionListener(){
            
            public void actionPerformed(ActionEvent ae) {
                ImageIcon imag = new ImageIcon("recursos/Heli/"+Imagenes[cuadro++]);
                Icon icono = new ImageIcon(imag.getImage().getScaledInstance( Helicoptero.super.getEnemigo().getWidth() , Helicoptero.super.getEnemigo().getHeight() , Image.SCALE_SMOOTH));
                Helicoptero.super.getEnemigo().setIcon(icono);
                
                if(cuadro>7){
                    cuadro=0;
                }
            }
        });     
    }
    
    /**
    * Se sobre carga el metodo desplazar de la clase padre e implementa el desplazamiento del enemigo por el mapa
    * @param despla velocidad con la cual el enemigo va ir bajando por el mapa
    */
    @Override
    public void desplazar(int despla) {
        super.getEnemigo().setLocation( super.getEnemigo().getX()+ super.getMovimiento(), super.getEnemigo().getY()+despla-2);
    }
    
    
    
}
