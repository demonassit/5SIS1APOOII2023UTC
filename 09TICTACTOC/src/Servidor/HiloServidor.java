/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author demon
 */
public class HiloServidor implements Runnable {
    
    //declarar las variables
    private Socket socket;
    private DataOutputStream salida;
    private DataInputStream entrada;
    
    //variable ppara guardar los turnos
    private int XO;
    //la matriz
    private int G[][];
    //turno
    private boolean turno;
    //lista de usuarios
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    
    //constructor
    public HiloServidor(Socket soc, LinkedList users, int ox, int[][] Gato){
        socket = soc;
        usuarios = users;
        XO = ox;
        G = Gato;
    }

    @Override
    public void run() {
        try{
            //inicializamos los canales de comunicacion
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            turno = XO == 1;
            String msg = "";
            msg += " Juegas: " + (turno ? " X; " : " O; ");
            msg += turno;
            salida.writeUTF(msg);
            
            //creamos un ciclo que estara escuchando cada movimiento del jugador
            while(true){
                //leer los datos que se envian por medio del boton
                String recibidos = entrada.readUTF();
                String recibido[] = recibidos.split(";");
                
                /*
                    Esto sirve para el tablero
                    recibido[0] : fila del tablero
                    recibido[1] : columna del tablero
                
                */
                
                int f = Integer.parseInt(recibido[0]);
                int c = Integer.parseInt(recibido[1]);
                
                //se guarda en la matriz
                
                G[f][c] = XO;
                
                //se forma una cadena que se envia a los jugadores
                String cad = "";
                cad += XO+";";
                cad += f+";";
                cad += c+";";
                
                //debo comprobar si alguien gano
                
                boolean ganador = gano(XO);
                boolean completo = lleno();
                
                if(!ganador && !completo){
                    cad += "Nadie";
                }else if(!ganador && completo){
                    cad += "Empate";
                }else if(ganador){
                    vaciarMatriz();
                    cad += XO == 1 ? "X" : "O";
                } 
                
                for(Socket usuario : usuarios){
                    salida = new DataOutputStream(usuario.getOutputStream());
                    salida.wri teUTF(cad);
                }
            }
            
        }catch(Exception e){
        
        }
    }

    private boolean gano(int XO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean lleno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void vaciarMatriz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
