/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

/**
 *
 * @author dicatterinamatteo
 */
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class NuovoOrdineView extends JFrame {

    private Date current_date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static String codFiscale = "";

    Label description, label_data_ordine, label_quantità, label_articolo, label_prezzo;
    JButton menu_principale, invia_ordine;
    JTextField data, tot_ordine;
    JComboBox quantità1_comboBox = new JComboBox(), quantità2_comboBox = new JComboBox(), quantità3_comboBox = new JComboBox(), quantità4_comboBox = new JComboBox(),
            quantità5_comboBox = new JComboBox(), tipo_articolo1 = new JComboBox(), tipo_articolo2 = new JComboBox(),
            tipo_articolo3 = new JComboBox(), tipo_articolo4 = new JComboBox(), tipo_articolo5 = new JComboBox();
    
    Container container = getContentPane();

    NuovoOrdineView() {

        this.codFiscale = codFiscale;

        container.setLayout(null);
        setTitle("Inserimento nuovo ordine");
        description = new Label("Compilare i seguenti campi per effettuare l'ordine");

        label_data_ordine = new Label("Data ordine ");
        label_quantità = new Label("Quantità ");
        label_articolo = new Label("Tipo Articolo ");
        label_prezzo = new Label("Tot. Ordine  €");

        menu_principale = new JButton("Indietro");
        invia_ordine = new JButton("Invia Ordine");

        data = new JTextField(" " + sdf.format(current_date));
        tot_ordine = new JTextField("0,00 €");

        description.setBounds(5, 5, 600, 15);
        label_data_ordine.setBounds(5, 35, 130, 15);
        label_articolo.setBounds(5, 65, 130, 15);
        label_quantità.setBounds(690, 40, 130, 15);
        label_prezzo.setBounds(170, 220, 100, 20);

        data.setBounds(170, 30, 90, 20);
        data.setEditable(false);

        tipo_articolo1.setBounds(170, 60, 500, 20);
        tipo_articolo2.setBounds(170, 90, 500, 20);
        tipo_articolo3.setBounds(170, 120, 500, 20);
        tipo_articolo4.setBounds(170, 150, 500, 20);
        tipo_articolo5.setBounds(170, 180, 500, 20);

        quantità1_comboBox.setBounds(690, 60, 60, 20);
        quantità2_comboBox.setBounds(690, 90, 60, 20);
        quantità3_comboBox.setBounds(690, 120, 60, 20);
        quantità4_comboBox.setBounds(690, 150, 60, 20);
        quantità5_comboBox.setBounds(690, 180, 60, 20);

        tot_ordine.setEditable(false);
        tot_ordine.setBounds(300, 220, 85, 20);

        invia_ordine.setBounds(25, 280, 250, 30);
        menu_principale.setBounds(515, 280, 250, 30);

        for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
            tipo_articolo1.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());
            tipo_articolo2.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());
            tipo_articolo3.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());
            tipo_articolo4.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());
            tipo_articolo5.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());

        }

        tipo_articolo1.setSelectedIndex(-1);
        tipo_articolo2.setSelectedIndex(-1);
        tipo_articolo3.setSelectedIndex(-1);
        tipo_articolo4.setSelectedIndex(-1);
        tipo_articolo5.setSelectedIndex(-1);

        quantità1_comboBox.addItem("5");
        quantità1_comboBox.addItem("10");
        quantità1_comboBox.addItem("20");
        quantità1_comboBox.addItem("30");
        quantità1_comboBox.addItem("40");
        quantità1_comboBox.addItem("50");
        quantità1_comboBox.addItem("60");
        quantità1_comboBox.addItem("70");
        quantità1_comboBox.addItem("80");
        quantità1_comboBox.addItem("90");
        quantità1_comboBox.addItem("100");
        quantità2_comboBox.addItem("5");
        quantità2_comboBox.addItem("10");
        quantità2_comboBox.addItem("20");
        quantità2_comboBox.addItem("30");
        quantità2_comboBox.addItem("40");
        quantità2_comboBox.addItem("50");
        quantità2_comboBox.addItem("60");
        quantità2_comboBox.addItem("70");
        quantità2_comboBox.addItem("80");
        quantità2_comboBox.addItem("90");
        quantità2_comboBox.addItem("100");
        quantità3_comboBox.addItem("5");
        quantità3_comboBox.addItem("10");
        quantità3_comboBox.addItem("20");
        quantità3_comboBox.addItem("30");
        quantità3_comboBox.addItem("40");
        quantità3_comboBox.addItem("50");
        quantità3_comboBox.addItem("60");
        quantità3_comboBox.addItem("70");
        quantità3_comboBox.addItem("80");
        quantità3_comboBox.addItem("40");
        quantità3_comboBox.addItem("50");
        quantità3_comboBox.addItem("60");
        quantità3_comboBox.addItem("70");
        quantità3_comboBox.addItem("80");
        quantità3_comboBox.addItem("90");
        quantità3_comboBox.addItem("100");
        quantità4_comboBox.addItem("5");
        quantità4_comboBox.addItem("10");
        quantità4_comboBox.addItem("20");
        quantità4_comboBox.addItem("30");
        quantità4_comboBox.addItem("40");
        quantità4_comboBox.addItem("50");
        quantità4_comboBox.addItem("60");
        quantità4_comboBox.addItem("70");
        quantità4_comboBox.addItem("80");
        quantità4_comboBox.addItem("90");
        quantità4_comboBox.addItem("100");
        quantità5_comboBox.addItem("5");
        quantità5_comboBox.addItem("10");
        quantità5_comboBox.addItem("20");
        quantità5_comboBox.addItem("30");
        quantità5_comboBox.addItem("40");
        quantità5_comboBox.addItem("50");
        quantità5_comboBox.addItem("60");
        quantità5_comboBox.addItem("70");
        quantità5_comboBox.addItem("80");
        quantità5_comboBox.addItem("90");
        quantità5_comboBox.addItem("100");

        quantità1_comboBox.setSelectedIndex(-1);
        quantità2_comboBox.setSelectedIndex(-1);
        quantità3_comboBox.setSelectedIndex(-1);
        quantità4_comboBox.setSelectedIndex(-1);
        quantità5_comboBox.setSelectedIndex(-1);

        tipo_articolo1.setEditable(false);
        tipo_articolo2.setEditable(false);
        tipo_articolo3.setEditable(false);
        tipo_articolo4.setEditable(false);
        tipo_articolo5.setEditable(false);
        quantità1_comboBox.setEditable(false);
        quantità2_comboBox.setEditable(false);
        quantità3_comboBox.setEditable(false);
        quantità4_comboBox.setEditable(false);
        quantità5_comboBox.setEditable(false);

        quantità1_comboBox.setEnabled(false);
        quantità2_comboBox.setEnabled(false);
        quantità3_comboBox.setEnabled(false);
        quantità4_comboBox.setEnabled(false);
        quantità5_comboBox.setEnabled(false);

        invia_ordine.setEnabled(false);

        tipo_articolo2.setEnabled(false);
        tipo_articolo3.setEnabled(false);
        tipo_articolo4.setEnabled(false);
        tipo_articolo5.setEnabled(false);

        container.add(description);
        container.add(menu_principale);
        container.add(invia_ordine);
        container.add(label_data_ordine);
        container.add(label_quantità);
        container.add(label_articolo);
        container.add(data);
        container.add(quantità1_comboBox);
        container.add(quantità2_comboBox);
        container.add(quantità3_comboBox);
        container.add(quantità4_comboBox);
        container.add(quantità5_comboBox);
        container.add(tipo_articolo1);
        container.add(tipo_articolo2);
        container.add(tipo_articolo3);
        container.add(tipo_articolo4);
        container.add(tipo_articolo5);
        container.add(tot_ordine);
        container.add(label_prezzo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListeners(ActionListener e) {
        invia_ordine.addActionListener(e);
        menu_principale.addActionListener(e);
        quantità1_comboBox.addActionListener(e);
        quantità2_comboBox.addActionListener(e);
        quantità3_comboBox.addActionListener(e);
        quantità4_comboBox.addActionListener(e);
        quantità5_comboBox.addActionListener(e);
        tipo_articolo1.addActionListener(e);
        tipo_articolo2.addActionListener(e);
        tipo_articolo3.addActionListener(e);
        tipo_articolo4.addActionListener(e);
        tipo_articolo5.addActionListener(e);

    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getCodFiscale() {
        return this.codFiscale;
    }

    public boolean isCellEditable(int row, int col) {
        if (col < 2) {   //columns 0 and 1 are not editable everything else is
            return false;
        } else {
            return true;
        }
    }
}
