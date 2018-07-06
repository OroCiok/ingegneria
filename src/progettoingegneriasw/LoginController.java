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
    private Magazzino magazzino;

    public LoginController(LoginView loginView, Login login, Magazzino magazzino) {
        this.loginView = loginView;
        this.login = login;
        this.magazzino=magazzino;
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
            if(loginView.segreteria.isSelected() || loginView.magazzino.isSelected() /*|| */){
            	
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
                    		Segreteria segreteria = new Segreteria();
                    		SegreteriaController segreteriaController = new SegreteriaController(segreteriaView, segreteria);
                    		break;
                            case "magazzino":
                                loginView.setVisible(false);
                                MagazzinoView magazzino_view = new MagazzinoView();
                                Magazzino magazzino = new Magazzino();
                                MagazzinoController magazzinoController = new MagazzinoController(magazzino_view, magazzino);
                    		break; 
                            default:
                    		break;
            		}
            	}
           
         }
            else if(loginView.gestioneNegozio.isSelected()){
                Negozio negozio = null;
                    String password[] = login.getPassword();

                Segreteria segreteria = new Segreteria();
                    for (int z = 0; z < segreteria.getShop_list().size(); z++) {
                        if (segreteria.getShop_list().get(z).getCodFiscale().equals(loginView.getPassword())) {
                            negozio = segreteria.getShop_list().get(z);
                            break;
                        }
                    }

                    if (negozio == null) {
                        JOptionPane.showMessageDialog(null, "Password non inserita o sbagliata, reinserire la password.\nSi ricorda che bisogna inserire il proprio codice univoco.");
                        loginView.password_text.setText("");
                    } else {
                        loginView.setVisible(false);
                        VisualizzaCreaOrdiniNegozioView visualizza_crea_ordini_negozio_view = new VisualizzaCreaOrdiniNegozioView(segreteria, negozio);
                        NegozioController negozioController = new NegozioController(visualizza_crea_ordini_negozio_view, negozio);
                    }
            }
            else{
       	   	JOptionPane.showMessageDialog(null, "E' necessario selezionare l'utente per poter effettuare il login");
         }
      }	 

    }

}
