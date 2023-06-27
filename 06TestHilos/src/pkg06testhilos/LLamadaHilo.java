/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06testhilos;

import java.util.concurrent.Callable;

/**
 *
 * @author demon
 */
public class LLamadaHilo implements Callable<String> {

    @Override
    public String call() throws Exception {
        //la duracion del hilo
        Thread.sleep(3000);
        return "Llamada al metodo resultado: ";
    }
    
}
