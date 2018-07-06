/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author dicatterinamatteo
 */
public class NegozioController implements ActionListener {

    private Negozio negozio;
    private Segreteria segreteria = new Segreteria();

    private VisualizzaCreaOrdiniNegozioView visualizza_crea_ordini_negozioView;
    private NuovoOrdineView nuovo_ordineView;
    private VisualizzaOrdiniView visualizza_ordini_recentiView;
    private AggiungiArticoloView aggiungiArticoloView;

    private String[] utenti = {"segreteria", "magazzino", "gestioneNegozio"};
    private String[] password = {"ciao1234", "salut1234"};

    private static double totale_ordine = 0.0;

    public NegozioController(VisualizzaCreaOrdiniNegozioView negView, Negozio negozio) {

        this.visualizza_crea_ordini_negozioView = negView;
        this.negozio = negozio;
        visualizza_crea_ordini_negozioView.setBounds(310, 310, 410, 310);
        visualizza_crea_ordini_negozioView.addActionListener(this);
        visualizza_crea_ordini_negozioView.setVisible(true);
        visualizza_crea_ordini_negozioView.setResizable(false);
        visualizza_ordini_recentiView = new VisualizzaOrdiniView(segreteria, this.negozio.getCodFiscale());
        visualizza_ordini_recentiView.setBounds(310, 310, 1200, 210);
        visualizza_ordini_recentiView.addActionListeners(this);
        visualizza_ordini_recentiView.setResizable(false);
        visualizza_ordini_recentiView.setVisible(false);
        nuovo_ordineView = new NuovoOrdineView();
        nuovo_ordineView.addActionListeners(this);
        nuovo_ordineView.setResizable(false);
        nuovo_ordineView.setBounds(310, 310, 800, 350);
        aggiungiArticoloView = new AggiungiArticoloView();
        aggiungiArticoloView.addActionListeners(this);
        aggiungiArticoloView.setResizable(false);
        aggiungiArticoloView.setBounds(310, 310, 700, 250);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == visualizza_crea_ordini_negozioView.indietro) {
            visualizza_crea_ordini_negozioView.setVisible(false);
            LoginController login = new LoginController(new LoginView(), new Login(utenti, password), Magazzino.getInstance());
        }

        if (e.getSource() == visualizza_crea_ordini_negozioView.inserisci_ordine) {
            nuovo_ordineView.setVisible(true);
            visualizza_crea_ordini_negozioView.setVisible(false);
        }

        if (e.getSource() == nuovo_ordineView.menu_principale) {

            nuovo_ordineView.setVisible(false);
            nuovo_ordineView.quantità1_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità1_comboBox.setEnabled(false);
            nuovo_ordineView.quantità2_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità2_comboBox.setEnabled(false);
            nuovo_ordineView.quantità3_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità3_comboBox.setEnabled(false);
            nuovo_ordineView.quantità4_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità4_comboBox.setEnabled(false);
            nuovo_ordineView.quantità5_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità5_comboBox.setEnabled(false);
            nuovo_ordineView.tipo_articolo1.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo2.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo3.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo4.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo5.setSelectedIndex(-1);

            nuovo_ordineView.invia_ordine.setEnabled(false);
            nuovo_ordineView.tot_ordine.setText("0,00 €");
            visualizza_crea_ordini_negozioView.setVisible(true);
        }

        if (e.getSource() == visualizza_crea_ordini_negozioView.visualizza_ordini) {
            visualizza_crea_ordini_negozioView.setVisible(false);
            visualizza_ordini_recentiView.setVisible(true);
            visualizza_ordini_recentiView.ordini.setSelectedIndex(-1);
            visualizza_ordini_recentiView.table_model.setRowCount(0);
            visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
            visualizza_ordini_recentiView.stato.setBackground(SystemColor.text);

        }

        if (e.getSource() == visualizza_ordini_recentiView.menu_principale) {
            visualizza_crea_ordini_negozioView.setVisible(true);
            visualizza_ordini_recentiView.setVisible(false);
            visualizza_ordini_recentiView.ordini.setSelectedIndex(-1);
            visualizza_ordini_recentiView.table_model.setRowCount(0);
            visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
            visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
            visualizza_ordini_recentiView.elimina_articoli.setEnabled(false);
            visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
            visualizza_ordini_recentiView.elimina_ordine.setEnabled(false);
            visualizza_ordini_recentiView.modifica_quantità.setEnabled(false);
            visualizza_ordini_recentiView.stato.setText("                                   ");
            visualizza_ordini_recentiView.stato.setBackground(SystemColor.text);

        }

        if (e.getSource() == nuovo_ordineView.tipo_articolo1) {

            if (nuovo_ordineView.tipo_articolo1.getSelectedIndex() != -1) {
                nuovo_ordineView.quantità1_comboBox.setEnabled(true);
            }
        }

        if (e.getSource() == nuovo_ordineView.tipo_articolo2) {

            if (nuovo_ordineView.tipo_articolo2.getSelectedIndex() != -1) {
                nuovo_ordineView.quantità2_comboBox.setEnabled(true);
            }
        }

        if (e.getSource() == nuovo_ordineView.tipo_articolo3) {

            if (nuovo_ordineView.tipo_articolo3.getSelectedIndex() != -1) {
                nuovo_ordineView.quantità3_comboBox.setEnabled(true);
            }
        }

        if (e.getSource() == nuovo_ordineView.tipo_articolo4) {

            if (nuovo_ordineView.tipo_articolo4.getSelectedIndex() != -1) {
                nuovo_ordineView.quantità4_comboBox.setEnabled(true);
            }
        }

        if (e.getSource() == nuovo_ordineView.tipo_articolo5) {

            if (nuovo_ordineView.tipo_articolo5.getSelectedIndex() != -1) {
                nuovo_ordineView.quantità5_comboBox.setEnabled(true);
            }
        }

        if (e.getSource() == nuovo_ordineView.quantità1_comboBox) {

            Articolo articolo = null;

            if (nuovo_ordineView.quantità1_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo1.getSelectedIndex() != -1) {
                nuovo_ordineView.tipo_articolo2.setEnabled(true);
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo1.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }
            }
            if (nuovo_ordineView.quantità1_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo1.getSelectedIndex() != -1) {
                totale_ordine = Double.parseDouble(nuovo_ordineView.quantità1_comboBox.getSelectedItem().toString()) * articolo.getPrice();
            }
            nuovo_ordineView.tot_ordine.setText(" " + new DecimalFormat("##.00").format(totale_ordine) + " €");
            nuovo_ordineView.invia_ordine.setEnabled(true);
        }

        if (e.getSource() == nuovo_ordineView.quantità2_comboBox) {

            Articolo articolo = null;

            if (nuovo_ordineView.quantità2_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo2.getSelectedIndex() != -1) {
                nuovo_ordineView.tipo_articolo3.setEnabled(true);
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo2.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }
            }
            if (nuovo_ordineView.quantità2_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo2.getSelectedIndex() != -1) {
                totale_ordine += Double.parseDouble(nuovo_ordineView.quantità2_comboBox.getSelectedItem().toString()) * articolo.getPrice();
            }
            nuovo_ordineView.tot_ordine.setText(" " + new DecimalFormat("##.00").format(totale_ordine) + " €");
            nuovo_ordineView.invia_ordine.setEnabled(true);
        }

        if (e.getSource() == nuovo_ordineView.quantità3_comboBox) {

            Articolo articolo = null;

            if (nuovo_ordineView.quantità3_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo3.getSelectedIndex() != -1) {
                nuovo_ordineView.tipo_articolo4.setEnabled(true);
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo3.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }
            }
            if (nuovo_ordineView.quantità3_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo3.getSelectedIndex() != -1) {
                totale_ordine += Double.parseDouble(nuovo_ordineView.quantità3_comboBox.getSelectedItem().toString()) * articolo.getPrice();
            }
            nuovo_ordineView.tot_ordine.setText(" " + new DecimalFormat("##.00").format(totale_ordine) + " €");
            nuovo_ordineView.invia_ordine.setEnabled(true);
        }

        if (e.getSource() == nuovo_ordineView.quantità4_comboBox) {

            Articolo articolo = null;

            if (nuovo_ordineView.quantità4_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo4.getSelectedIndex() != -1) {
                nuovo_ordineView.tipo_articolo5.setEnabled(true);
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo4.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }
            }
            if (nuovo_ordineView.quantità4_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo4.getSelectedIndex() != -1) {
                totale_ordine += Double.parseDouble(nuovo_ordineView.quantità4_comboBox.getSelectedItem().toString()) * articolo.getPrice();
            }
            nuovo_ordineView.tot_ordine.setText(" " + new DecimalFormat("##.00").format(totale_ordine) + " €");
            nuovo_ordineView.invia_ordine.setEnabled(true);
        }

        if (e.getSource() == nuovo_ordineView.quantità5_comboBox) {

            Articolo articolo = null;

            if (nuovo_ordineView.quantità5_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo5.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo5.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }
            }
            if (nuovo_ordineView.quantità5_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo5.getSelectedIndex() != -1) {
                totale_ordine += Double.parseDouble(nuovo_ordineView.quantità5_comboBox.getSelectedItem().toString()) * articolo.getPrice();
            }
            nuovo_ordineView.tot_ordine.setText(" " + new DecimalFormat("##.00").format(totale_ordine) + " €");
            nuovo_ordineView.invia_ordine.setEnabled(true);
        }

        if (e.getSource() == nuovo_ordineView.invia_ordine) {
            Articolo articolo = null;

            HashMap<Articolo, Integer> quantità = new HashMap<>();

            if (nuovo_ordineView.quantità1_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo1.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo1.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        quantità.put(articolo, Integer.parseInt(nuovo_ordineView.quantità1_comboBox.getSelectedItem().toString()));
                        break;
                    }
                }
            }

            if (nuovo_ordineView.quantità2_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo2.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo2.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        quantità.put(articolo, Integer.parseInt(nuovo_ordineView.quantità2_comboBox.getSelectedItem().toString()));
                        break;
                    }
                }
            }

            if (nuovo_ordineView.quantità3_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo3.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo3.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        quantità.put(articolo, Integer.parseInt(nuovo_ordineView.quantità3_comboBox.getSelectedItem().toString()));
                        break;
                    }
                }
            }

            if (nuovo_ordineView.quantità4_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo4.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo4.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        quantità.put(articolo, Integer.parseInt(nuovo_ordineView.quantità4_comboBox.getSelectedItem().toString()));
                        break;
                    }
                }
            }

            if (nuovo_ordineView.quantità5_comboBox.getSelectedIndex() != -1 && nuovo_ordineView.tipo_articolo5.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (nuovo_ordineView.tipo_articolo5.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        quantità.put(articolo, Integer.parseInt(nuovo_ordineView.quantità5_comboBox.getSelectedItem().toString()));
                        break;
                    }
                }
            }

            Magazzino.getInstance().addOrdine(new Ordine(this.negozio, quantità, totale_ordine));

            nuovo_ordineView.quantità1_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità1_comboBox.setEnabled(false);
            nuovo_ordineView.quantità2_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità2_comboBox.setEnabled(false);
            nuovo_ordineView.quantità3_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità3_comboBox.setEnabled(false);
            nuovo_ordineView.quantità4_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità4_comboBox.setEnabled(false);
            nuovo_ordineView.quantità5_comboBox.setSelectedIndex(-1);
            nuovo_ordineView.quantità5_comboBox.setEnabled(false);
            nuovo_ordineView.tipo_articolo1.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo2.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo3.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo4.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo5.setSelectedIndex(-1);
            nuovo_ordineView.tipo_articolo2.setEnabled(false);
            nuovo_ordineView.tipo_articolo3.setEnabled(false);
            nuovo_ordineView.tipo_articolo4.setEnabled(false);
            nuovo_ordineView.tipo_articolo5.setEnabled(false);
            nuovo_ordineView.invia_ordine.setEnabled(false);
            nuovo_ordineView.tot_ordine.setText("0,00 €");

            visualizza_ordini_recentiView.ordini.removeAllItems();
            for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                if (Magazzino.getInstance().getOrdini().get(i).getNegozio().getCodFiscale().equals(this.negozio.getCodFiscale())) {
                    visualizza_ordini_recentiView.ordini.addItem("" + abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()));
                }
            }

            JOptionPane.showMessageDialog(null, "L'ordine è andato a buon fine.");
        }

        if (e.getSource() == visualizza_ordini_recentiView.visualizza) {

            visualizza_ordini_recentiView.table_model.setRowCount(0);
            visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
            String order_date, article_cost, nome_articolo;
            int codice_articolo, order_quantity;

            if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1) {
                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {
                        visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(Magazzino.getInstance().getOrdini().get(i).getTotal_price()) + " €");

                        if (Magazzino.getInstance().getOrdini().get(i).Is_shipped() == false) {

                            visualizza_ordini_recentiView.stato.setText("NON SPEDITO    ");
                            visualizza_ordini_recentiView.stato.setBackground(Color.ORANGE);
                        } else {
                            visualizza_ordini_recentiView.stato.setText("SPEDITO    ");
                            visualizza_ordini_recentiView.stato.setBackground(Color.green);
                        }

                        for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                            codice_articolo = abs(articolo.getCodiceArticolo());
                            nome_articolo = articolo.getTypeArticle().getNome() + ", " + articolo.getTypeArticle().getDescrizione();
                            order_date = Magazzino.getInstance().getOrdini().get(i).getData();
                            order_quantity = Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo);
                            article_cost = "" + new DecimalFormat("##.00").format(articolo.getPrice() * Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo)) + "  €";
                            Object[] ordini = {order_date, codice_articolo, nome_articolo, order_quantity, article_cost};
                            visualizza_ordini_recentiView.table_model.addRow(ordini);

                        }

                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selezionare un ordine per visualizzarne il contenuto!");
            }

        }

        if (e.getSource() == visualizza_ordini_recentiView.elimina_ordine) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int conferma_decisione;

            if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1) {
                conferma_decisione = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler anullare l'ordine num.  " + visualizza_ordini_recentiView.ordini.getSelectedItem().toString() + " ?",
                        "Conferma annullamento ordine", dialogButton);

                if (conferma_decisione == JOptionPane.YES_OPTION) {

                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                        if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {
                            Magazzino.getInstance().getOrdini().remove(Magazzino.getInstance().getOrdini().get(i));
                            break;
                        }
                    }

                    visualizza_ordini_recentiView.table_model.setRowCount(0);
                    visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                    visualizza_ordini_recentiView.stato.setText("                                   ");
                    visualizza_ordini_recentiView.stato.setBackground(SystemColor.text);

                    visualizza_ordini_recentiView.ordini.removeAllItems();
                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                        if (Magazzino.getInstance().getOrdini().get(i).getNegozio().getCodFiscale().equals(this.negozio.getCodFiscale())) {
                            visualizza_ordini_recentiView.ordini.addItem("" + abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()));
                        }
                    }
                    visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                    visualizza_ordini_recentiView.elimina_articoli.setEnabled(false);
                    visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                    visualizza_ordini_recentiView.elimina_ordine.setEnabled(false);
                    visualizza_ordini_recentiView.modifica_quantità.setEnabled(false);
                    visualizza_ordini_recentiView.ordini.setSelectedIndex(-1);
                    JOptionPane.showMessageDialog(null, "L'ordine è stato rimosso con successo.");

                } else {
                    JOptionPane.showMessageDialog(null, "Operazione annullata.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Selezionare un ordine da rimuovere!");
            }

        }

        if (e.getSource() == visualizza_ordini_recentiView.modifica_ordine) {

            if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1 && visualizza_ordini_recentiView.table_model.getRowCount() != 0) {
                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                        if (Magazzino.getInstance().getOrdini().get(i).Is_shipped() == false) {
                            visualizza_ordini_recentiView.order_table.setEnabled(true);
                            visualizza_ordini_recentiView.order_table.isCellEditable(0, 0);
                            visualizza_ordini_recentiView.order_table.isCellEditable(0, 1);
                            visualizza_ordini_recentiView.order_table.isCellEditable(0, 2);
                            visualizza_ordini_recentiView.order_table.isCellEditable(0, 3);
                            visualizza_ordini_recentiView.order_table.isCellEditable(0, 4);
                            visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(true);
                            visualizza_ordini_recentiView.elimina_articoli.setEnabled(true);
                            visualizza_ordini_recentiView.elimina_ordine.setEnabled(true);
                            visualizza_ordini_recentiView.modifica_quantità.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "L'ordine è già stato spedito, non è possibile apportare alcuna modifica.");
                        }

                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "E' necessario visualizzare un ordine per poterlo modificare, annullare o eliminarlo.");
            }

        }

        if (e.getSource() == visualizza_ordini_recentiView.elimina_articoli) {

            HashMap<Articolo, Integer> copia = new HashMap<>();
            boolean empty = false;

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int conferma_decisione;

            if (visualizza_ordini_recentiView.order_table.getSelectedRowCount() > 0) {
                conferma_decisione = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare l'articolo num.  "
                        + visualizza_ordini_recentiView.table_model.getValueAt(visualizza_ordini_recentiView.order_table.getSelectedRow(), 1) + " ?",
                        "Conferma eliminazione articolo ordine n. " + Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString()), dialogButton);

                if (conferma_decisione == JOptionPane.YES_OPTION) {

                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                        if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                            for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(visualizza_ordini_recentiView.order_table.getSelectedRow(), 1)))) {
                                    copia.putAll(Magazzino.getInstance().getOrdini().get(i).getMapOrdine());
                                    Magazzino.getInstance().getOrdini().get(i).getMapOrdine().remove(articolo);
                                    empty = Magazzino.getInstance().getOrdini().get(i).getMapOrdine().isEmpty();
                                    break;
                                }
                            }
                        }
                    }

                    visualizza_ordini_recentiView.table_model.removeRow(visualizza_ordini_recentiView.order_table.getSelectedRow());

                    if (empty) {
                        int button = JOptionPane.YES_NO_OPTION;
                        int conferma_annulla;
                        conferma_annulla = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare anche l'ultimo articolo ?"
                                + "\nL'ordine verrà annullato in quanto ordine vuoto.", "Cancellazione ordine vuoto", button);
                        if (conferma_annulla == JOptionPane.YES_OPTION) {
                            Magazzino.getInstance().removeOrderByID(Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString()));
                            visualizza_ordini_recentiView.table_model.setRowCount(0);
                            visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                            visualizza_ordini_recentiView.stato.setText("                                   ");
                            visualizza_ordini_recentiView.stato.setBackground(SystemColor.text);

                            visualizza_ordini_recentiView.ordini.removeAllItems();
                            for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                                if (Magazzino.getInstance().getOrdini().get(i).getNegozio().getCodFiscale().equals(this.negozio.getCodFiscale())) {
                                    visualizza_ordini_recentiView.ordini.addItem("" + abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()));
                                }
                            }
                            visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                            visualizza_ordini_recentiView.elimina_articoli.setEnabled(false);
                            visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                            visualizza_ordini_recentiView.elimina_ordine.setEnabled(false);
                            visualizza_ordini_recentiView.modifica_quantità.setEnabled(false);

                            visualizza_ordini_recentiView.ordini.setSelectedIndex(-1);

                            JOptionPane.showMessageDialog(null, "L'ordine è stato rimosso con successo.");
                            return;

                        } else if (conferma_annulla == JOptionPane.NO_OPTION) {

                            Magazzino.getInstance().setQuantità(copia, Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString()));

                            visualizza_ordini_recentiView.table_model.setRowCount(0);
                            visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                            String order_date, article_cost, nome_articolo;
                            int codice_articolo, order_quantity;

                            if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1) {
                                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {
                                        visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(Magazzino.getInstance().getOrdini().get(i).getTotal_price()) + " €");

                                        if (Magazzino.getInstance().getOrdini().get(i).Is_shipped() == false) {
                                            visualizza_ordini_recentiView.stato.setText("NON SPEDITO    ");
                                            visualizza_ordini_recentiView.stato.setBackground(Color.ORANGE);
                                        } else {
                                            visualizza_ordini_recentiView.stato.setText("SPEDITO    ");
                                            visualizza_ordini_recentiView.stato.setBackground(Color.green);
                                        }

                                        for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                            codice_articolo = abs(articolo.getCodiceArticolo());
                                            nome_articolo = articolo.getTypeArticle().getNome() + ", " + articolo.getTypeArticle().getDescrizione();
                                            order_date = Magazzino.getInstance().getOrdini().get(i).getData();
                                            order_quantity = Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo);
                                            article_cost = "" + new DecimalFormat("##.00").format(articolo.getPrice() * Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo)) + "  €";
                                            Object[] ordini = {order_date, codice_articolo, nome_articolo, order_quantity, article_cost};
                                            visualizza_ordini_recentiView.table_model.addRow(ordini);

                                        }

                                    }
                                }

                                double totale_ordine = 0.0;
                                for (int z = 0; z < visualizza_ordini_recentiView.order_table.getRowCount(); z++) {
                                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                                        if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                                            for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                                if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 1)))) {
                                                    totale_ordine += articolo.getPrice()
                                                            * Double.parseDouble(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 3)));
                                                }
                                            }
                                            Magazzino.getInstance().getOrdini().get(i).setTotal_price(totale_ordine);
                                        }
                                    }
                                }
                                visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(totale_ordine) + " €");
                            }

                            JOptionPane.showMessageDialog(null, "L'operazione è stata annullata, l'articolo e l'ordine non sono stati cancellati.");

                            return;
                        }

                    }

                    double totale_ordine = 0.0;
                    for (int z = 0; z < visualizza_ordini_recentiView.order_table.getRowCount(); z++) {
                        for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                            if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                                for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                    if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 1)))) {
                                        totale_ordine += articolo.getPrice()
                                                * Double.parseDouble(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 3)));
                                    }
                                }
                                Magazzino.getInstance().getOrdini().get(i).setTotal_price(totale_ordine);
                            }
                        }
                    }

                    visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(totale_ordine) + " €");
                    JOptionPane.showMessageDialog(null, "L'ordine è stato modificato correttamente, gli articoli desiderati sono stati rimossi.");
                } else {
                    visualizza_ordini_recentiView.order_table.getSelectionModel().clearSelection();
                    JOptionPane.showMessageDialog(null, "Operazione annullata.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Per poter eliminare gli articoli dall'ordine è necessario selezionare la riga corrispondente.");
            }

        }

        if (e.getSource() == visualizza_ordini_recentiView.modifica_quantità) {

            if (visualizza_ordini_recentiView.order_table.getSelectedRowCount() > 0) {
                int quantità = 0;

                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {
                        try {
                            quantità = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la nuova quantità: "));

                            if (quantità != 5 && quantità != 10 && quantità != 20 && quantità != 30 && quantità != 40
                                    && quantità != 50 && quantità != 60 && quantità != 70 && quantità != 80 && quantità != 90 && quantità != 100) {
                                JOptionPane.showMessageDialog(null, "Non è stata inserita una quantità valida.\nI possibili valori ammessi sono 5, 10, 20, "
                                        + "30, 40, 50, 60, 70, 80, 90, 100\nOperazione annullata.");
                                visualizza_ordini_recentiView.order_table.getSelectionModel().clearSelection();
                                return;
                            }

                        } catch (NumberFormatException n) {
                            visualizza_ordini_recentiView.order_table.getSelectionModel().clearSelection();
                            JOptionPane.showMessageDialog(null, "Non è stata inserita correttamente la quantità, operazione annullata.");
                            return;
                        }
                        for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                            if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(visualizza_ordini_recentiView.order_table.getSelectedRow(), 1)))) {
                                Magazzino.getInstance().getOrdini().get(i).getMapOrdine().remove(articolo);
                                Magazzino.getInstance().getOrdini().get(i).getMapOrdine().put(articolo, quantità);
                                break;
                            }
                        }
                    }

                }

                visualizza_ordini_recentiView.table_model.setRowCount(0);
                visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                String order_date, article_cost, nome_articolo;
                int codice_articolo, order_quantity;

                if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1) {
                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                        if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                            if (Magazzino.getInstance().getOrdini().get(i).Is_shipped() == false) {

                                visualizza_ordini_recentiView.stato.setText("NON SPEDITO    ");
                                visualizza_ordini_recentiView.stato.setBackground(Color.ORANGE);
                            } else {
                                visualizza_ordini_recentiView.stato.setText("SPEDITO    ");
                                visualizza_ordini_recentiView.stato.setBackground(Color.green);
                            }

                            for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                codice_articolo = abs(articolo.getCodiceArticolo());
                                nome_articolo = articolo.getTypeArticle().getNome() + ", " + articolo.getTypeArticle().getDescrizione();
                                order_date = Magazzino.getInstance().getOrdini().get(i).getData();
                                order_quantity = Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo);
                                article_cost = "" + new DecimalFormat("##.00").format(articolo.getPrice() * Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(articolo)) + "  €";
                                Object[] ordini = {order_date, codice_articolo, nome_articolo, order_quantity, article_cost};
                                visualizza_ordini_recentiView.table_model.addRow(ordini);

                            }

                        }
                    }

                    double totale_ordine = 0.0;
                    for (int z = 0; z < visualizza_ordini_recentiView.order_table.getRowCount(); z++) {
                        for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                            if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                                for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                    if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 1)))) {
                                        totale_ordine += articolo.getPrice()
                                                * Double.parseDouble(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 3)));
                                    }
                                }
                                Magazzino.getInstance().getOrdini().get(i).setTotal_price(totale_ordine);
                            }
                        }
                    }
                    visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(totale_ordine) + " €");
                    JOptionPane.showMessageDialog(null, "L'operazione è andata a buon fine.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selezionare un ordine per visualizzarne il contenuto!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Per poter modificare la quantità selezionare la riga corrispondente.");
            }
        }

        if (e.getSource()
                == visualizza_ordini_recentiView.aggiungi_articoli) {
            aggiungiArticoloView.setTitle("Inserimento nuovo articolo ordine num. " + Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString()));
            aggiungiArticoloView.quantità.setSelectedIndex(-1);
            aggiungiArticoloView.articoli.setSelectedIndex(-1);
            aggiungiArticoloView.quantità.setEnabled(false);
            aggiungiArticoloView.aggiungi.setEnabled(false);
            aggiungiArticoloView.totale.setText("0,00 €");
            aggiungiArticoloView.setVisible(true);

        }

        if (e.getSource()
                == aggiungiArticoloView.indietro) {
            aggiungiArticoloView.setVisible(false);
        }

        if (e.getSource()
                == aggiungiArticoloView.articoli) {
            if (aggiungiArticoloView.articoli.getSelectedIndex() != -1) {
                aggiungiArticoloView.quantità.setEnabled(true);
            }
        }

        if (e.getSource() == aggiungiArticoloView.quantità) {
            if (aggiungiArticoloView.articoli.getSelectedIndex() != -1 && aggiungiArticoloView.quantità.getSelectedIndex() != -1) {
                aggiungiArticoloView.aggiungi.setEnabled(true);
                Articolo articolo = null;

                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (aggiungiArticoloView.articoli.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        articolo = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }

                aggiungiArticoloView.totale.setText("" + new DecimalFormat("##.00").format(articolo.getPrice()
                        * Double.parseDouble(aggiungiArticoloView.quantità.getSelectedItem().toString())) + " €");

            }
        }

        if (e.getSource() == aggiungiArticoloView.aggiungi) {

            if (aggiungiArticoloView.articoli.getSelectedIndex() != -1 && aggiungiArticoloView.quantità.getSelectedIndex() != -1) {

                Articolo art = null;
                for (int i = 0; i < Magazzino.getInstance().getCatalogoArticoliMagazzino().size(); i++) {
                    if (aggiungiArticoloView.articoli.getSelectedItem().toString().equals(Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i).getTypeArticle().toString())) {
                        art = Magazzino.getInstance().getCatalogoArticoliMagazzino().get(i);
                        break;
                    }
                }

                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {
                        if (Magazzino.getInstance().getOrdini().get(i).getMapOrdine().containsKey(art) == true) {
                            aggiungiArticoloView.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Articolo già presente nell'ordine, verrà aggiornata la quantità presente.");
                            Magazzino.getInstance().getOrdini().get(i).getMapOrdine().put(art,
                                    Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(art) + Integer.parseInt(aggiungiArticoloView.quantità.getSelectedItem().toString()));

                        } else {
                            Magazzino.getInstance().getOrdini().get(i).getMapOrdine().put(art, Integer.parseInt(aggiungiArticoloView.quantità.getSelectedItem().toString()));
                            aggiungiArticoloView.setVisible(false);
                            JOptionPane.showMessageDialog(null, "L'operazione è andata a buon fine.");
                        }
                    }
                }

                visualizza_ordini_recentiView.table_model.setRowCount(0);
                visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                String order_date, article_cost, nome_articolo;
                int codice_articolo, order_quantity;

                for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                    if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                        if (Magazzino.getInstance().getOrdini().get(i).Is_shipped() == false) {

                            visualizza_ordini_recentiView.stato.setText("NON SPEDITO    ");
                            visualizza_ordini_recentiView.stato.setBackground(Color.ORANGE);
                        } else {
                            visualizza_ordini_recentiView.stato.setText("SPEDITO    ");
                            visualizza_ordini_recentiView.stato.setBackground(Color.green);
                        }

                        for (Articolo a : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                            codice_articolo = abs(a.getCodiceArticolo());
                            nome_articolo = a.getTypeArticle().getNome() + ", " + a.getTypeArticle().getDescrizione();
                            order_date = Magazzino.getInstance().getOrdini().get(i).getData();
                            order_quantity = Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(a);
                            article_cost = "" + new DecimalFormat("##.00").format(a.getPrice() * Magazzino.getInstance().getOrdini().get(i).getMapOrdine().get(a)) + "  €";
                            Object[] ordini = {order_date, codice_articolo, nome_articolo, order_quantity, article_cost};
                            visualizza_ordini_recentiView.table_model.addRow(ordini);

                        }

                    }
                }

                double totale_ordine = 0.0;
                for (int z = 0; z < visualizza_ordini_recentiView.order_table.getRowCount(); z++) {
                    for (int i = 0; i < Magazzino.getInstance().getOrdini().size(); i++) {
                        if (abs(Magazzino.getInstance().getOrdini().get(i).getOrder_number()) == Integer.parseInt(visualizza_ordini_recentiView.ordini.getSelectedItem().toString())) {

                            for (Articolo articolo : Magazzino.getInstance().getOrdini().get(i).getMapOrdine().keySet()) {
                                if (abs(articolo.getCodiceArticolo()) == Integer.parseInt(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 1)))) {
                                    totale_ordine += articolo.getPrice()
                                            * Double.parseDouble(new String("" + visualizza_ordini_recentiView.table_model.getValueAt(z, 3)));
                                }
                            }
                            Magazzino.getInstance().getOrdini().get(i).setTotal_price(totale_ordine);
                        }
                    }
                }

                visualizza_ordini_recentiView.tot_ordine.setText("" + new DecimalFormat("##.00").format(totale_ordine) + " €");

            } else {
                JOptionPane.showMessageDialog(null, "L'operazione non può essere effettuata, selezionare un tipo articolo o una quantità mancanti");
            }

        }

        if (e.getSource()
                == visualizza_ordini_recentiView.ordini) {
            if (visualizza_ordini_recentiView.ordini.getSelectedIndex() != -1) {
                visualizza_ordini_recentiView.table_model.setRowCount(0);
                visualizza_ordini_recentiView.tot_ordine.setText("                                  ");
                visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                visualizza_ordini_recentiView.elimina_articoli.setEnabled(false);
                visualizza_ordini_recentiView.aggiungi_articoli.setEnabled(false);
                visualizza_ordini_recentiView.elimina_ordine.setEnabled(false);
                visualizza_ordini_recentiView.modifica_quantità.setEnabled(false);
                visualizza_ordini_recentiView.stato.setText("                                   ");
                visualizza_ordini_recentiView.stato.setBackground(SystemColor.text);
            }
        }
    }
}
