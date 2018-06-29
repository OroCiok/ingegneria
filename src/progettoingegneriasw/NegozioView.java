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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author dicatterinaMatteo
 */
public class NegozioView extends JFrame {
    
    JButton inserisci_ordine, visualizza_ordini, indietro;
    Label negozio = new Label("Selezionare un negozio dall'elenco");
    String negozi[] = {"Negozio - Verona", "Negozio - Lavagno"};
    JComboBox shop_list = new JComboBox(negozi);
    
    
    NegozioView(){
        
        Container container = getContentPane();
    	container.setLayout(null);
        setTitle("Creazione e Visualizzazione Ordini");
        
        shop_list.setSelectedIndex(-1);
       
        
        //ciao
        
        inserisci_ordine = new JButton("Crea Ordine");
        visualizza_ordini = new JButton("Visualizza ordini");
        indietro = new JButton("Logout");
        
        negozio.setBounds(15, 20, 300, 15);
        visualizza_ordini.setBounds(15, 150, 150, 30);
        inserisci_ordine.setBounds(185, 150, 150, 30);
        indietro.setBounds(100, 210, 150, 30);
        
        shop_list.setBounds(15, 50, 250, 25);
        
        
        
        
        
        container.add(negozio);
        container.add(inserisci_ordine);
        container.add(visualizza_ordini);
        container.add(indietro);
        container.add(shop_list);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void addActionListener(ActionListener l){
        shop_list.addActionListener(l);
        visualizza_ordini.addActionListener(l);
        inserisci_ordine.addActionListener(l);
        indietro.addActionListener(l);
    }
}