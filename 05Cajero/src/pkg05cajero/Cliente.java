/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05cajero;

/**
 *
 * @author demon
 */
public class Cliente {
    
    private String nombre;
    private int[] carrocompras;
    
    public Cliente(){
    }

    public Cliente(String nombre, int[] carrocompras) {
        this.nombre = nombre;
        this.carrocompras = carrocompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarrocompras() {
        return carrocompras;
    }

    public void setCarrocompras(int[] carrocompras) {
        this.carrocompras = carrocompras;
    }
    
    
    
}
