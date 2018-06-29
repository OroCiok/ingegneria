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
 * @author matte
 */
public class NewNegozioView extends JFrame {
    
    Label description, label_codFiscale, label_città, label_indirizzo, label_nome;
    JButton menu_principale, inserisci_negozio; 
    JTextField nome, codFiscale, indirizzo, città;
    Container container = getContentPane();
    
    public NewNegozioView(){
        
        container.setLayout(null);
    	setTitle("Inserimento nuovo ordine");
    	description = new Label("Compilare i seguenti campi per aggiungere il negozio");
    	
    	label_nome = new Label("Nome Proprietario ");
    	label_codFiscale = new Label("Codice Fiscale ");
    	label_indirizzo = new Label("Indirizzo ");
    	label_città = new Label("Città ");
    	menu_principale = new JButton("Indietro");
    	inserisci_negozio = new JButton("Inserisci Negozio");
    	
    	nome = new JTextField(70);
    	indirizzo = new JTextField(70);
    	codFiscale = new JTextField(70);
    	città = new JTextField(70);
    	
    	description.setBounds(5, 10, 700, 15);
    	label_nome.setBounds(5, 35, 130, 15);
    	label_codFiscale.setBounds(5, 60, 130, 15);
    	label_indirizzo.setBounds(5, 85, 130, 15);
    	label_città.setBounds(5, 110, 130, 15);
    	
    	nome.setBounds(170, 35, 400, 20);
    	codFiscale.setBounds(170, 60, 400, 20);
    	indirizzo.setBounds(170, 85, 400, 20);
    	città.setBounds(170, 110, 400, 20);
    	
    	
    	inserisci_negozio.setBounds(25,150,250,30);
    	menu_principale.setBounds(375, 150, 250, 30);
        
        
    	container.add(description);
    	container.add(menu_principale);
    	container.add(inserisci_negozio);
    	container.add(label_nome);
    	container.add(label_codFiscale);
    	container.add(label_indirizzo);
    	container.add(label_città);
    	container.add(nome);
    	container.add(codFiscale);
    	container.add(indirizzo);
    	container.add(città);
    
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	}
	
	 public void addActionListeners(ActionListener e){
            inserisci_negozio.addActionListener(e);
            menu_principale.addActionListener(e);
	 }
    
    
}
