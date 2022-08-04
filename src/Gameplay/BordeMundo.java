
package Gameplay;

import Musica.FX;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 *  Esta clase es la encargada de cargar y crear las colisiones del mapa ademas de generar ciertos estrechos en el mundo
 * 
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class BordeMundo {
    /** Se cargan las colisiones del lado derecho */
    private JLabel []grupoColisionDerecha; 
    /** Se cargan las colisiones del lado izquierdo */
    private JLabel []grupoColisionIzquierda; 
    
    /** Objeto de la clase FX que se encarga de reproducir los sonidos del juego */
    private FX sound;
    /** Velocidad en la que baja el mundo */
    public int move = 4;
    /** Usada para cambiar entre ambos mundos de obstaculos*/
    private boolean changeCollisions;
    /** Es para bajar mas rapido el mapa dando la sensacion de acelerar la nave */
    private int Acelerar;

    public BordeMundo() {
        Acelerar = 0;
        sound = new FX();
        grupoColisionDerecha = new JLabel[4];
        grupoColisionIzquierda = new JLabel[4];
        for (int i = 0; i < grupoColisionIzquierda.length; i++) {
                    
             grupoColisionIzquierda[i] = new JLabel(new ImageIcon("recursos/mundo/borde.png"));            
             grupoColisionDerecha[i] = new JLabel(new ImageIcon("recursos/mundo/borde.png"));
             
         }
        inicializarColisiones();
    }
    /** Se inician los componentes de la clase en su valor por defecto */
    public void inicializarColisiones(){    

        for (int i = 0; i < grupoColisionIzquierda.length; i++) {
                                   
            switch (i) {
                
                case 0:
                    grupoColisionIzquierda[i].setBounds(0, -3600, 50, 4200);                 
                    grupoColisionDerecha[i].setBounds(550, -3600, 50, 4200);
                    break;
                    
                case 1:
                    grupoColisionIzquierda[i].setBounds(50, -2800, 50*2, 500);                         
                    grupoColisionDerecha[i].setBounds(450, -2800, 50*2, 500);
                    
                    break;
                    
                case 2:
                  
                    grupoColisionIzquierda[i].setBounds(50, -1550, 50*3, 300);                   
                    grupoColisionDerecha[i].setBounds(400, -1550, 50*3, 300);               
                    break;
                    
                case 3:
                    grupoColisionIzquierda[i].setBounds(50, -600, 50*2, 600);                
                    grupoColisionDerecha[i].setBounds(450, -600, 50*2, 600);
                    break;
            }
            
        }
        
       changeCollisions = true;
    }
    
    /** Mueve el mapa de los obstaculos */
    
    public void moverColisiones(){
            
        if(grupoColisionIzquierda[1].getY() >= 600){
            
            this.inicializarColisiones();
        }
        
        else{         
            for (int i = 0; i < grupoColisionIzquierda.length; i++) {
             grupoColisionIzquierda[i].setLocation(grupoColisionIzquierda[i].getX(), grupoColisionIzquierda[i].getY()+move);
             grupoColisionDerecha[i].setLocation(grupoColisionDerecha[i].getX(), grupoColisionDerecha[i].getY()+move);            
            } 
        
             
        } 
        
    }
    /**
     * Se realizan eventos del teclado para generar la sensacion de acelerar en los obstaculos
     * @param juego representa al panel del juego donde se aplicaran los eventos
     * @param puntaje se instancia un objeto de la barra lateral del juego para al momento de acelerar este mismo disminuya
     * el combustible
     */
        public void eventos(JPanel juego, final Puntaje puntaje){
        juego.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {          
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                
                if(e.getKeyCode() == KeyEvent.VK_UP && move >0){  
                    
                    if( Acelerar == 0){
                       sound.SonidoAcelerar();
                       Acelerar = 1;
                       
                    }
                    
                    puntaje.getCombustible().setValue(puntaje.getCombustible().getValue()-1);
                    move = 10;                     
                }                            
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_UP){      
                    move = 4;
                    if(Acelerar == 1){
                        Acelerar = 0;
                        
                    }
                    
                }
                    
                
            }
        });
    }
        /**
         * Setter para modificar la velocidad de movimiento
         * @param move velocidad de movimiento
         */
    public void setMove(int move) {
        this.move = move;
    }  
    
        /**
         *  Getter para obtener la velocidad de movimiento 
         * @return Move
         */
    public int getMove() {
        return move;
    }
       

    /**
     *
     * @return grupoColisionIzquierda[] Label izquierdo de acuerdo al index 
     * @param  index Label en cierta posicion
     */
    public JLabel getgrupoColisionIzquierda(int index) {
        return grupoColisionIzquierda[index];
    }    
    
    /**
     * @return vector completo del JLabel de la izquierda
     */
    public JLabel[] getgrupoColisionIzquierda() {
        return grupoColisionIzquierda;
    }    

    /**
     *
     * @return grupoColisionDerecha[] Label derecho de acuerdo al index 
     * @param  index Label en cierta posicion
     */
    public JLabel getgrupoColisionDerecha(int index) {
        return grupoColisionDerecha[index];
    }  
    
    /**
     *
     * @return grupoColisionDerecha vector completo del JLabel de la derecha
     */
    public JLabel[] getgrupoColisionDerecha() {
        return  grupoColisionDerecha;
    }    

   
     
}
