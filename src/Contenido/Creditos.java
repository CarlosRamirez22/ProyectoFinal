
package Contenido;

import Musica.FX;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 * Esta clase es la encargada de mostrar los creditos
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */

public class Creditos extends JPanel{
 
 /** Se crean atributos de tipo privado*/
  /** Un JLabel que es la flecha para volver al menu   */
 private JLabel volver;
 /**  Un objeto de la clase sonido para agregar sonido a la flecha de regresar  */
 private FX sonido;
 

 /**  La creacion de una Image con la ruta ya descrita  */
 private Image fondo = new ImageIcon(getClass().getClassLoader().getResource("Creditos.png")).getImage();
 
 
 /**
  * Se inicializan los componentes y se carga el metodo volver
  */
    public Creditos() {
        sonido=new FX();
        super.setLayout(null);
        super.setBounds(0, 0, 800, 580);
        this.volver();
        super.add(volver);
        
    }
    /**
     * Este metodo carga la imagen para regresar y sus eventos con el mouse 
     */
    public void volver(){
        volver= new JLabel();
        volver.setBounds(650, 400, 100, 100);
        volver.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("flecha.png")), volver));
        
        volver.addMouseListener(new MouseAdapter(){
            
            @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == volver){
                sonido.SonidoClick();
                volver.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("flecha.png")), volver));
            }
        }
            
        });
        
    }
    
    /**
     * Se encarga de redimensionar la imagen y establecerla al JPanel
     * 
     * @param Button Recibe el image icon del boton 
     * @param Container Recibe las dimensiones 
     * @return 
     */
    private Icon Dimensionar(ImageIcon Boton, JLabel Container) {    
        return new ImageIcon(Boton.getImage().getScaledInstance(Container.getWidth(),Container.getHeight(),Image.SCALE_SMOOTH));
    }
    
    public JLabel getvolverMenu(){
        return volver;
    }
     /**
     * 
     * Sobrecarga el metodo paintComponent para poner la imagen en el fondo
     */
    @Override
    public void paintComponent(Graphics g){
        
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(),this);
        
    }
  
}
