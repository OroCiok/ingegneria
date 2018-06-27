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
import java.awt.TextField;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class LoginView extends JFrame{
    JButton exit, login;
    Label dsc, password_label;
    JPasswordField password_text = new JPasswordField(20);
    JRadioButton segreteria = new JRadioButton("Segreteria");
    JRadioButton magazzino = new JRadioButton("Gestione Magazzino");
    JRadioButton gestioneNegozio = new JRadioButton("Gestione Negozio");
    ButtonGroup group = new ButtonGroup();
    

    LoginView() {
    	Container content = getContentPane();
    	content.setLayout(null);
    	setTitle("Login utenza");
    	
        dsc = new Label("Selezionare l'utente e inserire la password", Label.CENTER);
        password_label = new Label("Inserire la Password", Label.CENTER);
        
        login = new JButton("Login");
        exit = new JButton("Esci");
        
        group.add(segreteria);
        group.add(magazzino);
        group.add(gestioneNegozio);

        dsc.setBounds(15, 20, 300, 20);
        segreteria.setBounds(15,60,120,20);
        magazzino.setBounds(15,100,180,20);
        gestioneNegozio.setBounds(15,140,180,20);
        password_label.setBounds(15,180,130,20);
        password_text.setBounds(15,200,250,30);
        login.setBounds(15,275,110,30);
        exit.setBounds(220,275,110,30);
        
        
        
        password_text.disable();
        
        content.add(dsc);
        content.add(segreteria);
        content.add(magazzino);
        content.add(gestioneNegozio);
        content.add(password_label);
        
        content.add(password_text);
        content.add(login);
        content.add(exit);
        
        segreteria.addActionListener(new EnableListener());
        magazzino.addActionListener(new EnableListener());
        gestioneNegozio.addActionListener(new EnableListener());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public String getUser() {
    	   		
        if (this.segreteria.isSelected())
            return "segreteria";    
        if (this.magazzino.isSelected())
            return "magazzino";
        if (this.gestioneNegozio.isSelected())    
            return "gestioneNegozio";
        
        return "";
        
    }
    public String getPassword() {
        return password_text.getText();
    }
    
    public void addActionListeners(ActionListener e){
        exit.addActionListener(e);
        login.addActionListener(e);
    }
    
    
    private class EnableListener implements ActionListener {
   
    	public void actionPerformed(ActionEvent e)   
    	{
    		if(segreteria.isSelected() || magazzino.isSelected() || gestioneNegozio.isSelected()){
    			password_text.enable();
    		}
    	}
    }

}
