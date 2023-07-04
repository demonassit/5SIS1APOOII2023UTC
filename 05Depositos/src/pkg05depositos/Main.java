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


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> dinero;
        
        dinero = new ArrayList<>();
        Saldo sal = new Saldo();
        Thread hsal = new Thread(sal);
        Retirar ret = new Retirar(dinero);
        Depositar dep = new Depositar(dinero);
        
        //hilos
        
        Thread cliente1 = new Thread(ret, "Juan");
        Thread cliente2 = new Thread(ret, "Pedro");
        Thread cliente3 = new Thread(ret, "Susana");
        Thread cliente4 = new Thread(ret, "Diana");
        Thread cliente5 = new Thread(dep, "Aziel");
        
        hsal.start();
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        
        
        
        
    }
    
}
