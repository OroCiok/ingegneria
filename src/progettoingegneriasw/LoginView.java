/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.TextField;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ionbaltaga
 */
public class LoginView extends JFrame{
    ActionListener l;
    TextField pass;
    Button exit, login;
    ButtonGroup bG = new ButtonGroup();
    Label dsc, psw;
    JRadioButton segreteria = new JRadioButton("Segreteria");
    JRadioButton magazzino = new JRadioButton("Magazzino");
    JRadioButton gestioneNegozio = new JRadioButton("gestioneNegozio");
    

    LoginView() {
        JPanel content = new JPanel();
        GridLayout experimentLayout = new GridLayout(10,0);
        content.setLayout(experimentLayout);
        

        bG.add(segreteria);
        bG.add(magazzino);
        bG.add(gestioneNegozio);
        dsc = new Label("Seleziona utente e inserire password", Label.CENTER);
        psw = new Label("Password", Label.CENTER);

        pass = new TextField(20);
        pass.setEchoChar('*');
        login = new Button("Login");
        exit = new Button("Esci");

        content.add(dsc);
        content.add(segreteria);
        content.add(magazzino);
        content.add(gestioneNegozio);
        content.add(psw);
        
        content.add(pass);
        content.add(exit);
        content.add(login);
        
        dsc.setBounds(70, 50, 250, 20);
        segreteria.setBounds(70, 90, 150, 60);
        magazzino.setBounds(70, 130, 150, 60);
        gestioneNegozio.setBounds(70, 170, 150, 60);
        psw.setBounds(70, 230, 90, 20);
        pass.setBounds(170, 230, 90, 20);
        exit.setBounds(70, 290, 100, 40);
        login.setBounds(230, 290, 100, 40);
        this.setContentPane(content);
        this.pack();
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
        System.out.println(""+pass.getText());
        return pass.getText();
    }
    
    public void addActionListeners(ActionListener e){
        exit.addActionListener(e);
        login.addActionListener(e);
    }
    
    public Button[] getButtons(){
        Button[] temp = new Button[2];
        temp[0] = exit;
        temp[1] = login;
        return temp;
    }

}
