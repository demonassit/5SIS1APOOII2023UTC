/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08socketc.vista;

/**
 *
 * @author demon
 */

import pkg08socketc.Controlador.EnviarTexto;

import javax.swing.*;


public class Panel extends JPanel {
       
    private final JTextField txtCampo;
    private final JButton btnEnviar;
    
    public Panel(){
        add(new JLabel("CLIENTE"));
        txtCampo = new JTextField(20);
        add(txtCampo);
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new EnviarTexto(txtCampo));
        add(btnEnviar);
    }
}
