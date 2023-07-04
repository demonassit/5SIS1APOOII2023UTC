/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05depositos;

/**
 *
 * @author demon
 */

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Retirar  implements Runnable{
    
    List<String> dinero;
    
    public Retirar(List<String>dinero){
        this.dinero = dinero;
    }
   
    @Override
    public void run() {
        synchronized(dinero){
            if(SuperClase.saldo == 0.00){
                
                try{
                    System.out.println("Hola soy  " + Thread.currentThread().getName() 
                    + " No hay dinero en el cajero llegale");
                    dinero.wait();
                }catch(InterruptedException ex){
                     Logger.getLogger(Depositar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            SuperClase.saldo = SuperClase.saldo - 100;
            System.out.println("En este momento " + Thread.currentThread().getName() 
            + " retiro 100 pesos");
        }
    }
    
    
    
    
}
