/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

/**
 *
 * @author ionbaltaga
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;

public class SegreteriaController implements ActionListener {

    private SegreteriaView segreteriaView;
    private Segreteria segreteria;

    private TipoArticoloView new_type = new TipoArticoloView();

    private ArticoloView new_articolo = new ArticoloView();

    private MovimentiMagazzinoView movimenti_magazzino_view = new MovimentiMagazzinoView();

    private String[] utenti = {"segreteria", "magazzino", "gestioneNegozio"};
    private String[] password = {"ciao1234", "salut1234", "privet1234"};

    public SegreteriaController(SegreteriaView segreteriaView, Segreteria Segreteria) {
        this.segreteriaView = segreteriaView;
        this.segreteria = Segreteria;
        segreteriaView.addActionListeners(this);
        segreteriaView.setVisible(true);
        segreteriaView.setResizable(false);
        segreteriaView.setBounds(275, 275, 360, 420);
        new_type.addActionListeners(this);
        new_type.setVisible(false);
        new_type.setBounds(275, 275, 630, 225);
        new_type.setResizable(false);
        movimenti_magazzino_view.addActionListeners(this);
        movimenti_magazzino_view.setVisible(false);
        movimenti_magazzino_view.setBounds(310, 310, 1500, 410);
        movimenti_magazzino_view.setResizable(false);
        new_articolo.addActionListeners(this);
        new_articolo.setVisible(false);
        new_articolo.setBounds(275, 275, 500, 180);
        new_articolo.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == segreteriaView.termina) {
            System.exit(0);
        }

        if (e.getSource() == segreteriaView.cambia_utente) {
            segreteriaView.setVisible(false);
            LoginController login = new LoginController(new LoginView(), new Login(utenti, password),Magazzino.getInstance());
        }

        if (e.getSource() == segreteriaView.inserisci_tipoart) {
            segreteriaView.setVisible(false);
            new_type.setVisible(true);
        }
        if (e.getSource() == segreteriaView.visualizzaMovimenti) {
            segreteriaView.setVisible(false);
            movimenti_magazzino_view.setVisible(true);
            movimenti_magazzino_view.ingressi.setSelectedIndex(-1);

        }
        if (e.getSource() == movimenti_magazzino_view.back) {
            segreteriaView.setVisible(true);
            movimenti_magazzino_view.setVisible(false);
        }

        if (e.getSource() == new_type.menu_principale) {
            segreteriaView.setVisible(true);
            new_type.setVisible(false);
        }

        if (e.getSource() == new_type.inserisci_nuovo_tipo) {
            if (new_type.nome.getText().equals("") || new_type.descrizione.getText().equals("") || new_type.sport.getText().equals("") || new_type.materiale.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Impossibile inserire il nuovo tipo articolo, è necessario compilare tutti i campi.");
            } else {
                TipoArticolo tipoArticolo = new TipoArticolo(new_type.nome.getText(), new_type.descrizione.getText(), new_type.sport.getText(), new_type.materiale.getText());
                //applicato su variabile statica
                Magazzino.getInstance().addTipoArticolo(tipoArticolo);
                //creato la variabile newingresso statica, da vedere dopo se è giusto fare cosi
                Magazzino.getInstance().getTipi_articoli_box().addItem(tipoArticolo.toString());
                new_type.descrizione.setText("");
                new_type.materiale.setText("");
                new_type.nome.setText("");
                new_type.sport.setText("");
                JOptionPane.showMessageDialog(null, "Tipo Articolo salvato correttamente in memoria");
            }
        }
        //action listener per la visualizzazione dei movimenti in magazzino
        if (e.getSource() == movimenti_magazzino_view.visualizza_botton) {
            movimenti_magazzino_view.table_model.setRowCount(0);

            int pos = movimenti_magazzino_view.ingressi.getSelectedIndex();

            String nome_articolo, ingresso_date, articolo_quantity, articolo_position;

            for (Articolo articolo : Magazzino.getInstance().getIngressi().get(pos).getArticoli().keySet()) {
                ingresso_date = Magazzino.getInstance().getIngressi().get(pos).getData();
                nome_articolo = articolo.getTypeArticle().getNome();
                articolo_position = Magazzino.getInstance().getIngressi().get(pos).getArticoli().get(articolo);
                articolo_quantity = "" + Magazzino.getInstance().getMappa_articolo_quantita().get(articolo);

                Object[] riga = {ingresso_date, nome_articolo, articolo_position, articolo_quantity};
                movimenti_magazzino_view.table_model.addRow(riga);
            }
        }
        if (e.getSource() == segreteriaView.inserisci_art) {
            new_articolo.tipo_articolo_box.setSelectedIndex(-1);
            new_articolo.setVisible(true);
            segreteriaView.setVisible(false);
        }
        if (e.getSource() == new_articolo.back) {
            new_articolo.setVisible(false);
            segreteriaView.setVisible(true);
        }
        //action listener per quando si crea la view per aggiungere un articolo
        if (e.getSource() == new_articolo.aggiungi_articolo) {
            //controllo che sia selezionato un tipo di articolo
            if (new_articolo.tipo_articolo_box.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Seleziona un tipo di articolo");
            } //controllo che il prezzo non contenga un carattere stringa
            else if (isDouble(new_articolo.field_prezzo.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Il prezzo non deve contenere caratteri alfabetici o deve essere compilato\n usa . al posto di ,");
            } 
            //controllo che gg non contenga un carattere stringa
            else if (isInt(new_articolo.field_gg.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Il giorno non deve contenere caratteri alfabetici o deve essere compilato");
            }
            //controllo che gmm non contenga un carattere stringa
            else if (isInt(new_articolo.field_mm.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Il mese non deve contenere caratteri alfabetici o deve essere compilato");
            }
            //controllo che aaaa non contenga un carattere stringa
            else if (isDouble(new_articolo.field_aaaa.getText()) == false) {
                JOptionPane.showMessageDialog(null, "L'anno non deve contenere caratteri alfabetici o deve essere compilato");
            }
            else if (Integer.parseInt(new_articolo.field_gg.getText()) > 31 || Integer.parseInt(new_articolo.field_gg.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "Il giorno non puo essere maggiore di 31 e deve essere un valore positivo maggiore di 0");
            }
            else if (Integer.parseInt(new_articolo.field_mm.getText()) > 12 || Integer.parseInt(new_articolo.field_mm.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "Il mese non puo essere maggiore di 12 e deve essere un valore positivo maggiore di 0");
            }
            else if (Integer.parseInt(new_articolo.field_aaaa.getText()) > LocalDateTime.now().getYear() || Integer.parseInt(new_articolo.field_aaaa.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "Non puoi viaggiare nel fututo e l'anno deve essere un valore positivo maggiore di 0");
            }
            
            
            else {
                Data data_produzione = new Data(Integer.parseInt(new_articolo.field_gg.getText()), Integer.parseInt(new_articolo.field_mm.getText()), Integer.parseInt(new_articolo.field_aaaa.getText()));
                TipoArticolo tipoArt = Magazzino.getInstance().getTipoArticolo(new_articolo.tipo_articolo_box.getSelectedIndex());
                Articolo art = new Articolo(tipoArt, Double.parseDouble(new_articolo.field_prezzo.getText()), data_produzione);
                Magazzino.getInstance().getCatalogoArticoliMagazzino().add(art);//aggiungo articolo all'array di articoli
                Magazzino.getInstance().getArticoli_box().addItem(tipoArt.getNome()+" "+art.getPrice()+" euro");//aggiungo articoli alla box

                new_articolo.field_gg.setText("");
                new_articolo.field_mm.setText("");
                new_articolo.field_aaaa.setText("");
                new_articolo.field_prezzo.setText("");

                new_articolo.tipo_articolo_box.setSelectedIndex(-1);
                Magazzino.getInstance().getTipi_articoli_box().setSelectedIndex(-1);
            }
        }

    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;//non è un double
        }
    }
    public boolean isInt(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;//non è un intero
        }
    }
}
