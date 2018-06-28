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
 * @author dicatterinaMatteo
 */
public class NegozioView extends JFrame {
    
    JButton inserisci_ordine, visualizza_ordini, indietro;
    Label negozio = new Label("Selezionare un negozio dall'elenco");
    Label cod_fiscale, nome, indirizzo, città;
    JTextField cod_fiscale_text, nome_text, indirizzo_text, città_text;
    
    NegozioView(){
        
        Container container = getContentPane();
    	container.setLayout(null);
        setTitle("Creazione e Visualizzazione Ordini");
        
    	cod_fiscale = new Label("Codice Fiscale ");
    	nome = new Label("Nome ");
    	indirizzo = new Label("Indirizzo ");
    	città = new Label("Città ");
        
        nome_text = new JTextField(70);
    	cod_fiscale_text = new JTextField(70);
    	indirizzo_text = new JTextField(70);
    	città_text = new JTextField(70);
        nome_text.setEditable(false);
        cod_fiscale_text.setEditable(false);
        indirizzo_text.setEditable(false);
        città_text.setEditable(false);
        
        
        
        inserisci_ordine = new JButton("Crea Ordine");
        visualizza_ordini = new JButton("Visualizza ordini");
        indietro = new JButton("Logout");
        
        negozio.setBounds(25, 20, 300, 15);
        
        
        
        
        
        
        container.add(negozio);
        container.add(inserisci_ordine);
        container.add(visualizza_ordini);
        
    }
    
    public void addActionListener(ActionListener l){
    }
}
