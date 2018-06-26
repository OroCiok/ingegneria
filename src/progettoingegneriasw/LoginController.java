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
    private Button[] bottonePremuto;

    public LoginController(LoginView loginView, Login login) {
        this.loginView = loginView;
        this.login = login;
        loginView.addActionListeners(this);
        loginView.setVisible(true);
        
    }

        public void actionPerformed (ActionEvent e) {
                
                bottonePremuto=loginView.getButtons();
                if (e.getSource() == bottonePremuto[0]) {
                System.exit(0);
            }
            if (e.getSource() == bottonePremuto[1]) {
                String utenti[] = login.getUtenti();
                int i = 0;
                while (utenti[i] != loginView.getUser()) {
                    i++;
                }
                String password[] = login.getPassword();
                System.out.println("" + utenti[i]);
                System.out.println("" + password[i]);
                System.out.println("" + loginView.getPassword());
                if (password[i].equals(loginView.getPassword()) == false) {
                    JOptionPane.showMessageDialog(null, "Password sbagliata, riprovare");
                }
            }

        }
    
}
