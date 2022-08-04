
package Gameplay;

import Enemigos.Enemigos;

/**
 * Clase encargada de detectar las colisiones con los limites del juego y las del Gas
 * @author Carlos Alejandro Ramirez Mora
 * C.I:28131450
 */
public class DetectarColisiones {
    
   /**
    * Detecta todas las colisiones por el lado izquierdo
    * @param nave Es la nave que manipula el jugador
    * @param colisiones son todas las colisiones que se pueden generar entre nave y borde
    * @return true o false con respecto a la colision
    */
    
    public boolean ColisionLadoIzquierdo(Nave nave, BordeMundo colisiones){
        

        for (int i = 0; i < colisiones.getgrupoColisionIzquierda().length; i++) {
                     
            if(nave.getNave().getX() <= colisiones.getgrupoColisionIzquierda(i).getX()+colisiones.getgrupoColisionIzquierda(i).getWidth()
                && nave.getNave().getY() <= colisiones.getgrupoColisionIzquierda(i).getY()+colisiones.getgrupoColisionIzquierda(i).getHeight()
                    && nave.getNave().getY()+nave.getNave().getHeight() >= colisiones.getgrupoColisionIzquierda(i).getY()){
                
                return true;
            }
            
            else if(nave.getNave().getX() <= colisiones.getgrupoColisionIzquierda(i).getX()+colisiones.getgrupoColisionIzquierda(i).getWidth()
                    && nave.getNave().getY() == colisiones.getgrupoColisionIzquierda(i).getY()+colisiones.getgrupoColisionDerecha(i).getHeight()){
                
                return true;
            }
            
            else{
                nave.setMove_izquierda(10);
                colisiones.setMove(5);           
            }        
        }
        
         return false;              
    }
    
     /**
    * Detecta todas las colisiones por el lado derecho
    * @param nave Es la nave que manipula el jugador
    * @param colisiones son todas las colisiones que se pueden generar entre nave y borde
    * @return true o false con respecto a la colision
    */
    public boolean ColisionLadoDerecho(Nave nave, BordeMundo colisiones){
        
        for (int i = 0; i < colisiones.getgrupoColisionDerecha().length; i++) {
            
            if(nave.getNave().getX()+nave.getNave().getWidth() >= colisiones.getgrupoColisionDerecha(i).getX()
                    && nave.getNave().getY() <= colisiones.getgrupoColisionDerecha(i).getY()+colisiones.getgrupoColisionDerecha(i).getHeight()
                    && nave.getNave().getY()+nave.getNave().getHeight()>= colisiones.getgrupoColisionDerecha(i).getY()){
                
                return true;
            }
            
            
            else if(nave.getNave().getX()+nave.getNave().getWidth() >= colisiones.getgrupoColisionDerecha(i).getX()
                    && nave.getNave().getY() == colisiones.getgrupoColisionDerecha(i).getY()+colisiones.getgrupoColisionDerecha(i).getHeight()){
                
                return true;
            }
            
             else{
                 
                 nave.setMove_derecha(10);
                 colisiones.setMove(5);
            }
 
        }

        return false;
    }
  
    /**
     * Este metodo es el encargado de detectar las colisiones entre los enemigos y la nave del jugador
     * @param nave nave del jugador
     * @param enemigo enemigos
     * @return true or false
     */
    public boolean colisionNaveEnemigo(Nave nave, Enemigos enemigo){
        
        if(nave.getNave().getY() <= enemigo.getEnemigo().getY()+enemigo.getEnemigo().getHeight()
                && nave.getNave().getY()+nave.getNave().getHeight() >= enemigo.getEnemigo().getY()
                && nave.getNave().getX() <= enemigo.getEnemigo().getX()+enemigo.getEnemigo().getWidth()
                && nave.getNave().getX()+nave.getNave().getWidth() >= enemigo.getEnemigo().getX()){
            
            return true;
        }
            
        
       return false; 
    }
    /** Detecta colisiones del enemigo con el borde de la derecha
    * @param enemigo Son los enemigos
    * @param colisiones Son todas las colisiones que se pueden provocar los enemigos con el borde derecho
    * @param pixel El tamaño del label que posee el enemigo
    */
    public void ColisionesBordeEnemigoDerecha(Enemigos enemigo, BordeMundo colisiones, int pixel){

        for (int i = 0; i < colisiones.getgrupoColisionDerecha().length; i++) {
            
            if(enemigo.getEnemigo().getX()+enemigo.getEnemigo().getWidth() >= colisiones.getgrupoColisionDerecha(i).getX()
                    && enemigo.getEnemigo().getY() <= colisiones.getgrupoColisionDerecha(i).getY()+colisiones.getgrupoColisionDerecha(i).getHeight()
                    && enemigo.getEnemigo().getY()+pixel >= colisiones.getgrupoColisionDerecha(i).getY()){
                
                enemigo.setMovimiento(enemigo.getMovimiento()*(-1));
                enemigo.getEnemigo().setLocation(enemigo.getEnemigo().getX()+ enemigo.getMovimiento(), enemigo.getEnemigo().getY()); 
                break;
            } 
        }     
    }
    
    /** Detecta colisiones del enemigo con el borde de la izquierda
    * @param enemigo Son los enemigos
    * @param colisiones Son todas las colisiones que se pueden provocar los enemigos con el borde izquierdo
    * @param pixel El tamaño del label que posee el enemigo
    */
    public void ColisionesBordeEnemigoIzquierda(Enemigos enemigo, BordeMundo colisiones, int pixel){
        
        for (int i = 0; i < colisiones.getgrupoColisionIzquierda().length; i++) {
                     
            if(enemigo.getEnemigo().getX() <= colisiones.getgrupoColisionIzquierda(i).getX()+colisiones.getgrupoColisionIzquierda(i).getWidth()
                && enemigo.getEnemigo().getY() <= colisiones.getgrupoColisionIzquierda(i).getY()+colisiones.getgrupoColisionIzquierda(i).getHeight()
                    && enemigo.getEnemigo().getY()+pixel >= colisiones.getgrupoColisionIzquierda(i).getY()){
                
                enemigo.setMovimiento(enemigo.getMovimiento()*(-1));
                enemigo.getEnemigo().setLocation(enemigo.getEnemigo().getX()+ enemigo.getMovimiento(), enemigo.getEnemigo().getY()); 
                break;
            }               
        }               
    }

    /** Detecta colisiones entre el Gas y la nave
     * @param nave Es la nave del jugador
     * @param gas Es el combustible que puede poseer la nave
     * @return true or false
     */
    public boolean colisionGas(Nave nave, Gas gas){
        
        if(nave.getNave().getX() <= gas.getGas().getX()+gas.getGas().getWidth()
                &&nave.getNave().getX() + nave.getNave().getWidth() >= gas.getGas().getX()
                    && nave.getNave().getY() <= gas.getGas().getY()+gas.getGas().getHeight()
                        && nave.getNave().getY()+nave.getNave().getWidth()>= gas.getGas().getY()){
            
            return true;
            
        }
       
        return false;
    }
    
    
    
}
