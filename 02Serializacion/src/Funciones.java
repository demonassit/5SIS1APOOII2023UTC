/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Funciones {
    
    //es mis variables y objetos
    ArrayList<Persona> listaPersonas = new ArrayList();
    String rep = "si";
    String nombre = "";
    int edad, num_empleado, bol;
    
    //vamos aplciar el polimorfismo
    Persona profesor = new Profesor();
    
    Persona alumno = new Alumno();
    
    //menu
    
    void menu(){
        while(true){
            while(rep.equalsIgnoreCase("si")){
                try{
                    String var = JOptionPane.showInputDialog("Ingresa la opcion deseada : \n"
                    + "1.- Registrar nuevo Profesor. \n"
                    + "2.- Registrar nuevo Alumno. \n"
                    + "3.- Consultar Alumnos. \n"
                    + "4.- Salir. \n");
                    
                    if(var == null){
                        System.exit(0);
                    }
                    
                    int opcion = Integer.parseInt(var);
                    
                    switch (opcion) {
                        case 1:
                            //metodos
                            pedirDatosProfesor();
                            //le voy asingar los datos al profesor
                            profesor = new Profesor(num_empleado, nombre, edad);
                            //guardo
                            guardarProfesor();

                            break;
                       case 2:
                            //metodos
                            pedirDatosAlumno();
                            //le voy asingar los datos al profesor
                            alumno = new Alumno(bol, nombre, edad);
                            //guardo
                            guardarAlumno();

                            break;
                       case 3:
                           //metodo para leer 
                           leerAlumnos();
                           break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    rep = JOptionPane.showInputDialog("¿Desea repetir?");
                }catch(Exception e){
                    System.out.println("Error " + e.getMessage());
                
                }
            }
        }
    }

    private void pedirDatosProfesor() {
        num_empleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de empleado: "));
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de empleado: "));
        
    }

    private void guardarProfesor() {
       //agrego a la lista el objeto del profesor
       listaPersonas.add(profesor);
       guardar();
    }

    private void pedirDatosAlumno() {
        bol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la boleta del alumno: "));
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno: ");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno: "));
           }

    private void guardarAlumno() throws IOException {
        listaPersonas.add(alumno);
       guardar();
    }

    private void leerAlumnos() throws FileNotFoundException, IOException, ClassNotFoundException {
        //hay que definir la entrada de un archivo
        FileInputStream archivo = new FileInputStream("archivo.dat");
        //genero la lectura del buffer de objetos
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        //que hay que transofrmar los objetos en bytes
        //debo de castear los tipos de dato
        listaPersonas = (ArrayList)entrada.readObject();
        
        //recorrer el array
        for(int i = 0; i < listaPersonas.size(); i++){
            //recorro lo que necesito del objeto
            Alumno obj = (Alumno)listaPersonas.get(i);
            //ahora si sacamos la informacion
            JOptionPane.showMessageDialog(null, "\n"
            + "Numero de Alumno : " + (i+1) + "\n"
            + "Boleta : " + obj.getBoleta() + "\n"
            + "Nombre : " + obj.getNombre()+ "\n"
            + "Edad : " + obj.getEdad()+ "\n"
            + "Tipo Persona : " + obj.tipoPersona()+ "\n");
        }
        
    }

    private void guardar() throws FileNotFoundException, IOException {
        //debo de generar un archivo de salida
        FileOutputStream archivo = new FileOutputStream("archivo.dat");
        //definimos el buffer para la salida de los objetos
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        
        //empiezo a escribir dentro del archivo los objetos que quiero guardar
        salida.writeObject(listaPersonas);
        salida.close();
        
        
    }
    
    
}
