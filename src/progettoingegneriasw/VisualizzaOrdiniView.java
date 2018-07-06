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
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dicatterinamatteo
 */
public class VisualizzaOrdiniView extends JFrame {

    JComboBox ordini = new JComboBox();
    JTable order_table;
    JButton menu_principale, visualizza, modifica_ordine, elimina_ordine, aggiungi_articoli, elimina_articoli, modifica_quantità;
    JPanel pnlButton_indietro, ordine_panel;
    Container container = getContentPane();
    JTextField tot_ordine, stato;
    Label num_ordine = new Label("Selezionare numero ordine"), totale = new Label("Totale Ordine €"), stato_ordine;

    public DefaultTableModel table_model;

    String codFiscale;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    VisualizzaOrdiniView(Segreteria segreteria, String codFiscale) {

        this.codFiscale = codFiscale;

        container.setLayout(new BorderLayout());
        setTitle("Ordini recenti");
        String colum[] = {"Data ordine", "Codice Articolo", "Nome articolo", "Quantità", "Prezzo Articoli"};
        stato_ordine = new Label("Stato Ordine ");
        menu_principale = new JButton("Indietro");
        visualizza = new JButton("Visualizza Dettagli Ordine");
        aggiungi_articoli = new JButton("Aggiungi Articolo");
        elimina_ordine = new JButton("Annulla ordine");
        modifica_quantità = new JButton("Modifica quantità");
        elimina_articoli = new JButton("Elimina Articolo");
        modifica_ordine = new JButton("Modifica/Annulla Ordine");
        pnlButton_indietro = new JPanel();
        tot_ordine = new JTextField("                                           ");
        stato = new JTextField("                                           ");
        tot_ordine.setEditable(false);
        stato.setEditable(false);
        pnlButton_indietro.setLayout(new FlowLayout(FlowLayout.CENTER));
        ordine_panel = new JPanel();
        ordine_panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ordine_panel.add(num_ordine);
        ordine_panel.add(ordini);
        ordine_panel.add(visualizza);
        
        ordine_panel.add(modifica_ordine);
        ordine_panel.add(totale);
        ordine_panel.add(tot_ordine);

        for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
            if (Magazzino.getInstance().getOrdini().get(i).getNegozio().getCodFiscale().equals(codFiscale)) {
                ordini.addItem("" + abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()));
            }
        }
        
        
        table_model = new DefaultTableModel(colum, 0);
        order_table = new JTable(table_model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0 || column == 1 || column == 2 || column == 3 ||column == 4 ? false : true;
            }
        };

        order_table.getTableHeader().setReorderingAllowed(false);    
        JScrollPane js = new JScrollPane(order_table);
        order_table.setAutoscrolls(true);
        order_table.setEnabled(false);
        container.add(js);

        aggiungi_articoli.setEnabled(false);
        elimina_articoli.setEnabled(false);
        elimina_ordine.setEnabled(false);
        modifica_quantità.setEnabled(false);
        pnlButton_indietro.add(menu_principale);
        pnlButton_indietro.add(modifica_quantità);
        pnlButton_indietro.add(aggiungi_articoli);
        pnlButton_indietro.add(elimina_articoli);
        pnlButton_indietro.add(elimina_ordine);

        ordine_panel.add(stato_ordine);
        ordine_panel.add(stato);

        container.add(pnlButton_indietro, BorderLayout.SOUTH);
        container.add(ordine_panel, BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListeners(ActionListener e) {
        menu_principale.addActionListener(e);
        ordini.addActionListener(e);
        visualizza.addActionListener(e);
        elimina_ordine.addActionListener(e);
        modifica_ordine.addActionListener(e);
        aggiungi_articoli.addActionListener(e);
        elimina_articoli.addActionListener(e);
        modifica_quantità.addActionListener(e);
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getCodFiscale() {
        return this.codFiscale;
    }
}
