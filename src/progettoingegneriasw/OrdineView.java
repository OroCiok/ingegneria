/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

/**
 *
 * @author dicatterinamatteo
 */
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class OrdineView extends JFrame {
Label description, label_nome, label_descrizione, label_sport, label_materiale;
	
	JButton menu_principale, invia_ordine; 
	JTextField nome, descrizione, sport, materiale;
	Container container = getContentPane();
	
	OrdineView(){
		
    	container.setLayout(null);
    	setTitle("Inserimento nuovo ordine");
    	description = new Label("Compilare i seguenti campi per effettuare l'ordine");
    	
    	label_nome = new Label("Nome Articolo ");
    	label_descrizione = new Label("Descrizione Articolo ");
    	label_sport = new Label("Sport ");
    	label_materiale = new Label("Materiale ");
    	menu_principale = new JButton("Indietro");
    	invia_ordine = new JButton("Invia Ordine");
    	
    	nome = new JTextField(70);
    	sport = new JTextField(70);
    	descrizione = new JTextField(70);
    	materiale = new JTextField(70);
    	
    	description.setBounds(5, 10, 600, 15);
    	label_nome.setBounds(5, 35, 130, 15);
    	label_descrizione.setBounds(5, 60, 130, 15);
    	label_sport.setBounds(5, 85, 130, 15);
    	label_materiale.setBounds(5, 110, 130, 15);
    	
    	nome.setBounds(170, 35, 400, 20);
    	descrizione.setBounds(170, 60, 400, 20);
    	sport.setBounds(170, 85, 400, 20);
    	materiale.setBounds(170, 110, 400, 20);
    	
    	
    	invia_ordine.setBounds(25,150,250,30);
    	menu_principale.setBounds(375, 150, 250, 30);
        
        
    	container.add(description);
    	container.add(menu_principale);
    	container.add(invia_ordine);
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
		 
		 invia_ordine.addActionListener(e);
		 menu_principale.addActionListener(e);
	 
	 }

}

