/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ionbaltaga
 */
public class LoginController implements ActionListener {

    private LoginView loginView;
    private Login login;

    public LoginController(LoginView loginView, Login login) {
        this.loginView = loginView;
        this.login = login;
        loginView.addActionListeners(this);
        loginView.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.exit) {
            System.exit(0);
        }
        if (e.getSource() == loginView.login) {
            String utenti[] = login.getUtenti();
            int i = 0;
            while (utenti[i] != loginView.getUser()) {
                i++;
            }
            String password[] = login.getPassword();
            if (password[i].equals(loginView.getPassword()) == false) {
                JOptionPane.showMessageDialog(null, "Password sbagliata, riprovare");
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
                        //codice creazione view
                        break;
                    default:
                        break;
                }
            }
        }

    }

}
