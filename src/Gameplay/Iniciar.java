
package Gameplay;


import Enemigos.Enemigos;
import Enemigos.Helicoptero;
import Enemigos.Barcos;
import Contenido.MenuPrincipal;
import Musica.FX;
import Musica.Musica;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Esta clase se encarga de iniciar el juego 
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Iniciar extends JPanel{
    
    /** Objeto del mundo*/
    private Mundo mundo;
    /** objeto de la nave del jugador */
    private Nave nave;
    /** objeto de los bordes del mundo */
    private BordeMundo colisiones;
    /** objeto que detecta todas las colisiones */
    private DetectarColisiones detectarColision;
    /** objeto del panel lateral donde va el puntaje */
    private Puntaje puntaje;
    /** objeto de la clase FX que se encarga del sonido*/
    private FX sound;
    private Musica music;
    /** objeto sobre el menu principal*/
    private MenuPrincipal menu;
    /** objetos sobre los timer para agregarEnemigos, agregarGas y la espera del Game Over */
    private Timer agregarEnemigoAleatorio, agregarGasAleatorio,espera;
    /** objetos sobre el puntajeObtenido, el tiempo de juego y un contador */
    private int PuntajeObtenido, tiempoJuego,contador;
    /** objeto de la clase explosiones para realizar las animaciones */
    private Explosion explo;
    private static int ejecutar=0;
    /** objeto del tiempo de juego */
    private Timer timerJuego;
    /** arraylist sobre los disparos */
    private ArrayList<Disparo> Disparos;
    /** arraylist sobre el combustible */
    private ArrayList<Gas> combustible;
    /** arraylist sobre los enemigos*/
    private ArrayList<Enemigos> grupoEnemigo;
    /** variables de tipo boolena para realizar validaciones */
    private boolean pararDisparo,naveChoca, EXIT;

    /** JLabel que muestra el fin del juego*/
    private JLabel FindelJuego;
    
    /**
     * Metodo constructor que recibe como parametros el menu principal y la barra lateral del juego
     * @param puntaje barra lateral 
     * @param menu menu principal 
     */
    public Iniciar(Puntaje puntaje, MenuPrincipal menu) {
        this.puntaje=puntaje;
        this.menu=menu;
    }
    /**
     * Inicializa todos los componentes basicos del juego
     * @throws IOException 
     */
     public void inicializar() throws IOException{
        this.setLayout(null); 
        this.setBounds(0, 0, 600, 600);
        FindelJuego = new JLabel(new ImageIcon("recursos/FinalLabel.png"));
        FindelJuego.setBounds(100, 120, 400, 300);
        FindelJuego.setVisible(false);
        mundo = new Mundo();
        nave = new Nave();
        grupoEnemigo = new ArrayList<Enemigos>();
        Disparos = new ArrayList<Disparo>();
        combustible = new ArrayList<Gas>();
        colisiones = new BordeMundo();
        detectarColision = new DetectarColisiones();
        sound = new FX();
        music = new Musica();
        explo = new Explosion();
        PuntajeObtenido=0;
        tiempoJuego=90;
        pararDisparo = false;
        EXIT = false;
        naveChoca=false;
        
        this.add(FindelJuego);
        
        agregarEnemigoAleatorio = new Timer( TiempoAleatorio()*1000 , new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int Type = EnemigoAleatorio();
                int Position = EnemigoAleatorio();
                if(Type == 2){
                    
                    if( Position == 1){
                        int x = (int) (Math.random() * (320 - 200)) + 200;
                        int y = (int) (Math.random() * (-100 - -80)) + -80;
                        
                       grupoEnemigo.add(new Helicoptero(x,y)); 
                    }else if( Position == 2){
                        int x = (int) (Math.random() * (320 - 200)) + 200;
                        int y = (int) (Math.random() * (-100 - -80)) + -80;
                        
                        grupoEnemigo.add(new Helicoptero(x,y)); 
                    }else{
                        
                        int x = (int) (Math.random() * (320 - 200)) + 200;
                        int y = (int) (Math.random() * (-100 - -80)) + -80;
                         grupoEnemigo.add(new Helicoptero(x,y)); 
                    }
      
                }else if ( Type == 1 || Type == 3){
                    
                    if( Position == 1){
                        
                       int x = (int) (Math.random() * (320 - 200)) + 200;
                       int y = (int) (Math.random() * (-100 - -80)) + -80;
                       grupoEnemigo.add(new Barcos(200,-100)); 
                    }else if ( Position == 2 ){
                        
                        int x = (int) (Math.random() * (320 - 200)) + 200;
                        int y = (int) (Math.random() * (-100 - -80)) + -80;
                        grupoEnemigo.add(new Barcos(300,-100)); 
                    }else{
                        
                        int x = (int) (Math.random() * (320 - 200)) + 200;
                        int y = (int) (Math.random() * (-100 - -80)) + -80;
                        grupoEnemigo.add(new Barcos(350,-100));
                    }   
                }
                agregarEnemigo();
            }
        });
        
        this.agregarEnemigoAleatorio.start();
        
        agregarEnemigoAleatorio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEnemigoAleatorio.setDelay(TiempoAleatorio()*1000);
            }
        });
        
           agregarGasAleatorio = new Timer((TiempoAleatorio()-1)*1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int Position = EnemigoAleatorio();
                
                if(Position==2){
                    int x = (int) (Math.random() * (330 - 190)) + 190;
                    
                    combustible.add(new Gas(x, -80));
                } 
                //En caso de querer mas gasolina en pantalla
                /**
                if(Position==2){
                    int x = (int) (Math.random() * (330 - 190)) + 190;
                    
                    combustible.add(new Gas(x, -70));
                }
                */
                agregarCombustible();
            }
        });
           
         this.agregarGasAleatorio.start();
         
        agregarGasAleatorio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarGasAleatorio.setDelay((TiempoAleatorio()-1)*1000);
            }
        
        });
           
           
        nave.teclado(this);
        colisiones.eventos(this, puntaje);
        this.setFocusable(true);
        this.add(nave.getNave());
        
        for (int i = 0; i < colisiones.getgrupoColisionIzquierda().length; i++) {
            this.add(colisiones.getgrupoColisionIzquierda(i));
            this.add(colisiones.getgrupoColisionDerecha(i));
        }      
       
        
        this.add(mundo.getMundo1());
        this.add(mundo.getMundo2());
        
    }
 
     
     /**
     * Este metodo retorna un numero aleatorio que representa el tiempoen segundos.
     * @return retorna un valor de tipo Int.
     */
   public int TiempoAleatorio(){
        int max = 6; int min = 2;
        return min + (int)(Math.random() * ((max - min) + 1));
    }
   
   /**
     * Este metodo retorna un numero aleatorio que tiene un significado para la logica de los villanos y el fuel.
     * @return random entero para la ubicacion del enemigo y fuel
     */
   
    public int EnemigoAleatorio(){
        int max = 3;
        return (int)(Math.random() * (max) + 1);
    }
    
  
     /**
     * Este metodo se encarga de agregar el combustible al JLabel del panel y los hace visibles
     */
    public void agregarCombustible(){      
        for(Gas gas: combustible){
            if(gas.getGas().isVisible() == true){
                super.add(gas.getGas(), 0); 
            }
        }
    }
    /**
    * Este metodo se encarga de agregar los enemigos al JLabel del panel y los hace visibles 
    */
      public void agregarEnemigo(){
        for( Enemigos enemigos: grupoEnemigo){
            if(enemigos.getEnemigo().isVisible()==true){
                
                super.add(enemigos.getEnemigo(),0);
            }
        }  
    }
    /**
    * Este metodo se encarga de agregar los disparos al JLabel del panel y los hace visibles 
    */
     public void agregarDisparo(){      
        for(Disparo proyectil: Disparos){
            super.add(proyectil.getDisparo(),0); 
            
        }
    }
    
    /**
     * Este metodo arranca con toda la dinamica del juego
     * @throws IOException 
     */ 
   
    
    public void arrancar() throws IOException{
              
        
              music.DetenerSonidoMenu();
              music.SonidoJuego();
          
        
        /**
         * Se inicia una cuenta regresiva en el tiempo de juego
         */
        puntaje.tiempoJuego(tiempoJuego);
        
        /**
         * Se inicia a jugar
         */
        timerJuego = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                mundo.moverMundo();
                colisiones.moverColisiones();
                try {
                    comprobarSTOP();
                } catch (IOException ex) {
                    Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /**
                 * For para desplazar a los enemigos
                 */
                 for( Enemigos enemigos : grupoEnemigo){
                   if(enemigos.getEnemigo().isVisible()==true){
                         enemigos.desplazar(colisiones.getMove());
                   }
               }
              
                 /**
                  * For para desplazar al combustible
                  */
                 for( Gas gas : combustible){
                   if(gas.getGas().isVisible()==true){
                       gas.desplazarse(colisiones.getMove()); 
                   }                       
               }
                 
                /**
                * Colisiones de la nave del jugador con los obstaculos
                */              
               if(detectarColision.ColisionLadoDerecho(nave, colisiones)==true 
                       || detectarColision.ColisionLadoIzquierdo(nave, colisiones) == true){
                   
                   stopProcesos();
                   sound.SonidoExplosion();//sonido.reproducirSonidoExplosion();
                   explo.animacionExplosion(nave, timerJuego);
                   naveChoca = true;
                   
               }else{
                   /**
                     * Verificar las colisiones de todos los enemigos.
                     */
                    for( Enemigos enemigos : grupoEnemigo){

                         if(enemigos.getEnemigo().isVisible()){

                             //Aca se realiza la verificacion que si la nave choca con los enemigos
                             if(detectarColision.colisionNaveEnemigo(nave, enemigos)==true
                                     && enemigos.noHacer()==false){
                                 stopProcesos();
                                 explo.animacionExplosion(nave, timerJuego);
                                 sound.SonidoExplosion();
                                 naveChoca = true;
                             }
                             else{    
                                 //Verificacion de que los enemigos choquen con los bordes del mundo
                                 detectarColision.ColisionesBordeEnemigoDerecha(enemigos, colisiones, 60);
                                 detectarColision.ColisionesBordeEnemigoIzquierda(enemigos, colisiones,60);
                                

                                 /**
                                  * Verificacion de los proyectiles con todos los enemigos y combustibles
                                  */
                                 for(Disparo proyectil: Disparos){

                                         /**
                                          * En caso de que los enemigos sean impactados por una bala
                                          */
                                         if(enemigos.getEnemigo().getY()+enemigos.getEnemigo().getHeight() > proyectil.getDisparo().getY()
                                                 && enemigos.getEnemigo().getY() < proyectil.getDisparo().getY()
                                                 && enemigos.getEnemigo().getX() < proyectil.getDisparo().getX()
                                                 && enemigos.getEnemigo().getX() + enemigos.getEnemigo().getWidth() > proyectil.getDisparo().getX()
                                                 && enemigos.noHacer()==false){
                                                 
                                                 sound.SonidoExplosion();

                                                 /**
                                                  * Si el proyectil elimina a un barco son +40
                                                  */                                            
                                                 if(enemigos instanceof Barcos){

                                                     enemigos.setNoHacer(true);
                                                     explo.animacionExplosion(enemigos);                                             
                                                     PuntajeObtenido += 40;
                                                     sound.SonidoPuntos();

                                                 }
                                                 /**
                                                  * Si el proyectil elimina a un helicoptero +80
                                                  */
                                                 else if(enemigos instanceof Helicoptero){
                                                     
                                                     enemigos.getEnemigo().setVisible(false);
                                                     enemigos.getEnemigo().setLocation(-600, 0);
                                                     PuntajeObtenido += 80;                  
                                                     sound.SonidoPuntos();
                                                 }

                                                 proyectil.getDisparo().setVisible(false);
                                                 proyectil.getDisparo().setLocation(-100, 0);
                                                 puntaje.setPuntaje(PuntajeObtenido);
                                         } 

                                         /**
                                          * si la bala toca el combustible se le resta puntaje
                                          */   
                                        
                                         for(Gas gas: combustible){
                                             
                                               
                                              if(gas.getGas().getY()+gas.getGas().getHeight() > proyectil.getDisparo().getY()
                                                 && gas.getGas().getY() < proyectil.getDisparo().getY()
                                                 && gas.getGas().getX() < proyectil.getDisparo().getX()
                                                 && gas.getGas().getX() + gas.getGas().getWidth() > proyectil.getDisparo().getX()){
                                                     gas.getGas().setVisible(false);
                                                     gas.getGas().setLocation(-4000, 0);
                                                     proyectil.getDisparo().setVisible(false);
                                                     proyectil.getDisparo().setLocation(-3000, 0);
                                                     /**
                                                      * Si el proyectil toca un combustible se le restan -30
                                                      */
                                                     sound.SonidoExplosion();
                                                     sound.SonidoLosePuntos();
                                                     
                                                     int auxPuntaje = PuntajeObtenido-30;

                                                     if(auxPuntaje <= 0){
                                                         PuntajeObtenido = 0;
                                                     } else{
                                                         PuntajeObtenido = auxPuntaje;
                                                     }

                                                     puntaje.setPuntaje(PuntajeObtenido);

                                                     

                                              }

                                         }

                                 }

                                 //En caso de que el enemigo se salga del mapa
                                 if(enemigos.getEnemigo().getY() >= 650){
                                     enemigos.getEnemigo().setVisible(false);
                                 }
                             }
                         }                     
                    }

                    /**
                     *  Se verifican las colisiones entre el combustible y la nave del jugador
                     * al tocar uno la barra de combustible sube al 100%
                     */
                    for( Gas gas : combustible){

                        if(detectarColision.colisionGas(nave, gas)==true){
                            gas.getGas().setLocation(-600, 0);
                            gas.getGas().setVisible(false);
                            sound.SonidoGas();
                            puntaje.getCombustible().setValue(100);
                        }
                    }
                }     
            }
        });
        timerJuego.start();
        
        
        
        /**
         * Se realiza una variable ejecutar que funciona como auxiliar para saber
         * si el jugador puede o no realizar los disparos
         * dependiendo en el momento del juego que este
         */
       
       if( ejecutar == 0 ){
           super.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
                }

            @Override
            public void keyPressed(KeyEvent e) {
                
                }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if((e.getKeyCode() == KeyEvent.VK_SPACE) && (pararDisparo == false)){
                    Disparos.add(new Disparo(nave.getNave().getX()+(nave.getNave().getWidth()/2)-2));
                    sound.SonidoDisparo();
                    agregarDisparo();                  
                }
               
                    
                    
                
            }
       });
       }
    
    }
     
    /**
     * Se realiza una comprobacion de que todo el juego este detenido primero antes de volverse a ejecutar en multiples ocasiones
     * @throws IOException 
     */
    private void comprobarSTOP() throws IOException{
 
        music.DetenerSonidoMenu();
         if(puntaje.getCombustible().getValue()<=0){
             //Resto vidas Al Player
            puntaje.setVidas(puntaje.getVidas()-1);
             
             puntaje.getCombustible().setValue(100);
         }
         //En caso de que la nave
         if(naveChoca == true){
             //se inicializa de nuevo
             nave.inicializar();
             //se le restan las vidas al jugador
             puntaje.setVidas(puntaje.getVidas()-1);
             //se le establece el combustible al 100
             puntaje.getCombustible().setValue(100);
             //se reinicia el mapa
             colisiones.inicializarColisiones();
             //se elimina a los enemigos visibles en el mapa
             for(Enemigos enemigo : grupoEnemigo){
                 enemigo.getEnemigo().setVisible(false);
                 enemigo.getEnemigo().setLocation(-600, 0);
             }
             //la variable se pasa a false y se reinician los procesos
             naveChoca = false;
             resetProcesos();
         }
         /**
          * Aca se validan las vidas del jugador
          */
         if(puntaje.getVidas()==0){
            
             EXIT = true;
             
         }
         /**
          * Aca se validan que el tiempo cuando sea igual a 0 termine el juego
          */
         if(puntaje.getTiempo()==0){
             EXIT = true;                
             
         }

         /**
          * Y en dado caso que el jugador pierda sus tres vidas o se quede sin tiempo se entra a este if y se ejecuta 
          * el metodo FinDelJuego
          */
         if(EXIT == true){
            
             FinDelJuego();
         }
        
    }
    /**
     * Metodo que se utiliza para reiniciar los procesos para cuando el jugador choca
     */
    private void resetProcesos(){
            
        timerJuego.start();
        colisiones.setMove(5);
        nave.setMove_derecha(10);
        nave.setMove_izquierda(10);
        puntaje.getTimerTiempo().start();
        puntaje.getTimerGasolina().start();
        pararDisparo= false;
        agregarEnemigoAleatorio.start();
        agregarGasAleatorio.start();
        for(Disparo proyectil: Disparos){
            proyectil.getDisparoTime().start();
        }
    }

      
    /**
     * Metodo que se utiliza para parar todos los procesos en ejecucion
     */
    private void stopProcesos(){
        
        timerJuego.stop();
        colisiones.setMove(0);
        nave.setMove_izquierda(0);
        nave.setMove_derecha(0);
        puntaje.getTimerTiempo().stop();
        puntaje.getTimerGasolina().stop();       
        pararDisparo= true;
        agregarEnemigoAleatorio.stop();
        agregarGasAleatorio.stop();
        
        for(Disparo proyectil: Disparos){
            proyectil.getDisparoTime().stop();
        }
    }
    
    /**
     * Este metodo se encarga de quitar todos los componentes usado en el juego mostrando solo la nave con un gameover
     * y tiene un cierto descanso o periodo de tiempo para que se muestre el menu nuevamente
     * @throws IOException 
     */
     public void FinDelJuego() throws IOException{
        music.DetenerSonidoJuego();
        
        contador = 0;
 
          for(Gas gas: combustible){
            gas.getGas().setVisible(false);
        }
         
        
        FindelJuego.setVisible(true);
        
        espera = new Timer(1000, new ActionListener(){
            @Override
            
            public void actionPerformed(ActionEvent e) {  
                
                contador++;
                
            }
        });
        
        espera.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contador == 4){     
                    espera.stop();
                    puntaje.setVisible(false);
                    puntaje.removeAll();
                    ejecutar++;      
                    Iniciar.super.removeAll();
                    removeAll();
                    menu.setVisible(true);
                }
            }     
        });
        
        espera.start();
        timerJuego.stop();
        nave.setMove_izquierda(0);
        nave.setMove_derecha(0);
        puntaje.getTimerTiempo().stop();
        puntaje.getTimerGasolina().stop();
        agregarEnemigoAleatorio.stop();
        agregarGasAleatorio.stop();
        pararDisparo = true;
        
        Iniciar.super.setFocusable(false);
        
    }
    
    public Puntaje getPuntaje() {
        return puntaje;
    }

    
}
