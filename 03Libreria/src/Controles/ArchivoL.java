/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.io.Serializable;
import java.io.*;
import java.util.*;

import Documentos.CLibro;

/**
 *
 * @author demon
 */
public class ArchivoL implements Serializable {
    
    //vamos a crear un objeto para poder guardar los diferentes libros y revistas
    ArrayList<CLibro> listarecuperar = new ArrayList<CLibro>();
    
    //metodo para generar la lectura del archivo
    
    public ArrayList<CLibro> leer(){
        try{
        
            //primer tenemos que crear la lectura del buffer
            ObjectInputStream in = new ObjectInputStream( 
                    new FileInputStream("libro.txt"));
            listarecuperar = (ArrayList<CLibro>)in.readObject();
            in.close();
            
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return listarecuperar;
    }
    
    //el metodo para escribir
    void serializar(ArrayList<CLibro> listaserializada){
        try{
        
            //generar el archivo de salida
            FileOutputStream salida = new FileOutputStream("libro.txt");
            //genero la escritura del objeto
            ObjectOutputStream salidaobjeto = new ObjectOutputStream(salida);
            
            //ya que lo tengo lo escribo
            salidaobjeto.writeObject(listaserializada);
            
        }catch(Exception e){
        
            System.out.println("Error "+ e.getMessage());
        }
    }
    
}
