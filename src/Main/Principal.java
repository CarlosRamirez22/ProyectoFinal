
package Main;

import Contenido.Creditos;
import Contenido.Instrucciones;
import Contenido.MenuPrincipal;
import Gameplay.Iniciar;
import Gameplay.Puntaje;
import Musica.FX;
import Musica.Musica;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Esta clase es la encargada de cargar todo de manera correcta para jugar e iniciar
 * 
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Principal extends JFrame{
    
   
   /**
    * Se realiza la declaracion de un objeto por cada clase que vamos a necesitar
    */
    private MenuPrincipal menu;
    private Iniciar juego;
    private Creditos credito;
    private Instrucciones instrucciones;
    private Puntaje puntaje;
    private FX sound;
    private Musica music;
    
    /**
     * Se inicializan los objetos en el constructor 
     * @throws java.io.IOException
     */
    public Principal() throws IOException{
        super.setIconImage(new ImageIcon("recursos/icon.png").getImage());
        
        super.setTitle("River Raid");
        super.setResizable(false);
        super.setBounds(0,0,800,600);
        super.setLocationRelativeTo(null);
        super.setFocusable(false);
        
        /**
         * Se inicializa el menu
         */
        menu = new MenuPrincipal();
        menu.setVisible(true);
        
        /**
         * Se inicializa la barra lateral donde va el puntaje
         */
        
        puntaje = new Puntaje();
        puntaje.setVisible(false);
        
        /**
         * Se inicializa el objeto creditos
         */
        credito = new Creditos();
        credito.setVisible(false);
        
       /**
        * Se inicializa el objeto juego el cual recibe como parametro a la barra lateral y al menu del mismo
        */
        juego= new Iniciar(puntaje,menu);
        juego.setFocusable(true);
        
        /**
         * Se inicializa el objeto instrucciones
         */
        
        instrucciones = new Instrucciones();
        instrucciones.setVisible(false);
        
        /**
         * se inicializa el sonido y empieza a sonar la cancion del menu
         */
        sound = new FX();
        music = new Musica();
        
        
        /**
         * Se añade todo al JFrame
         */
        super.add(puntaje);
        super.add(juego);
        super.add(credito, 0);
        super.add(instrucciones,0);
        super.add(menu, 0);
        
        
        /**
         * Se realiza la carga del metodo eventos el cual ejecutara el juego despues de que el usuario
         * haya puesto su nombre de forma correcta
         */
        this.eventos();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
      
    }
    
    /**
     * Se comprueba el nombre del jugador para determinar si iniciar el juego o no
     * @param nombre Recibe un string el cual es el nombre ingresado por el usuario y se realiza la verificacion
     * @return los valores dependiendo el error
     */
    public int comprobarNombre(String nombre){
      /**
       *  al realizar la comprobacion del nombre del usuario para que sea menor a 8 caracteres
       *  tambien se realiza unos returns que funcionan para lo siguiente
       * 
       *  Si se retorna 0 es error, reingresa un nombre correcto.
       *  Si se retorna 1 es Nombre correcto, ingresar al juego.
       *  Si se retorna 2 se Regresar al menu principal.
       */
        try{
            if(nombre.length() > 8){
                JOptionPane.showMessageDialog(null, "Ingresó más de Ocho caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            } else if(nombre.replaceAll(" ", "").length()==0){
                JOptionPane.showMessageDialog(null, "Está en blanco ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);                      
                return 0;
            }
            else{
                return 1;
            }

         }
         catch(Exception e){
             return 2;
         }
        
    }
    /**
     * Aca se encuentra el metodo que inicia el juego
     */
    public void eventos() throws IOException{
       try {
                  music.SonidoMenu();
              } catch (IOException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
        
        //Si se pulsa el boton de jugar en el menu cargar el juego
      menu.getJugar().addMouseListener(new MouseAdapter(){
          
          public void mouseClicked(java.awt.event.MouseEvent e){
              
              
              sound.SonidoClick();
              
              int continuar=0;
              String nombre;
                
                do{
                     nombre = JOptionPane.showInputDialog(null, "Nombre del Jugador", "");
                     continuar = comprobarNombre(nombre);
                     puntaje.setNombre(nombre);
                     
                     
                }while(continuar == 0);
                
                
                if(continuar==1){
                    try {
                          music.DetenerSonidoMenu();
                      }catch (IOException ex) {
                             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                      }
                    
                    menu.setVisible(false);
                  try {
                      juego.inicializar();
                  } catch (IOException ex) {
                      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                    juego.getPuntaje().inicializarPuntaje();
                    juego.getPuntaje().quitarCombustible();
                    juego.getPuntaje().setVisible(true);
                    
                  try { 
                      juego.arrancar();
                  } catch (IOException ex) {
                      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                   
                }
              

          }
          
      });
      
        
        
        
        
        
    //Si se pulsa el menu de creditos del menu cargar los creditos
        menu.getCreditos().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                sound.SonidoClick();
                menu.setVisible(false);
                credito.setVisible(true);
                       
            }
        });
        menu.getInstrucciones().addMouseListener(new MouseAdapter(){
        @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                sound.SonidoClick();
                menu.setVisible(false);
                instrucciones.setVisible(true);
                       
            }
            
        });
     //Para regresar de los creditos y cargar nuevamente el menu
     
      credito.getvolverMenu().addMouseListener(new MouseAdapter(){
             
            public void mouseClicked(java.awt.event.MouseEvent e){
                menu.setVisible(true);
                credito.setVisible(false);
            }
        });  
      
      instrucciones.getvolverMenu().addMouseListener(new MouseAdapter(){
             
            public void mouseClicked(java.awt.event.MouseEvent e){
                menu.setVisible(true);
                instrucciones.setVisible(false);
            }
        });  
    }
    
    /**
     * Metodo Main
     * @param args 
     * @throws java.io.IOException 
     */
    public static void main(String[] args) throws IOException {
        
        Principal p1 = new Principal();
        
    }
}
