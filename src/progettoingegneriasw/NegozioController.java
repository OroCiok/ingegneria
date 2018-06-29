/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author matte
 */
public class NegozioController implements ActionListener {
    
    private Negozio negozio;
    private NegozioView negozioView;
    private OrdineView new_ordine = new OrdineView();
    
    private String[] utenti={"segreteria","magazzino","gestioneNegozio"};
    private String[] password={"ciao1234","salut1234","privet1234"};
    
    
    public NegozioController(NegozioView negView, Negozio negozio){
        
        this.negozio = negozio;
        this.negozioView = negView;
        negozioView.setBounds(310, 310, 360, 290);
        negozioView.addActionListener(this);
        negozioView.setVisible(true);
        negozioView.setResizable(false);
        new_ordine.addActionListeners(this);
        new_ordine.setResizable(false);
        new_ordine.setBounds(310, 310, 400, 400);
        
        
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource() == negozioView.indietro){
            negozioView.setVisible(false);
            LoginController login = new LoginController(new LoginView(), new Login(utenti, password));
        }
        
        if( e.getSource() == negozioView.inserisci_ordine){
            negozioView.setVisible(false);
            new_ordine.setVisible(true);
        }
        
        if( e.getSource() == negozioView.shop_list ){
            String codFiscale = "";
            codFiscale = JOptionPane.showInputDialog(null, "Inserire il codice fiscale per confermare la propria identità");
            //controllo codice Fiscale
            
            if( negozioView.shop_list.getSelectedIndex() != -1 ){
                negozioView.inserisci_ordine.setEnabled(true);
                negozioView.visualizza_ordini.setEnabled(true);
            }
            
        }
        
    }
        
}
    
    

