/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author matte
 */
public class NegozioController implements ActionListener {
    
    private Negozio negozio;
    private NegozioView negozioView;
    
    private String[] utenti={"segreteria","magazzino","gestioneNegozio"};
    private String[] password={"ciao1234","salut1234","privet1234"};
    
    
    public NegozioController(NegozioView negView, Negozio negozio){
        
        this.negozio = negozio;
        this.negozioView = negView;
        negView.setBounds(310, 310, 360, 290);
        negView.addActionListener(this);
        negView.setVisible(true);
        negView.setResizable(false);
        
        
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource() == negozioView.indietro){
            negozioView.setVisible(false);
            LoginController login = new LoginController(new LoginView(), new Login(utenti, password));
        }
        
        if( e.getSource() == negozioView.visualizza_ordini){
            if( negozioView.shop_list.getSelectedIndex() == -1 ){
                
            }
            
        }
        
        if( e.getSource() == negozioView.shop_list ){
            
        }
        
    }
        
}
    
    

