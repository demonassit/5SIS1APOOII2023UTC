
import Vista.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
            gui.iniciarServidor();
        });
    }
    
}
