package progettoingegneriasw;

/**
 *
 * @author dicatterinamatteo
 */
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AggiungiArticoloView extends JFrame {

    private static int order_number;

    JButton indietro, aggiungi;
    JTextField totale;
    JComboBox articoli;
    JComboBox quantità;
    Label descrizione, tipo_articolo, prezzo_totale, quantità_articolo;

    Container container = getContentPane();

    AggiungiArticoloView() {

        container.setLayout(null);
        indietro = new JButton("Indietro");
        aggiungi = new JButton("Aggiungi Articolo");

        descrizione = new Label("Scegliere un valore nei seguenti campi per aggiungere l'articolo desiderato");
        tipo_articolo = new Label("Tipo Articolo");
        prezzo_totale = new Label("Tot. Prezzo Articoli €");
        quantità_articolo = new Label("Quantità ");
        totale = new JTextField();
        totale.setText("0,00 €");
        articoli = new JComboBox();
        quantità = new JComboBox();

        quantità.addItem("5");
        quantità.addItem("10");
        quantità.addItem("20");
        quantità.addItem("30");
        quantità.addItem("40");
        quantità.addItem("50");
        quantità.addItem("60");
        quantità.addItem("70");
        quantità.addItem("80");
        quantità.addItem("90");
        quantità.addItem("100");

        for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
            articoli.addItem(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString());
        }

        descrizione.setBounds(15, 10, 500, 20);
        tipo_articolo.setBounds(15, 50, 150, 20);
        articoli.setBounds(190, 50, 400, 20);
        indietro.setBounds(15, 170, 200, 30);
        aggiungi.setBounds(480, 170, 200, 30);
        quantità_articolo.setBounds(15, 90, 150, 20);
        quantità.setBounds(190, 90, 70, 20);
        prezzo_totale.setBounds(15, 130, 150, 20);
        totale.setBounds(190,130, 100, 20);
        articoli.setSelectedIndex(-1);
        quantità.setSelectedIndex(-1);
        
        quantità.setEnabled(false);
        quantità.setEditable(false);
        totale.setEditable(false);
        aggiungi.setEnabled(false);
        container.add(indietro);
        container.add(aggiungi);
        container.add(descrizione);
        container.add(tipo_articolo);
        container.add(articoli);
        container.add(quantità);
        container.add(quantità_articolo);
        container.add(totale);
        container.add(prezzo_totale);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListeners(ActionListener e) {
        aggiungi.addActionListener(e);
        indietro.addActionListener(e);
        articoli.addActionListener(e);
        quantità.addActionListener(e);
    }

}
