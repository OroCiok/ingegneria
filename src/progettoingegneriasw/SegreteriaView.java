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

    JButton visualizzaMovimenti, termina, cambia_utente, inserisci_tipoart, inserisci_negozio, inserisci_articolo,inserisci_art;
    Label description = new Label("Scegliere una delle seguenti opzioni", Label.CENTER);
    
    SegreteriaView() {
    	
    	Container container = getContentPane();
    	container.setLayout(null);
    	
        setTitle("Gestione Segreteria");

        visualizzaMovimenti = new JButton("Visualizza movimenti magazzino");
        termina = new JButton("Termina");
        cambia_utente = new JButton("Logout");
        inserisci_tipoart = new JButton("Inserisci nuovo tipo articolo");
        inserisci_negozio = new JButton("Inserisci nuovo negozio");    
        inserisci_art=new JButton("Inserisci Articolo");
        
        description.setBounds(25, 20, 300, 15);
        inserisci_tipoart.setBounds(25,50,300,30);
        inserisci_art.setBounds(25,100,300,30);
        inserisci_negozio.setBounds(25,150,300,30);
        visualizzaMovimenti.setBounds(25, 200, 300, 30);
        termina.setBounds(15,310,150,30);
        cambia_utente.setBounds(195, 310, 150, 30);
        
        container.add(description);
        container.add(inserisci_art);
        container.add(visualizzaMovimenti);
        container.add(inserisci_art);
        container.add(termina);
        container.add(cambia_utente);
        container.add(inserisci_negozio);
        container.add(inserisci_art);
        container.add(inserisci_tipoart);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addActionListeners(ActionListener e){
    	
        termina.addActionListener(e);
        
        visualizzaMovimenti.addActionListener(e);
        inserisci_art.addActionListener(e);
        cambia_utente.addActionListener(e);
        inserisci_negozio.addActionListener(e);
        inserisci_art.addActionListener(e);
        inserisci_tipoart.addActionListener(e);
        
    }
}
