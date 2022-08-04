
package Gameplay;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * Clase encargada de crear los combustibles que apareceran por todo el mapa
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Gas {
    
    /**Coordenadas para Y */
    private int Y;
    /**Coordenadas para X*/
    private int X;
    /** ImageIcon donde se carga la imagen del combustible*/
    private ImageIcon image;
    private Icon icon;
    /** JLabel donde se cargara la ImageIcon del combustible */
    private JLabel gas;
    
    public Gas(int X, int Y) {
        this.Y = Y;
        this.X = X;
        
        gas = new JLabel();
        gas.setBounds(X, Y, 65, 65);
        image = new ImageIcon("recursos/gas/gas2.png");
        icon = new ImageIcon(image.getImage().getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_SMOOTH));
        gas.setIcon(image);
    }
    /**
     * Metodo que se usa para desplazar el combustible hacia abajo
     * @param despla velocidad de desplazamiento
     */
      public void desplazarse(int despla){
        
        gas.setLocation(gas.getX(), gas.getY()+despla-1);
        
    }
    /**Getter que devuelve los combustibles
     * @return  gas*/
    public JLabel getGas() {
        return gas;
    }
    
    
}
