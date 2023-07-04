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


public class Depositar implements  Runnable{
    
    List<String> dinero;
    
    public Depositar(List<String> dinero){
        this.dinero = dinero;
    }
    
    

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(2000);
                synchronized(dinero){
                    SuperClase.saldo = SuperClase.saldo + 100;
                    dinero.notify();
                    System.out.println("En este momento se depositaron 100 pesos");
                }
            
            }catch(InterruptedException ex){
                Logger.getLogger(Depositar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
