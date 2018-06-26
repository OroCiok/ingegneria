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
public class ProgettoIngegneriaSW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView loginView=new LoginView();
        String[] utenti={"segreteria","magazzino","gestioneNegozio"};
        String[] password={"ciao1234","salut1234","privet1234"};
        Login login= new Login(utenti,password);
        LoginController loginController = new LoginController(loginView,login);
    }
    
}
