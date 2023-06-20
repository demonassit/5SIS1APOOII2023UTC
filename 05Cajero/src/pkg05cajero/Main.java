/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05cajero;

/**
 *
 * @author demon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cliente cliente1 = new Cliente("Michellin ", new int[]{2, 2, 1, 5,2});
        Cliente cliente2 = new Cliente("Juana ", new int[]{1, 1, 6, 2,2});
        
        Cajera cajero1 = new Cajera("Luisa");
        Cajera cajero2 = new Cajera("Mario Francisco");
        
        //inicializar el tiempo
        long initialTime = System.currentTimeMillis();
        
        cajero1.procesarComprar(cliente1, initialTime);
        cajero2.procesarComprar(cliente2, initialTime);
    }
    
}
