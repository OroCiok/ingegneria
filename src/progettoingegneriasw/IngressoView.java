/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ionbaltaga
 */
public class IngressoView extends JFrame{
    Label label_tipo_articolo, label_posizione, label_quantita,label_intro;
    JComboBox<String> posizione_box;
    JButton back, aggiungi_ingresso, aggiungi_articolo;
    JTextField field_quantita;
    
    JTable ingressi_table,articoli_table;
    DefaultTableModel table_model, table_model_ingressi;
    JScrollPane js,js1;
    JPanel ing,table_panel,ingressi_table_panel;

    Container container = getContentPane();

    IngressoView() {
        container.setLayout(null);
        setTitle("Inserimento Ingresso in Magazzino");
        String posizioni[]={"alto","medio","basso"};
        posizione_box=new JComboBox<>(posizioni);


        field_quantita=new JTextField(20);
        
        label_tipo_articolo = new Label("Scegli l'articolo");
        
        label_posizione=new Label("Posizione");
        label_quantita=new Label("Quantità");
        label_intro = new Label("Compila i seguenti campi");
        back=new JButton("Indietro");
        aggiungi_ingresso=new JButton("Aggiungi ingresso");
        aggiungi_articolo=new JButton("Aggiungi articolo"); 
        
        
        ing=new JPanel();
        ing.setLayout(null);
        label_intro.setBounds(5,10,200,30);
        label_tipo_articolo.setBounds(5, 40, 150, 30);
        Magazzino.getInstance().getArticoli_box().setBounds(160, 40, 300, 30);
        
        
        label_posizione.setBounds(5,70,150,30);
        posizione_box.setBounds(160,70,100,30);
        
        label_quantita.setBounds(270,70,70,30);
        field_quantita.setBounds(350,70,100,30);
                
        aggiungi_articolo.setBounds(5,100,150,30);
        
    	aggiungi_ingresso.setBounds(200, 100, 150, 30);
        back.setBounds(5, 130, 150, 30);
      
        
        
        ing.add(label_tipo_articolo);
        ing.add(label_intro);
        ing.add(Magazzino.getInstance().getArticoli_box());

        
        
        ing.add(label_posizione);
        ing.add(posizione_box);
        ing.add(aggiungi_articolo);
        ing.add(label_quantita);
        ing.add(field_quantita);
        ing.add(aggiungi_ingresso);
        ing.add(back);
        ing.setBounds(5,5,500,200);
        container.add(ing);
        
        String colum[] = {"Articolo", "Prezzo","Data di produzione","Posizione","Quantità"}; 
        table_model = new DefaultTableModel(colum, 0); 
        articoli_table = new JTable(table_model); 
        js = new JScrollPane(articoli_table);
        articoli_table.setAutoscrolls(true); 
        articoli_table.setEnabled(true);
        table_panel = new JPanel();
        table_panel.add(js);
        table_panel.setBounds(500, 5, 500, 100);
        container.add(table_panel); 
        
        String columingressi[] = {"ID Ingresso", "DataIngresso"};
        table_model_ingressi= new DefaultTableModel(columingressi,0);
        ingressi_table=new JTable(table_model_ingressi); 
        js1 = new JScrollPane(ingressi_table); 
        ingressi_table.setAutoscrolls(true); 
        ingressi_table.setEnabled(false);
        ingressi_table_panel=new JPanel();
        ingressi_table_panel.add(js1);
        ingressi_table_panel.setBounds(500, 105, 500, 100);
        container.add(ingressi_table_panel); 
        
        

        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public void addActionListeners(ActionListener e) {
        back.addActionListener(e);
        aggiungi_articolo.addActionListener(e);
        aggiungi_ingresso.addActionListener(e);
       
    }
 
}
