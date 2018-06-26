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
 * @author ionbaltaga
 */
public class SegreteriaController implements ActionListener{
    private SegreteriaView segreteriaView;
    private Segreteria segreteria;

    public SegreteriaController(SegreteriaView segreteriaView, Segreteria Segreteria) {
        this.segreteriaView = segreteriaView;
        this.segreteria = Segreteria;
        segreteriaView.addActionListeners(this);
        segreteriaView.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == segreteriaView.back) {
        
        }
    }
 
}
