
package Enemigos;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase es la encargada de generar los dos tipos de enemigos y de usar un metodo abstracto para su desplazamiento
 * 
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public abstract class Enemigos {
    /** Valor inicial en la Coordenada Y*/
    private int Y;
    /** Valor inicial en la Coordenada X*/
    private int X;
    /** Valor inicial para el movimiento horizontal de cada enemigo*/
    private int movimiento;
    /** ImageIcon para cada enemigo segun cuando sea llamado */
    private ImageIcon imagen;
    /** Variable extra para setear el Icon*/
    private Icon icono;
    /** Donde se va a imprimir el ImagenIcon del enemigo */
    private JLabel Enemigo;
    /** Esto es para comprobar cuando el enemigo explote y la nave no choque contra el*/
    private boolean NoHacer;

    /**
     * Constructor de la Clase enemigos, se encarga de recibir y setear las coordenadas iniciales en X,Y asi como la 
     * velocidad del enemigo y su modelo ImageIcon
     * 
     * @param X Valor inicial en X
     * @param Y Valor inicial en Y
     * @param movimiento Velocidad con la cual se desplaza el enemigo
     * @param imagen ImageIcon del Enemigo seleccionado
     *
     */
    public Enemigos(int X, int Y, int movimiento, ImageIcon imagen) {
        this.X = X;
        this.Y = Y;
        this.movimiento = movimiento;
        this.imagen = imagen;
        Enemigo = new JLabel();
        Enemigo.setBounds(X,Y,100,100);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(Enemigo.getWidth(), Enemigo.getHeight(), Image.SCALE_SMOOTH));
        Enemigo.setIcon(icono);
        
        NoHacer = false;
    }
    /** Getter que retorna el movimiento del enemig
     * @return o*/
    public int getMovimiento() {
        return movimiento;
    }

    /** Getter que retorna la coordenada en
     * @return X*/
    public int getX() {
        return X;
    }
    
     /** Getter que retorna la coordenada en
     * @return Y*/
    public int getY() {
        return Y;
    }

     /** Getter que retorna el JLabel del enemig
     * @return o*/
    public JLabel getEnemigo() {
        return Enemigo;
    }
    /**
     * Setea la coordenada Y del Enemigo
     * @param Y Coordenada en Y
     */
    public void setY(int Y) {
        this.Y = Y;
    }
    /**
     * Setea la coordenada X del Enemigo
     * @param X Coordenada en Y
     */
    public void setX(int X) {
        this.X = X;
    }
    /**
     * Setea el movimiento del enemigo
     * @param movimiento se recibe el valor del movimiento del enemigo
     */
    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    /**
     * Setea el enemigo que se quiera usar
     * @param Enemigo Recibe el JLabel del enemigo deseado
     */
    public void setEnemigo(JLabel Enemigo) {
        this.Enemigo = Enemigo;
    }
    
    /**
     * Metodo abstracto que recibe la velocidad de desplazamiento hacia abajo para cada enemigo
     * @param SPEED Velocidad de desplazamiento hacia abajo
     */
    public abstract void desplazar(int SPEED);
    
    /**
     * Metodo que retorna si el enemigo esta realizando una animacion o no para evitar que choque con el jugador
     * @return retorna true o false
     */
    public boolean noHacer(){
        return NoHacer;
    }
    
    /**
     * Setear el la variable NoHacer
     * @param NoHacer recibe true o false
     */
    public void setNoHacer(boolean NoHacer) {
        this.NoHacer = NoHacer;
    }
    
    
}
