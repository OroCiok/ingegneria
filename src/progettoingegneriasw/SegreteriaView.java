/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ionbaltaga
 */
public class SegreteriaView extends JFrame{

    JButton ingresso, visualizzaMovimenti,back;

    SegreteriaView() {
        JPanel content = new JPanel();
        GridLayout experimentLayout = new GridLayout(10, 0);
        content.setLayout(experimentLayout);
        
        ingresso= new JButton("Inserisci ingresso in magazzino");
        visualizzaMovimenti= new JButton("Visualizza movimenti magazzino");
        back= new JButton("torna indietro");
        
        content.add(ingresso);
        content.add(visualizzaMovimenti);
        content.add(back);
        
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addActionListeners(ActionListener e){
        back.addActionListener(e);
        ingresso.addActionListener(e);
        visualizzaMovimenti.addActionListener(e);
    }
}
