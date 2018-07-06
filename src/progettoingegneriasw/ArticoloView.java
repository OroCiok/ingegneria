/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author ionbaltaga
 */
public class ArticoloView extends JFrame {

    Label label_tipo_articolo,label_prezzo,label_data;
    JComboBox<String> tipo_articolo_box = Magazzino.getInstance().getTipi_articoli_box();
    JButton back, aggiungi_articolo;
    JTextField field_prezzo,field_gg,field_mm,field_aaaa;
    Container container = getContentPane();

    ArticoloView() {
        container.setLayout(null);
        setTitle("Inserimento di un Articolo");
        
        label_tipo_articolo= new Label("Scegli il tipo di articolo");
        label_prezzo=new Label("Prezzo");
        field_prezzo=new JTextField(30);
        label_data=new Label("Data");
        field_gg=new JTextField(2);
        field_mm=new JTextField(2);
        field_aaaa=new JTextField(4);
        back=new JButton("Indietro");
        aggiungi_articolo=new JButton("Aggiungi articolo");
        
        
        label_tipo_articolo.setBounds(5,5,200,30);
        tipo_articolo_box.setBounds(210,5,280,30);
        label_prezzo.setBounds(5,40,200,30);
        field_prezzo.setBounds(210,40,50,30);
        label_data.setBounds(5,75,200,30);
        field_gg.setBounds(210,75,50,30);
        field_mm.setBounds(270,75,50,30);
        field_aaaa.setBounds(330,75,50,30);
        aggiungi_articolo.setBounds(5,110,200,30);
        back.setBounds(210,110,200,30);
        
        
        
        container.add(label_tipo_articolo);
        container.add(tipo_articolo_box);
        container.add(label_prezzo);
        container.add(field_prezzo);
        container.add(label_data);
        container.add(field_gg);
        container.add(field_mm);
        container.add(field_aaaa);
        container.add(back);
        container.add(aggiungi_articolo);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void addActionListeners(ActionListener e) {
        back.addActionListener(e);
        aggiungi_articolo.addActionListener(e);
    }
}
