
package Enemigos;

import javax.swing.ImageIcon;

/**
 *  Esta clase hereda de Enemigos y crea a los barcos
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Barcos extends Enemigos{
  
    /**
     * El constructor recibe como parametro la ubicacion donde va a aparecer el barco de forma aleatoria
     * @param InitX valor x aleatorio
     * @param InitY valor y aleatorio
     * 
     * Al constructor del padre se le pasa los datos X,Y, un int el cual es la velocidad con la cual se mueve el enemigo
     * y el ImageIcon del mismo
     */
      public Barcos(int InitX, int InitY) {
        super(InitX, InitY,5, new ImageIcon("recursos/barco/barco2.png"));
    }

   /**
    * Se sobre carga el metodo desplazar de la clase padre e implementa el desplazamiento del enemigo por el mapa y proporcionando un
    * desplazamiento hacia abajo
    * @param despla velocidad con la cual el enemigo va ir bajando por el mapa
    */
      @Override
    public void desplazar(int despla) {
        super.getEnemigo().setLocation( super.getEnemigo().getX()+ super.getMovimiento(), super.getEnemigo().getY()+despla-2);
    }
    
}
