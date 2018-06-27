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



public class SegreteriaView extends JFrame{

    JButton ingresso, visualizzaMovimenti, termina, cambia_utente, inserisci_articolo;
    Label description = new Label("Scegliere una delle seguenti opzioni", Label.CENTER);
    
    SegreteriaView() {
    	
    	Container container = getContentPane();
    	container.setLayout(null);
    	
        setTitle("Gestione Segreteria");
        
        ingresso = new JButton("Inserisci ingresso in magazzino");
        visualizzaMovimenti = new JButton("Visualizza movimenti magazzino");
        termina = new JButton("Termina");
        cambia_utente = new JButton("Logout");
        inserisci_articolo = new JButton("Inserisci nuovo tipo articolo");
        
        description.setBounds(25, 20, 300, 15);
        ingresso.setBounds(25,50,300,30);
        visualizzaMovimenti.setBounds(25,100,300,30);
        inserisci_articolo.setBounds(25,150,300,30);
        termina.setBounds(15,210,150,30);
        cambia_utente.setBounds(195, 210, 150, 30);
        
        container.add(description);
        container.add(ingresso);
        container.add(visualizzaMovimenti);
        container.add(inserisci_articolo);
        container.add(termina);
        container.add(cambia_utente);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addActionListeners(ActionListener e){
    	
        termina.addActionListener(e);
        ingresso.addActionListener(e);
        visualizzaMovimenti.addActionListener(e);
        inserisci_articolo.addActionListener(e);
        cambia_utente.addActionListener(e);
        
    }
}
