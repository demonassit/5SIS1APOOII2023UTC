/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08socketc.Controlador;

/**
 *
 * @author demon
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;


public class EnviarTexto implements ActionListener {
    
    public final static int PUERTO_SERVIDOR = 5000;
    public final static String IP_SERVIDOR = "127.0.0.1";
    
    private final JTextField txtCampo;
    
    public EnviarTexto(JTextField txtCampo){
        this.txtCampo = txtCampo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Socket socket = new Socket(IP_SERVIDOR, PUERTO_SERVIDOR);
            try(DataOutputStream flujosalida = 
                    new DataOutputStream(socket.getOutputStream())){
                flujosalida.writeUTF(txtCampo.getText() + "/n");
                txtCampo.setText("");
            }        
        }catch(IOException ex){
            System.out.println("Mensaje de error: " + ex.getMessage());
        
        }
    }
    
}
