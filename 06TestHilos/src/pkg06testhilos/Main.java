/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06testhilos;

/**
 *
 * @author demon
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.FutureTask;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //primero creamos nuestro objeto de interfaz abstracta
        LLamadaHilo callable = new LLamadaHilo();
        
        //vamos a crear un objeto de future para implementarlo en el hilo
        FutureTask<String> task = new FutureTask<>(callable);
        
        //cremao un hilo para manejar las tareas
        Thread hilo = new Thread(task);
        
        //primero pedir los datos de la tarea
        
        //objetos de la tarea
        Tarea nuevatarea = new Tarea();
        
        
        //vamos abrir el hilo
        System.out.println("La hora para iniciar la tarea: " + getNowTime());
        hilo.start();
        
        
        
        //obtiene el valor de la llamada
        try{
            String resultado = task.get();
            //mando a llamar los datos de la tarea
            nuevatarea.pedirDatos();
            
            System.out.println("Obtener el valor de retorno : " + resultado);
            System.out.println("Fin del tiempo de ejecition del get :" + getNowTime());
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String getNowTime() {
        //vamos a ocupar simpledateformat
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(new Date());
    }
    
}
