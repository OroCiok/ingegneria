/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author dicatterinamatteo
 */
public class VisualizzaCreaOrdiniNegozioView extends JFrame {

    JButton inserisci_ordine, visualizza_ordini, indietro;
    Label opzioni = new Label("Informazioni negozio"), label_nome, label_sede, label_via, label_codFiscale;
    JTextField nome, sede, via, cod_fiscale;

    private Negozio negozio;
    int i;

    VisualizzaCreaOrdiniNegozioView(Segreteria segreteria, Negozio negozio) {

        this.negozio = negozio;
        Container container = getContentPane();
        container.setLayout(null);
        setTitle("Negozio " + negozio.getNome());

        nome = new JTextField(negozio.getNome());
        sede = new JTextField(negozio.getCittà());
        via = new JTextField(negozio.getIndirizzo());
        cod_fiscale = new JTextField(negozio.getCodFiscale());

        label_nome = new Label("Nome negozio");
        label_sede = new Label("Sede");
        label_via = new Label("Indirizzo");
        label_codFiscale = new Label("Codice Responsabile");

        nome.setEditable(false);
        sede.setEditable(false);
        via.setEditable(false);
        cod_fiscale.setEditable(false);

        label_nome.setBounds(5, 45, 130, 20);
        label_sede.setBounds(5, 70, 130, 20);
        label_via.setBounds(5, 95, 130, 20);
        label_codFiscale.setBounds(5, 120, 130, 20);

        inserisci_ordine = new JButton("Crea Ordine");
        visualizza_ordini = new JButton("Visualizza ordini");
        indietro = new JButton("Logout");

        opzioni.setBounds(5, 12, 300, 15);

        visualizza_ordini.setBounds(15, 180, 150, 30);
        inserisci_ordine.setBounds(235, 180, 150, 30);
        indietro.setBounds(125, 230, 150, 30);

        nome.setBounds(150, 45, 225, 20);
        sede.setBounds(150, 70, 225, 20);
        via.setBounds(150, 95, 225, 20);
        cod_fiscale.setBounds(150, 120, 225, 20);

        inserisci_ordine.setEnabled(true);
        visualizza_ordini.setEnabled(true);

        container.add(indietro);
        container.add(opzioni);
        container.add(inserisci_ordine);
        container.add(visualizza_ordini);
        container.add(label_nome);
        container.add(label_sede);
        container.add(label_via);
        container.add(label_codFiscale);
        container.add(nome);
        container.add(sede);
        container.add(via);
        container.add(cod_fiscale);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addActionListener(ActionListener l) {
        visualizza_ordini.addActionListener(l);
        inserisci_ordine.addActionListener(l);
        indietro.addActionListener(l);
    }

}
