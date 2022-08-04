
package Gameplay;

import Main.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * Clase encargada de la barra lateral del juego
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class Puntaje extends JPanel{
   
    

    /** Variables de tipo int que manejan el puntaje, la cantidad de vidas y el tiempo*/
    private int Tiempo, Puntaje, Vidas;
    /** Timers del tiempo de juego y la disminucion de la gasolina */
    private Timer timerGasolina, timerTiempo;
    /** JLabels empleados en toda la ejecucion de la clase*/
    private JLabel iconTiempo, iconPuntaje, iconVidas,palabra_vida;
    private JLabel tiempo, puntaje, vidas,gasolina,Nombre;
    private JLabel backNombre,backPuntaje,backTiempo,backGasolina,user;
    /** String que se encarga de tomar el nombre que ingresa el jugador y mostrarlo por pantalla*/
    private String nombre;
    /** JProgressBar que cuenta la cantidad de combustible que posee la nave */
    private JProgressBar combustible;
    /** Imagen que es el fondo del panel lateral */
    private Image fondo = new ImageIcon("recursos/mundo/panelpuntaje.png").getImage();
    /** Icon usado para ponerle fondo a los complementos del panel lateral */
    private Icon i1;
    
    public Puntaje() {
        super.setLayout(null);
        super.setBackground(Color.black);
        super.setBounds(600, 0, 200, 600);     
    }
   /**
    * Metodo encargado de pintar la imagen del fondo del panel lateral
    * @param g se envia el fondo
    */
    @Override
    public void paintComponent(Graphics g){
        
        if( isVisible() ){
           g.drawImage(fondo, 0, 0, getWidth(), getHeight(),this); 
        }
    
    }
    /**
     * Metodo encargado de iniciarlizar las variables de la clase y cargarlas
     */
    public void inicializarPuntaje(){
        
        ImageIcon b1 = new ImageIcon("recursos/Label/Button1.png");
        
        int adicional = 30;
        int adicionalp= 70;
        
          
        iconVidas = new JLabel();  
        iconVidas.setBounds(40, 380+adicional, 120, 50);
        i1= new ImageIcon(b1.getImage().getScaledInstance(iconVidas.getWidth(), iconVidas.getHeight(), Image.SCALE_SMOOTH));
        iconVidas.setIcon(i1);
        iconVidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconVidas.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        palabra_vida = new JLabel("Vidas",SwingConstants.CENTER);
        palabra_vida.setForeground(Color.BLACK);
        palabra_vida.setBounds(40, 380+adicional, 120, 30);

        Vidas = 3;
        vidas = new JLabel(String.valueOf(Vidas));
        vidas.setForeground(Color.BLACK);
        vidas.setBounds(95, 425, 120, 35);
 
        backNombre = new JLabel();  
        backNombre.setBounds(40,480+adicional,120,50);
        backNombre.setIcon(i1);
        backNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backNombre.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        user = new JLabel("Nombre:",SwingConstants.CENTER);
        user.setBounds(40,475+adicional,120,30);
        user.setForeground(Color.BLACK);
        
        Nombre = new JLabel("",SwingConstants.CENTER);
        Nombre.setBounds(40,495+adicional,120,30);
        Nombre.setText(nombre);
        Nombre.setForeground(Color.BLACK);
        
        backPuntaje = new JLabel();
        backPuntaje.setBounds(39,110+adicionalp,120,50);
       
        backPuntaje.setIcon(i1);
        backPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backPuntaje.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        iconPuntaje = new JLabel("Puntaje",SwingConstants.CENTER);               
        iconPuntaje.setBounds(38, 96+adicionalp, 120, 50);
        iconPuntaje.setForeground(Color.black);
         
        Puntaje = 0;
        puntaje = new JLabel(String.valueOf(Puntaje),SwingConstants.CENTER);
        puntaje.setForeground(Color.BLACK);
        puntaje.setBounds(38, 115+adicionalp, 120, 50);
        
        backTiempo = new JLabel();
        backTiempo.setBounds(39, 55+adicional, 120, 50);
        backTiempo.setIcon(i1);
        backTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backTiempo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        iconTiempo = new JLabel("Tiempo",SwingConstants.CENTER);               
        iconTiempo.setBounds(38, 42+adicional, 120, 50);
        iconTiempo.setForeground(Color.black);
        
        
        Tiempo = 0;
        tiempo = new JLabel(String.valueOf(Tiempo),SwingConstants.CENTER);
        tiempo.setBounds(38, 60+adicional, 120, 50);
        tiempo.setForeground(Color.black);
        
        backGasolina = new JLabel();
        backGasolina.setBounds(39, 250+adicional, 120, 50);
        backGasolina.setIcon(i1);
        backGasolina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGasolina.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        gasolina = new JLabel("Combustible",SwingConstants.CENTER);               
        gasolina.setBounds(38, 250+adicional, 120, 50);
        gasolina.setForeground(Color.BLACK);
        
        
        combustible = new JProgressBar(0);
        combustible.setBounds(25, 325+adicional, 150, 30);  
        combustible.setValue(100);
        combustible.setBackground(Color.BLACK);
        
        super.add(backTiempo,0);
        super.add(iconTiempo, 0);
        super.add(tiempo, 0);
        super.add(backPuntaje,0);
        super.add(iconPuntaje, 0);
        super.add(puntaje, 0);
        super.add(backGasolina,0);
        super.add(gasolina, 0);
        super.add(combustible, 0);
        super.add(iconVidas, 0);
        super.add(palabra_vida,0);
        super.add(vidas, 0);
        super.add(backNombre,0);
        super.add(user,0);
        super.add(Nombre,0);
        
    }
    
    /**
     * Metodo que se encarga de cargar el timer que va air disminuyendo el valor de la gasolina
     */
    public void quitarCombustible(){
                
        timerGasolina = new Timer(800, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                combustible.setValue(combustible.getValue()-2);
                
            }
            
        });
        timerGasolina.start();
    }
    /**
     * Metodo que se encarga del tiempo del juego 
     * @param segundos recibe la cantidad de tiempo de juego
     */
     public void tiempoJuego(int segundos){
        
        Tiempo = segundos;
        tiempo.setText(String.valueOf(Tiempo));
        
        timerTiempo = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Tiempo -= 1;
                tiempo.setText(String.valueOf(Tiempo));
                
            }
            
        });
        timerTiempo.start(); 
    }
    /**
     * Getter que obtiene la barra de porcentaje de combustible
     * @return combustible
     */
    public JProgressBar getCombustible() {
        return combustible;
    }

    /**
     * Metodo que settea el puntaje que pueda recibir el jugador
     * @param Puntaje puntaje que tiene el jugador actualmente
     */
    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
        puntaje.setText(String.valueOf(this.Puntaje));
    }

    /**
     * Metodo que setea las vidas que posee el jugador
     * @param Vidas recibe la cantidad de vidas
     */
    public void setVidas(int Vidas) {
        this.Vidas = Vidas;
        vidas.setText(String.valueOf(Vidas));
    }
    
    /**
     * Metodo que setea el nombre del jugador para ponerlo en el panel lateral
     * @param nombre nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    /**
     * se obtienen las vidas que posee el jugador
     * @return Vidas
     */
    public int getVidas() {
        return Vidas;
    }
    /**
     * se obtiene el tiempo de juego
     * @return Tiempo
     */
    public int getTiempo() {
        return Tiempo;
    }
    /**
     * se obtiene el timer de la gasolina
     * @return timerGasolina
     */
    public Timer getTimerGasolina() {
        return timerGasolina;
    }
    
    /**
     * se obtiene el timer del tiempo de juego
     * @return TimerTiempo
     */
    public Timer getTimerTiempo() {
        return timerTiempo;
    }
    
    
}
