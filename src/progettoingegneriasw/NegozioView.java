/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    Segreteria segreteria = new Segreteria();
    JComboBox shop_list = new JComboBox();
    //private ArrayList <Negozio> negozi = segreteria.getShop_list();
    //int i, size = negozi.size();
    
    
    
    NegozioView(){
        
        Container container = getContentPane();
    	container.setLayout(null);
        setTitle("Creazione e Visualizzazione Ordini");
        
        shop_list.setSelectedIndex(-1);
       
        //for(i = 0; i < size; i++){
            //shop_list.addItem("Negozio -"+negozi.get(i).getCittà());
        //}
        
        
        inserisci_ordine = new JButton("Crea Ordine");
        visualizza_ordini = new JButton("Visualizza ordini");
        indietro = new JButton("Logout");
        
        negozio.setBounds(15, 20, 300, 15);
        visualizza_ordini.setBounds(15, 150, 150, 30);
        inserisci_ordine.setBounds(185, 150, 150, 30);
        indietro.setBounds(100, 210, 150, 30);
        
        shop_list.setBounds(15, 50, 250, 25);
        
        
        inserisci_ordine.setEnabled(false);
        visualizza_ordini.setEnabled(false);
        
        
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