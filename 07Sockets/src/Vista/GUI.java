/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author demon
 */

import controlador.Servidor;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    
    private final JTextArea areatexto;
    
    public GUI(){
        setBounds(600, 300, 280, 350);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        areatexto = new JTextArea();
        panel.add(areatexto, BorderLayout.CENTER);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarServidor(){
        Servidor servidor = new Servidor(areatexto);
        servidor.start();
    }
}
