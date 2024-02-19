/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.*;
import java.util.*;

/**
 *
 * @author demon
 */
public class Servidor {
    
    //puerto
    private final int puerto = 2027;
    //numero maximo de conexiones
    private final int noConexiones = 2;
    //creamos una lista de sockets para guardar el socket de cada jugador
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    //variable para controlar el turno de cada jugador
    private Boolean turno = true;
    //matriz donde vamos a guardar los movimientos
    private int G[][] = new int[3][3];
    //Numero de veces que se juega 
    private int turnos = 1;
    
    //vamos a crear una funcion para recibir las conexiones del cliente
    public void escuchar(){
        try{
            //inicializamos la matriz del juego con -1
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    G[i][j] = -1;
                }
            }
            
            //cremaos el socket del servidor
            ServerSocket servidor = new ServerSocket(puerto, noConexiones);
            
            //creamos un ciclo infinito para estar escuchando
            System.out.println("Espreando jugadores");
            
            while(true){
                Socket cliente = servidor.accept();
                
                //agregar el socket a  la lista
                usuarios.add(cliente);
                
                //se generar el turno
                
                int xo = turnos % 2 == 0 ? 1 : 0;
                turnos++;
                
                //instanciamos un hilo que estara atendiendo al cliente y 
                //lo ponemos a escuchar
                Runnable run = new HiloServidor(cliente, usuarios, xo, G);
                
                Thread hilo = new Thread(run);
                
                hilo.start();
                
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        Servidor servidor = new Servidor();
        servidor.escuchar();
    }
    
}
