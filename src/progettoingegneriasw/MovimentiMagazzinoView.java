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
import static java.lang.Math.abs;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ionbaltaga
 */
public class MovimentiMagazzinoView extends JFrame {
    Container container = getContentPane();
    JButton back,visualizza_botton;
    DefaultTableModel table_model;
    JTable order_table;
    JScrollPane js;
    JPanel ingressi_panel, back_panel; 
    Label num_ingresso;
    JComboBox ingressi; 
    
    
    MovimentiMagazzinoView(){
        container.setLayout(new BorderLayout()); 
    	setTitle("Movimenti Magazzino");
        num_ingresso = new Label("Selezionare numero ingresso");
        ingressi = new JComboBox();
        back = new JButton("Indietro");
        visualizza_botton = new JButton("Visualizza");
        
        ingressi_panel = new JPanel(); 
        ingressi_panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ingressi_panel.add(num_ingresso);
        ingressi_panel.add(ingressi);
        ingressi_panel.add(visualizza_botton);
        
        for (int i=0;i<Magazzino.getInstance().getIngressi().size();i++){
            ingressi.addItem(abs(Magazzino.getInstance().getIngressi().get(i).getCodIntUnivoco()));
        }
        
        back_panel=new JPanel();
        back_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        back_panel.add(back);
        
        String colum[] = {"Data Ingresso", "Articolo", "Posizione","Quantità"}; 
        table_model = new DefaultTableModel(colum, 0); 
        order_table = new JTable(table_model); 
        JScrollPane js = new JScrollPane(order_table); 
        order_table.setAutoscrolls(true); 
        order_table.setEnabled(false);
        
        container.add(js); 
        container.add(ingressi_panel, BorderLayout.NORTH); 
        container.add(back_panel, BorderLayout.SOUTH); 

        
        back.setBounds(375, 150, 250, 30);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void addActionListeners(ActionListener e){
		 back.addActionListener(e); 
                 visualizza_botton.addActionListener(e);
	 }
}
