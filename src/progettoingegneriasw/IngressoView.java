/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author ionbaltaga
 */
public class IngressoView extends JFrame {

    Label label_tipo_articolo;

    JButton back, aggiungi_ingresso;
    JTextField nome, descrizione, sport, materiale;
    Container container = getContentPane();

    IngressoView() {
        container.setLayout(null);
        setTitle("Inserimento Tipo Articolo");
        label_tipo_articolo = new Label("Scegli il tipo di articolo");
        
        back=new JButton("Indietro");
        aggiungi_ingresso=new JButton("Aggiungi ingresso");
        
        label_tipo_articolo.setBounds(5, 10, 600, 15);
    	back.setBounds(5, 35, 130, 15);
        aggiungi_ingresso.setBounds(5, 35, 130, 15);
        
        
        
        
        
        
        container.add(label_tipo_articolo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListeners(ActionListener e) {
        back.addActionListener(e);
        aggiungi_ingresso.addActionListener(e);
    }
}
