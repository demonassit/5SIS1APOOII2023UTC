/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author demon
 */

import com.sun.istack.internal.logging.Logger;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import javax.swing.*;


public class Servidor extends Thread {
    
    private final JTextArea areatexto;
    
    public final static int PUERTO_SERVIDOR = 5000;
    
    public Servidor(JTextArea areatexto){
        this.areatexto = areatexto;
    }
    
    public void run(){
        try{
            //primero debemos de crear la instancia del socket servidor
            ServerSocket serverSocket = new ServerSocket(PUERTO_SERVIDOR);
            
            while(true){
                try(Socket socket = serverSocket.accept()){
                    DataInputStream flujoEntrada = 
                            new DataInputStream(socket.getInputStream());
                    
                    String mensaje = flujoEntrada.readUTF();
                    areatexto.append(mensaje);
                }
            }
            
        }catch(IOException ex){
            System.out.println("Mensaje de error: " + ex.getMessage());
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
}
