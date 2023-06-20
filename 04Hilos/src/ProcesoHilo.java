/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class ProcesoHilo  extends Thread {
    /*
    Los hilos nos permiten crear procesos independientes
    que se pueden ejecutar como elementos de objeto
    
    Cada hilo puede tener su propia seria de operaciones
    Cada hilo puede mandar a llamar a mas hilos
    */
    
    public ProcesoHilo(){
    }
    
    public ProcesoHilo(String nombreHilo){
        super(nombreHilo);
    }
    
    //para correr el hilo
    int num_int;
    
    //metodo para ejecutar o correr un hilo
    public void run(){
        for(int i = 0; i <= num_int; i++){
            System.out.println(" + " + this.getName());
        }
        System.out.println(" ");
    }
    
    public void valorDeCondicion(int valor){
        this.num_int = valor;
    }
}
