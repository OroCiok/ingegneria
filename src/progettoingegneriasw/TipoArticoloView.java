/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

/**
 *
 * @author ionbaltaga
 */
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;




public class TipoArticoloView extends JFrame {

	Label description, label_nome, label_descrizione, label_sport, label_materiale,label_prezzo,label_dataproduzione;
	
	JButton menu_principale, inserisci_nuovo_tipo; 
	JTextField nome, descrizione, sport, materiale,gg,mm,aaaa,field_prezzo;
	Container container = getContentPane();
	
	TipoArticoloView(){
    	container.setLayout(null);
    	setTitle("Inserimento Tipo Articolo");
    	description = new Label("Compilare i seguenti campi per aggiungere un nuovo tipo di articolo");
    	label_nome = new Label("Nome Articolo ");
    	label_descrizione = new Label("Descrizione Articolo ");
    	label_sport = new Label("Sport ");
    	label_materiale = new Label("Materiale ");
    	menu_principale = new JButton("Indietro");
    	inserisci_nuovo_tipo = new JButton("Inserisci Tipo Articolo");
        
        
    	nome = new JTextField(70);
    	sport = new JTextField(70);
    	descrizione = new JTextField(70);
    	materiale = new JTextField(70); 
    	
    	description.setBounds(5, 10, 600, 15);
    	label_nome.setBounds(5, 35, 130, 15);
    	label_descrizione.setBounds(5, 60, 140, 15);
    	label_sport.setBounds(5, 85, 130,15);
    	label_materiale.setBounds(5, 110, 130, 15);
    	
    	nome.setBounds(170, 35, 400, 20);
    	descrizione.setBounds(170, 60, 400, 20);
    	sport.setBounds(170, 85, 400, 20);
    	materiale.setBounds(170, 110, 400, 20);

        
    	
        
        
    	
    	inserisci_nuovo_tipo.setBounds(25,150,250,30);
    	menu_principale.setBounds(375, 150, 250, 30);
        
        
    	container.add(description);
    	container.add(menu_principale);
    	container.add(inserisci_nuovo_tipo);
    	container.add(label_nome);
    	container.add(label_descrizione);
    	container.add(label_sport);
    	container.add(label_materiale);
    	container.add(nome);
    	container.add(descrizione);
    	container.add(sport);
    	container.add(materiale);
    
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	}
	
	 public void addActionListeners(ActionListener e){
		 inserisci_nuovo_tipo.addActionListener(e);
		 menu_principale.addActionListener(e);
	 
	 }


}

