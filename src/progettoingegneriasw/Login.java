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
public class Login {
     private final String[] utenti;
     private String[] password;

    public Login(String[] utenti, String[] password) {
        this.utenti = utenti;
        this.password = password;
    }

     
     
    public String[] getUtenti() {
        return utenti;
    }

    public String[] getPassword() {
        return password;
    }

    public void setPassword(String nomeUtente, String password) {
        int i=0;
        while(nomeUtente!=utenti[i]){
            i++;
        }
        this.password[i]= password;
    }
 
}
