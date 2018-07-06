/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ionbaltaga
 */
public class MagazzinoView extends JFrame {

    JButton bottone_ingresso,bottone_uscita,bottone_modifica_ingresso,bottone_inventario,back;
    Container container = getContentPane();

    MagazzinoView() {
        container.setLayout(null);
        setTitle("Magazziniere");

        bottone_ingresso = new JButton("Inserisci ingresso in magazzino");
        bottone_modifica_ingresso=new JButton("Modifica ingresso");
        bottone_uscita = new JButton("Effetua ordine- uscita magazzino");
        bottone_inventario=new JButton("Visualizza l'inventario del magazzino");
        back=new JButton("Indietro");
        
        
        bottone_ingresso.setBounds(25, 50, 300, 30);
        bottone_uscita.setBounds(25,100,300,30);
        bottone_modifica_ingresso.setBounds(25,150,300,30);
        bottone_inventario.setBounds(25,200,300,30);
        back.setBounds(25, 250, 150, 30);
        
        container.add(bottone_ingresso);
        container.add(bottone_uscita);
        container.add(bottone_modifica_ingresso);
        container.add(bottone_inventario);
        container.add(back);
    }

    public void addActionListeners(ActionListener e) {
        bottone_ingresso.addActionListener(e);
        bottone_modifica_ingresso.addActionListener(e);
        bottone_inventario.addActionListener(e);
        back.addActionListener(e);
    }
}
