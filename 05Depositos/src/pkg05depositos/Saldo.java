/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05depositos;

/**
 *
 * @author demon
 */


import javax.swing.*;


public class Saldo extends JFrame implements Runnable{

    private JPanel pnl;
    static JLabel lblSaldo;
    
    public Saldo(){
        super("Lo que tiene el cajero");
        setBounds(100, 100, 372, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblSaldo = new JLabel("Saldo");
        lblSaldo.setBounds(150, 50, 105, 15);
        
        pnl = new JPanel(null);
        pnl.add(lblSaldo);
        setContentPane(pnl);
        setVisible(true);
        
       
    }
    
    
    @Override
    public void run() {
        while(true){
            lblSaldo.setText(" " + SuperClase.saldo);
        }
    }
    
    
    
}
