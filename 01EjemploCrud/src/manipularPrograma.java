
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class manipularPrograma {
    
    public void menu(){
    
        Scanner entrada = new Scanner(System.in);

        //instancia del crud
        AccionesPersona control = new AccionesPersona();

        System.out.println("Bienvenido al programa para manipular pokemones");
        System.out.println("Elija la opcion deseada");
        System.out.println("1.- Mostrar todas las personas");
        System.out.println("2.- Registrar nuevo pukamon");
        System.out.println("3.- Editar los datos del pukamon");
        System.out.println("4.- Borrar el pukamon");
        System.out.println("5.- Salir");
        
        int opcion = Integer.parseInt(entrada.nextLine());
        
        switch (opcion) {
            case 1:
                //instancia
                ArrayList<Persona> listadepersonas = 
                        control.mostrarPersonas();
                //debo imprimir los resultados del arreglo
                for(Persona objeto : listadepersonas){
                    System.out.println("El id del pukamon es: " + objeto.getId()
                    + "El nombre del pukamon es: " + objeto.getNombre()
                    + "El edad del pukamon es: " + objeto.getEdad());
                }
                menu();
                break;
            default:
                throw new AssertionError();
        }
    
    }
                
    
    
    
}
