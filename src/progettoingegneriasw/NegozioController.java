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

    public NegozioController(NegozioView negView, Negozio negozio){
        this.negozio = negozio;
        this.negozioView = negView;
        negView.setBounds(275, 275, 360, 290);
        negView.addActionListener(this);
        negView.setVisible(true);
        negView.setResizable(false);
        
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}
