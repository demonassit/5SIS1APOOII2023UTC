/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    int num_int;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Ejemplo de hilo");
        
        ProcesoHilo hilo1 = new ProcesoHilo();
        ProcesoHilo hilo2 = new ProcesoHilo();
        ProcesoHilo hilo3 = new ProcesoHilo();
        
        hilo1.valorDeCondicion(5);
        hilo2.valorDeCondicion(6);
        hilo3.valorDeCondicion(7);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        
    }
    
}
