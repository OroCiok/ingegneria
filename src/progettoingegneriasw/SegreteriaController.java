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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class SegreteriaController implements ActionListener{
	
    private SegreteriaView segreteriaView;
    private Segreteria segreteria;
    private TipoArticoloView new_type = new TipoArticoloView();
    private NewNegozioView new_negozio= new NewNegozioView();

    
    
    private String[] utenti={"segreteria","magazzino","gestioneNegozio"};
    private String[] password={"ciao1234","salut1234","privet1234"};
	
    
    public SegreteriaController(SegreteriaView segreteriaView, Segreteria Segreteria) {
        this.segreteriaView = segreteriaView;
        this.segreteria = Segreteria;
        segreteriaView.addActionListeners(this);
        segreteriaView.setVisible(true);
        segreteriaView.setResizable(false);
        segreteriaView.setBounds(275, 275, 360, 390);
        new_type.addActionListeners(this);
        new_type.setVisible(false);
        new_type.setBounds(275, 275, 650, 225);
        new_type.setResizable(false);
        new_negozio.addActionListeners(this);
        new_negozio.setVisible(false);
        new_negozio.setBounds(275, 275, 650, 225);
        new_negozio.setResizable(false);
        
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == segreteriaView.termina) {
        	System.exit(0);
        }
        
        if (e.getSource() == segreteriaView.cambia_utente) {
        	segreteriaView.setVisible(false);
        	LoginController login = new LoginController(new LoginView(), new Login(utenti, password));
        }
        
        if (e.getSource() == segreteriaView.inserisci_articolo) {
        	segreteriaView.setVisible(false);
        	new_type.setVisible(true);
        }
        
        if (e.getSource() == new_type.menu_principale) {
        	segreteriaView.setVisible(true);
        	new_type.setVisible(false);
        	
        }
        
        if (e.getSource() == new_type.inserisci_nuovo_tipo) {
        	if(new_type.nome.getText().equals("") ||new_type.descrizione.getText().equals("") || new_type.sport.getText().equals("") || new_type.materiale.getText().equals("")){
        		JOptionPane.showMessageDialog(null, "Impossibile inserire il nuovo tipo articolo, è necessario compilare tutti i campi.");
        	}else{
        		
        	}
        }
        
        if(e.getSource() == segreteriaView.inserisci_negozio){
            segreteriaView.setVisible(false);
            new_negozio.setVisible(true);
        }
        
        if(e.getSource() == new_negozio.inserisci_negozio){
            if(new_negozio.nome.getText().equals("") || new_negozio.codFiscale.getText().equals("") || new_negozio.indirizzo.getText().equals("") || new_negozio.città.getText().equals("")){
        	JOptionPane.showMessageDialog(null, "Impossibile inserire il negozio, è necessario compilare tutti i campi.");
            }else{
                this.segreteria.addNegozio(new Negozio(new_negozio.nome.getText(), new_negozio.codFiscale.getText(), new_negozio.indirizzo.getText(), new_negozio.città.getText()));
                JOptionPane.showMessageDialog(null, "Il nuovo negozio è stato aggiunto correttamente.");
                new_negozio.codFiscale.setText("");
                new_negozio.nome.setText("");
                new_negozio.indirizzo.setText("");
                new_negozio.città.setText("");
                
            }
        }
        
        if(e.getSource() == new_negozio.menu_principale){
            new_negozio.setVisible(false);
            segreteriaView.setVisible(true);
        }
    }
 
}

