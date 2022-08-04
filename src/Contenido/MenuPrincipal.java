
package Contenido;
import Musica.FX;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * Esta clase carga todo el menu principal del juego incluyendo sus botones y metodos
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */


public class MenuPrincipal extends JPanel{


private JLabel jugar, instrucciones, creditos, salir;



private final Image background = new ImageIcon(getClass().getClassLoader().getResource("Fondo23.png")).getImage();
private ImageIcon image1;
private FX sonido = new FX();

   
    /**
     * Se realiza la carga y inicializacion del menu principal
     */
    public MenuPrincipal(){
        
        
        
        this.setLayout(null);
        this.jugar = new JLabel();
        this.jugar.setBounds(450, 150, 300, 50);
        this.jugar.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("jugar_button2.png")),jugar));
        this.jugar.setFocusable(false);
        
        
        this.instrucciones = new JLabel();
        this.instrucciones.setBounds(450, 240, 300, 50);
        this.instrucciones.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("instru_butto.png")),jugar));
        this.instrucciones.setFocusable(false);
        
        
        this.creditos = new JLabel();
        this.creditos.setBounds(450, 330, 300, 50);
        this.creditos.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("credi_button2.png")),creditos));
        this.creditos.setFocusable(false);
        
        this.salir = new JLabel();
        this.salir.setBounds(450, 410, 300, 50);
        this.salir.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("salir_button2.png")),salir));
        this.salir.setFocusable(false);
        
        this.add(jugar);
        this.add(instrucciones);
        this.add(creditos);
        this.add(salir);
        
        /**
         * Aca se realiza los eventos del mouse para cada uno de los JLabels
         */
        jugar.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e){
                
                jugar.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("jugar_button.png")), jugar));
            }
            
            public void mouseExited(MouseEvent e){
                
                jugar.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("jugar_button2.png")), jugar));
            }
            
        });
        
        instrucciones.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e){
                
                instrucciones.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("instru_button.png")), instrucciones));
            }
            
            public void mouseExited(MouseEvent e){
                
                instrucciones.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("instru_butto.png")), instrucciones));
            }
            
        });
        
        creditos.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e){
                
                creditos.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("credi_button.png")), creditos));
            }
            
            public void mouseExited(MouseEvent e){
                
                
                creditos.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("credi_button2.png")), creditos));
            }
            
        });
        
         salir.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e){
                
                salir.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("salir_button.png")), salir));
            }
            
            public void mouseExited(MouseEvent e){
                
                salir.setIcon(Dimensionar(new ImageIcon(getClass().getClassLoader().getResource("salir_button2.png")), salir));
            }
            
            public void mouseClicked(MouseEvent e){
                
                System.exit(0);
            }
            
        });
        
    }
    
    /**
     * Se pinta el fondo del menu en el JPanel
     * @param g variable de la clase Graphics para pintar el fondo
     */
    
    public void paintComponent(Graphics g){
      
        g.drawImage(background, 0, 0, getWidth(), getHeight(),this);
    }
    
    /**
     * Se realiza este metodo para poder redimensionar las imagenes para cada uno de los botones del menu principal
     * @param Boton Recibe la imagen 
     * @param Container obtienes las dimensiones 
     * @return la imagen ya redimensionada
     */
    
    public Icon Dimensionar(ImageIcon Boton, JLabel Container){
        
       return new ImageIcon(Boton.getImage().getScaledInstance(Container.getWidth(),Container.getHeight(),Image.SCALE_SMOOTH));
       
    }

    
     public JLabel getJugar() {
        return jugar;
    }

    public JLabel getInstrucciones() {
        return instrucciones;
    }
    
    public JLabel getCreditos(){
        return creditos;
    }
    
    
    
}

