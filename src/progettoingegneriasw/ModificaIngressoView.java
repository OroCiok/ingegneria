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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ionbaltaga
 */
public class ModificaIngressoView extends JFrame {

    Label label_seleziona_ingresso;
    JScrollPane js2;
    JTable art_table;
    DefaultTableModel table_model_art;
    JPanel art_table_panel, header_panel, bottons_panel;
    JButton back, modifica_pos;

    Container container = getContentPane();

    ModificaIngressoView() {
        container.setLayout(new BorderLayout());
        setTitle("Modifica posizione di un ingresso");
        label_seleziona_ingresso = new Label("Seleziona l'articolo a cui cambiare posizione");
        back = new JButton("indietro");
        modifica_pos = new JButton("Modifica");

        header_panel = new JPanel();
        header_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        header_panel.add(label_seleziona_ingresso);

        bottons_panel = new JPanel();
        bottons_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottons_panel.add(back);
        bottons_panel.add(modifica_pos);

        String columarticoli[] = {"ID Ingresso", "Articolo", "Posizione"};
        table_model_art = new DefaultTableModel(columarticoli, 0);
        art_table = new JTable(table_model_art);
        js2 = new JScrollPane(art_table);
        art_table.setAutoscrolls(true);
        art_table.setEnabled(true);

        container.add(js2);
        container.add(header_panel, BorderLayout.NORTH);
        container.add(bottons_panel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addActionListeners(ActionListener e) {
        back.addActionListener(e);
    }

}
