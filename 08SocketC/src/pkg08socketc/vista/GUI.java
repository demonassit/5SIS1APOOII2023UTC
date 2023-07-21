/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08socketc.vista;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author demon
 */
public class GUI extends JFrame {
    
    public GUI() throws HeadlessException{
        setBounds(600, 300, 280, 350);
        add(new Panel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
