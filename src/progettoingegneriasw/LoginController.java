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
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;


public class LoginController implements ActionListener {

    private LoginView loginView;
    private Login login;

    public LoginController(LoginView loginView, Login login) {
        this.loginView = loginView;
        this.login = login;
        loginView.addActionListeners(this);
        loginView.setVisible(true);
        loginView.setResizable(false);
        loginView.setBounds(325, 300, 350, 345);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.exit) {
            System.exit(0);
        }
        String utenti[]; 
        
        if (e.getSource() == loginView.login) {
             utenti = login.getUtenti();
            int i = 0;
            if(loginView.segreteria.isSelected() || loginView.magazzino.isSelected() || loginView.gestioneNegozio.isSelected()){
            	
            	while (utenti[i] != loginView.getUser()) {
            		i++;
            	}
            
            String password[] = login.getPassword();
            
            	if (password[i].equals(loginView.getPassword()) == false) {
            		JOptionPane.showMessageDialog(null, "Password non inserita o sbagliata, reinserire la password");
            	} else {
            		//creo interfaccia per segreteria, magazzino, gestione negozio a seconda del tipo di utente
            		switch (utenti[i]) {
                            case "segreteria":
                    		loginView.setVisible(false);
                    		//codice creazione view
                    		SegreteriaView segreteriaView = new SegreteriaView();
                    		Segreteria segreteria = new Segreteria(loginView);
                    		SegreteriaController segreteriaController = new SegreteriaController(segreteriaView, segreteria);
                    		break;
                            case "magazzino":
                    			//codice creazione view
                    		break;
                            case "gestioneNegozio":
                                loginView.setVisible(false);
                                NegozioView negozio_view = new NegozioView();
                                Negozio negozio = new Negozio("DCTMTT97C18I775K", "Matteo Di Catterina", "Via Passere, 31", "San Briccio(VR)");
                                NegozioController negozioController = new NegozioController(negozio_view, negozio);
                    		break;
                            default:
                    		break;
            		}
            	}
           
         }else{
       	   	JOptionPane.showMessageDialog(null, "E' necessario selezionare l'utente per poter effettuare il login");
         }
      }	 

    }

}
